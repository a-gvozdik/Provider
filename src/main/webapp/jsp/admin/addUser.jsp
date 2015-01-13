<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="<c:url value="passvalid.js" />"></script>
<script src="jquery.js" type="text/javascript"></script>
	<script type="text/javascript">
          $(document).ready(function(){
              $(".uname").change(function(){
                  var uname = $(this).val();
                  if(uname.length >= 3){
                      $.ajax({
                          type: "POST",
                          url: "http://localhost:8080/MainServlet/checkLogin",
                          data: "uname="+ uname,
                          success: function(msg){

                              $(".status").ajaxComplete(function(event, request, settings){
                                   
                                  $(".status").html(msg);

                              });
                          }
                      }); 
                  }
                  else{
                       
                      $(".status").html("<font color=red>Login should be min <b>3</b> character long.</font>");
                  }
                  
              });
          });
		  $(document).ready(function(){
              $(".mail").change(function(){
                  var mail = $(this).val();
                  if(mail.length > 0){
                      $.ajax({
                          type: "POST",
                          url: "http://localhost:8080/MainServlet/checkMail",
                          data: "mail="+ mail,
                          success: function(msg){

                              $(".status2").ajaxComplete(function(event, request, settings){
                                   
                                  $(".status2").html(msg);

                              });
                          }
                      }); 
                  }
                                    
              });
          });
</script>
          

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style>
   <%@include file='style.css' %>
</style>

<title>Add  new User</title>

</head>

<body>
<div class="admininfo">
<c:out value="${admin.first_name}" /> <c:out value="${admin.last_name}" />
<c:out value="${info}"/>
<br> <a href="http://localhost:8080/MainServlet/jsp/admin/mainadmin.jsp">Admin main</a>
<br><a href="<c:url value="${'http://localhost:8080/MainServlet/logout'}"></c:url>">Logout</a>
</div>
<div class="newuser">
	<div class="newuserinner">
<p align="center"> Add new User </p>
<form name="newuserform" method="post" action="http://localhost:8080/MainServlet/addUser">
<p> First Name* <input type="text" name="firstname"> </p>
<p> Last Name* <input type="text" name="lastname"> </p>
<p> Login* <input type="text" name="login" class="uname"> <br><span style="font-size: 10px;" class="status"></span></p>
<p> Password* <input type="password" name="password" onBlur="passValid()"> <br><span id="span1" style="font-size: 10px;">min 5 chars</span> </p>
<p> Confirm pass* <input type="password" name="password2" onBlur="passMatch()"> <br><span style="font-size: 10px;" id="span2" class="passvalid"></span> </p>
<p> Email* <input type="text" name="email" onBlur="validateEmail()" class="mail"> <br><span span style="font-size: 10px;" class="status2"></span><br><span style="font-size: 10px;" id="span3"></span></p>
<p> MAC* <input type="text" name="MAC"> </p>
<p> Birthday* <input type="text" name="birthday" onBlur="isValidDate()"><br> <span style="font-size: 10px;">2000-01-01</span> </p>
<p> Phone* <input type="text" name="phone"> </p>
<p> Balans <input type="text" name="balans"> </p>
<p> Address <input type="text" name="address"> </p>
<p> <input class="button" name="submit" type="submit" value="Add User" disabled> <input class="button" type="reset" value="Reset"> </p>
</form>
	</div>
</div>

</body>
</html>
