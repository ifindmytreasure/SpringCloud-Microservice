package com.colin.apigateway.filter;

import com.colin.apigateway.constant.RedisConstant;
import com.colin.apigateway.utils.CookieUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @author: BlueMelancholy
 * 2019/10/12 10:24
 * @desc:
 */
@Component
public class AuthFilter extends ZuulFilter {
   @Autowired
   private StringRedisTemplate stringRedisTemplate;
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER-1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        //order/create 只能买家访问（cookie里面有openId）
        //order/finish 只能是卖家访问(cookie里面有token)
        //order/list 都能访问
        final String createUrl = "/order/order/create";
        final String finishUrl = "/order/order/finish";
        if (createUrl.equals(request.getRequestURI())){
            Cookie openId = CookieUtil.get(request, "openId");
            if (openId == null || StringUtils.isEmpty(openId.getValue())){
                currentContext.setSendZuulResponse(false);
                currentContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            }
        }
        if (finishUrl.equals(request.getRequestURI())){
            Cookie openId = CookieUtil.get(request, "token");
            if (openId == null||StringUtils.isEmpty(openId.getValue())
                    ||StringUtils.isEmpty(stringRedisTemplate.opsForValue()
                    .get(String.format(RedisConstant.TOKEN_TEMPLATE, openId.getValue())))){
                currentContext.setSendZuulResponse(false);
                currentContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            }
        }
        return null;
    }
}
