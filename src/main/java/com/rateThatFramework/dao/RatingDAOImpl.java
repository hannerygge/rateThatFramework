package com.rateThatFramework.dao;

import com.rateThatFramework.model.Rating;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hanne_000 on 03.05.2016.
 */
public class RatingDAOImpl {
    private SessionFactory sessionFactory;

    public RatingDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //@Override
    @Transactional
    public List<Rating> list() {
        @SuppressWarnings("unchecked")
        List<Rating> listUser = (List<Rating>) sessionFactory.getCurrentSession()
                .createCriteria(Rating.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return listUser;
    }
}
