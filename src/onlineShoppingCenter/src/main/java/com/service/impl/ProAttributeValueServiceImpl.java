package com.service.impl;

import com.dao.ProAttributeValueDAO;
import com.entity.ProAttributeValue;
import com.service.ProAttributeValueService;

import java.util.List;

/**
 * Created by ZS on 2016/6/28.
 */
public class ProAttributeValueServiceImpl implements ProAttributeValueService{

    private ProAttributeValueDAO proAttributeValueDAO;

    public ProAttributeValueDAO getProAttributeValueDAO() {
        return proAttributeValueDAO;
    }

    public void setProAttributeValueDAO(ProAttributeValueDAO proAttributeValueDAO) {
        this.proAttributeValueDAO = proAttributeValueDAO;
    }

    //增加商品属性值
    public void addProAttrVal(ProAttributeValue proAttributeValue){ proAttributeValueDAO.addProAttributeValue(proAttributeValue);}

    //删除商品属性值
    public void deleteProAttrVal(ProAttributeValue proAttributeValue){ proAttributeValueDAO.deleteProAttributeValue(proAttributeValue);}

    //更新商品属性值
    public void updateProAttrVal(ProAttributeValue proAttributeValue){ proAttributeValueDAO.updateProAttributeValue(proAttributeValue);}

    //查询商品属性值
    public List<ProAttributeValue> findByProAttributeID(int pro_attribute_ID){
        return proAttributeValueDAO.findByProAttributeID(pro_attribute_ID);
    }
}
