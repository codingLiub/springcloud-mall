package com.mall.item.service;

import com.mall.common.enums.ExceptionEnum;
import com.mall.common.exception.MallException;
import com.mall.item.mapper.CategoryMapper;
import com.mall.item.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/4/24 15:26
 * @ Description：${description}
 * @ Modified By：
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> queryCategoryListByPid(Long pid){
        Category category=new Category();
        category.setParentId(pid);
        List<Category> list=categoryMapper.select(category);
        if(CollectionUtils.isEmpty(list)){
            throw new MallException(ExceptionEnum.CATEGORY_NOT_FOUND);
        }
        return list;
    }

    public List<Category> queryByIds(List<Long> ids){
        final List<Category> list=categoryMapper.selectByIdList(ids);
        if (CollectionUtils.isEmpty(list)) {
            throw new MallException(ExceptionEnum.CATEGORY_NOT_FOUND);
        }
        return list;
    }
}
