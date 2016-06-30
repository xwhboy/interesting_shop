package com.service;

import com.entity.ProAttribute;

import java.util.List;

/**
 * Created by ZS on 2016/6/27.
 */
public interface ProAttributeService {

    //添加商品属性
    void addProAttr(ProAttribute proAttr);

    //删除商品属性
    void deleteProAttr(ProAttribute proAttr);

    //更新商品属性
    void updateProAttr(ProAttribute proAttr);

    //查找指定商品名称的商品属性
    List<ProAttribute> findProAttr(String proName);

}
