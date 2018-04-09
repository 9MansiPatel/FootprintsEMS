<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
        
    <%@include file="head.jsp" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

    <center>
    <%
	if (session.getAttribute("currentSessionUser") == null){%>
		You need to Login..!!
		<jsp:forward page="index.jsp" /><% 
	}%>
       <br>
            Sorry, your ticket was not generated!</br>
            Please try again! 
            
	<form action="<%=request.getContextPath() %>/LogoutServlet" method="post"> 
		</br><input type="submit" class="btn btn-primary" value="Logout"> 
	</form> </br></br>
	
	<form action="<%=request.getContextPath() %>/temp.jsp" method="post"> 
		</br><input type="submit" class="btn btn-primary" value="Regenerate Ticket"> 
	</form>
    </center>


<%@include file="footer.jsp" %>
</body>
</html>