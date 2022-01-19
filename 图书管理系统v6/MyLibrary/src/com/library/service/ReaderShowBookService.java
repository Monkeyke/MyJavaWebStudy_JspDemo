package com.library.service;

import com.library.dao.ReaderFindBookDao;
import com.library.pojo.BookBean;
import com.library.pojo.Borrow_booksBean;

import java.util.List;

public class ReaderShowBookService {
    private ReaderFindBookDao readerDao=new ReaderFindBookDao();
    public List<BookBean> readFindBook(int limit, int page,String condition,String conditionValue) throws Exception {
       return readerDao.readFindBook(limit,page,condition,conditionValue);
    }

    public Long findBookCount() throws Exception {
        return readerDao.findBookCount();
    }

    public List<Borrow_booksBean> readFindBorrows(int limit, int page,String condition,String conditionValue,String id) throws Exception {
        return readerDao.readFindBorrows(limit,page,condition,conditionValue,id);
    }

    public Long FindBorrowsCount(String id) throws Exception {
        return readerDao.finBorrowsCount(id);
    }
}
