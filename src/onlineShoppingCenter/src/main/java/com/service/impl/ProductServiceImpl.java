package com.service.impl;

import com.dao.ProductDAO;
import com.entity.Product;
import com.entity.Sort;
import com.service.ProductService;

import java.util.Collections;
import java.util.List;

/**
 * Created by ZS on 2016/6/27.
 */
public class ProductServiceImpl implements ProductService{

    private ProductDAO productDAO;

    public ProductDAO getProductDAO() {
        return productDAO;
    }

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    //添加商品
    public String addPro(Product product){
        //添加之前判断数据库中是否已经存在相同商品名称的商品，若存在，则无法添加，否则可以添加
        if (productDAO.findPro(product.getProName()).size() != 0){
            return "false";
        }else {
            productDAO.addPro(product);
        }
        return "true";
    }

    //删除商品
    public String deletePro(Product product){
        //删除之前判断数据库中是否存在该商品，若存在则执行删除操作
        if(productDAO.findPro(product.getProName()).size() != 0) {
            productDAO.deletePro(product);
        }else{
            return "false";
        }
        return "true";
    }

    //更新商品
    public String updatePro(Product product) {
        //更新前判断数据库中是否存在该商品，若存在则执行更新操作
        if(productDAO.findPro(product.getProName()).size() != 0){
            productDAO.updatePro(product);
        }else {
            return "false";
        }
       return "true";
    }

    //查找所有商品
    public List<Product> findAllPro(){
        return productDAO.findAllPro();
    }

    //按照总销量从高到低查找所有商品
    public List<Product> findAllProByProSellCount(){
        List<Product> result = productDAO.findAllPro();
        for(int i = 0; i < result.size();i++){
            for(int j = i+1; j < result.size();j++){
                if(result.get(i).getProSellCount() < result.get(j).getProSellCount()){
                    Collections.swap(result,i,j);
                }
            }
        }
        return result;
    }

    //按照价格从高到低查找所有商品
    public List<Product> findAllProByProPrice(){
        List<Product> result = productDAO.findAllPro();
        for(int i = 0; i < result.size();i++){
            for(int j = i+1; j < result.size();j++){
                if(result.get(i).getProPrice() < result.get(j).getProPrice()){
                    Collections.swap(result,i,j);
                }
            }
        }
        return result;
    }

    //按商品名称查找商品，模糊查找
    public List<Product> findProByKeyWord(String proName){
        List<Product> result = null;
        result = productDAO.findProByKeyWord(proName);
        return result;
    }

    //通过商品名称模糊查询并分页显示
    public List<Product> findProByKeyWord(String proName,int pageNum,int pageSize){
        List<Product> result = null;
        if(proName!=null && !proName.equals("") && pageNum > 0 && pageSize > 0){
            result = productDAO.findProByKeyWord(proName,pageNum,pageSize);
        }
        return result;
    }

    //通过商品的类别查询
    public List<Product> findProBySort(Sort sort){
        List<Product> result = null;
        result = productDAO.findProBySortID(sort.getSortId());
        return result;
    }
}
