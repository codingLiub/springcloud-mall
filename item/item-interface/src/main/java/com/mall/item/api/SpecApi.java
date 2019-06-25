package com.mall.item.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/6/25 11:21
 * @ Description：${description}
 * @ Modified By：
 */
public interface SpecApi {
    /**
     * 查询商品分类对应的规格参数模板
     * @param id
     * @return
     */
    @GetMapping("{id}")
    ResponseEntity<String> querySpecificationByCategoryId(@PathVariable("id") Long id);
}
