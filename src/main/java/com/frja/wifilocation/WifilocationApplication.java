package com.frja.wifilocation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.frja.wifilocation.dao")
public class WifilocationApplication {

    public static void main(String[] args) {
        SpringApplication.run(WifilocationApplication.class, args);
    }

}
