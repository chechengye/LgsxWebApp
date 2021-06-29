package com.lovecoding.service.impl;

import com.lovecoding.dao.ProductDao;
import com.lovecoding.service.ProductService;
import com.lovecoding.vo.Page;

public class ProductServiceImpl implements ProductService {

    private static ProductDao productDao;

    static {
        productDao = new ProductDao();
    }

    @Override
    public Page getProductList(String currentPage, int maxCount) {
        Page page = new Page();
        page.setCurrentPage(Integer.valueOf(currentPage));
        page.setMaxCount(maxCount);
        //60 / 12 向上取整 Math.ceil
        page.setTotalPages((int)Math.ceil(productDao.getProductCount() / maxCount));
        //计算当前索引值，根据索引值与数量查询数据库商品列表内容
        page.setProductList(productDao.getProductList((page.getCurrentPage() - 1) * maxCount , maxCount));
        return page;
    }
}
