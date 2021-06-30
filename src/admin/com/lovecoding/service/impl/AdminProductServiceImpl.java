package admin.com.lovecoding.service.impl;

import admin.com.lovecoding.dao.AdminProductDao;
import admin.com.lovecoding.dto.Product;
import admin.com.lovecoding.service.AdminProductService;

import java.util.List;

public class AdminProductServiceImpl implements AdminProductService {

    private static AdminProductDao adminProductDao;

    static {
        adminProductDao = new AdminProductDao();
    }
    /**
     * 获取管理系统商品列表
     * @return
     */
    @Override
    public List<Product> getProductList() {

        return adminProductDao.getProductList();
    }
}
