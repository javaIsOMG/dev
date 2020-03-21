package com.zsy.hr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("/mapper")
@SpringBootApplication
public class HrApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrApplication.class, args);
    }

}
