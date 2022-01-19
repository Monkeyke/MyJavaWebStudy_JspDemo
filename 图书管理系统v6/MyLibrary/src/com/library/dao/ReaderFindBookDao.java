package com.library.dao;

import com.library.pojo.BookBean;
import com.library.pojo.Borrow_booksBean;
import com.library.utils.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class ReaderFindBookDao {
    private QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
    public List<BookBean> readFindBook(int  limit, int page,String conditionValue,String condition) throws Exception {
        String sql="select * from books";
        String where="";
        if (condition != null && conditionValue != null && !condition.equals("") && !conditionValue.equals("")) {
            where = " where " +  conditionValue+ " like '%" + condition + "%' ";
            sql += where;
        }
        sql += " limit ?,?";
//        System.out.println(sql);
        return queryRunner.query(sql, new BeanListHandler<>(BookBean.class),(page-1)*limit,limit);
    }

    public Long findBookCount() throws Exception {
        Long query = (Long) queryRunner.query("select count(*) from books", new ScalarHandler());
        return query;
    }

    public List<Borrow_booksBean> readFindBorrows(int limit, int page,String condition,String conditionValue,String id) throws Exception {
        String sql="select * from borrow_books where card_id = ?";
        String where="";
        if (condition != null && conditionValue != null && !condition.equals("") && !conditionValue.equals("")) {
            where = " and " + condition + " like '%" + conditionValue + "%' ";
            sql += where;
        }
        sql += " limit ?,?";

        return  queryRunner.query(sql,new BeanListHandler<>(Borrow_booksBean.class),id,(page-1)*limit,limit);
    }

    public Long finBorrowsCount(String id) throws Exception {
        Long result = (Long) queryRunner.query("select count(*) as count from borrow_books where card_id = ?", new ScalarHandler(), id);
        return result;
    }
}
