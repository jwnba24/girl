package com.jw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Administrator on 2017/5/10.
 */
@SpringBootApplication
@MapperScan("com.jw.dao")
public class GirlApplication {
    public static void main(String[] args) {
        SpringApplication.run(GirlApplication.class,args);
    }
}
