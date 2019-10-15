package com.colin.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author: BlueMelancholy
 * 2019/10/12 18:00
 * @desc:
 */
@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {
    //超时配置
//    @HystrixCommand(commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")
//    })
    //熔断配置
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),  				//设置熔断，关闭主逻辑，执行fallback
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),	//请求数达到后才计算
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //休眠时间窗，10秒后进入半开状态，请求成功，关闭熔断器
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),	//错误率
    })
    @RequestMapping("/getProductInfoList")
    public String getProductInfoList(@RequestParam("number")Integer number) {
        if (number %2 ==0){
            return "success";
        }
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject("http://localhost:8089/product/listfororder", Collections.singletonList("164103465734242707"), String.class);
    }
    private String fallback(){
        return "太拥挤了, 请稍后再试~~";
    }
    private String defaultFallback() {
        return "默认提示：太拥挤了, 请稍后再试~~";
    }
}
