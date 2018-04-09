package DAO;

import VO.LoginVO;
import java.sql.*;

public class LoginDAO {

    static Connection currentCon = null;
    static Connection currentCon1 = null;
    static ResultSet rs = null;  
    static ResultSet rs1 = null; 
    public static LoginVO login(LoginVO bean) {
    	
        //preparing some objects for connection 
        Statement stmt = null;
        Statement stmt1 = null;
	
        String netId = bean.getNetId();    
        String userPassword = bean.getUserPassword();   
	    
        
        String searchQuery1 ="select * from userdetails where netId='"
                       + netId
                       + "'";
        
        System.out.println(searchQuery1);
        
        String searchQuery =
              "select * from users where netId='"
                       + netId
                       + "' AND password='"
                       + userPassword
                       + "'";
	    
     // "System.out.println" prints in the console; Normally used to trace the process
     System.out.println("Your user name is " + netId);          
     System.out.println("Your password is " + userPassword);
     System.out.println("Query: "+searchQuery);
     
     //String searchQuery1 ="select * from userdetails";
     
     System.out.println(searchQuery1);
    
    try{
	     currentCon1 = ConnectionManager.getConnectionEms();
	 	stmt1=currentCon1.createStatement();
	     rs1 = stmt1.executeQuery(searchQuery1);
	     boolean more = rs1.next();
	 	System.out.println("***********************************"+ more);
	 	String n = rs1.getString("firstname");
	     System.out.println(rs1 + "\n"+n);
	     System.out.println("***********************************");
    }
    catch (Exception e) {
		// TODO: handle exception
	}
	    
     try 
     {
        //connect to DB 
    	
        currentCon = ConnectionManager.getConnection();
        stmt=currentCon.createStatement();
        rs = stmt.executeQuery(searchQuery);	        
        boolean more = rs.next();
	       
        // if user does not exist set the isValid variable to false
        if (!more) 
        {
           System.out.println("Sorry, you are not a registered user!");
           bean.setValid(false);
        } 
	        
        //if user exists set the isValid variable to true
        else if (more) 
        {
           String firstName = rs.getString("firstName");
           String lastName = rs.getString("lastName");
	     	
           System.out.println("Welcome " + firstName);
           bean.setFirstName(firstName);
           bean.setLastName(lastName);
           bean.setValid(true);
        }
     } 

     catch (Exception ex) 
     {
        System.out.println("Log In failed: An Exception has occurred! " + ex);
     } 
	    
     //some exception handling
     finally 
     {
        if (rs != null)	{
           try {
              rs.close();
           } catch (Exception e) {}
              rs = null;
           }
	
        if (stmt != null) {
           try {
              stmt.close();
           } catch (Exception e) {}
              stmt = null;
           }
	
        if (currentCon != null) {
           try {
              currentCon.close();
           } catch (Exception e) {
           }

           currentCon = null;
        }
     }

return bean;
	
     }	
}
