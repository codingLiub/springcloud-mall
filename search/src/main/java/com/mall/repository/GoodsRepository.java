package com.mall.repository;

import com.mall.pojo.Goods;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/6/23 20:59
 * @ Description：文档操作
 * @ Modified By：
 */
public interface GoodsRepository extends ElasticsearchRepository<Goods,Long> {
}
