package pc.com.lovecoding.service.impl;

import pc.com.lovecoding.dao.ProductDao;
import pc.com.lovecoding.pojo.Product;
import pc.com.lovecoding.service.ProductService;
import pc.com.lovecoding.vo.Page;

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

    /**
     * 根据商品主键获取商品信息
     * @param pid
     * @return
     */
    @Override
    public Product getProductByPid(String pid) {
        return productDao.getProductByPid(pid);
    }
}
