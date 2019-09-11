package com.demo.razorpay.controller;

import com.demo.razorpay.RequestParameter;
import com.demo.razorpay.controller.helper.CartControllerHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

public class CartController extends CartControllerHelper {

    private static final Logger LOGGER = Logger.getLogger(CartController.class.getName());

    public static final String ADD_TO_CART = "add-to-cart";
    public static final String REMOVE_FROM_CART = "remove-from-cart";
    public static final String CHECKOUT_CART = "checkout-cart";

    @Override
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) {
        String command = request.getParameter(RequestParameter.COMMAND);

        System.out.println("command ==============>>>>>>> "+command);

        switch (command) {
            case ADD_TO_CART:
                addToCart(request, response);
                break;
            case REMOVE_FROM_CART:
                removeFromCart(request, response);
                break;
            case CHECKOUT_CART:
                checkoutCart(request, response);
                break;
        }
    }

}
