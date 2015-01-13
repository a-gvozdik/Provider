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
<title>Active service list</title>
</head>
<body>
<div class="admininfo">
<c:out value="${admin.first_name}" /> <c:out value="${admin.last_name}" />
<c:out value="${info}"/>
<br> <a href="http://localhost:8080/MainServlet/jsp/admin/mainadmin.jsp">Admin main</a>
<br><a href="<c:url value="${'http://localhost:8080/MainServlet/logout'}"></c:url>">Logout</a>
</div>
<div>
<p align="center"> <a href="http://localhost:8080/MainServlet/activeservice"><b> Active service list </b></a> </p>
 <table>
        <thead>
            <tr>
                <th>Order Id</th>
                <th>Status</th>
                <th>User ID</th>
                <th>User Firstname</th>
                <th>User Lastname</th>
                <th>Service</th>
                <th>Description</th>
                <th>Service ID</th>
                <th>Price</th>
                <th colspan="2">Action</th>
                </tr>
        </thead>
        <tbody>
            <c:forEach items="${laservice}" var="aservice">
                <tr>
                    <td><c:out value="${aservice.ID_order}" /></td>
                    <td><c:out value="${aservice.status}" /></td>
                    <td><c:out value="${aservice.user.id}" /></td>
                    <td><c:out value="${aservice.user.first_name}" /></td>
                    <td><c:out value="${aservice.user.last_name}" /></td>
                    <td><c:out value="${aservice.service.name}" /></td>
                    <td><c:out value="${aservice.service.description}" /></td>
                    <td><c:out value="${aservice.service.ID}" /></td>
                    <td><c:out value="${aservice.service.price}" /></td>
                    <td><a href="http://localhost:8080/MainServlet/changeServiceStatus?ID_order=<c:out value="${aservice.ID_order}"/>&status=<c:out value="${aservice.status}"/>">Change status</a></td>
                    <td><a href="http://localhost:8080/MainServlet/deleteActiveService?ID_order=<c:out value="${aservice.ID_order}"/>">Delete order</a></td>
                    
                                      
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>