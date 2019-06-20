package com.mall.item.service;

import com.mall.common.pojo.PageResult;
import com.mall.item.bo.SpuBo;
import com.mall.parameter.pojo.SpuQueryByPageParameter;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/6/20 10:21
 * @ Description：${description}
 * @ Modified By：
 */
public interface GoodsService {
    /**
     * 分页查询
     * @param spuQueryByPageParameter
     * @return
     */
    public PageResult<SpuBo> querySpuByPageAndSort(SpuQueryByPageParameter spuQueryByPageParameter);

    /**
     * 保存商品
     * @param spu
     * @return
     */
    void saveGoods(SpuBo spu);

    /**
     * 根据id查询商品信息
     * @param id
     * @return
     */
    SpuBo queryGoodsById(Long id);

    /**
     * 更新商品信息
     * @param spuBo
     */
    void updateGoods(SpuBo spuBo);

    /**
     * 商品删除，单个多个二合一
     * @param id
     */
    void deleteGoods(long id);

    /**
     * 商品下架
     * @param id
     */
    void goodsSoldOut(Long id);
}
