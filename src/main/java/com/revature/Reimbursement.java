package com.revature;

import jakarta.persistence.*;

@Entity
@Table (name="rs")
public class Reimbursement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;
    @ManyToOne
    @JoinColumn(name="eid")
    private User user;
    @Column(name="amount")
    private int amount;
    @Column(name="approved")
    private boolean approved;

    public Reimbursement() {
    }

    public Reimbursement(int id, User user, int amount, boolean approved) {
        this.id = id;
        this.user = user;
        this.amount = amount;
        this.approved = approved;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "id=" + id +
                ", user=" + user +
                ", amount=" + amount +
                ", approved=" + approved +
                '}';
    }
}
