package com.SpringBoot.ibats.service;


import com.SpringBoot.ibats.model.Entity.SfUser;
import com.SpringBoot.ibats.utils.ResultJson;

/**
 * Created by Administrator on 2017/6/27.
 */
public interface UserService {
    ResultJson findAll();

    ResultJson findPage(Integer pageNo, Integer pageSize);

    ResultJson delete(String id);

    ResultJson findByID(String id);

    ResultJson save(SfUser s);

    ResultJson update(String id);
}
