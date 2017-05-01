package com.sample.bruce.controller;

import com.sample.bruce.loader.DataLoader;
import com.sample.bruce.loader.impl.JsonDataLoaderImpl;
import com.sample.bruce.po.LinkmanPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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
    private DataLoader<LinkmanPo> dataLoader = new JsonDataLoaderImpl();
    @RequestMapping("/")
    String index(){
        //return new ModelAndView("index");
        return "index";
    }

    @RequestMapping("/listLinkman")
    @ResponseBody
    List<LinkmanPo> listLinkman(){
        return dataLoader.listData();
    }

    @RequestMapping("/addLinkman")
    @ResponseBody
    List<LinkmanPo> addLinkman(LinkmanPo linkmanPo){
        dataLoader.addData(dataLoader.listData().get(0));
        return dataLoader.listData();
    }

    @RequestMapping("/getLinkmanById")
    @ResponseBody
    LinkmanPo getLinkmanById(Integer id){
        return dataLoader.getDataById(id);
    }



    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
}
