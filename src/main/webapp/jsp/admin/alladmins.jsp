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
<title>All admins list</title>
</head>
<body>
<div class="admininfo">
<c:out value="${admin.first_name}" /> <c:out value="${admin.last_name}" />

<br> <a href="/ProviderServlet/jsp/admin/mainadmin.jsp">Admin main</a>
<br><a href="<c:url value="${'/logout'}"></c:url>">Logout</a>
</div>
<div>
<p align="left"> <button class="button" onClick="document.location.href='/ProviderServlet/jsp/admin/addAdmin.jsp'">Add new admin</button>
<p align="center"> <a href="/ProviderServlet/alladmins"> All admins list </a> </p>
 <table>
        <thead>
            <tr>
                <th>Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Login</th>
                <th>Email</th>
                <th>Phone</th>
                <th colspan=3>Action</th>
                </tr>
        </thead>
        <tbody>
            <c:forEach items="${alist}" var="tadmin">
                <tr>
                    <td><c:out value="${tadmin.id}" /></td>
                    <td><c:out value="${tadmin.first_name}" /></td>
                    <td><c:out value="${tadmin.last_name}" /></td>
                    <td><c:out value="${tadmin.login}" /></td>
                    <td><c:out value="${tadmin.email}" /></td>
                    <td><c:out value="${tadmin.phone}" /></td>
                    <td><button class="button" onClick="document.location.href='/ProviderServlet/getadmin?id=<c:out value="${tadmin.id}"/>'">Update</button></td>
                    <td><button class="button" onClick="document.location.href='/ProviderServlet/deleteAdmin?id=<c:out value="${tadmin.id}"/>'">Delete</button></td>
                    <td><button class="button" onClick="document.location.href='/ProviderServlet/getadminpass?id=<c:out value="${tadmin.id}"/>'">Change pass</button></td>
                   
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>