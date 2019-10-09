package com.demo.razorpay.dao;

import com.demo.razorpay.models.OrderTransaction;

import javax.persistence.Query;
import java.util.List;

public class OrderTransactionDAO extends AbstractDAO<OrderTransaction>{

    public OrderTransactionDAO() {
        super(OrderTransaction.class);
    }

    @SuppressWarnings("unchecked")
	public List<OrderTransaction> list(){
        Query query = this.getEntityManager().createQuery("SELECT ot FROM OrderTransaction AS ot");
        return query.getResultList();
    }

}
