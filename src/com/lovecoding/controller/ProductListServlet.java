package com.lovecoding.controller;

import com.lovecoding.service.ProductService;
import com.lovecoding.service.impl.ProductServiceImpl;
import com.lovecoding.vo.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 商品列表管理类
 */
@WebServlet("/productList")
public class ProductListServlet extends HttpServlet {

    private ProductService productService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String currentPage = req.getParameter("currentPage") == null ? "1" : req.getParameter("currentPage");
        productService = new ProductServiceImpl();
        int maxCount = 12;
        Page page = productService.getProductList(currentPage , maxCount);
        req.setAttribute("page" , page);
        req.getRequestDispatcher("/product_list.jsp").forward(req , resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req , resp);
    }
}
