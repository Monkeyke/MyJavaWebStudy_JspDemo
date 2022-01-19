package com.library.dao;

import com.library.pojo.BookBean;
import com.library.pojo.Borrow_cardBean;
import com.library.utils.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class AdminSortListDao {
    private QueryRunner queryRunner=new QueryRunner(DruidUtil.getDataSource());


    public List<Borrow_cardBean> findAllCard(String limit, String page, String condition, String conditionValue) throws Exception {

        int number = Integer.valueOf(page);
        int size = Integer.valueOf(limit);
        String sql="select * from borrow_card";
        String where="";
        if (condition != null && conditionValue != null && !condition.equals("") && !conditionValue.equals("")) {
            where = " where " +  conditionValue+ " like '%" + condition + "%' ";
            sql += where;
        }
        sql += " limit ?,?";
//        System.out.println(sql);
        return queryRunner.query(sql, new BeanListHandler<>(Borrow_cardBean.class),(number-1)*size,size);

    }

    public Long findCardCount() throws Exception {
        return (Long) queryRunner.query("select count(*) from borrow_card",new ScalarHandler());
    }
}
