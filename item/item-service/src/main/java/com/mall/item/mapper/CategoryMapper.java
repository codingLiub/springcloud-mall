package com.mall.item.mapper;

import com.mall.item.pojo.Category;
import tk.mybatis.mapper.additional.idlist.IdListMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/4/24 15:14
 * @ Description：${description}
 * @ Modified By：
 */
public interface CategoryMapper extends Mapper<Category>,IdListMapper<Category,Long> {
}
