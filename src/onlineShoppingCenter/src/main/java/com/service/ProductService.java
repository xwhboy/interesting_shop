package com.service;

import com.entity.Product;
import com.entity.Sort;

import java.util.List;

/**
 * Created by ZS on 2016/6/27.
 */
public interface ProductService {

    //添加商品
    String addPro(Product product);

    //删除商品
    String deletePro(Product product);

    //更新商品
    String updatePro(Product product);

    //查找所有商品
    List<Product> findAllPro();

    //按照总销量从高到低查找所有商品
    List<Product> findAllProByProSellCount();

    //按照价格从高到低查找所有商品
    List<Product> findAllProByProPrice();

    //根据商品名称查找商品，模糊查找
    List<Product> findProByKeyWord(String proName);

    //通过商品名称模糊查询并分页显示
    List<Product> findProByKeyWord(String proName,int beginIndex,int pageSize);

    //通过商品的类别查询
    List<Product> findProBySort(Sort sort);
}
