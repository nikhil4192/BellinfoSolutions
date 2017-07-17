package telephoneServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import org.postgresql.util.PSQLException;

import telephoneModel.TelePayment;
import telephoneRepository.TelePayRepo;

public class telePayServlet extends HttpServlet{

	String rContact = null;
	String netName = null;
	private static  final String SUCCESS ="Hey, Payment made Successfully ";
	private static final String FAILED ="You can pay bill's only to the registered phone numbers for this account. Soory for inconvinence please register.\n";
	public void init(ServletConfig sc){
		rContact =sc.getInitParameter("Bill_Contact");
		ServletContext serContext = sc.getServletContext();
		netName = serContext.getInitParameter("network-name");
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		String message = null;
		//Extracting Telephone Inputs
	     String phone = req.getParameter("phone");
	     String name = req.getParameter("name");
	     String card = req.getParameter("card");
	     String month = req.getParameter("mm");
	     String year = req.getParameter("yy");
	     String cvv = req.getParameter("cvv");
	     String amount = req.getParameter("amount");
	     
	     TelePayment tp = new TelePayment(phone, name, card, month, year, cvv, amount);

	     TelePayRepo tpr = new TelePayRepo();
	     int result =0;
			try {
				result = tpr.insertTelePay(tp);

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
		     RequestDispatcher rd = req.getRequestDispatcher("payment_sucess.jsp");
		     rd.forward(req, resp);
			
		     
			
		}

	}
