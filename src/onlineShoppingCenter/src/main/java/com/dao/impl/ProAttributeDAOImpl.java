package com.dao.impl;

import com.dao.ProAttributeDAO;
import com.entity.ProAttribute;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by ZS on 2016/6/26.
 */
public class ProAttributeDAOImpl implements ProAttributeDAO{

    private SessionFactory sessionFactory;

    private static final String HQL_FIND_BY_PRO_NAME = "FROM ProAttribute pa " +
            "WHERE pa.proName = :proName";

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //添加商品属性
    public void addProAttr(ProAttribute proAttr){

        getSessionFactory().getCurrentSession().save(proAttr);
    }

    //删除商品属性
    public void deleteProAttr(ProAttribute proAttr){

        getSessionFactory().getCurrentSession().delete(proAttr);
    }

    //更新商品属性
    public void updateProAttr(ProAttribute proAttr){

        getSessionFactory().getCurrentSession().saveOrUpdate(proAttr);
    }

    //查找指定商品名称的商品属性
    public List<ProAttribute> findProAttr(String proName){
        return getSessionFactory().getCurrentSession()
                .createQuery(HQL_FIND_BY_PRO_NAME)
                .setParameter("proName", proName)
                .list();
    }


}
