package com.neuedu.controller;

import com.neuedu.consts.Const;
import com.neuedu.pojo.UserInfo;
import com.neuedu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by tao on 2019/8/6.
 */

@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    IUserService userService;

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(UserInfo userInfo, HttpSession session, HttpServletResponse response){

        UserInfo loginUserInfo = userService.login(userInfo);

        System.out.println(loginUserInfo);

        if(loginUserInfo!=null){
            Cookie username_cookie=new Cookie("username",loginUserInfo.getUsername());
            Cookie password_cookie=new Cookie("password",loginUserInfo.getPassword());

            username_cookie.setMaxAge(60*60*24*7);
            password_cookie.setMaxAge(60*60*24*7);

            response.addCookie(username_cookie);
            response.addCookie(password_cookie);
            session.setAttribute(Const.CURRENT_USER,loginUserInfo);

            return "redirect:home";
        }

        return "login";
    }

    @RequestMapping(value = "register",method = RequestMethod.GET)
    public String register(){
        return "register";
    }

    @RequestMapping(value = "register",method = RequestMethod.POST)
    public String registerlogic(UserInfo userInfo,
                                HttpServletRequest request,
                                HttpServletResponse response){

        int i= userService.register(userInfo);


        if(i==1){//注册成功
            return "redirect:login";
        }

        return "register";
    }

    @RequestMapping("userlist")
    public String home(HttpServletRequest request,
                       HttpServletResponse response){
        List<UserInfo> userInfoList=userService.findAll();
        request.setAttribute(Const.ALL_USER,userInfoList);

        return "userlist";
    }

    @RequestMapping("outLogin")
    public String outLogin(HttpServletRequest request,
                           HttpServletResponse response){


        HttpSession session = request.getSession();
        session.removeAttribute(Const.CURRENT_USER);

        return "index";
    }

    @RequestMapping(value = "update/{id}",method = RequestMethod.GET)
    public String update(@PathVariable("id") Integer userId, HttpServletRequest request){
        UserInfo userInfo = userService.findById(userId);
        request.setAttribute(Const.UPDATE_USER,userInfo);
        return "userupdate";
    }

    @RequestMapping(value = "update/{id}",method = RequestMethod.POST)
    public String update(UserInfo userInfo,HttpServletRequest request,HttpServletResponse response){

        int i = userService.update(userInfo);
        if(i>0){
            return "redirect:/user/userlist";
        }

        return "userupdate";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer userId){

        int i=userService.delete(userId);
        if(i==1){

            return "redirect:/user/userlist";
        }

        return "redirect:/user/userlist";
    }

    @RequestMapping("home")
    public String home(){
        return "home";
    }

}
