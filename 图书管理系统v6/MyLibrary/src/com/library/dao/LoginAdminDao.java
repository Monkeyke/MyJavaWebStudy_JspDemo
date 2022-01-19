package com.library.dao;

import com.library.pojo.AdminBean;
import com.library.utils.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class LoginAdminDao {
    private QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
    public AdminBean findAdminResult(String username, String password) throws Exception {
        return queryRunner.query("select * from admin where username=? and password=?",new BeanHandler<>(AdminBean.class),username,password);
    }
}
