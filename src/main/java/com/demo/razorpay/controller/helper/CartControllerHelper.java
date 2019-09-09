package com.demo.razorpay.controller.helper;

import com.demo.razorpay.RequestParameter;
import com.demo.razorpay.SessionAttributes;
import com.demo.razorpay.controller.RazorPayController;
import com.demo.razorpay.models.session.Cart;
import org.apache.commons.lang3.NotImplementedException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.logging.Logger;

public class CartControllerHelper extends RazorPayController {

    private static final Logger LOGGER = Logger.getLogger(CartControllerHelper.class.getName());

    @Override
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) {
        throw new NotImplementedException("'doprocess()' method should be overridden...");
    }

    protected void addToCart(HttpServletRequest request, HttpServletResponse response){
        HttpSession httpSession = request.getSession(false);
        if(null != httpSession){
            String productId = request.getParameter(RequestParameter.PRODUCT_ID);
            Cart sessionCart = (Cart)httpSession.getAttribute(SessionAttributes.SESSION_CART);
            if(null != sessionCart){
                sessionCart.addProductId(productId);
            } else {
                sessionCart = new Cart();
                sessionCart.addProductId(productId);
                httpSession.setAttribute(SessionAttributes.SESSION_CART, sessionCart);
            }
            System.out.println("sessionCart ================>>>>>>>>> "+sessionCart.getProductIds());
        }
    }

    protected void removeFromCart(HttpServletRequest request, HttpServletResponse response){
        HttpSession httpSession = request.getSession(false);
        if(null != httpSession){
            Cart sessionCart = (Cart)httpSession.getAttribute(SessionAttributes.SESSION_CART);
            if(null != sessionCart){
                String productId = request.getParameter(RequestParameter.PRODUCT_ID);
                sessionCart.removeProductId(productId);
            }
            System.out.println("sessionCart ================>>>>>>>>> "+sessionCart.getProductIds());
        }
    }
}
