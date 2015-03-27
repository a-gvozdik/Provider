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
<title>All service list</title>
</head>
<body>
<div class="userinfo">
<c:out value="${user.first_name}" /> <c:out value="${user.last_name}" />

<br> 
<a href="/ProviderServlet/jsp/user/mainuser.jsp">User main</a>
<br><a href="<c:url value="${'/logout'}"></c:url>">Logout</a>
</div>
<div>
<p align="center"> <a href="/ProviderServlet/allserv"> All service list </a> </p>
<form name="servorder" method="post" action="/ProviderServlet/orderUserServ">
 <table id="tab">
        <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
                
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${slist}" var="serv">
                <tr>
                    <td><c:out value="${serv.ID}" /></td>
                    <td><input type="checkbox" name="orderservice" value="${serv.ID}"><c:out value="${serv.name}" /></td>
                    <td><c:out value="${serv.description}" /></td>
                    <td class="sprice"><c:out value="${serv.price}" /></td>
                 </tr>
            </c:forEach>
          </tbody>
    </table>
     <p align="center"> <input class="button" name="submit" type="submit" value="Order"> <input class="button" type="button" onclick="history.back();" value="Back"/> </p>
    <input type="hidden" name="userid" value="<c:out value="${user.id}" />">
</form>
</div>
</body>
</html>