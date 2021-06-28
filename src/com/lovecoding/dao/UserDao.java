package com.lovecoding.dao;

import com.lovecoding.pojo.User;
import com.lovecoding.util.C3p0Util;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

public class UserDao {

    private static QueryRunner queryRunner;// 存在与dbutils.jar

    static {
        queryRunner = new QueryRunner(C3p0Util.getDataSource());
    }
    public int register(User user) {
        String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?)";

        try {
            int rows = queryRunner.update(sql
                    , user.getUid()
                    , user.getUsername()
                    , user.getPassword()
                    , user.getName()
                    , user.getEmail() , null
                    , user.getBirthday()
                    , user.getSex() , 0
                    , user.getCode());
            return rows;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
