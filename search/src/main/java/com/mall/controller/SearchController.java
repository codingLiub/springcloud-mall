package com.mall.controller;

import com.mall.bo.SearchRequest;
import com.mall.client.GoodsClient;
import com.mall.common.pojo.PageResult;
import com.mall.pojo.Goods;
import com.mall.repository.GoodsRepository;
import com.mall.service.SearchService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/6/24 15:33
 * @ Description：${description}
 * @ Modified By：
 */
public class SearchController implements InitializingBean {
    @Autowired
    private SearchService searchService;

    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private GoodsClient goodsClient;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @PostMapping("page")
    public ResponseEntity<PageResult<Goods>> search(@RequestBody SearchRequest searchRequest){
        PageResult<Goods> result = this.searchService.search(searchRequest);
        if (result == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return ResponseEntity.ok(result);
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
