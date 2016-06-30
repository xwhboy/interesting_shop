package com.controller;

import com.entity.Sort;
import com.entity.User;
import com.google.gson.Gson;
import com.service.SortService;
import com.service.UserService;
import com.service.impl.OrderServiceImpl;
import com.service.impl.SortServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ZK on 6/25/16.
 */
@Controller
public class WebController {
    private static final Logger logger = LogManager.getLogger(WebController.class);

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;
    private SortServiceImpl sortService;
    private OrderServiceImpl orderService;
    @RequestMapping("/test")
    public ModelAndView test(HttpServletRequest request, HttpServletResponse response,
                             @RequestParam("u") String userAccount,
                             @RequestParam("p") String userPassword) {
        logger.info("################# For testing #################");

        return userService.test(new User(userAccount, userPassword));
    }



   @RequestMapping("/manager/add_goods_type")
   public String manager_add_sort(@RequestBody Map map){
       String sort_name=(String)map.get("sort_name");
       boolean result=sortService.addSort(sort_name);
       Gson gson=new Gson();
       return gson.toJson(result);
   }



    @RequestMapping("/manager/get_sort_list")
    public  String get_sort_list(HttpServletRequest request){

        int pagenum=Integer.parseInt(request.getParameter("pagenum"));
        int pagesize=Integer.parseInt(request.getParameter("pagesize"));
        List<Sort> result=sortService.getSortList(pagenum,pagesize);
        Gson gson=new Gson();
        return gson.toJson(result);
    }


    @RequestMapping("user_cancel_order")
    public  String user_cancel_order(@RequestBody Map map){
        String user_name=(String)map.get("user-name");
        int order_id=(Integer)map.get("order_id");
        return orderService.cancelOrder(order_id);
    }
    @RequestMapping("/manager/modify_goods_type")
    public  String modify_goods_type(@RequestBody Map map){
        int sort_id=(Integer)map.get("sort_ID");
        String sort_name=(String)map.get("sort_name ");
        boolean result=sortService.modifySort(sort_id,sort_name);
        Gson gson=new Gson();
        return gson.toJson(result);
    }



    @RequestMapping("/register")
    public ModelAndView register(HttpServletRequest request, HttpServletResponse response,
                             @RequestParam("u") String userAccount,
                             @RequestParam("p") String userPassword,
                             @RequestParam("t") String tel) {
        logger.info("################# For register testing #################");

        return userService.register(new User(userAccount, userPassword, tel));
    }



    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
