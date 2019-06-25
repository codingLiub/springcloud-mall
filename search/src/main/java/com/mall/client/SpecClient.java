package com.mall.client;

import com.mall.item.api.SpecApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/6/25 11:27
 * @ Description：特有属性FeignClient
 *
 * @ Modified By：
 */
@FeignClient(value = "item-service")
public interface SpecClient extends SpecApi {
}
