package com.mall.client;

import com.mall.item.api.GoodsApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/6/24 9:23
 * @ Description：商品FeignClient
 * @ Modified By：
 */
@FeignClient(value = "item-service")
public interface GoodsClient extends GoodsApi {

}
