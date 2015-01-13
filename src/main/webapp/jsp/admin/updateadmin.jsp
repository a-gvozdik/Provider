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
<p align="center"> Update admin <c:out value="${uadmin.first_name}" /> <c:out value="${uadmin.last_name}"/> </p>
<form name="update" method="post" action="http://localhost:8080/MainServlet/updateAdmin">
<p> ID* <input style="background-color:#EDEDED" type="text" readonly name="id" value="<c:out value="${uadmin.id}" />"> </p>
<p> First Name* <input type="text" name="firstname" value="<c:out value="${uadmin.first_name}" />"> </p>
<p> Last Name* <input type="text" name="lastname" value="<c:out value="${uadmin.last_name}" />"> </p>
<p> Login* <input type="text" name="login" value="<c:out value="${uadmin.login}" />" > </p>
<p> Email* <input type="text" name="email" value="<c:out value="${uadmin.email}" />"> </p>
<p> Phone* <input type="text" name="phone" value="<c:out value="${uadmin.phone}" />"> </p>
<p> <input class="button" name="submit" type="submit" value="Update"> <input type="button" onclick="history.back();" value="Back"/> </p>
</form>
	</div>
</div>
</body>
</html>