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
<c:out value="${info}"/>
<br> <a href="/MainServlet/jsp/admin/mainadmin.jsp">Admin main</a>
<br><a href="<c:url value="${'/logout'}"></c:url>">Logout</a>
</div>
<div>
<p align="left"> <a href="/MainServlet/jsp/admin/addService.jsp">Add new service</a>
<p align="center"> <a href="/MainServlet/allservice"><b> All service list </b></a> </p>
 <table>
        <thead>
            <tr>
                <th>Service Id</th>
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
                    <td><a href="/MainServlet/getservice?id=<c:out value="${serv.ID}"/>">Update service</a></td>
                    <td><a href="/MainServlet/deleteService?id=<c:out value="${serv.ID}"/>">Delete service</a></td>
                                      
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>