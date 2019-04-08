package com.ll.secondhouse;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.ll.secondhouse.mapper")
@SpringBootApplication
public class SecondhouseApplication {
    public static void main(String[] args) {
        SpringApplication.run(SecondhouseApplication.class, args);
    }
}
