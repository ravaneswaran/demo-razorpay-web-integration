package rc.demo.app.controller;

import rc.demo.app.RequestParameter;
import rc.demo.app.SessionAttributes;
import rc.demo.app.controller.helper.PasswordControllerHelper;
import rc.demo.app.models.User;
import rc.demo.app.service.local.UserLocalService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PasswordController extends PasswordControllerHelper {
	
	private static final long serialVersionUID = 1L;

    private static final Logger LOGGER = Logger.getLogger(PasswordController.class.getName());

    public static final String FORGOT_PASSWORD = "forgot-password";
    public static final String CHANGE_PASSWORD = "change-password";
    

    @Override
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) {
        String command = request.getParameter(RequestParameter.COMMAND);
        switch (command) {
            case FORGOT_PASSWORD:
                forgotPassword(request, response);
                break;
            case CHANGE_PASSWORD:
                changePassword(request, response);
                break;
        }
    }

    protected void forgotPassword(HttpServletRequest request, HttpServletResponse response){
        String email = request.getParameter(RequestParameter.EMAIL);
        String password = getUserPassword(email);
        try {
            if(null != password) {
                String loginLink = String.format("Your password is : %s <a href=\"%s\">( Use this password here... )</a>", password, "../pages/login.jsp");

                StringBuffer responseBuffer = new StringBuffer();
                responseBuffer.append(loginLink);

                response.getWriter().println(responseBuffer.toString());
            } else {
                String registerLink = String.format("Sorry!!! You are yet to register... <a href=\"%s\">( Go here... )</a>", "../pages/user-registration.jsp");
                response.getWriter().print(registerLink);
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            toErrorPage500(request, response);
            return;
        }
    }
    
    protected void changePassword(HttpServletRequest request, HttpServletResponse response){
        String email = request.getParameter(RequestParameter.EMAIL);
        String currentPassword = request.getParameter(RequestParameter.CURRENT_PASSWORD);
        String newPassword = request.getParameter(RequestParameter.NEW_PASSWORD);
        String confirmPassword = request.getParameter(RequestParameter.CONFIRM_PASSWORD);
        String password = getUserPassword(email);
        
        try {
        	
        	if(email == null || email.isEmpty()) {
            	response.getWriter().println("Please provide your email address.");
            	return;
            }
        	
        	if(currentPassword == null || currentPassword.isEmpty()) {
            	response.getWriter().println("Current password cannot be blank.");
            	return;
            }
        	
        	if(newPassword == null || newPassword.isEmpty()) {
            	response.getWriter().println("New password cannot be blank.");
            	return;
            }
        	
        	if(confirmPassword == null || confirmPassword.isEmpty()) {
            	response.getWriter().println("Confirm password cannot be blank.");
            	return;
            }
        	
        	if(password == null || password.isEmpty()) {
            	response.getWriter().println("Please check your email address");
            	return;
            }
        	
        	if(5 > newPassword.length()) {
        		response.getWriter().println("New password lenght should be 5 characters long");
            	return;
        	}
        	
        	if(5 > confirmPassword.length()) {
        		response.getWriter().println("Confirm password lenght should be 5 characters long");
            	return;
        	}
        	
        	if(currentPassword.equals(newPassword)) {
        		response.getWriter().println("Current and New password cannot be same.");
            	return;
        	}
        	
        	if(!confirmPassword.equals(newPassword)) {
        		response.getWriter().println("New and Confirm password must be same.");
            	return;
        	}
        	
        	User sessionUser = (User)request.getSession().getAttribute(SessionAttributes.SESSION_USER);
        	if(!sessionUser.getEmailId().equals(email)) {
        		response.getWriter().println("Who are you?");
            	return;
        	}
        	
        	if(currentPassword.equals(password)) {
        		User user = UserLocalService.fetchUserBy(email);
        		user.setPassword(newPassword);
        		
        		UserLocalService.updateUser(user);
        		response.getWriter().print("0");
        	} else {
        		response.getWriter().print("Please provide your current password.");
        	}
        	
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            toErrorPage500(request, response);
            return;
        }
    }
}
