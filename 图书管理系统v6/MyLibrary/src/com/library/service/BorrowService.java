package com.library.service;

import com.library.dao.BorrowDao;
import com.library.pojo.BookBean;
import com.library.pojo.Borrow_cardBean;

import java.util.List;

public class BorrowService {
    private BorrowDao dao=new BorrowDao();

    public BookBean findBookid(String book) throws Exception {
        return dao.findBookid(book);
    }

    public Borrow_cardBean findUserByid(String user) throws Exception {
        return dao.findUserByID(user);
    }

    public int insertBorrw_Book(String date1, String user,String book) throws Exception {
        return dao.insertBorrow_Book(date1,user,book);
    }

    public Borrow_cardBean returnBook(String userid, String bookid) throws Exception {
        return dao.returnBook(bookid,userid);
    }

    public void removeMark(String bookid, String userid) throws Exception {
        dao.removeMark(bookid,userid);
    }
}
