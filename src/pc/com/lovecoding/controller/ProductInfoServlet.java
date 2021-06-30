package pc.com.lovecoding.controller;

import pc.com.lovecoding.pojo.Product;
import pc.com.lovecoding.service.ProductService;
import pc.com.lovecoding.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/productInfo")
public class ProductInfoServlet extends HttpServlet{

    private ProductService productService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pid = req.getParameter("pid");
        productService = new ProductServiceImpl();
        Product product = productService.getProductByPid(pid);
        req.setAttribute("product" , product);
        req.getRequestDispatcher("/product_info.jsp").forward(req , resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }
}
