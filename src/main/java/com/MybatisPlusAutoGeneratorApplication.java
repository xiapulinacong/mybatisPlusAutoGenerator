package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lin.test.mapper")
public class MybatisPlusAutoGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusAutoGeneratorApplication.class, args);
    }

}
