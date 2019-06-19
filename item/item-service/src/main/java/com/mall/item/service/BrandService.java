package com.mall.item.service;

import com.mall.common.pojo.PageResult;
import com.mall.item.pojo.Brand;
import com.mall.parameter.pojo.BrandQueryByPageParameter;

import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/4/24 16:00
 * @ Description：品牌的业务层接口
 * @ Modified By：
 */

public interface BrandService {
    /**
     * 分页查询
     * @param brandQueryByPageParameter
     * @return
     */
    PageResult<Brand> queryBrandByPageAndSort(BrandQueryByPageParameter brandQueryByPageParameter);

    /**
     * 新增brand,并且维护中间表
     * @param brand
     * @param categories
     */
    void saveBrand(Brand brand, List<Long> categories);

    /**
     * 删除brand，并且维护中间表
     * @param id
     */
    void deleteBrand(long id);

    /**
     * 根据category id查询brand
     * @param cid
     * @return
     */
    List<Brand> queryBrandByCategoryId(Long cid);

    /**
     * 根据品牌id集合查询品牌信息
     * @param ids
     * @return
     */
    List<Brand> queryBrandByBrandIds(List<Long> ids);
}
