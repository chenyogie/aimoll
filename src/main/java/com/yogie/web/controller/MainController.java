package com.yogie.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: aimoll
 * @Date: 2019/7/6 13:22
 * @Author: Chenyogie
 * @Description:
 */
@Controller
@RequestMapping
public class MainController {

    @RequestMapping("/main")
    public String main(){
        return "main";
    }

}
