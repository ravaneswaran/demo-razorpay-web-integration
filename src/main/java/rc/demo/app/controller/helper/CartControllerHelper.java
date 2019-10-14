package rc.demo.app.controller.helper;

import rc.demo.app.RequestParameter;
import rc.demo.app.SessionAttributes;
import rc.demo.app.controller.RazorPayController;
import rc.demo.app.models.Order;
import rc.demo.app.models.OrderProductJoin;
import rc.demo.app.models.Product;
import rc.demo.app.models.User;
import rc.demo.app.models.session.Cart;
import rc.demo.app.service.local.OrderLocalService;
import rc.demo.app.service.local.OrderProductJoinLocalService;
import rc.demo.app.service.local.ProductLocalService;

import org.apache.commons.lang3.NotImplementedException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CartControllerHelper extends RazorPayController {

	private static final long serialVersionUID = 1L;
	
	private static final Logger LOGGER = Logger.getLogger(CartControllerHelper.class.getName());

    @Override
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) {
        throw new NotImplementedException("'doprocess()' method should be overridden...");
    }

    protected void addToCart(HttpServletRequest request, HttpServletResponse response) {
        HttpSession httpSession = request.getSession(false);
        if (null != httpSession) {
            String productId = request.getParameter(RequestParameter.PRODUCT_ID);
            Cart sessionCart = (Cart) httpSession.getAttribute(SessionAttributes.SESSION_CART);
            if (null != sessionCart) {
                sessionCart.addProductId(productId);
            } else {
                sessionCart = new Cart();
                sessionCart.addProductId(productId);
                httpSession.setAttribute(SessionAttributes.SESSION_CART, sessionCart);
            }
            LOGGER.log(Level.INFO, String.format("sessionCart ================>>>>>>>>> %s", sessionCart.getProductIds()));
        }
    }

    protected void removeFromCart(HttpServletRequest request, HttpServletResponse response) {
        HttpSession httpSession = request.getSession(false);
        if (null != httpSession) {
            Cart sessionCart = (Cart) httpSession.getAttribute(SessionAttributes.SESSION_CART);
            if (null != sessionCart) {
                String productId = request.getParameter(RequestParameter.PRODUCT_ID);
                sessionCart.removeProductId(productId);
            }
            LOGGER.log(Level.INFO, String.format("sessionCart ================>>>>>>>>> %s", sessionCart.getProductIds()));
        }
    }

    protected void checkoutCart(HttpServletRequest request, HttpServletResponse response) {
        HttpSession httpSession = request.getSession(false);
        if (null != httpSession) {
            User sessionUser = (User) httpSession.getAttribute(SessionAttributes.SESSION_USER);
            Cart sessionCart = (Cart) httpSession.getAttribute(SessionAttributes.SESSION_CART);

            LOGGER.log(Level.INFO, String.format("sessionCart ------------------>>>>>>> %s", sessionCart));

            if (null != sessionCart) {
                List<String> productIds = sessionCart.getProductIds();

                if (!productIds.isEmpty()) {
                    Order newOrder = new Order();
                    newOrder.setUser(sessionUser);
                    newOrder.setStatus(Order.PAYMENT_PENDING);

                    LOGGER.info(String.format("Registering order with id '%s' in table ORDER", newOrder.getId()));
                    OrderLocalService.registerOrder(newOrder);

                    for (String productId : productIds) {
                        Product product = ProductLocalService.fetchById(productId);

                        OrderProductJoin orderProductJoin = new OrderProductJoin();
                        orderProductJoin.setOrder(newOrder);
                        orderProductJoin.setProduct(product);

                        LOGGER.info(String.format("Registering (order : product) = (%s : %s) in table ORDER_PRODUCT_JOIN", newOrder.getId(), product.getId()));
                        OrderProductJoinLocalService.register(orderProductJoin);
                    }

                    try {
                        response.getWriter().print("0");
                    } catch (IOException e) {
                        LOGGER.log(Level.SEVERE, e.getMessage(), e);
                        toErrorPage500(request, response);
                        return;
                    }
                } else {
                    try {
                        response.getWriter().print("Cart is empty");
                    } catch (IOException e) {
                        LOGGER.log(Level.SEVERE, e.getMessage(), e);
                        toErrorPage500(request, response);
                        return;
                    }
                }
            } else {
                try {
                    response.getWriter().print("Cart is empty");
                } catch (IOException e) {
                    LOGGER.log(Level.SEVERE, e.getMessage(), e);
                    toErrorPage500(request, response);
                    return;
                }
            }
        } else {
            try {
                response.getWriter().print("Invalid Session...");
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, e.getMessage(), e);
                toErrorPage500(request, response);
                return;
            }
        }
    }
}
