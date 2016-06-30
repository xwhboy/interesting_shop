package com.dao;

import com.entity.ProAttribute;

import java.util.List;

/**
 * Created by ZS on 6/26/16.
 */
public interface ProAttributeDAO {

    //添加商品属性
    void addProAttr(ProAttribute proAttr);

    //删除商品属性
    void deleteProAttr(ProAttribute proAttr);

    //更新商品属性
    void updateProAttr(ProAttribute proAttr);

    //查找指定商品名的商品属性
    List<ProAttribute> findProAttr(String pro_name);

}
