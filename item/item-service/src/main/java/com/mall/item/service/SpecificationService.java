package com.mall.item.service;

import com.mall.item.pojo.Specification;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/6/20 9:30
 * @ Description：规格的业务层接口
 * @ Modified By：
 */
public interface SpecificationService {
    /**
     * 根据category id查询规格参数模板
     * @param id
     * @return
     */
    Specification queryById(Long id);

    /**
     * 添加规格参数模板
     * @param specification
     */
    void saveSpecification(Specification specification);

    /**
     * 修改一个规格参数模板
     * @param specification
     * @return
     */
    void updateSpecification(Specification specification);

    /**
     * 删除规格参数模板
     * @param specification
     */
    void deleteSpecification(Specification specification);
}
