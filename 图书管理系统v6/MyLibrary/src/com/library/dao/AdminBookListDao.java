package com.library.dao;

import com.library.pojo.BookBean;
import com.library.pojo.Book_SortBean;
import com.library.pojo.LibraryBean;
import com.library.utils.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class AdminBookListDao {
    private QueryRunner queryRunner=new QueryRunner(DruidUtil.getDataSource());
    public List<BookBean> findByPage(String page, String limit, String condition, String conditionValue) throws Exception {
        int number = Integer.valueOf(page);
        int size = Integer.valueOf(limit);
        String sql="select * from books";
        String where="";
        if (condition != null && conditionValue != null && !condition.equals("") && !conditionValue.equals("")) {
            where = " where " +  conditionValue+ " like '%" + condition + "%' ";
            sql += where;
        }
        sql += " limit ?,?";
//        System.out.println(sql);
        return queryRunner.query(sql, new BeanListHandler<>(BookBean.class),(number-1)*size,size);

    }
    public BookBean findById(int id) throws Exception {
        String sql="select * from books where id =?";
        return queryRunner.query(sql, new BeanHandler<>(BookBean.class),id);

    }


    public List<LibraryBean> findAlLibrary() throws Exception {
        return queryRunner.query("select * from library ",new BeanListHandler<>(LibraryBean.class));
    }
    public List<Book_SortBean> findAlbook_sort() throws Exception {
        return queryRunner.query("select * from book_sort ",new BeanListHandler<>(Book_SortBean.class));
    }
}
