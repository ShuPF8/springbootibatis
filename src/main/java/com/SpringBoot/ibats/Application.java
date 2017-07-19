package com.SpringBoot.ibats;

import com.GMMapper.MyBatisMapperScannerConfig;
import com.GMMapper.MyMapper;
import com.GMMapper.MybatisAutoConfiguration;
import com.GMMapper.MybatisProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Administrator on 2017/6/26 0026.
 */
@MapperScan("com.SpringBoot.ibats.mapper")
@EnableTransactionManagement
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

}
