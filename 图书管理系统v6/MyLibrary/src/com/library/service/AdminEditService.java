package com.library.service;

import com.library.dao.AdminEditDao;
import com.library.pojo.BookBean;

public class AdminEditService {
    private AdminEditDao dao=new AdminEditDao();
    public int editbooks(BookBean bookbean) throws Exception {
        return dao.editbooks(bookbean);
    }
}
