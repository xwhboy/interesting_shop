package com.dao.impl;

import com.dao.BaseDAO;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ZK on 3/6/16.
 */
public class BaseDAOImpl<T> implements BaseDAO<T> {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<T> find(String hql) {
        return getSessionFactory().getCurrentSession()
                .createQuery(hql)
                .list();
    }

    public List<T> find(String hql, Object... params) {
        Query query = getSessionFactory().getCurrentSession()
                .createQuery(hql);
        for (int i = 0; i < params.length; i++) {
            query.setParameter(i, params[i]);
        }
        return (List<T>)query.list();
    }

    public List<T> findAll(Class<T> entityClass) {
        return find("FROM " + entityClass.getSimpleName());
    }

    public Serializable save(T entity) {
        return getSessionFactory().getCurrentSession().save(entity);
    }

    public void update(T entity) {
        getSessionFactory().getCurrentSession().saveOrUpdate(entity);
    }

    public void delete(T entity) {
        getSessionFactory().getCurrentSession().delete(entity);
    }

    public void delete(Class<T> entityClass, Serializable id) {
        getSessionFactory().getCurrentSession().createQuery(
                "DELETE FROM " + entityClass.getSimpleName() +
                        " en WHERE en.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    public long count(Class<T> entityClass) {
        List<T> list = find("SELECT count(*) FROM " + entityClass.getSimpleName());
        if (list != null && list.size() == 1) {
            return (Long)list.get(0);
        }
        return 0;
    }
}
