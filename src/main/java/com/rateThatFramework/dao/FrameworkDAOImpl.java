package com.rateThatFramework.dao;

import com.rateThatFramework.model.Framework;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hanne_000 on 03.05.2016.
 */
public class FrameworkDAOImpl implements FrameworkDAO{
    private SessionFactory sessionFactory;

    public FrameworkDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //@Override
    @Transactional
    public List<Framework> list() {
        @SuppressWarnings("unchecked")
        List<Framework> listFramework = (List<Framework>) sessionFactory.getCurrentSession()
                .createCriteria(Framework.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return listFramework;
    }

}
