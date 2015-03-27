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
<title>All service list</title>
</head>
<body>
<div class="admininfo">
<c:out value="${admin.first_name}" /> <c:out value="${admin.last_name}" />

<br> <a href="/ProviderServlet/jsp/admin/mainadmin.jsp">Admin main</a>
<br><a href="<c:url value="${'/logout'}"></c:url>">Logout</a>
</div>
<div>
<p align="left"><button class="button" onClick="document.location.href='/ProviderServlet/jsp/admin/addService.jsp'">Add new service</button>
<p align="center"> <a href="/ProviderServlet/allservice"> All service list </a> </p>
 <table>
        <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
                <th colspan=2>Action</th>
                </tr>
        </thead>
        <tbody>
            <c:forEach items="${slist}" var="serv">
                <tr>
                    <td><c:out value="${serv.ID}" /></td>
                    <td><c:out value="${serv.name}" /></td>
                    <td><c:out value="${serv.description}" /></td>
                    <td><c:out value="${serv.price}" /></td>
                    <td><button class="button" onClick="document.location.href='/ProviderServlet/getservice?id=<c:out value="${serv.ID}"/>'">Update</button></td>
                    <td><button class="button" onClick="document.location.href='/ProviderServlet/deleteService?id=<c:out value="${serv.ID}"/>'">Delete</button></td>
                                      
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>