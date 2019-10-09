package com.demo.razorpay.dao;

import com.demo.razorpay.models.PaymentTransaction;
import junit.framework.TestCase;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.UUID;

public class TestEntityManager extends TestCase {

    private static final String PERSISTENCE_UNIT_NAME = "razorpay";
    private static EntityManagerFactory factory;

    @SuppressWarnings("unchecked")
	public void testEntityManager() {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = factory.createEntityManager();
        // read the existing entries and write to console
        Query query = entityManager.createQuery("select pt from PaymentTransaction pt");
        List<PaymentTransaction> paymentTransactions = query.getResultList();
        for (PaymentTransaction paymentTransaction : paymentTransactions) {
            System.out.println(paymentTransaction);
        }
        System.out.println("Size: " + paymentTransactions.size());

        entityManager.getTransaction().begin();
        PaymentTransaction paymentTransaction = new PaymentTransaction();
        paymentTransaction.setId(UUID.randomUUID().toString());
        paymentTransaction.setDescription("Test Payment Transaction");
        entityManager.persist(paymentTransaction);
        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
