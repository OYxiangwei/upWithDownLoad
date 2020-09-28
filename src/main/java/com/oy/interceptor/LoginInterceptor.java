package com.oy.interceptor;

import org.aopalliance.intercept.Interceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URL;

public class LoginInterceptor implements HandlerInterceptor {
   // private static final String[] ignoreURL={"/login"};
    // 该方法将在 Controller 处理前进行调用
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("This is preHandle!");
        boolean flag = false;
      /*  String url = request.getServletPath();
        System.out.println("url:----"+url);
        for(String url1:ignoreURL){
            if(url.contains(url1)){
                flag =true;
                break;
            }
        }*/
        if(!flag){
            String username = (String) request.getSession().getAttribute("username");
            if(username==null||username.length()==0){
                request.setAttribute("message","请先登录");
                request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,response);
            }else {
                flag=true;
            }
        }

        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("This is postHandle!");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("This is afterCompletion!");
    }
}
