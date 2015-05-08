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
<title>Authorization</title>
</head>

<body background="img/back.png">
<div class="divmain" >
	<div class="divinner">
    <h4> Enter login and password</h4>
<form method="post" action="/ProviderServlet/login">
<p>Login <input align="right" class="simple-input" type="text" name="login"> </p>
<p>Password <input class="simple-input" type="password" name="password"> </p>
<p align="center"> <input class="button"  type="submit" value="Login"> <input class="button"  type="reset" value="Reset"></form> </p>
  <span style="font-size: 15px; color:#FF0004; text-align:left" class="status"><c:out value="${auth}" /></span>
	</div>
</div>
</body>
</html>
