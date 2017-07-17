package telephoneServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import org.postgresql.util.PSQLException;

import telephoneModel.TeleInfo;
import telephoneModel.TeleLogin;
import telephoneRepository.TeleRegRepo;

public class teleLoginServlet extends HttpServlet{

	String rContact = null;
	String netName = null;
	private static  final String SUCCESS ="Hey, Successfully Logged in at ";
	private static final String FAILED ="Something went wrong, please contact at ";
	public void init(ServletConfig sc){
		rContact =sc.getInitParameter("Log-Contact");
		ServletContext serContext = sc.getServletContext();
		netName = serContext.getInitParameter("network-name");
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		String message = null;
		//Extracting Telephone Inputs
	     String email = req.getParameter("email");
	     String password = req.getParameter("pwd");
	
	     TeleLogin tl = new TeleLogin(email, password);
	     TeleRegRepo trr = new TeleRegRepo();
	     boolean result = false;
		result = trr.validateLogin(tl); 
	   //Validating the status & return
	     if(result == true){
	    	 message  = SUCCESS + netName;
	     }else{
	    	 message = FAILED + rContact;
	     }
	     
	     //Seeting in to response and flush it
	     req.setAttribute("status", message);
	     RequestDispatcher rd = null;
	     if(result == true ){
	     rd = req.getRequestDispatcher("teleHome.jsp");
	     }
	     else{
	     rd = req.getRequestDispatcher("loginFailure.jsp");
	     }
	     rd.forward(req, resp);
	     }
	     
	}
