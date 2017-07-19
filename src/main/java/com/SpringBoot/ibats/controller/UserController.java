package com.SpringBoot.ibats.controller;

import com.SpringBoot.ibats.model.Entity.SfUser;
import com.alibaba.fastjson.JSON;
import com.SpringBoot.ibats.service.UserService;
import com.SpringBoot.ibats.utils.BaseUtils;
import com.SpringBoot.ibats.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/6/27.
 */
@RestController
public class UserController extends BaseUtils {

    @Autowired private UserService userService;

    @RequestMapping("/findAll")
    public void findAll(){
        ResultJson result = userService.findAll();
        backClient(JSON.toJSONString(result));
    }

    @RequestMapping("/findpage")
    public void findpage(){
        String pageNo = request.getParameter("pageNo");
        String pageSize = request.getParameter("pageSize");
        ResultJson result = userService.findPage(Integer.valueOf(pageNo),Integer.valueOf(pageSize));
        System.out.println("测试热部署");
        backClient(JSON.toJSONString(result));
    }

    @RequestMapping("/findId")
    public void findId(){
        String id = request.getParameter("id");
        ResultJson result = userService.findByID(id);
        backClient(JSON.toJSONString(result));
    }

    @RequestMapping("/save")
    public void save(){
        SfUser s = new SfUser();
        s.setSex("N");
        s.setAge(212);
        s.setPwd("777777");;
        s.setPhone("561565646556");
        s.setName("asd");
        ResultJson result = userService.save(s);
        backClient(JSON.toJSONString(result));
    }


    @RequestMapping("/update")
    public void update(){
        String id = request.getParameter("id");
        ResultJson result = userService.update(id);
        backClient(JSON.toJSONString(result));
    }


}
