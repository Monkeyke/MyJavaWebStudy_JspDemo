package com.library.service;

import com.library.dao.AdminDelBooksDao;

public class AdminDelBooks {
    private AdminDelBooksDao dao=new AdminDelBooksDao();
    public int delBooksById(String id) throws Exception {
        return dao.delBooksById(id);

    }
}
