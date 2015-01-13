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
<title>User orders</title>
</head>
<body>
<div class="userinfo">
<c:out value="${user.first_name}" /> <c:out value="${user.last_name}" />
<c:out value="${info}"/>
<br> 
<a href="http://localhost:8080/MainServlet/jsp/user/mainuser.jsp">User main</a>
<br><a href="<c:url value="${'http://localhost:8080/MainServlet/logout'}"></c:url>">Logout</a>
</div>
<div>
<p align="center"> <b> My orders </b> </p>
 <table id="tab">
        <thead>
            <tr>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
                <th>Status</th>
                
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${uslist}" var="userv">
                <tr>
                    <td><c:out value="${userv.name}" /></td>
                    <td><c:out value="${userv.description}" /></td>
                    <td><c:out value="${userv.price}" /></td>
                    <td class="sprice"><c:out value="${userv.orderstatus}" /></td>
                 </tr>
            </c:forEach>
           </tbody>
    </table>
 </div>
</body>
</html>