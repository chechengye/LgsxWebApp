package admin.com.lovecoding.dao;

import admin.com.lovecoding.dto.Product;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pc.com.lovecoding.util.C3p0Util;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class AdminProductDao {
    private static QueryRunner queryRunner;

    static {
        queryRunner = new QueryRunner(C3p0Util.getDataSource());
    }

    public List<Product> getProductList() {
        try {
            return queryRunner.query("select p.pid , p.pname , p.pimage , p.shop_price as shopPrice , p.is_hot from product p" , new BeanListHandler<>(Product.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
