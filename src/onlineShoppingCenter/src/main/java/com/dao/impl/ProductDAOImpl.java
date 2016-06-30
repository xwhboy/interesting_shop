package com.dao.impl;

import com.dao.ProductDAO;
import com.entity.Product;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by ZS on 2016/6/26.
 */
public class ProductDAOImpl implements ProductDAO{

    private SessionFactory sessionFactory;

    private static final String HQL_FIND_BY_PRO_NAME = "FROM Product p " +
            "WHERE p.proName = :proName";
    //定义一些查询语句
    private static final String HQL_FIND_ALL = "FROM Product ";

    private static final String HQL_FIND_BY_KEYWORD = "FROM Product " +
            "WHERE proName LIKE :proName";

    private static final String HQL_FIND_BY_SORT = "FROM Product " +
            "WHERE sortID = :sortID";

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //添加商品
    public void addPro(Product product){

        getSessionFactory().getCurrentSession().save(product);
    }
    //删除商品
    public void deletePro(Product product){

        getSessionFactory().getCurrentSession().delete(product);
    }
    //更新商品信息
    public void updatePro(Product product) {

        getSessionFactory().getCurrentSession().saveOrUpdate(product);
    }

    //查找指定商品名称的商品
    public List<Product> findPro(String proName){
        return getSessionFactory().getCurrentSession()
                .createQuery(HQL_FIND_BY_PRO_NAME)
                .setParameter("proName", proName)
                .list();
    }

    //查询所有商品
    public List<Product> findAllPro(){
        return getSessionFactory().getCurrentSession()
                .createQuery(HQL_FIND_ALL)
                .list();
    }
    //通过关键字查询
    public List<Product> findProByKeyWord(String proName){
        return getSessionFactory().getCurrentSession()
                .createQuery(HQL_FIND_BY_KEYWORD)
                .setParameter("proName", proName)
                .list();
    }
    //通过商品名称模糊查询并分页显示
    public List<Product> findProByKeyWord(String proName,int pageNum,int pageSize){

        int beginIndex = (pageNum-1) *  pageSize ;
        Query hqlQuery = getSessionFactory().getCurrentSession()
                .createQuery(HQL_FIND_BY_KEYWORD)
                .setParameter("proName", proName);
        // 从第几条记录开始查询
        hqlQuery.setFirstResult(beginIndex);

        // 一共查询多少条记录
        hqlQuery.setMaxResults(pageSize);

        // 获取查询的结果
        return hqlQuery.list();
    }

    //通过商品分类查询商品
    public List<Product> findProBySortID(int sortID){
        return  getSessionFactory().getCurrentSession()
                .createQuery(HQL_FIND_BY_SORT)
                .setParameter("sortID", sortID)
                .list();
    }

}
