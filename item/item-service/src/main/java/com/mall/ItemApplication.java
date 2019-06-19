package com.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/4/23 19:15
 * @ Description：${description}
 * @ Modified By：
 */
@SpringBootApplication
@EnableDiscoveryClient
// 导入tk包
@MapperScan("com.mall.item.mapper")
public class ItemApplication {
    public static void main(String[] args) {
        SpringApplication.run(ItemApplication.class);
    }
}
