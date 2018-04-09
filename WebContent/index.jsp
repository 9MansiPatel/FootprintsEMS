<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
        
    <%@include file="head.jsp" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <link rel="stylesheet" href="bootstrap/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="bootstrap/bootstrap.min.js"></script>
  
<title>Footprints login</title>
</head>
<body>

<center>
	<%
	if (session.getAttribute("currentSessionUser") != null){%>
			You are already Logged in..!!
		<jsp:forward page="temp.jsp" /><% 
	}%>
<br><br>

<%
	if(request.getAttribute("errorMessage")!=null)
	{%>
  <center><%= request.getAttribute("errorMessage") %> </center>
  
<%
request.setAttribute("errorMessage",null);
	}
%>
 
 
 
<div class="container" style=" padding:2em; width:50%; height:50%; background-color:#E8E8E8;">
<form action="<%=request.getContextPath() %>/LoginController" method="post">  



<center>
<font size="3px" color="#000000" style="font-family:'Century Schoolbook'">Please Log in</font></a>
</center>
<br><br>


<div class="input-group">
      <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
      <input  type="text" class="form-control" name="netId" placeholder="NetID" required="required"/>
    </div>
    <p>
    <div class="input-group">
      <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
      <input type="password" class="form-control" name="userPassword" placeholder="Password" required="required"/>
    </div>
    <br>
   

 <input type="submit" class="btn btn-primary" value="Login">
<br><br>

<a href=index.jsp><input type="button" class="btn btn-primary" value="Reset"></a>


</form>

</div>

</center>
<%@include file="footer.jsp" %>

</body>
</html>