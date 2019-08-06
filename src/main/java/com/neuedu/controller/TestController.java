package com.neuedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by tao on 2019/8/6.
 */

@Controller
public class TestController {


    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
