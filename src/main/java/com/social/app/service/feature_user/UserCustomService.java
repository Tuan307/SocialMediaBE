package com.social.app.service.feature_user;

import com.social.app.model.feature_user.User;
import com.social.app.repository.feature_user.UserRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserCustomService implements UserRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<User> findNearestUsers(double yourLat, double yourLng) {
        String queryStr = "SELECT * FROM User u " +
                "ORDER BY SQRT((u.lat - :yourLat) * (u.lat - :yourLat) + (u.lng - :yourLng) * (u.lng - :yourLng))";

        TypedQuery<User> query = entityManager.createQuery(queryStr, User.class);
        query.setParameter("yourLat", yourLat);
        query.setParameter("yourLng", yourLng);
        query.setMaxResults(5);

        return query.getResultList();
    }
}
