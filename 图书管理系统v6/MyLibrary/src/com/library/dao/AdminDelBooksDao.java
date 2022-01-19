package com.library.dao;

import com.library.utils.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;

public class AdminDelBooksDao {
    private QueryRunner queryRunner=new QueryRunner(DruidUtil.getDataSource());
    public int delBooksById(String id) throws Exception {
        String sql="delete from books where id = ?";
        return  queryRunner.update(sql,id);
    }
}
