package com.revature;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ReimbursementDaoImpl implements ReimbursementDao {
    Configuration config;
    SessionFactory factory;

    public ReimbursementDaoImpl() {
        this.config = new Configuration();
        config.configure("hibernate.cfg.xml");
        this.factory = config.buildSessionFactory();
    }

    @Override
    public void submitReimbursement(Reimbursement reimbursement) {
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        session.persist(reimbursement);
        t.commit();
        session.close();
    }

    @Override
    public void updateReimbursement(Reimbursement reimbursement) {
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        session.merge(reimbursement);
        t.commit();
        session.close();
    }

    @Override
    public List<Reimbursement> getPendingReimbursements() {
        Session session = factory.openSession();
        TypedQuery<Reimbursement> query = session.createQuery("SELECT r from Reimbursement r INNER JOIN r.user u where r.approved='NULL'", Reimbursement.class);
        List<Reimbursement> results = query.getResultList();
        session.close();
        return results;
    }

    @Override
    public List<Reimbursement> getPendingReimbursements(int userId) {
        Session session = factory.openSession();
        TypedQuery<Reimbursement> query = session.createQuery("SELECT r from Reimbursement r INNER JOIN r.user u where r.approved='NULL' AND u.id=" + userId, Reimbursement.class);
        List<Reimbursement> results = query.getResultList();
        session.close();
        return results;
    }

    @Override
    public List<Reimbursement> getResolvedReimbursements() {
        Session session = factory.openSession();
        TypedQuery<Reimbursement> query = session.createQuery("SELECT r from Reimbursement r INNER JOIN r.user u where r.approved=true", Reimbursement.class);
        List<Reimbursement> results = query.getResultList();
        session.close();
        return results;
    }

    @Override
    public List<Reimbursement> getResolvedReimbursements(int userId) {
        Session session = factory.openSession();
        TypedQuery<Reimbursement> query = session.createQuery("SELECT r from Reimbursement r INNER JOIN r.user u where r.approved=true AND u.id=" + userId, Reimbursement.class);
        List<Reimbursement> results = query.getResultList();
        session.close();
        return results;
    }
}
