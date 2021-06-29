package com.lovecoding.service;

import com.lovecoding.vo.Page;

public interface ProductService {
    Page getProductList(String currentPage, int maxCount);
}
