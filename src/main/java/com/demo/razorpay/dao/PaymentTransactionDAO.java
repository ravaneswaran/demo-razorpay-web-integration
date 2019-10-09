package com.demo.razorpay.dao;

import com.demo.razorpay.models.PaymentTransaction;

import javax.persistence.Query;
import java.util.List;

public class PaymentTransactionDAO extends AbstractDAO<PaymentTransaction>{

    public PaymentTransactionDAO(){
        super(PaymentTransaction.class);
    }

    @SuppressWarnings("unchecked")
	public List<PaymentTransaction> list(){
        Query query = this.getEntityManager().createQuery("SELECT pt FROM PaymentTransaction AS pt");
        return query.getResultList();
    }

}
