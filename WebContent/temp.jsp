<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
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

<%
	if (session.getAttribute("currentSessionUser") == null){%>
		You need to Login..!!
		<jsp:forward page="index.jsp" /><% 
	}%>

<center>


<div class="container" style=" padding:2em; width:50%; height:50%; background-color:#E8E8E8;">
<form action="<%=request.getContextPath() %>/TicketFormController" method="post">  
 
 
 <center>
<font size="3px" color="#000000" style="font-family:'Century Schoolbook'"></font></a>
</center>
<br><br>
<div class="input-group"> 
	<label>Building name</label>
	<select name="buildingName">  
	<option value="Lecture Center">Lecture Center</option>  
	<option value="Social Science">Social Science</option>
	<option value="Humanities">Humanities</option>
	<option value="Earth Science">Earth Science</option>
	<option value="Fine arts and Sciences">Fine arts and Sciences</option>
	<option value="Campus Center">Campus Center</option>
	<option value="Physical Education">Physical Education</option>    
	</select> <br/> 
</div>
</br>


<div class="input-group">
	<label>Room number</label>
	<input type="text"  class="form-control" name="roomnumber" placeholder="Enter room number" required="required"/>  
</div>
</br>


<div class="input-group">
	<label>Date</label>
	<input type="text" class="form-control" name="date" placeholder="Enter date: (yyyy-mm-dd)" id="date" required="required"/>  
<!-- 
<script type="text/javascript">
    function checkDOB() {
        var dateString = document.getElementById('date').setAttribute("max", today);;
        var myDate = new Date(dateString);
        var today = new Date();
        if ( myDate > today ) { 
            $('#id_date').after('<p>You cannot enter a date in the future!.</p>');
            return false;
        }
        return true;
    }
</script>
 -->
</div>


</br>




<div class="input-group">
	<label>Time</label>
	<input type="text" class="form-control" name="time" placeholder="Enter time: HH:mm" required="required"/><br/><br/>  
</div>
</br>
</br> 
<input type="hidden" name="flag" value="getValue"> 
<input type="submit" class="btn btn-primary" value="get values"/>  
</br>

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