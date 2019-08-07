package com.neuedu.interceptors;

import com.neuedu.consts.Const;
import com.neuedu.pojo.UserInfo;
import com.neuedu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by tao on 2019/8/5.
 */

@Component
public class AuthorityInterceptor implements HandlerInterceptor {

    @Autowired
    IUserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {



        System.out.println("====preHandle===");

        HttpSession session=request.getSession();
        Cookie[] cookies=request.getCookies();
        String username=null;
        String password=null;
        if(cookies!=null&&cookies.length>0){
            for(Cookie c:cookies){
                if(c.getName().equals("username")){
                    username=c.getValue();
                }
                if(c.getName().equals("password")){
                    password=c.getValue();
                }
            }
        }
        UserInfo userInfo=new UserInfo(username,password);
        if(username!=null&&password!=null){
            UserInfo loginUserInfo = userService.login(userInfo);
            if(loginUserInfo!=null){
                session.setAttribute(Const.CURRENT_USER,loginUserInfo);
            }
        }
        UserInfo loginUserInfo=(UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(loginUserInfo!=null){
            if(loginUserInfo.getRole()!=0){
                response.setContentType("text/html;charset=UTF-8");
                response.getWriter().print("<script>alert(\"权限不足，请联系管理员\");window.location.href='http://localhost:8080/login'</script>");
                response.getWriter().close();
                return false;
            }
            return true;
        }
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print("<script>alert(\"用户未登录\");window.location.href='http://localhost:8080/login'</script>");
        response.getWriter().close();
        return false;//false拦截请求  true不会拦截
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

        System.out.println("=====postHandle=====");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("=======afterCompletion=====");
    }
}
