package com.library.dao;

import com.library.utils.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

public class RegisterDao {
    private QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());


    public void registerReader(String username, String psw) throws Exception {
        queryRunner.update("insert into  borrow_card  values (null,?,?,1,1)",username,psw);
    }
}
