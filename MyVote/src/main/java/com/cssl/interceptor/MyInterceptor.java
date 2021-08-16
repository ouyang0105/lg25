package com.cssl.interceptor;

import com.cssl.entity.Users;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle..................");
        String uri = request.getRequestURI();
        System.out.println("uri:"+uri);
        if(uri.endsWith("index")||uri.endsWith("login")||uri.endsWith("regist")||uri.endsWith("cx_selectone")||uri.endsWith("insert_User")||uri.endsWith("quanxian")) {
            return true;
        }
        Users users=(Users)request.getSession().getAttribute("ULogin");
        System.out.println(users);
        if(users!=null){
            if((uri.endsWith("update")||uri.endsWith("insert_subject")||uri.endsWith("add")||uri.endsWith("modify"))&&users.getIsAdmin()!=1){
                response.sendRedirect("quanxian");
                return false;
            }
            return true;

        }else {
            response.sendRedirect("login");

        }

        return false;
    }
}
