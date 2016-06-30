package com.dao;

import com.entity.User;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ZK on 6/26/16.
 */
public interface UserDAO {
    List<User> login(User user);

    List<User> register(User user);

    List<User> change(User user);
}
