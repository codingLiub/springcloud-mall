package com.mall.service;

import com.mall.bo.SearchRequest;
import com.mall.item.pojo.Spu;
import com.mall.pojo.Goods;
import com.mall.vo.SearchResult;

import java.io.IOException;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/6/24 9:26
 * @ Description：搜索功能
 * @ Modified By：
 */
public interface SearchService {
    /**
     * 查询商品信息
     *
     * @param spu
     * @return
     * @throws IOException
     */
    Goods buildGoods(Spu spu) throws IOException;

    /**
     * 商品搜索
     *
     * @param searchRequest
     * @return
     */
    SearchResult<Goods> search(SearchRequest searchRequest);

    /**
     * 根据goods的id创建相应的索引
     *
     * @param id
     * @throws IOException
     */
    void createIndex(Long id) throws IOException;

    /**
     * 根据goods的id删除相应的索引
     *
     * @param id
     */
    void deleteIndex(Long id);
}
