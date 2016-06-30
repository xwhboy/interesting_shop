package com.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ZK on 3/6/16.
 */
public interface BaseDAO<T> {
    List<T> find(String hql);
    List<T> find(String hql, Object... params);
    List<T> findAll(Class<T> entityClass);
    Serializable save(T entity);
    void update(T entity);
    void delete(T entity);
    void delete(Class<T> entityClass, Serializable id);
    long count(Class<T> entityClass);
}
