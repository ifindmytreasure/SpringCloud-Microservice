package com.colin.order.controller;

import com.colin.order.config.GirlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: BlueMelancholy
 * 2019/10/4 19:40
 * @desc:
 */
@RestController
@RequestMapping("/girl")
public class GirlController {
    @Autowired
    private GirlConfig girlConfig;
    @RequestMapping("/print")
    public String print(){
        return "name:" + girlConfig.getName() + ",age:" + girlConfig.getAge();
    }
}
