package com.anka.dao;

import com.anka.domain.User;

public interface UserDao {

    User getByName(String name);

}
