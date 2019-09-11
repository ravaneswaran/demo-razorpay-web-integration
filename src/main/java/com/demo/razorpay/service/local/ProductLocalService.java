package com.demo.razorpay.service.local;

import com.demo.razorpay.dao.ProductDAO;
import com.demo.razorpay.models.Product;

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

    public static void deRegisterProductUsingId(String id){
        PRODUCT_DAO.deleteById(id);
    }

    public static final Product fetchById(String productId){
        return PRODUCT_DAO.findById(productId);
    }

    public static boolean hasProducts() {
        return !fetchAllProducts().isEmpty();
    }
}
