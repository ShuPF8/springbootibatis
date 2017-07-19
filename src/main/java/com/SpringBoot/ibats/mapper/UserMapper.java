package com.SpringBoot.ibats.mapper;

import com.GMMapper.MyMapper;
import com.SpringBoot.ibats.model.Entity.SfUser;
import com.SpringBoot.ibats.model.result.UserModelRes;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper extends MyMapper<SfUser> {

    List<UserModelRes> findAll();

}
