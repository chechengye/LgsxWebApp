package pc.com.lovecoding.controller;

import pc.com.lovecoding.service.UserService;
import pc.com.lovecoding.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 通过继承HttpServlet，来实现将普通的类，变为Servlet支撑。即可接收前端映射请求
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet{

    private UserService userService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //String username = req.getParameter("username");获取单个input输入的值
        /*Map<String, String[]> parameterMap = req.getParameterMap();
        //parameterMap.forEach((k,v)-> System.out.println(k + "->" + v));
        User user = new User();
        BeanUtils.populate(user , parameterMap);
        在业务层处理业务
        */
        //乱码解决
        req.setCharacterEncoding("utf-8");
        userService = new UserServiceImpl();
        int rows = userService.register(req.getParameterMap());
        if(rows > 0 ){//成功，跳转登录
            //重定向
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        }else{
            req.getRequestDispatcher("/register.jsp").forward(req , resp);//内部转发
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req ,resp);//统一出口
    }
}
