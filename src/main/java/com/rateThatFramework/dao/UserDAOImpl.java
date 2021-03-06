package com.rateThatFramework.dao;

import com.rateThatFramework.model.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class UserDAOImpl implements UserDAO {
    private SessionFactory sessionFactory;

    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //@Override
    @Transactional
    public List<User> list() {
        @SuppressWarnings("unchecked")
        List<User> listUser = (List<User>) sessionFactory.getCurrentSession()
                .createCriteria(User.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return listUser;
    }

}