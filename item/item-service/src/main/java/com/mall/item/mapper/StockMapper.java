package com.mall.item.mapper;

import com.mall.item.pojo.Stock;
import tk.mybatis.mapper.additional.idlist.SelectByIdListMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/6/20 13:20
 * @ Description：${description}
 * @ Modified By：
 */
@org.apache.ibatis.annotations.Mapper
public interface StockMapper extends Mapper<Stock> , SelectByIdListMapper<Stock,Long> {
}
