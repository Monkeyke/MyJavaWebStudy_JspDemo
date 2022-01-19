package com.library.service;

import com.library.dao.BorrowListDao;
import com.library.pojo.Borrow_booksBean;

import java.util.List;

public class BorrowList {
    private BorrowListDao dao=new BorrowListDao();

    public List<Borrow_booksBean> showBorrowList(String page, String limit, String condition, String conditionValue) throws Exception {
       return   dao.showBorrowList(page, limit, condition, conditionValue);
    }

    public Long findCountBorrows() throws Exception {
        return dao.findCountBorrows();
    }
}
