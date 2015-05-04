package com.anka.dao;

import com.anka.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public User getByName(String name) {
        return (User) getCurrentSession().get(User.class, name);
    }

}
