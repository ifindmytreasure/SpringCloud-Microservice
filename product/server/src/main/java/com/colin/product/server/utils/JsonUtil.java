package com.colin.product.server.utils;

import com.colin.product.server.domain.ProductInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/**
 * @author: BlueMelancholy
 * 2019/10/7 10:11
 * @desc:
 */
public class JsonUtil {
    private static ObjectMapper objectMapper = new ObjectMapper();
    public static String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String toJsonArray(List<ProductInfo> object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
