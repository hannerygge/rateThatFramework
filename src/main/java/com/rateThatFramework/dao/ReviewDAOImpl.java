package com.rateThatFramework.dao;

import com.rateThatFramework.model.Review;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hanne_000 on 03.05.2016.
 */
public class ReviewDAOImpl implements ReviewDAO {
    private SessionFactory sessionFactory;

    public ReviewDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //@Override
    @Transactional
    public List<Review> list() {
        @SuppressWarnings("unchecked")
        List<Review> listReview = (List<Review>) sessionFactory.getCurrentSession()
                .createCriteria(Review.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return listReview;
    }
}
