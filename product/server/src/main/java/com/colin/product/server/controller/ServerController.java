package com.colin.product.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: BlueMelancholy
 * 2019/10/3 14:09
 * @desc:
 */
@RestController
public class ServerController {
    @RequestMapping("/msg")
    public String msg() {
        return "this is product msg 9080";
    }
}
