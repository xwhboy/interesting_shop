package com.service.impl;

import com.dao.UserDAO;
import com.entity.User;
import com.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ZK on 6/26/16.
 */
public class UserServiceImpl implements UserService {
    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

    private UserDAO userDAO;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 5)
    public String login(User user) {
        return null;
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 5)
    public ModelAndView register(User user) {
        ModelAndView mv = new ModelAndView("register");
        mv.addObject("test", userDAO.register(user).toString());

        return mv;
    }

    //测试用
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 5)
    public ModelAndView test(User user) {
        if (userDAO.login(user).size() != 0) {
//            Map<String, Object> viewParam = new HashMap<String, Object>();
//            viewParam.put("interesting", "This is ZK!!!!");
            ModelAndView mv = new ModelAndView("login_index");
            mv.addObject("interesting", "This is ZK!!!!");

            logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@   nothing!!!  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            return mv;
        } else {
            logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@   account number or password is wrong!!!  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            return new ModelAndView("login_failed");
        }
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }
}
