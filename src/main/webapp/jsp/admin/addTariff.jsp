<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style>
   <%@include file='style.css' %>
</style>

<title>Add new tariff</title>

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
<p align="center"> Add new tariff </p>
<form name="newuserform" method="post" action="http://localhost:8080/MainServlet/addTariff">
<p> Name* <input type="text" name="name"> </p>
<p> Description* <input type="text" name="description"> </p>
<p> Price* <input type="text" name="price"></p>
<p> <input class="button" name="submit" type="submit" value="Add tariff"> <input class="button" type="reset" value="Reset"> </p>
</form>
	</div>
</div>

</body>
</html>
