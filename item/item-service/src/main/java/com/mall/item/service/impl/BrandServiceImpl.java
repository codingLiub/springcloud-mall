package com.mall.item.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mall.common.pojo.PageResult;
import com.mall.item.mapper.BrandMapper;
import com.mall.item.pojo.Brand;
import com.mall.item.service.BrandService;
import com.mall.parameter.pojo.BrandQueryByPageParameter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/6/19 22:03
 * @ Description：品牌的业务层
 * @ Modified By：
 */
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;

    @Override
    public PageResult<Brand> queryBrandByPageAndSort(BrandQueryByPageParameter brandQueryByPageParameter) {
        /**
         * 1.分页
         */
        PageHelper.startPage(brandQueryByPageParameter.getPage(),brandQueryByPageParameter
        .getRows());

        /**
         *  2.排序
         */
        Example example=new Example(Brand.class);
        if(StringUtils.isNotBlank(brandQueryByPageParameter.getSortBy())){
            example.setOrderByClause(brandQueryByPageParameter.getSortBy()+(brandQueryByPageParameter.getDesc()?"DESC":"ASC"));
        }

        /**
         * 3.查询
         */
        if(StringUtils.isNotBlank(brandQueryByPageParameter.getKey())) {
            example.createCriteria().orLike("name",brandQueryByPageParameter.getKey()+"%").orEqualTo("letter",brandQueryByPageParameter.getKey().toUpperCase());
        }
        List<Brand> list=this.brandMapper.selectByExample(example);

        /**
         * 4.创建PageInfo
         */
        PageInfo<Brand> pageInfo=new PageInfo<>(list);
        /**
         * 5.返回分页结果
         */
        return new PageResult<>(pageInfo.getTotal(),pageInfo.getList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveBrand(Brand brand, List<Long> categories) {
        // 新增品牌信息
        this.brandMapper.insertSelective(brand);
        // 新增品牌和分类中间表
        for (Long cid:categories){
            this.brandMapper.insertCategoryBrand(cid,brand.getId());
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBrand(long id) {
        //删除品牌信息
        this.brandMapper.deleteByPrimaryKey(id);

        //维护中间表
        this.brandMapper.deleteByBrandIdInCategoryBrand(id);
    }

    @Override
    public List<Brand> queryBrandByCategoryId(Long cid) {
        return this.brandMapper.queryBrandByCategoryId(cid);
    }

    @Override
    public List<Brand> queryBrandByBrandIds(List<Long> ids) {
        return this.brandMapper.selectByIdList(ids);
    }
}
