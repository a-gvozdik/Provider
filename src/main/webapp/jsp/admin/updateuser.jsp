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
                          url: "/ProviderServlet/checkLogin",
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
                          url: "/ProviderServlet/checkMail",
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
<title>Update user</title>
<style>
   <%@include file='style.css' %>
</style>
</head>
<body>
<div class="admininfo">
<c:out value="${admin.first_name}" /> <c:out value="${admin.last_name}" />

<br> <a href="/ProviderServlet/jsp/admin/mainadmin.jsp">Admin main</a>
<br><a href="<c:url value="${'/logout'}"></c:url>">Logout</a>
</div>
<div class="newuser">
	<div class="newuserinner">
<p align="center"> Update user <c:out value="${user.first_name}" /> <c:out value="${user.last_name}"/> </p>
<form name="update" method="post" action="/ProviderServlet/updateUser">
<p> ID* <input class="simple-input" style="background-color:#EDEDED" type="text" readonly name="id" value="<c:out value="${user.id}" />"> </p>
<p> First Name* <input class="simple-input" type="text" name="firstname" value="<c:out value="${user.first_name}" />"> </p>
<p> Last Name* <input class="simple-input" type="text" name="lastname" value="<c:out value="${user.last_name}" />"> </p>
<p> Login* <input type="text" name="login" class="uname" value="<c:out value="${user.login}" />" > <br><span style="font-size: 10px;" class="status"></span></p>
<p> Email* <input type="text" name="email" onBlur="validateEmail()" class="mail" value="<c:out value="${user.email}" />"> <br><span style="font-size: 10px;" class="status2"></span><br><span style="font-size: 10px;" id="span3"></span></p>
<p> MAC* <input class="simple-input" type="text" name="MAC" value="<c:out value="${user.mac}" />"> </p>
<p> Birthday* <input class="simple-input" type="text" name="birthday" value="<c:out value="${user.birthday}" />" onBlur="isValidDate()"><br> <span style="font-size: 10px;">2000-01-01</span> </p>
<p> Phone* <input class="simple-input" type="text" name="phone" value="<c:out value="${user.phone}" />"> </p>
<p> Balans <input class="simple-input" type="text" style="background-color:#EDEDED" name="balans" value="<c:out value="${user.balans}" />" readonly> </p>
<p> Address <input class="simple-input" type="text" name="address" value="<c:out value="${user.address}" />"> </p>
<c:choose>
<c:when test="${user.status=='enabled'}">
 <p align="right"> <input type="radio" name="status" value="enabled" checked> Enabled</p>
 <p align="right"> <input type="radio" name="status" value="disabled"> Disabled</p>
 </c:when>
 <c:otherwise>
 <p align="right"> <input type="radio" name="status" value="enabled" > Enabled</p>
 <p align="right"> <input type="radio" name="status" value="disabled" checked> Disabled</p>
 </c:otherwise>
 </c:choose>
<p> <input class="button" name="submit" type="submit" value="Update"> <input type="button" class="button" onclick="history.back();" value="Back"/> </p>
</form>
	</div>
</div>
</body>
</html>