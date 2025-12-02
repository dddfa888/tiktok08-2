package com.auto.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan({"com.auto.mall.mapper"})
@SpringBootConfiguration
@SpringBootApplication
@EnableScheduling
public class MallAutoApplication {
  public static void main(String[] args) {
    SpringApplication.run(MallAutoApplication.class, args);
  }
}
