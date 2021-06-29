package com.lovecoding.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * C3P0 : 开源的数据库连接池
 * dbcp、druid
 */
public class C3p0Util {
    private static ComboPooledDataSource dataSource;

    static {
        try {
            dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/lgsx?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT");
            dataSource.setUser("root");
            dataSource.setPassword("root");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接池的数据源
     * @return
     */
    public static DataSource getDataSource(){
        return dataSource;
    }
}
