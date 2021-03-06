package com.mall.item.api;

import com.mall.common.pojo.PageResult;
import com.mall.item.bo.SpuBo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/6/25 11:21
 * @ Description：${description}
 * @ Modified By：
 */
@RequestMapping("spu")
public interface SpuApi {
    /**
     * 分页查询
     * @param page
     * @param rows
     * @param desc
     * @param saleable
     * @return
     */
    @GetMapping("page")
    ResponseEntity<PageResult<SpuBo>> querySpuByPage(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows,
            @RequestParam(value = "desc", defaultValue = "false") Boolean desc,
            @RequestParam(value = "saleable",defaultValue = "true") Boolean saleable);
}
