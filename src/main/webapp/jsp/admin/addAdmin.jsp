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
                          url: "/ProviderServlet/checkLoginAdmin",
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
                          url: "/ProviderServlet/checkMailAdmin",
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

<title>Add new Admin</title>

</head>

<body>
<div class="admininfo">
<c:out value="${admin.first_name}" /> <c:out value="${admin.last_name}" />

<br> <a href="/ProviderServlet/jsp/admin/mainadmin.jsp">Admin main</a>
<br><a href="<c:url value="${'/logout'}"></c:url>">Logout</a>
</div>
<div class="newuser">
	<div class="newuserinner">
<p align="center"> Add new Admin </p>
<form name="newuserform" method="post" action="/ProviderServlet/addAdmin">
<p> First Name* <input class="simple-input" type="text" name="firstname"> </p>
<p> Last Name* <input class="simple-input" type="text" name="lastname"> </p>
<p> Login* <input type="text" name="login" class="uname"><br><span style="font-size: 10px;" class="status"></span> </p>
<p> Password* <input class="simple-input" type="password" name="password" onKeyPress="passValid()"> <br><span id="span1" style="font-size: 10px;">min 5 chars</span> </p>
<p> Confirm pass* <input class="simple-input" type="password" name="password2" onKeyUp="passMatch()"><br><span style="font-size: 10px;" id="span2" class="passvalid"></span> </p>
<p> Email* <input type="text" name="email" onBlur="validateEmail()" class="mail"> <br><span style="font-size: 10px;" class="status2"></span><br><span style="font-size: 10px;" id="span3"></span></p>
<p> Phone* <input class="simple-input" type="text" name="phone"> </p>
<p> <input class="button" name="submit" type="submit" value="Add" disabled> <input class="button" type="reset" value="Reset"> </p>
</form>
	</div>
</div>
</body>
</html>
