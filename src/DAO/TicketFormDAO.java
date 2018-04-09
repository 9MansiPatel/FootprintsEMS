package DAO;

import VO.ticketFormVO;

import java.sql.*; 

public class TicketFormDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;
    public static ticketFormVO ticket(ticketFormVO bean) {
    	
        //preparing some objects for connection 
        Statement stmt = null;    
	
        String netId = bean.getNetId();    
        String buildingTicket = bean.getbuildingTicket();
        String roomTicket = bean.getRoomTicket();
        String timeTicket = bean.getTimeTicket();
        String email = bean.getEmail();
        String firstName = bean.getFirstName();
        String lastName = bean.getLastName();
        		    
        java.util.Date util_DateTicket;
		try {
			util_DateTicket = bean.getDateTicket();
	        java.sql.Date dateTicket = new java.sql.Date( util_DateTicket.getTime() );
	        
	        String searchQuery1 = "select * from tickets where building='"
                    + buildingTicket
                    +"'AND room='"
                    +roomTicket
                    + "' AND date='"
                    +dateTicket
                    + "' AND time ='"
                    + timeTicket
                    + "'";
		    
	        String searchQuery =
	        		"INSERT INTO tickets"
	        				+ "(netId, building, room, date, time, email, fName, lName) " + "VALUES"
	        				+ "('" + netId + "','" + buildingTicket + "','" + roomTicket + "','" + dateTicket + "','" + timeTicket + "', "
	        						+ "'" + email + "','" + firstName + "','" + lastName + "')";
	        System.out.println("Query: "+searchQuery);
	        //connect to DB 
	        currentCon = ConnectionManager.getConnection();
	        stmt=currentCon.createStatement();
	        rs = stmt.executeQuery(searchQuery1);
	        if(rs.next()) {
	        	System.out.println("Already exist!!");
	        	bean.setValid(false);
	        	return bean;
	        }
	        stmt.executeUpdate(searchQuery);
	        bean.setValid(true);

		} 
		catch (Exception e1) {
			// TODO Auto-generated catch block
			bean.setValid(false);
			e1.printStackTrace();
			System.out.println(e1);
     } 
	    
     //some exception handling
     finally 
     {
	
        if (stmt != null) {
           try {
              stmt.close();
           } catch (Exception e) {}
              stmt = null;
           }
	
        if (currentCon != null) {
           try {
              currentCon.close();
           } 
           
           catch (Exception e) {
           }
           currentCon = null;
        	}
     	}

		return bean;
	
     }	
    
    public static ticketFormVO getticketdetails(ticketFormVO bean) {
    	
        //preparing some objects for connection 
        Statement stmt = null;    
	
        String netId = bean.getNetId();    
        String buildingTicket = bean.getbuildingTicket();
        String roomTicket = bean.getRoomTicket();
        String timeTicket = bean.getTimeTicket();
        java.util.Date util_DateTicket;
		try {
			util_DateTicket = bean.getDateTicket();
	        java.sql.Date dateTicket = new java.sql.Date( util_DateTicket.getTime() );
	        
	        System.out.println("In controller"+ dateTicket);
		    
	        String searchQuery = "select * from userdetails where building='"
                    + buildingTicket
                    +"'AND room='"
                    +roomTicket
                    + "' AND date='"
                    +dateTicket
                    + "' AND startTime <='"
                    + timeTicket
                    + "' AND endTime >='"
                    + timeTicket
                    + "'";


	        System.out.println("Query: "+searchQuery);
	        //connect to DB 
	        currentCon = ConnectionManager.getConnectionEms();
	        stmt=currentCon.createStatement();
	        rs = stmt.executeQuery(searchQuery);
	        if(rs.next()) {
	        bean.setEmail(rs.getString("email"));
	        bean.setFirstName(rs.getString("firstName"));
	        bean.setLastName(rs.getString("lastName"));
	        bean.setNetId(rs.getString("netId"));
	        bean.setValid(true);
	        }
	        else {
	        	bean.setValid(false);
	        }
		} 
		catch (Exception e1) {
			// TODO Auto-generated catch block
			bean.setValid(false);
			e1.printStackTrace();
			System.out.println(e1);
     } 
	    
     //some exception handling
     finally 
     {
	
        if (stmt != null) {
           try {
              stmt.close();
           } catch (Exception e) {}
              stmt = null;
           }
	
        if (currentCon != null) {
           try {
              currentCon.close();
           } 
           
           catch (Exception e) {
           }
           currentCon = null;
        	}
     	}

		return bean;
	
     }	

}
