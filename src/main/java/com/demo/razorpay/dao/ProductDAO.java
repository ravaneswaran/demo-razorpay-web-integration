package com.demo.razorpay.dao;

import com.demo.razorpay.models.products.Product;

import javax.persistence.Query;
import java.util.List;

public class ProductDAO extends AbstractDAO<Product>{

    public ProductDAO() {
        super(Product.class);
    }

    public List<Product> findAll(){
        Query query = this.getEntityManager().createQuery("SELECT p FROM Product AS p ORDER BY p.rowId");
        return  query.getResultList();
    }
}
