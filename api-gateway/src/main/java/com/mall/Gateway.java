package com.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/4/23 18:54
 * @ Description：${description}
 * @ Modified By：
 */
@EnableZuulProxy
@SpringCloudApplication
public class Gateway {
    public static void main(String[] args) {
        SpringApplication.run(Gateway.class);
    }
}
