package com.wp.filehandler;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.wp.filehandler.mapper"})
public class FileHandlerApplication {
    public static void main(String[] args) {
        SpringApplication.run(FileHandlerApplication.class, args);
    }
}
