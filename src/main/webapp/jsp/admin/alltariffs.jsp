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
<title>All tariffs list</title>
</head>
<body>
<div class="admininfo">
<c:out value="${admin.first_name}" /> <c:out value="${admin.last_name}" />
<c:out value="${info}"/>
<br> <a href="http://localhost:8080/MainServlet/jsp/admin/mainadmin.jsp">Admin main</a>
<br><a href="<c:url value="${'http://localhost:8080/MainServlet/logout'}"></c:url>">Logout</a>
</div>
<div>
<p align="left"> <a href="http://localhost:8080/MainServlet/jsp/admin/addTariff.jsp">Add new tariff</a>
<p align="center"> <a href="http://localhost:8080/MainServlet/alltariffs"><b> All tariffs list </b></a> </p>
 <table>
        <thead>
            <tr>
                <th>Tariff Id</th>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
                <th colspan=2>Action</th>
                </tr>
        </thead>
        <tbody>
            <c:forEach items="${tlist}" var="tar">
                <tr>
                    <td><c:out value="${tar.ID}" /></td>
                    <td><c:out value="${tar.name}" /></td>
                    <td><c:out value="${tar.description}" /></td>
                    <td><c:out value="${tar.price}" /></td>
                    <td><a href="http://localhost:8080/MainServlet/gettariff?id=<c:out value="${tar.ID}"/>">Update tariff</a></td>
                    <td><a href="http://localhost:8080/MainServlet/deleteTariff?id=<c:out value="${tar.ID}"/>">Delete tariff</a></td>
                                      
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>