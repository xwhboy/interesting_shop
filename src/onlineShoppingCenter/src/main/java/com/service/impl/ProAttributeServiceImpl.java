package com.service.impl;

import com.dao.ProAttributeDAO;
import com.entity.ProAttribute;
import com.service.ProAttributeService;

import java.util.List;

/**
 * Created by ZS on 2016/6/27.
 */
public class ProAttributeServiceImpl implements ProAttributeService {

    private ProAttributeDAO proAttributeDAO;

    public ProAttributeDAO getProAttributeDAO() {
        return proAttributeDAO;
    }

    public void setProAttributeDAO(ProAttributeDAO proAttributeDAO) { this.proAttributeDAO = proAttributeDAO;}

    //添加商品属性
    public void addProAttr(ProAttribute proAttr){ proAttributeDAO.addProAttr(proAttr); }

    //删除商品属性
    public void deleteProAttr(ProAttribute proAttr){ proAttributeDAO.deleteProAttr(proAttr);}

    //更新商品属性
    public void updateProAttr(ProAttribute proAttr){ proAttributeDAO.updateProAttr(proAttr);}

    //查找指定商品名称的商品属性
    public List<ProAttribute> findProAttr(String proName){ return proAttributeDAO.findProAttr(proName);}
}
