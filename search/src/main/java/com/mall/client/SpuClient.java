package com.mall.client;

import com.mall.item.api.SpuApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/6/25 11:27
 * @ Description：${description}
 * @ Modified By：
 */
@FeignClient(value = "item-service")
public interface SpuClient extends SpuApi {
}
