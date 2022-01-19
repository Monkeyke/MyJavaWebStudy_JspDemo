package com.library.service;

import com.library.dao.LoginReaderDao;
import com.library.pojo.ReaderBean;

public class LoginReaderService {
    private LoginReaderDao dao=new LoginReaderDao();

    public ReaderBean findAResult(String user, String psw) throws Exception {
       return dao.findAResult(user, psw);
    }
}
