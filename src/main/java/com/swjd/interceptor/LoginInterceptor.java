package com.swjd.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//自定义拦截器
public class LoginInterceptor implements HandlerInterceptor {

    //用于做拦截的方法
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestUri=request.getRequestURI();//获取请求地址
        //1.如果是登录页面就放行
        if (requestUri.indexOf("login")>=0||requestUri.indexOf("Login")>=0||requestUri.indexOf("toMain")>=0){
            return true;
        }
        //2.如果用户登录过
        HttpSession session=request.getSession();//获取session
        if (session.getAttribute("activeName")!=null){
            return true;
        }

        //不放行并且需要回到登录页面
        request.getRequestDispatcher("/toLogin").forward(request,response);
        return false;
    }
}
