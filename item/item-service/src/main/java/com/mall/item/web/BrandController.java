package com.mall.item.web;

import com.mall.common.pojo.PageResult;
import com.mall.item.pojo.Brand;
import com.mall.item.pojo.Category;
import com.mall.item.service.BrandService;
import com.mall.parameter.pojo.BrandQueryByPageParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/4/24 16:10
 * @ Description：${description}
 * @ Modified By：
 */
@RestController
@RequestMapping("brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    /**
     * 分页查询品牌
     * @param page
     * @param rows
     * @param sortBy
     * @param desc
     * @param key
     * @return
     */
    @GetMapping("page")
    public ResponseEntity<PageResult<Brand>> queryBrandByPage(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows,
            @RequestParam(value = "sortBy", required = false) String sortBy,
            @RequestParam(value = "desc", defaultValue = "false") Boolean desc,
            @RequestParam(value = "key", required = false) String key) {
        BrandQueryByPageParameter brandQueryByPageParameter=new BrandQueryByPageParameter(page,rows,sortBy,desc,key);
        PageResult<Brand> result = brandService.queryBrandByPageAndSort(brandQueryByPageParameter);
        if (result == null ) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(result);
    }

    /**
     * 新增品牌
     * @param brand
     * @param categories
     * @return
     */
    @PostMapping
    public ResponseEntity<Void> saveBrand(Brand brand, @RequestParam("categories") List<Long> categories) {
        this.brandService.saveBrand(brand, categories);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 删除tb_brand中的数据,单个删除、多个删除二合一
     * @param bid
     * @return
     */
    @DeleteMapping("bid/{bid}")
    public ResponseEntity<Void> deleteBrand(@PathVariable("bid") String bid) {
        String separator="-";
        if(bid.contains(separator)){
            String[] ids=bid.split(separator);
            for (String id:ids){
                this.brandService.deleteBrand(Long.parseLong(id));
            }
        }
        else {
            this.brandService.deleteBrand(Long.parseLong(bid));
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /**
     * 根据分类查询品牌
     * @param cid
     * @return
     */
    @GetMapping("cid/{cid}")
    public ResponseEntity<List<Brand>> queryBrandByCategory(@PathVariable("cid") Long cid) {
        List<Brand> list = this.brandService.queryBrandByCategoryId(cid);
        if (list == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(list);
    }



    /**
     * 根据id列表查询品牌列表
     * @param ids
     * @return
     */
    @GetMapping("list")
    public ResponseEntity<List<Brand>> queryBrandByIds(@RequestParam("ids") List<Long> ids) {
        List<Brand> list = this.brandService.queryBrandByBrandIds(ids);
        if (list == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(list);
    }

}
