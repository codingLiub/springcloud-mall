package com.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/4/23 18:28
 * @ Description：${description}
 * @ Modified By：
 */
@SpringBootApplication
@EnableEurekaServer
public class Registry {
    public static void main(String[] args) {
        SpringApplication.run(Registry.class);
    }
}
