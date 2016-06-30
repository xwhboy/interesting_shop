package com.dao;

import com.entity.ProAttributeValue;

import java.util.List;

/**
 * Created by ZS on 2016/6/27.
 */
public interface ProAttributeValueDAO {

    //增加商品属性值
    void addProAttributeValue(ProAttributeValue proAttributeValue);

    //删除商品属性值
    void deleteProAttributeValue(ProAttributeValue proAttributeValue);

    //更新商品属性值
    void updateProAttributeValue(ProAttributeValue proAttributeValue);

    //根据pro_attribute_ID查询商品属性值
    List<ProAttributeValue> findByProAttributeID(int pro_attribute_ID);

    //根据pro_attribute_value_ID查询商品属性值
    List<ProAttributeValue> findByProAttributeValueID(int pro_attribute_value_ID);
}
