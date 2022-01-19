package com.library.service;

import com.library.dao.AdminSortListDao;
import com.library.pojo.Borrow_cardBean;

import java.sql.SQLException;
import java.util.List;

public class AdminSortListService {
    private AdminSortListDao dao=new AdminSortListDao();
    public List<Borrow_cardBean> showAllCard(String limit, String page, String condition, String conditionValue) throws Exception {
        return dao.findAllCard(limit, page, condition, conditionValue);
    }

    public Long findCardCount() throws Exception {
        return dao.findCardCount();
    }
}
