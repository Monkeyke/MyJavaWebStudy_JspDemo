package com.library.service;

import com.library.dao.AdminBookListDao;
import com.library.pojo.BookBean;
import com.library.pojo.Book_SortBean;

import java.util.List;

public class AdminBookListService {
    private AdminBookListDao dao=new AdminBookListDao();
    public List<BookBean> showBookList(String page, String limit, String condition, String conditionValue) throws Exception {
         return  dao.findByPage(page, limit, condition, conditionValue);
    }

   public List<Book_SortBean>  showSortList() throws Exception {
        return dao.findAlbook_sort();
   }
}
