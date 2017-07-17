package telephoneServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;

import telephoneModel.TelePayment;
import telephoneRepository.TelePayRepo;

public class teleBillsServlet extends HttpServlet{
//List<TelePayment> list = new ArrayList<TelePayment>();
//	String rContact = null;
//	String netName = null;
//	
//	public void init(ServletConfig sc){
//		rContact =sc.getInitParameter("Log-Contact");
//		ServletContext serContext = sc.getServletContext();
//		netName = serContext.getInitParameter("network-name");
//	}
//	
//	public void doGet(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException{
//		TelePayRepo tp = new TelePayRepo();
//		System.out.println("start fun");
//		//tp.selectAllData(list);
//		System.out.println("end fun");
//	req.setAttribute("list", list);
//	System.out.println("five");
//	RequestDispatcher rd = req.getRequestDispatcher("teleBills.jsp");
//	System.out.println("six");
//    rd.forward(req, resp);
//	}
}
