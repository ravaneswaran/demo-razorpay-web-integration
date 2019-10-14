package rc.demo.app.controller.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.NotImplementedException;

import rc.demo.app.controller.RazorPayController;
import rc.demo.app.models.User;
import rc.demo.app.service.local.UserLocalService;

public class LoginControllerHelper extends RazorPayController {
	
	private static final long serialVersionUID = 1L;

    @Override
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) {
        throw new NotImplementedException("'doprocess()' method should be overridden...");
    }

    protected User login(String emailId, String password){
        return UserLocalService.fetchUserBy(emailId, password);
    }
}
