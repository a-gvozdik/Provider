<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Update user</title>
<style>
   <%@include file='style.css' %>
</style>
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
<p align="center"> Update user <c:out value="${user.first_name}" /> <c:out value="${user.last_name}"/> </p>
<form name="update" method="post" action="http://localhost:8080/MainServlet/updateUser">
<p> ID* <input style="background-color:#EDEDED" type="text" readonly name="id" value="<c:out value="${user.id}" />"> </p>
<p> First Name* <input type="text" name="firstname" value="<c:out value="${user.first_name}" />"> </p>
<p> Last Name* <input type="text" name="lastname" value="<c:out value="${user.last_name}" />"> </p>
<p> Login* <input type="text" name="login" value="<c:out value="${user.login}" />" > </p>
<p> Email* <input type="text" name="email" value="<c:out value="${user.email}" />"> </p>
<p> MAC* <input type="text" name="MAC" value="<c:out value="${user.mac}" />"> </p>
<p> Birthday* <input type="text" name="birthday" value="<c:out value="${user.birthday}" />" > </p>
<p> Phone* <input type="text" name="phone" value="<c:out value="${user.phone}" />"> </p>
<p> Balans <input type="text" style="background-color:#EDEDED" name="balans" value="<c:out value="${user.balans}" />" readonly> </p>
<p> Address <input type="text" name="address" value="<c:out value="${user.address}" />"> </p>
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
<p> <input class="button" name="submit" type="submit" value="Update"> <input type="button" onclick="history.back();" value="Back"/> </p>
</form>
	</div>
</div>
</body>
</html>