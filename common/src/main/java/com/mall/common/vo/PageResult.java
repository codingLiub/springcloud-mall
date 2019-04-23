package com.mall.common.vo;

import lombok.Data;

import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/4/23 21:01
 * @ Description：分页类
 * @ Modified By：
 */
@Data
public class PageResult<T> {
    private Long total;     // 总条数
    private Long totalPage; // 总页数
    private List<T> items;  // 当前页数据

    public PageResult() {
    }

    public PageResult(Long total, List<T> items) {
        this.total = total;
        this.items = items;
    }

    public PageResult(Long total, Long totalPage, List<T> items) {
        this.total = total;
        this.totalPage = totalPage;
        this.items = items;
    }
}
