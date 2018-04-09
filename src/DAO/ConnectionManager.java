package DAO;

import java.sql.*;

public class ConnectionManager {
	
	static Connection con, con1;
    static String url, url1;
          
    public static Connection getConnection()
    {
      
       try
       {
          String url = "jdbc:mysql://localhost:3306/fp_db";
         
          // assuming "DataSource" is your DataSource name

          Class.forName("com.mysql.jdbc.Driver");
          
          try
          {            	
             con = DriverManager.getConnection(url,"mansi","patel");
             
          }
          
          catch (SQLException ex)
          {
             ex.printStackTrace();
          }
       }

       catch(ClassNotFoundException e)
       {
          System.out.println(e);
       }

    return con;
   
}
    
    
    public static Connection getConnectionEms()
    {
      
       try
       {
          
          String url1 = "jdbc:mysql://localhost:3306/ems_db";
          // assuming "DataSource" is your DataSource name

          Class.forName("com.mysql.jdbc.Driver");
          
          try
          {            	
             
             con1 = DriverManager.getConnection(url1,"mansi","patel");
          }
          
          catch (SQLException ex)
          {
             ex.printStackTrace();
          }
       }

       catch(ClassNotFoundException e)
       {
          System.out.println(e);
       }

    
    return con1;
}

}
