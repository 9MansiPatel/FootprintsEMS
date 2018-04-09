<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    
    <%@include file="head.jsp" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="bootstrap/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="bootstrap/bootstrap.min.js"></script>
  
<title>Footprints</title>
</head>
<body>

<!-- 
<%
	if (session.getAttribute("currentSessionUser") == null){%>
		You need to Login..!!
		<jsp:forward page="index.jsp" /><% 
	}%>
 
 -->
<center>

<div class="container" style=" padding:2em; width:50%; height:50%; background-color:#E8E8E8;">
<form action="<%=request.getContextPath() %>/TicketFormController" method="post">  
<c:forEach var="i" items="${sessionScope.ls}">
<%--  <input type="hidden" name="netId" value="${i.netId }" /> --%>
 <center>
<font size="3px" color="#000000" style="font-family:'Century Schoolbook'"></font></a>
</center>
<br><br>
<div class="input-group"> 
	<label>Building name</label>
	<input type="text"  class="form-control" name="buildingName" placeholder="Enter room number" required="required" value="${i.buildingTicket}"/>  
	
	<!-- 
	<select name="buildingName">  
	<option value="Lecture Center">Lecture Center</option>  
	<option value="Social Science">Social Science</option>
	<option value="Humanities">Humanities</option>
	<option value="Earth Science">Earth Science</option>
	<option value="Fine arts and Sciences">Fine arts and Sciences</option>
	<option value="Campus Center">Campus Center</option>
	<option value="Physical Education">Physical Education</option>    
	</select> <br/>
	
	 --> 
</div>
</br>


<div class="input-group">
	<label>Room number</label>
	<input type="text"  class="form-control" name="roomnumber" placeholder="Enter room number" required="required" value="${i.roomTicket}"/>  
</div>
</br>


<div class="input-group">
	<label>Date</label>
	<input type="text" class="form-control" name="date" placeholder="Enter date: (yyyy-mm-dd)" required="required" value="${i.dateTicket}"/>  
</div>
</br>


<div class="input-group">
	<label>Time</label>
	<input type="text" class="form-control" name="time" placeholder="Enter time: HH:mm" required="required" value="${i.timeTicket}" /><br/><br/>  
</div>
</br>
</br> 



<div class="input-group">
	<label>Net ID</label>
	<input type="text" class="form-control" name="netId" required="required" value="${i.netId}"/>
</div>
</br>

<div class="input-group">
	<label>First Name</label>
	<input type="text" class="form-control" name="firstName" required="required" value="${i.firstName}"/>
</div>
</br>

<div class="input-group">
	<label>Last Name</label>
	<input type="text" class="form-control" name="lastName" required="required" value="${i.lastName}"/>
</div>
</br>

<div class="input-group">
	<label>Email-Id</label>
	<input type="text" class="form-control" name="email" required="required" value="${i.email}"/>
</div>
</br>
<input type="hidden" name="flag" value="insertValue"> 
</br>
</br>  
<input type="submit" class="btn btn-primary" value="generate ticket"/>  
</br>
</br>
<a href="temp.jsp"><input type="button" class="btn btn-primary" value="Reset"></a>
<!-- <input type="reset" class="btn btn-primary" formaction="/temp.jsp"/> -->
</c:forEach>
</form>



<form action="<%=request.getContextPath() %>/LogoutServlet" method="post"> 
		</br><input type="submit" class="btn btn-primary" value="Logout"> 
	</form>


</center>
</div>


</br>
</br>
<%@include file="footer.jsp" %>

</body>
</html>