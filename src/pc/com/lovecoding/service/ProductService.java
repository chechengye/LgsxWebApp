package pc.com.lovecoding.service;

import pc.com.lovecoding.pojo.Product;
import pc.com.lovecoding.vo.Page;

public interface ProductService {
    Page getProductList(String currentPage, int maxCount);

    Product getProductByPid(String pid);
}
