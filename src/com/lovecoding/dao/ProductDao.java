package com.lovecoding.dao;

import com.lovecoding.pojo.Product;
import com.lovecoding.util.C3p0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class ProductDao {
    private static QueryRunner queryRunner;

    static {
        queryRunner = new QueryRunner(C3p0Util.getDataSource());
    }

    public double getProductCount() {
        String sql = "select count(*) from product";

        try {
            Long l = (Long)queryRunner.query(sql, new ScalarHandler());
            return l.doubleValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Product> getProductList(int index , int maxCount) {
        try {
            String sql = "select p.pid , p.pname , p.pimage , p.shop_price as shopPrice from product p limit ? , ?";
            List<Product> productList = queryRunner.query(sql, new BeanListHandler<>(Product.class), index, maxCount);
            return productList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
