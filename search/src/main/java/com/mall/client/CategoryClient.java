package com.mall.client;

import com.mall.item.api.CategoryApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/6/24 9:24
 * @ Description：商品分类FeignClient
 * @ Modified By：
 */
@FeignClient(value = "item-service")
public interface CategoryClient extends CategoryApi {
}