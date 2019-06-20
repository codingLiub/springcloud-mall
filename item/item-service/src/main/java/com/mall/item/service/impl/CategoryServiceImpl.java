package com.mall.item.service.impl;

import com.mall.item.mapper.CategoryMapper;
import com.mall.item.pojo.Category;
import com.mall.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/6/19 16:19
 * @ Description：分类的业务层
 * @ Modified By：
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> queryCategoryByPid(Long pid) {
        Category t=new Category();
        t.setParentId(pid);
        return this.categoryMapper.select(t);
    }

    @Override
    public void saveCategory(Category category) {
        /**
         * 将本节点插入到数据库中
         * 将此category的父节点的isParent设为true
         */
        //1.首先置id为null
        category.setId(null);
        //2.保存
        this.categoryMapper.insert(category);
        //3.修改父节点
        Category parent = new Category();
        parent.setId(category.getParentId());
        parent.setIsParent(true);
        this.categoryMapper.updateByPrimaryKeySelective(parent);
    }

    @Override
    public void deleteCategory(Long id) {
        Category category=this.categoryMapper.selectByPrimaryKey(id);
        if(category.getIsParent()){
            //查找所有的叶子节点
            List<Category> list=new ArrayList<>();
            queryAllLeafNode(category,list);

            //2.查找所有子节点
            List<Category> list2 = new ArrayList<>();
            queryAllNode(category,list2);

            //3.删除tb_category中的数据,使用list2
            for(Category c:list2){
                this.categoryMapper.delete(c);
            }

            //4.维护中间表
            for (Category c:list){
                this.categoryMapper.deleteByCategoryIdInCategoryBrand(c.getId());
            }
        }else {
            //1.查询此节点的父亲节点的孩子个数 ===> 查询还有几个兄弟
            Example example=new Example(Category.class);
            example.createCriteria().andEqualTo("parentId",category.getParentId());
            List<Category> list=this.categoryMapper.selectByExample(example);
            if(list.size()!=1){
                //有兄弟,直接删除自己
                this.categoryMapper.deleteByPrimaryKey(category.getId());

                //维护中间表
                this.categoryMapper.deleteByCategoryIdInCategoryBrand(category.getId());
            }else {
                //已经没有兄弟了
                this.categoryMapper.deleteByPrimaryKey(category.getId());

                Category parent=new Category();
                parent.setId(category.getParentId());
                parent.setIsParent(false);
                this.categoryMapper.updateByPrimaryKeySelective(parent);

                //维护中间表
                this.categoryMapper.deleteByCategoryIdInCategoryBrand(category.getId());
            }
        }
    }

    @Override
    public void updateCategory(Category category) {
        this.categoryMapper.updateByPrimaryKeySelective(category);
    }

    @Override
    public List<Category> queryLast() {
        List<Category> last =this.categoryMapper.selectLast();
        return last;
    }

    @Override
    public List<Category> queryByBrandId(Long bid) {
        return this.categoryMapper.queryByBrandId(bid);
    }

    @Override
    public List<String> queryNameByIds(List<Long> asList) {
        List<String> names = new ArrayList<>();
        if (asList != null && asList.size() !=0){
            for (Long id : asList) {
                names.add(this.categoryMapper.queryNameById(id));
            }
        }
        return names;
        //使用通用mapper接口中的SelectByIdListMapper接口查询
        //return this.categoryMapper.selectByIdList(asList).stream().map(Category::getName).collect(Collectors.toList());
    }

    /**
     * 查询本节点下所有子节点
     * @param category
     * @param node
     */
    private void queryAllNode(Category category, List<Category> node) {
        node.add(category);
        Example example = new Example(Category.class);
        example.createCriteria().andEqualTo("parentId",category.getId());
        List<Category> list=this.categoryMapper.selectByExample(example);

        for (Category category1:list){
            queryAllNode(category1,node);
        }
    }

    /**
     * 查询本节点下所包含的所有叶子节点，用于维护tb_category_brand中间表
     * @param category
     * @param leafNode
     */
    private void queryAllLeafNode(Category category, List<Category> leafNode) {
        if(!category.getIsParent()){
            leafNode.add(category);
        }
        Example example=new Example(Category.class);
        example.createCriteria().andEqualTo("parentId",category.getId());
        List<Category> list=this.categoryMapper.selectByExample(example);

        for(Category category1:list){
            queryAllLeafNode(category1,leafNode);
        }
    }
}
