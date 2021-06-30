package admin.com.lovecoding.contorller;

import admin.com.lovecoding.dto.Product;
import admin.com.lovecoding.service.AdminProductService;
import admin.com.lovecoding.service.impl.AdminProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/adminProductList")
public class AdminProductListServlet extends HttpServlet {

    private AdminProductService adminProductService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        adminProductService = new AdminProductServiceImpl();
        List<Product> productList = adminProductService.getProductList();
        req.setAttribute("productList", productList);
        req.getRequestDispatcher("/admin/product/list.jsp").forward(req , resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }
}
