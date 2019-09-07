package com.demo.razorpay.service.local;

import com.demo.razorpay.dao.ProductDAO;
import com.demo.razorpay.models.products.Product;

import java.util.List;

public class ProductLocalService {

    private static final ProductDAO PRODUCT_DAO = new ProductDAO();

    public static List<Product> fetchAllProducts(){
        return PRODUCT_DAO.findAll();
    }

    public static void registerProduct(Product product){
        PRODUCT_DAO.save(product);
    }

    public static void deRegisterProduct(Product product){
        PRODUCT_DAO.delete(product);
    }
}
