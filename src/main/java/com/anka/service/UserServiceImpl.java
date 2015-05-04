package com.anka.service;

import com.anka.dao.UserDao;
import com.anka.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier(value = "userDao")
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public User getByName(String name) {
        return this.userDao.getByName(name);
    }
}
