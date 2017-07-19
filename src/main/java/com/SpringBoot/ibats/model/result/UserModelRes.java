package com.SpringBoot.ibats.model.result;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/6/27.
 */
@Data
public class UserModelRes implements Serializable {
    private String id;
    private String name;
    private String phone;
    private String pwd;
    private String sex;
    private String age;
}
