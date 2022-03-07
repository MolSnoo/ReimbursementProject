package com.revature;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class UserDaoImpl implements UserDao {
    Configuration config;
    SessionFactory factory;

    public UserDaoImpl() {
        this.config = new Configuration();
        config.configure("hibernate.cfg.xml");
        this.factory = config.buildSessionFactory();
    }


    @Override
    public User login(String email, String password) {
        Session session = factory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        
        Predicate[] predicates = new Predicate[2];
        predicates[0] = cb.equal(root.get("email"), email);
        predicates[1] = cb.equal(root.get("password"), password);
        cq.select(root).where(cb.and(predicates));

        List<User> results = session.createQuery(cq).getResultList();
        session.close();

        if (results.size() > 0)
            return results.get(0);
        return null;
    }
}
