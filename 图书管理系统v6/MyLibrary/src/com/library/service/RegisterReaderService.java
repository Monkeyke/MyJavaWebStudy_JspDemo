package com.library.service;

import com.library.dao.RegisterDao;

public class RegisterReaderService {
    private RegisterDao registerDao =new RegisterDao();

    public void registerReader(String username, String psw) throws Exception {
        registerDao.registerReader(username,psw);
    }
}
