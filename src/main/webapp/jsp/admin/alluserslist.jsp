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
<title>All users list</title>
</head>
<body>
<div class="admininfo">
<c:out value="${admin.first_name}" /> <c:out value="${admin.last_name}" />
<c:out value="${info}"/>
<br> <a href="http://localhost:8080/MainServlet/jsp/admin/mainadmin.jsp">Admin main</a>
<br><a href="<c:url value="${'http://localhost:8080/MainServlet/logout'}"></c:url>">Logout</a>
</div>
<div>
<p align="left"> <a href="http://localhost:8080/MainServlet/jsp/admin/addUser.jsp">Add new user</a>
<p align="center"> <a href="http://localhost:8080/MainServlet/alluserlist"><b> All users list </b></a> </p>
 <table>
        <thead>
            <tr>
                <th>User Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Login</th>
                <th>Email</th>
                <th>MAC</th>
                <th>Birthday</th>
                <th>Phone</th>
                <th>Balans</th>
                <th>Address</th>
                <th>Status</th>
                <th colspan=3>Action</th>
                </tr>
        </thead>
        <tbody>
            <c:forEach items="${ulist}" var="user">
                <tr>
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.first_name}" /></td>
                    <td><c:out value="${user.last_name}" /></td>
                    <td><c:out value="${user.login}" /></td>
                    <td><c:out value="${user.email}" /></td>
                    <td><c:out value="${user.mac}" /></td>
                    <td><c:out value="${user.birthday}" /></td>
                    <td><c:out value="${user.phone}" /></td>
                    <td><c:out value="${user.balans}" /></td>
                    <td><c:out value="${user.address}" /></td>
                    <td><c:out value="${user.status}" /></td>
                    <td><a href="http://localhost:8080/MainServlet/getuser?id=<c:out value="${user.id}"/>">Update user</a></td>
                    <td><a href="http://localhost:8080/MainServlet/deleteUser?id=<c:out value="${user.id}"/>">Delete user</a></td>
                    <td><a href="http://localhost:8080/MainServlet/getuserpass?id=<c:out value="${user.id}"/>">Pass renew</a></td>
                   
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>