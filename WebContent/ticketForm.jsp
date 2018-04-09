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
  
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/style.css"></script>


<title>   Footprints   </title>

</head>

<body>
<%
	if (session.getAttribute("currentSessionUser") == null){%>
		You need to Login..!!
		<jsp:forward page="index.jsp" /><% 
	}%>
<div class="container"  style= "padding:2em; width:50%; height:100%; background-color:#E8E8E8;">


<form action="<%=request.getContextPath() %>/TicketFormController" method="post">  




 <div class="input-group">
    <label for="netId">NetID</label>
    <input type="text" class="form-control" id="netId" placeholder="NetID" required="required"/>
  </div>


 <div class="input-group">
    <label for="buildingname">Building name</label>
    <select class="form-control" id="buildingname" required="required"/>
      <option>Air bubble</option>
      <option>Albany Medical center</option>
      <option>Building 25</option>
      <option>Campus Center</option>
      <option>Earth Science</option>
      <option>Education building</option>
      <option>Fine Arts and Sciences</option>
    </select>
  </div>
  

<div class="input-group">
    <label for="roomnumber">Room number</label>
    <input type="text" class="form-control" id="roomnumber" aria-describedby="Room number" placeholder="room number" required="required"/>
  </div>
  




<div class='input-group date' data-provide='date'>
             <label for="date">Date</label>
             <input type="date"   class="form-control" placeholder="Date" required="required"/>
</div>

</br>

<div class="input-group">
	
    <label for="time">Time</label>
    <input type="text" class="form-control" id="time" placeholder="Time" required="required"/>
  
</div>


</br>
</br>


<!--  <div class="input-group">
    <label for="description">Description</label>
    <textarea class="form-control" id="description" rows="3" required="required" ></textarea>
</div>-->

</br>
</br>


<center>
<button type="submit" class="btn btn-primary">Generate ticket</button>
</center>
<form action="<%=request.getContextPath() %>/LogoutServlet" method="post"> 
		<br/><input type="submit" value="Logout"> 
	</form>

</form>


</div>
</body>
</br>
</br>
</br>
</br>

<%@include file="footer.jsp" %>


</html>