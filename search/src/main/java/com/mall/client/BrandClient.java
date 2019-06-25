package com.mall.client;

import com.mall.item.api.BrandApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/6/25 11:16
 * @ Description：品牌FeignClient
 * @ Modified By：
 */
@FeignClient(value = "item-service")
public interface BrandClient extends BrandApi {
}
