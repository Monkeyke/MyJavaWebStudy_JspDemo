package com.library.dao;

import com.library.pojo.BookBean;
import com.library.utils.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

public class AdminEditDao {
    private QueryRunner queryRunner=new QueryRunner(DruidUtil.getDataSource());


    public int editbooks(BookBean bookbean) throws Exception {
        String sql="update books set name=? ,author=? ,library_id=? ,sort_id=? ,position=? ,status=?, description=? where id=?";
       return queryRunner.update(sql,bookbean.getName(),bookbean.getAuthor(),bookbean.getLibrary_id(),bookbean.getSort_id(),bookbean.getPosition(),bookbean.getStatus(),bookbean.getDescription(),bookbean.getId());
    }
}
