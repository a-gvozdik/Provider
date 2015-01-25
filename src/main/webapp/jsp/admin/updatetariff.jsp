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

<title>Update tariff</title>

</head>

<body>
<div class="admininfo">
<c:out value="${admin.first_name}" /> <c:out value="${admin.last_name}" />
<c:out value="${info}"/>
<br> <a href="/MainServlet/jsp/admin/mainadmin.jsp">Admin main</a>
<br><a href="<c:url value="${'/logout'}"></c:url>">Logout</a>
</div>
<div class="newuser">
	<div class="newuserinner">
<p align="center"> Update tariff </p>
<form name="newuserform" method="post" action="/MainServlet/updateTariff">
<p> ID* <input style="background-color:#EDEDED" type="text" readonly name="id" value="<c:out value="${tariff.ID}" />"> </p>
<p> Name* <input type="text" name="name" value="<c:out value="${tariff.name}" />"> </p>
<p> Description* <input type="text" name="description" value="<c:out value="${tariff.description}" />"> </p>
<p> Price* <input type="text" name="price" value="<c:out value="${tariff.price}" />"></p>
<p> <input class="button" name="submit" type="submit" value="Update"> <input type="button" onclick="history.back();" value="Back"/> </p>
</form>
	</div>
</div>

</body>
</html>
