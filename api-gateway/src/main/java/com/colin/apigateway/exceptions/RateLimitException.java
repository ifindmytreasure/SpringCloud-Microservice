package com.colin.apigateway.exceptions;

/**
 * @author: BlueMelancholy
 * 2019/10/11 14:42
 * @desc:
 */
public class RateLimitException extends RuntimeException{
    public RateLimitException(String message) {
        super(message);
    }
}
