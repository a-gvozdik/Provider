<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style>
   <%@include file='/jsp/admin/style.css' %>
</style>
<title>User</title>
</head>
<body>
<div class="userinfo">
<c:out value="${user.first_name}" /> <c:out value="${user.last_name}" />

<br> 
<a href="/ProviderServlet/jsp/user/mainuser.jsp">User main</a>
<br><a href="<c:url value="${'/logout'}"></c:url>">Logout</a>
</div>
<p align="center">Current tariff: <c:out value="${user.tariff.name}" />. Price: <c:out value="${user.tariff.price}" /> </p>
<div class="usertable">
<p>Tariffs</p>
<p align="center"> <a href="/ProviderServlet/alltar">All tariffs</a> </p>
</div>
<div class="usertable">
<p>Services</p>
<p align="center"> <a href="/ProviderServlet/allserv">All services</a>
<br><a href="/ProviderServlet/userorders?userid=<c:out value="${user.id}" />">My orders</a> </p>
</div>
</body>
</html>