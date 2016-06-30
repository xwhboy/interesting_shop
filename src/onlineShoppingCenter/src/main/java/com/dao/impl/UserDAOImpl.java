package com.dao.impl;

import com.dao.UserDAO;
import com.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by ZK on 6/26/16.
 */
public class UserDAOImpl implements UserDAO {
    private SessionFactory sessionFactory;

    private static final String HQL_FIND_BY_ACCOUNT = "FROM User u " +
            "WHERE u.userAccount = :userAccount AND u.userPassword = :userPassword";

    private static final String HQL_FIND_BY_ID = "FROM User u " +
            "WHERE u.userId = :userId";

    public List<User> login(User user) {
        return getSessionFactory().getCurrentSession()
                .createQuery(HQL_FIND_BY_ACCOUNT)
                .setParameter("userAccount", user.getUserAccount())
                .setParameter("userPassword", user.getUserPassword())
                .list();
    }

    public List<User> register(User user) {
        Session session = getSessionFactory().getCurrentSession();
        return session.createQuery(HQL_FIND_BY_ID)
                      .setParameter("userId", session.save(user))
                      .list();
    }

    public List<User> change(User user) {
        Session session = getSessionFactory().getCurrentSession();
        session.saveOrUpdate(user);

        return session.createQuery(HQL_FIND_BY_ID)
                .setParameter("userId", user.getUserId())
                .list();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
