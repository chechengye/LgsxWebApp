package com.lovecoding.controller;

import com.lovecoding.pojo.User;
import com.lovecoding.service.UserService;
import com.lovecoding.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req , resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        userService = new UserServiceImpl();

        User user = userService.login(username , password);

        if(null == user){//此用户不存在与数据库中
            //存入域中
            req.setAttribute("tipMsg" , "用户名或密码错误");//一次内部转发中使用
            req.getRequestDispatcher("/login.jsp").forward(req , resp);
        }else{
            //登录成功，跳转到首页 ，且将对象存入域中
            HttpSession session = req.getSession();//获取session 。存在与服务器中，获取时，会先判断服务器中是否存在session，若存在直接使用。若不存在创建
            session.setAttribute("user" , user);
            Cookie cookie = new Cookie("JSESSIONID" , session.getId());
            cookie.setMaxAge(60 * 30);//单位s
            resp.addCookie(cookie);//使用响应对象，将cookie添加回客户端
            resp.sendRedirect(req.getContextPath() + "/index.jsp");//重定向到首页
        }

    }
}
