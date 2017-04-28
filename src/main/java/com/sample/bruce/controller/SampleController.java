package com.sample.bruce.controller;

import com.sample.bruce.po.LinkmanPo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping("/listLinkman")
    @ResponseBody
    List<LinkmanPo> listLinkman(){
        List<LinkmanPo> list = new ArrayList<LinkmanPo>();

        LinkmanPo item1 = new LinkmanPo();
        item1.setCompany("test");
        item1.setId(100);
        item1.setName("zhagnsan");
        item1.setPhoneNo("15288123");
        item1.setTitle("软件工程师");

        list.add(item1);
        return list;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
}
