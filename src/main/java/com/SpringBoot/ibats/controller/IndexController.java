package com.SpringBoot.ibats.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/27 0027.
 */
@RestController
public class IndexController {

    @RequestMapping("/")
    public ModelAndView index(ModelMap modelMap) {
        List<Map<String,Object>> learnList =new ArrayList<Map<String,Object>>();
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("title","官方参考文档");
        map.put("content","http://docs.spring.io/spring-boot/docs/1.5.1.RELEASE/reference/htmlsingle/#getting-started-first-application");
        learnList.add(map);
        map = new HashMap<String, Object>();
        map.put("title","官方SpriongBoot例子");
        map.put("content","https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples");
        learnList.add(map);
        map = new HashMap<String, Object>();
        map.put("title","Spring Boot教程系列学习");
        map.put("content","http://www.roncoo.com/article/detail/125488");
        learnList.add(map);
        map = new HashMap<String, Object>();
        map.put("title","Spring Boot干货系列");
        map.put("content","http://tengj.top/");
        learnList.add(map);
        map = new HashMap<String, Object>();
        map.put("title","Spring Boot教程和视频");
        map.put("content","http://www.toutiao.com/m1559096720023553/");
        learnList.add(map);
        map = new HashMap<String, Object>();
        map.put("title","Spring Boot系列");
        map.put("content","http://www.roncoo.com/article/detail/125488");
        learnList.add(map);
        map = new HashMap<String, Object>();
        map.put("title","Spring Boot系列文章");
        map.put("content","http://www.ityouknow.com/spring-boot");
        learnList.add(map);
        map = new HashMap<String, Object>();
        map.put("title","Spring Boot学习");
        map.put("content","http://blog.csdn.net/column/details/spring-boot.html");
        learnList.add(map);
        map = new HashMap<String, Object>();
        map.put("title","Spring Boot 揭秘与实战");
        map.put("content","http://blog.csdn.net/column/details/spring-boot.html");
        learnList.add(map);
        map = new HashMap<String, Object>();
        map.put("title","从零开始学Spring Boot");
        map.put("content","http://412887952-qq-com.iteye.com/category/356333");
        learnList.add(map);
        map = new HashMap<String, Object>();
        ModelAndView modelAndView = new ModelAndView("test/index");
        modelAndView.addObject("learnList", learnList);
        return modelAndView;
    }

}
