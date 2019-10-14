package rc.demo.app.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rc.demo.app.RequestParameter;
import rc.demo.app.controller.helper.CartControllerHelper;

public class CartController extends CartControllerHelper {

	private static final long serialVersionUID = 1L;
	
	private static final Logger LOGGER = Logger.getLogger(CartController.class.getName());

    public static final String ADD_TO_CART = "add-to-cart";
    public static final String REMOVE_FROM_CART = "remove-from-cart";
    public static final String CHECKOUT_CART = "checkout-cart";

    @Override
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) {
        String command = request.getParameter(RequestParameter.COMMAND);

        LOGGER.log(Level.INFO, String.format("command ==============>>>>>>> %s", command));
        
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
