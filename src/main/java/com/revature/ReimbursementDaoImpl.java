package com.revature;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
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
    public void deleteReimbursement(Reimbursement reimbursement) {
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        session.delete(reimbursement);
        t.commit();
        session.close();
    }

    @Override
    public Reimbursement getReimbursement(int id) {
        Session session = factory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Reimbursement> cq = cb.createQuery(Reimbursement.class);
        Root<Reimbursement> root = cq.from(Reimbursement.class);
        cq.select(root).where(cb.equal(root.get("id"), id));

        List <Reimbursement> results = session.createQuery(cq).getResultList();
        session.close();

        if (results.size() > 0)
            return results.get(0);
        return null;
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
