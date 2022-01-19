package com.library.dao;

import com.library.pojo.BookBean;
import com.library.pojo.Borrow_cardBean;
import com.library.utils.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BorrowDao {
    private QueryRunner queryRunner=new QueryRunner(DruidUtil.getDataSource());
    public BookBean findBookid(String book) throws Exception {
        String sql="select* from books where id=?";
        return queryRunner.query(sql,new BeanHandler<>(BookBean.class),book);
    }

    public Borrow_cardBean findUserByID(String user) throws Exception {
        String sql="select* from borrow_card where id=?";
        return queryRunner.query(sql,new BeanHandler<>(Borrow_cardBean.class),user);
    }

    public int insertBorrow_Book(String date1, String user,String book) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        date = sdf.parse(date1);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, +1);
        String date2 = sdf.format(calendar.getTime());
        System.out.println(date2);
        String sql="insert into borrow_books values(null,?,?,?,?,null,null,null)";

        int update = queryRunner.update(sql, user, book, date1, date2);
        return update;
    }

    public Borrow_cardBean returnBook(String userid, String bookid) throws Exception {
        String sql="select * from borrow_books where card_id=? and book_id=?";
       Borrow_cardBean beanLists = queryRunner.query(sql, new BeanHandler<>(Borrow_cardBean.class), userid, bookid);
        return beanLists;
    }

    public void removeMark(String bookid, String userid) throws Exception {
        String sql="delete from borrow_books where card_id=? and book_id=? ";
        queryRunner.update(sql,userid,bookid);
    }
}
