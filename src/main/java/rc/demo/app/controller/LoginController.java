package rc.demo.app.controller;

import rc.demo.app.RequestParameter;
import rc.demo.app.SessionAttributes;
import rc.demo.app.controller.helper.LoginControllerHelper;
import rc.demo.app.models.User;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginController extends LoginControllerHelper {
	
	private static final long serialVersionUID = 1L;

    private static final Logger LOGGER = Logger.getLogger(LoginController.class.getName());

    @Override
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) {

        String emailId = request.getParameter(RequestParameter.EMAIL);
        String password = request.getParameter(RequestParameter.PASSWORD);

        int status = validateRequestParameters(emailId, password);

        if(0 == status) {
            User registeredUser = this.login(emailId, password);

            if (null != registeredUser) {
                HttpSession httpSession = request.getSession(true);
                httpSession.setAttribute(SessionAttributes.SESSION_USER, registeredUser);
                try {
                    response.getWriter().print("0");
                } catch (IOException e) {
                    LOGGER.log(Level.SEVERE, e.getMessage(), e);
                    toErrorPage500(request, response);
                    return;
                }
            } else {
                try {
                    response.getWriter().print("You are yet to register...");
                } catch (IOException e) {
                    LOGGER.log(Level.SEVERE, e.getMessage(), e);
                    toErrorPage500(request, response);
                    return;
                }
            }
        } else {
            try {
                switch(status) {
                    case -1:
                        response.getWriter().print("Your email id cannot be blank...");
                        break;
                    case -2:
                        response.getWriter().print("Your password cannot be blank");
                        break;
                }
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, e.getMessage(), e);
                toErrorPage500(request, response);
                return;
            }
        }
    }

    protected int validateRequestParameters(String emailId, String password){
        if(StringUtils.isEmpty(emailId)){
            return -1;
        }

        if(StringUtils.isEmpty(password)){
            return -2;
        }

        return 0;
    }
}