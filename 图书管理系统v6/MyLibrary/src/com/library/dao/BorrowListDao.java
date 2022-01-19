package com.library.dao;

import com.library.pojo.BookBean;
import com.library.pojo.Borrow_booksBean;
import com.library.utils.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class BorrowListDao {

    DataSource ds;
    private QueryRunner queryRunner=new QueryRunner(DruidUtil.getDataSource());
    public List<Borrow_booksBean> showBorrowList(String page, String limit, String condition, String conditionValue) throws Exception {
        int number = Integer.valueOf(page);
        int size = Integer.valueOf(limit);
        String sql="select id, card_id, book_id, "
                + "DATE_FORMAT(borrow_date, '%Y-%m-%d %k:%i:%s') as borrow_date, "
                + "DATE_FORMAT(return_date, '%Y-%m-%d %k:%i:%s') as return_date, "
                + "DATE_FORMAT(end_date, '%Y-%m-%d %k:%i:%s') as end_date,"
                + "illegal, manager_id "
                + "from borrow_books";
        String where="";
        if(condition!=null && conditionValue != null && !condition.equals("") && !conditionValue.equals("")) {
            where = " where "+ condition +" like '%" +conditionValue +"%' ";
            sql += where;
        }else if(condition!=null && condition.equals("other")) {
            where = " where return_date is null and curtime()>end_date ";
            sql +=where;
        }
        sql += " limit ?,?";
//        System.out.println(sql);
        return queryRunner.query(sql, new BeanListHandler<>(Borrow_booksBean.class),(number-1)*size,size);

    }

    public Long findCountBorrows() throws Exception {
        return (Long) queryRunner.query("select count(*) as count from borrow_books ",new ScalarHandler());
    }
}
