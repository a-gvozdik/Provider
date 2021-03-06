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

<br> 
<a href="/ProviderServlet/jsp/user/mainuser.jsp">User main</a>
<br><a href="<c:url value="${'/logout'}"></c:url>">Logout</a>
</div>
<div>
<p align="center"> <a href="/ProviderServlet/userorders?userid=<c:out value="${user.id}" />">My orders</a> </p>
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
                    <td><c:out value="${userv.service.name}" /></td>
                    <td><c:out value="${userv.service.description}" /></td>
                    <td><c:out value="${userv.service.price}" /></td>
                    <td class="sprice"><c:out value="${userv.status}" /></td>
                 </tr>
            </c:forEach>
           </tbody>
    </table>
    
 </div>
</body>
</html>