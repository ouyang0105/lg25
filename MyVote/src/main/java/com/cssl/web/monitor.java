package com.cssl.web;

import com.cssl.entity.Users;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;
import java.util.List;

@Controller
@WebListener
public class monitor implements ServletContextListener, HttpSessionListener, ServletRequestAttributeListener {


    private ServletContext apption;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("服务开启时触发");
        apption=sce.getServletContext();
        List<Users> list=new ArrayList<Users>();
        list.add(new Users(0,"1232123","sdw2das",3,0));
        list.add(new Users(0,"sdfgh","123456",3,0));
        sce.getServletContext().setAttribute("ListUsers",list);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        System.out.println("服务死亡时触发");


    }
/*

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.println("1");
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        System.out.println("2");
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        System.out.println("3");
    }
*/

    @Override
    public void sessionCreated(HttpSessionEvent se) {

        System.out.println("创建session时触发");
        se.getSession().setMaxInactiveInterval(60);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

        System.out.println("session消亡时触发");
        Users users=(Users)se.getSession().getAttribute("ULogin");
        List<Users> list=(List<Users>) apption.getAttribute("ListUsers");
        list.remove(users);

    }
}
