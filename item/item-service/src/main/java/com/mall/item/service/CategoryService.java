package com.mall.item.service;

import com.mall.item.pojo.Category;

import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/4/24 15:26
 * @ Description：分类的业务层接口
 * @ Modified By：
 */

public interface CategoryService {
    /**
     * 根据id查询分类
     * @param pid
     * @return
     */
    List<Category> queryCategoryByPid(Long pid);

    /**
     * 保存
     * @param category
     */
    void saveCategory(Category category);

    /**
     * 删除
     * @return
     */
    void deleteCategory(Long id);

    /**
     * 更新
     * @return
     */
    void updateCategory(Category category);

    /**
     * 查询当前数据库中最后一条数据
     * @return
     */
    List<Category> queryLast();

    /**
     * 根据brand id查询分类信息
     * @param bid
     * @return
     */
    List<Category> queryByBrandId(Long bid);

    /**
     * 根据ids查询名字
     * @param asList
     * @return
     */
    List<String> queryNameByIds(List<Long> asList);
}
