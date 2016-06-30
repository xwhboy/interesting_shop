package com.dao;

import com.entity.Product;

import java.util.List;

/**
 * Created by Z on 6/26/16.
 */
public interface ProductDAO {
    //添加商品
    void addPro(Product product);

   //删除商品
    void deletePro(Product product);

   //更新商品信息
    void updatePro(Product product);

    //查找指定商品名称的商品
    List<Product> findPro(String pro_name);

   //查询所有商品信息
    List<Product> findAllPro();

   //通过关键字进行模糊查询
    List<Product> findProByKeyWord(String proName);

    //通过关键字进行模糊查询，并按照分页显示
    List<Product> findProByKeyWord(String proName,int pageNum,int pageSize);

    //通过商品分类查询商品
    List<Product> findProBySortID(int sortID);
}
