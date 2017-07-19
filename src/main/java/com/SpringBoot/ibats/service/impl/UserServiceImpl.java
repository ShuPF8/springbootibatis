package com.SpringBoot.ibats.service.impl;
import com.SpringBoot.ibats.mapper.UserMapper;
import com.SpringBoot.ibats.model.Entity.SfUser;
import com.SpringBoot.ibats.service.UserService;
import com.SpringBoot.ibats.utils.ResultJson;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by SPF on 2017/6/27.
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired private UserMapper userMapper;

    @Override
    public ResultJson findAll() {
        ResultJson result = new ResultJson();
        List<SfUser> datass = userMapper.selectAll();
        result.setDatas(datass);
        return result;
    }

    @Override
    public ResultJson findPage(Integer pageNo, Integer pageSize) {
        ResultJson result = new ResultJson();
        PageHelper.startPage(pageNo,pageSize);
        List<SfUser> datas = userMapper.selectAll();
        result.setDatas(datas);
        return result;
    }

    @Override
    public ResultJson delete(String id) {
        ResultJson result = new ResultJson();
        int n = userMapper.deleteByPrimaryKey(id);
        if (n > 0) {
            result.success();
        }
        return result;
    }

    @Override
    public ResultJson findByID(String id) {
        ResultJson result = new ResultJson();
        SfUser s = userMapper.selectByPrimaryKey(Integer.valueOf(id));
        result.success();
        result.setData(s);
        return result;
    }

    @Override
    public ResultJson save(SfUser s) {
        ResultJson result = new ResultJson();
        int n = userMapper.insert(s);
        if (n > 0) {
            result.success();
        }
        return result;
    }

    @Override
    public ResultJson update(String id) {
        ResultJson result = new ResultJson();
        SfUser s = (SfUser) findByID(id).getData();
        s.setSex("女");
        userMapper.updateByPrimaryKey(s);
        result.success();
        return result;
    }


}
