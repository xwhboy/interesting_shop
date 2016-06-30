package com.service;

import com.entity.ProAttributeValue;

import java.util.List;

/**
 * Created by ZS on 2016/6/28.
 */
public interface ProAttributeValueService {

    //增加商品属性值
    void addProAttrVal(ProAttributeValue proAttributeValue);

    //删除商品属性值
    void deleteProAttrVal(ProAttributeValue proAttributeValue);

    //更新商品属性值
    void updateProAttrVal(ProAttributeValue proAttributeValue);

    //查询商品属性值
    List<ProAttributeValue> findByProAttributeID(int pro_attribute_ID);
}
