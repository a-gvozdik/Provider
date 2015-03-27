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
<title>Admin</title>
</head>
<body>
<div class="admininfo">
<c:out value="${admin.first_name}" /> <c:out value="${admin.last_name}" />

<br> <a href="/ProviderServlet/jsp/admin/mainadmin.jsp">Admin main</a>
<br><a href="<c:url value="${'/logout'}"></c:url>">Logout</a>
</div>
<div class="userslinks">
<p>Users</p>
<p align="center"> <a href="/ProviderServlet/alluserlist">All users list</a> 
<br> <a href="/ProviderServlet/jsp/admin/addUser.jsp">Add new user</a></p>
</div>
<p></p>
<div class="adminslinks">
<p>Admins</p>
<p align="center"> <a href="/ProviderServlet/alladmins">All admins</a>
<br> <a href="/ProviderServlet/jsp/admin/addAdmin.jsp">Add admin</a></p>
</div>
<p></p>
<div class="adminslinks">
<p>Tariffs</p>
<p align="center"> <a href="/ProviderServlet/alltariffs">All tariffs</a>
<br> <a href="/ProviderServlet/jsp/admin/addTariff.jsp">Add tariff</a></p>
</div>
<p></p>
<div class="adminslinks">
<p>Service</p>
<p align="center"> <a href="/ProviderServlet/allservice">All service</a>
<br> <a href="/ProviderServlet/jsp/admin/addService.jsp">Add service</a>
<br> <a href="/ProviderServlet/activeservice">Active service list</a></p>
</div>
</body>
</html>