package com.service;

import com.entity.User;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ZK on 6/26/16.
 */
public interface UserService {
    ModelAndView test(User user);

    String login(User user);

    ModelAndView register(User user);


}
