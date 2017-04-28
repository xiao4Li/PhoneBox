package com.sample.bruce.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: liqi@youbangsoft.com
 * @Date: 2017/4/27
 * @Description: [ xxxx ]
 * @Version: 1.0
 */
@EnableAutoConfiguration
@Controller
public class SampleController {
    @RequestMapping("/")
    String index(){
        //return new ModelAndView("index");
        return "index";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
}
