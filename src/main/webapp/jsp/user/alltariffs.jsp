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
<title>All tariffs list</title>
</head>
<body>
<div class="userinfo">
<c:out value="${user.first_name}" /> <c:out value="${user.last_name}" />

<br> 
<a href="/ProviderServlet/jsp/user/mainuser.jsp">User main</a>
<br><a href="<c:url value="${'/logout'}"></c:url>">Logout</a>
</div>
<div>
<p align="center"> <a href="/ProviderServlet/alltar"> All tariffs list </a> </p>
<form name="newuserform" method="post" action="/ProviderServlet/changeUserTar">
 <table>
        <thead>
            <tr>
                <th>Tariff Id</th>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
                <th>Select</th>
                </tr>
        </thead>
        <tbody>
            <c:forEach items="${tlist}" var="tar">
                <tr>
                    <td><c:out value="${tar.ID}" /></td>
                    <td><c:out value="${tar.name}" /></td>
                    <td><c:out value="${tar.description}" /></td>
                    <td><c:out value="${tar.price}" /></td>
                    <td><input type="radio" name="tarchange" value="<c:out value="${tar.ID}"/>" ${user.tariff.ID == tar.ID ?'checked':''}> <c:out value="${tar.name}" /></td>
                                                     
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p align="center"> <input class="button" name="submit" type="submit" value="Change"> <input type="button" class="button" onclick="history.back();" value="Back"/> </p>
    <input type="hidden" name="userid" value="<c:out value="${user.id}" />">
</form>
</div>
</body>
</html>