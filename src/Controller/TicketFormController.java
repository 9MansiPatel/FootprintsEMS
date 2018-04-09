package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.TicketFormDAO;
import VO.ticketFormVO;

/**
 * Servlet implementation class TicketFormController
 */
@WebServlet("/TicketFormController")
public class TicketFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TicketFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{	    

			HttpSession session = request.getSession(false);
			if (session.getAttribute("currentSessionUser") == null){
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
			      rd.include(request,response);  
			}
			
			//--------------
			
			//--------------
			
			String flag = request.getParameter("flag");
			System.out.println(flag);
		    //String netId = request.getParameter("netId");
		    //System.out.println(netId);
		    String  buildingTicket= request.getParameter("buildingName");
		    System.out.println(buildingTicket);
		    String  roomTicket= request.getParameter("roomnumber");
		    System.out.println(roomTicket);
		    Pattern p = Pattern.compile("^\\d{4}[\\-\\/\\s]?((((0[13578])|(1[02]))[\\-\\/\\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\\-\\/\\s]?(([0-2][0-9])|(30)))|(02[\\-\\/\\s]?[0-2][0-9]))$");
		    String date1 = request.getParameter("date");
		    Matcher m = p.matcher(date1);
		    Boolean d = m.matches();
		    //SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
		    if(!d) {
		    	System.out.println(d);
				//RequestDispatcher rd=request.getRequestDispatcher("failure.jsp");  
			    //rd.forward(request,response); 
				response.setContentType("text/html");  
				PrintWriter out = response.getWriter();
				out.print("Improper date!!!");
		    	response.sendRedirect("failure.jsp");
		    }
		    
		    SimpleDateFormat dateTicket1 = new SimpleDateFormat("yyyy-MM-dd");
		    dateTicket1.setLenient(false);
		    Date dateTicket=dateTicket1.parse(date1);
		    
		    //String parameter = request.getParameter("date");
		    System.out.println(" date->"+dateTicket);
		    //Date dateTicket = in.parse(parameter);
		    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		    Date currentDate = dateFormat.parse(dateFormat.format(new Date()));
		    System.out.println(currentDate);
		    System.out.println(dateTicket);
		    Boolean state = dateTicket.after(currentDate);
		    
		    if(state) {
		    	System.out.println(state);
				//RequestDispatcher rd=request.getRequestDispatcher("failure.jsp");  
			    //rd.forward(request,response); 
				response.setContentType("text/html");  
				PrintWriter out = response.getWriter();
				out.print("Improper date!!!");
		    	response.sendRedirect("failure.jsp");
		    }
		    else {
	    	String timeTicket = request.getParameter("time");
		    System.out.println(timeTicket);
		    Pattern pattern = Pattern.compile("([01]?[0-9]|2[0-3]):[0-5][0-9]");
		    Matcher matcher = pattern.matcher(timeTicket);
		    Boolean time = matcher.matches();
		    if(!time) {
		    	System.out.println(time);
				//RequestDispatcher rd=request.getRequestDispatcher("failure.jsp");  
			    //rd.forward(request,response); 
				response.setContentType("text/html");  
				PrintWriter out = response.getWriter();
				out.print("Improper time!!!");
		    	response.sendRedirect("failure.jsp");
		    }
		    else if(dateTicket.equals(currentDate)) {
		    	String s= new SimpleDateFormat("HH:mm").format(new Date());
		    	System.out.println(s);
		    	if(timeTicket.compareTo(s)>1) {
		    		System.out.println(time);
					//RequestDispatcher rd=request.getRequestDispatcher("failure.jsp");  
				    //rd.forward(request,response); 
					response.setContentType("text/html");  
					PrintWriter out = response.getWriter();
					out.print("Improper time for today!!!");
			    	response.sendRedirect("failure.jsp");
		    	}
		    }
		    else {
		    ticketFormVO user = new ticketFormVO();
		    ticketFormVO userout = new ticketFormVO();
		     //user.setNetId(netId);
		    user.setBuildingTicket(buildingTicket);
		    user.setDateTicket(dateTicket);
		    user.setRoomTicket(roomTicket);
		    user.setTimeTicket(timeTicket);
		     
		     //user = TicketFormDAO.ticket(user);
		     boolean check = flag.equals("getValue");
		     System.out.println("Checking flag = "+check);
		     
		     if(flag.equals("getValue")){
		    	 
		    	 System.out.println("in if flag get Value");
		    	 
		    	 userout = TicketFormDAO.getticketdetails(user);
		    	 System.out.println("After getting data"+userout.getFirstName());
		    	 System.out.println("After getting data"+userout.isValid());
		    	 if(userout.getFirstName()==null) {
		    		 System.out.println("After getting data"+userout.getFirstName());
		    		 response.sendRedirect("failure.jsp"); //error page
		    	 }
		    	 if(user.isValid()){
		    		 java.sql.Date date = new java.sql.Date( userout.getDateTicket().getTime() );
				    	 List ls = new ArrayList();
				    	 userout.setDateTicket(date);
				    	 ls.add(userout);
				    	 session.setAttribute("ls", ls);
				    	 //System.out.println(session.getAttribute("ls"));
				    	 response.sendRedirect("autoFill.jsp"); //logged-in page
		    	 }
		    	 else
		    		 response.sendRedirect("temp.jsp");
		     }
		     
		     if(flag.equals("insertValue")){
		    	 
		    	 user.setBuildingTicket(buildingTicket);
			     user.setDateTicket(dateTicket);
			     user.setRoomTicket(roomTicket);
			     user.setTimeTicket(timeTicket);
			     user.setFirstName(request.getParameter("firstName"));
			     user.setLastName(request.getParameter("lastName"));
			     user.setEmail(request.getParameter("email"));
			     user.setNetId(request.getParameter("netId"));
			     
			     user = TicketFormDAO.ticket(user);
			     
		    	 //System.out.println("in if flag check");
		    	 
		    	 userout = TicketFormDAO.getticketdetails(user);
		    	 System.out.println("After getting data"+userout.getFirstName());
		    	 System.out.println("After getting data"+userout.isValid());
		    	 if(userout.getFirstName()== null) {
		    		 System.out.println("After getting data"+userout.getFirstName());
		    		 
		    		 response.sendRedirect("failure.jsp"); //error page
		    	 }
		    	 if (user.isValid())
			     {
			          response.sendRedirect("success.jsp"); //logged-in page      		
			     }
				        
			     else 
			          response.sendRedirect("failure.jsp"); //error page
		    	 
		    	 
		     }
		     
		     
			} 
		 
		}
		}
		catch (Exception theException) 	    
		{
			//response.sendRedirect("failure.jsp"); //error page
		     System.out.println(theException); 
		     //response.sendRedirect("failure.jsp"); //error page
		}
	}

}
