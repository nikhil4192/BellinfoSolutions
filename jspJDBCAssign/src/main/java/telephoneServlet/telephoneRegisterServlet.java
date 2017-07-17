package telephoneServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import org.postgresql.util.PSQLException;

import telephoneModel.TeleInfo;
import telephoneRepository.TeleRegRepo;

public class telephoneRegisterServlet extends HttpServlet{
	
	String rContact = null;
	String netName = null;
	private static  final String SUCCESS ="Hey, Successfully Registred at ";
	private static final String FAILED ="Something went wrong, please contact at ";
	public void init(ServletConfig sc){
		rContact =sc.getInitParameter("Reg-Contact");
		ServletContext serContext = sc.getServletContext();
		netName = serContext.getInitParameter("network-name");
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		String message = null;
		//Extracting Telephone Inputs
	     String name = req.getParameter("name");
	     String phone = req.getParameter("num");
	     String email = req.getParameter("email");
	     String password = req.getParameter("pwd");
	     String dt = req.getParameter("date");
	     String gen = req.getParameter("gender");
	     String car = req.getParameter("carrier");
	     String zipcode = req.getParameter("zip");
	     
	   // Populating PatientInfo  
	     TeleInfo tel = new TeleInfo(name, phone, email, password, dt, gen, car, zipcode);
	     
	    //Persisting PR info 
	     TeleRegRepo trr = new TeleRegRepo();
	     int result =0;
		try {
			result = trr.insertTeleInfo(tel);
		} catch (PSQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	   //Validating the status & return
	     if(result!=0){
	    	 message  = SUCCESS + netName;
	     }else{
	    	 message = FAILED + rContact;
	     }
	     
	     //Seeting in to response and flush it
	     req.setAttribute("status", message);
	     RequestDispatcher rd = req.getRequestDispatcher("register-success.jsp");
	     rd.forward(req, resp);
		
	     
		
	}

}
