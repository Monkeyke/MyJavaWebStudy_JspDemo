package com.library.service;

import com.library.dao.LoginAdminDao;
import com.library.pojo.AdminBean;

public class LoginAdminService {
    private LoginAdminDao dao=new LoginAdminDao();
    public AdminBean findAdminResult(String username, String password) throws Exception {
       return dao.findAdminResult(username, password);
    }
}
