package com.library.dao;

import com.library.pojo.ReaderBean;
import com.library.utils.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;

public class LoginReaderDao {
    private QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());


    public ReaderBean findAResult(String user, String psw) throws Exception {
        String sql ="select * from borrow_card where id=? and password =?";
        ReaderBean readerBean = queryRunner.query(sql, new BeanHandler<>(ReaderBean.class), user, psw);
        return readerBean;
    }
}
