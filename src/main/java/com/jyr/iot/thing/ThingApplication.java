package com.jyr.iot.thing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan(value = "com.jyr.iot.platform.mapper")
@SpringBootApplication
public class ThingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThingApplication.class, args);
    }

}
