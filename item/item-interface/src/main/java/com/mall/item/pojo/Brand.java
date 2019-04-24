package com.mall.item.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/4/24 15:51
 * @ Description：${description}
 * @ Modified By：
 */
@Data
@Table(name = "tb_brand")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**品牌名称 */
    private String name;
    /** 品牌图片 */
    private String image;
    private Character letter;
}
