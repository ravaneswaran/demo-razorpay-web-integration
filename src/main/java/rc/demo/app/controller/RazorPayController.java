package rc.demo.app.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class RazorPayController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOGGER = Logger.getLogger(RazorPayController.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doProcess(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doProcess(request, response);
    }

    protected abstract void doProcess(HttpServletRequest request, HttpServletResponse response);
    
    protected void toErrorPage500(HttpServletRequest request, HttpServletResponse response) {
    	RequestDispatcher requestDispatcher = request.getRequestDispatcher("../pages/internal-server-error.jsp");
    	try {
			requestDispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
		}
    }
}
