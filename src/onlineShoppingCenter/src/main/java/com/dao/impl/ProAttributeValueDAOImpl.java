package com.dao.impl;

import com.dao.ProAttributeValueDAO;
import com.entity.ProAttributeValue;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by ZS on 2016/6/27.
 */
public class ProAttributeValueDAOImpl implements ProAttributeValueDAO{

    private SessionFactory sessionFactory;

    private static final String HQL_FIND_BY_PROATRRIBUTEID="from ProAttributeValue "
            +"WHERE pro_attribute_ID =:pro_attribute_ID";
    private static final String HQL_FIND_BY_PROATRRIBUTEVALUEID="from ProAttributeValue "
            +"WHERE pro_attribute_value_ID =:pro_attribute_value_ID";

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //增加商品属性值
    public void addProAttributeValue(ProAttributeValue proAttributeValue){

        getSessionFactory().getCurrentSession().save(proAttributeValue);
    }

    //删除商品属性值
    public void deleteProAttributeValue(ProAttributeValue proAttributeValue){

        getSessionFactory().getCurrentSession().delete(proAttributeValue);
    }

    //更新商品属性值
    public void updateProAttributeValue(ProAttributeValue proAttributeValue){

        getSessionFactory().getCurrentSession().saveOrUpdate(proAttributeValue);
    }

    //根据pro_attribute_ID查询商品属性值
    public List<ProAttributeValue> findByProAttributeID(int pro_attribute_ID){
        return getSessionFactory().getCurrentSession()
                .createQuery(HQL_FIND_BY_PROATRRIBUTEID)
                .setParameter("pro_attribute_ID",pro_attribute_ID)
                .list();
    }

    //根据pro_attribute_value_ID查询商品属性值
    public List<ProAttributeValue> findByProAttributeValueID(int pro_attribute_value_ID){
        return getSessionFactory().getCurrentSession()
                .createQuery(HQL_FIND_BY_PROATRRIBUTEVALUEID)
                .setParameter("pro_attribute_value_ID",pro_attribute_value_ID)
                .list();
    }
}
