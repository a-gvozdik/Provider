<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function ValRe()
{
var minlength=5;
var NEWPASS1count=document.updatepass.newpass.value.length;
document.updatepass.newpass.style.background="#FD8FA7";
if (NEWPASS1count<minlength)
{
document.getElementById("sp1").innerHTML="Min 5 chars!";
document.updatepass.newpass.style.background="#FD8FA7";
document.updatepass.submit.disabled=true;
}
else {
document.getElementById("sp1").innerHTML="";
document.updatepass.newpass.style.background="#FFFFFF";
}
}

function MaRe()
{
var minlength=5;
var NEWPASS1count=document.updatepass.newpass.value.length;
var NEWPASS1=document.updatepass.newpass.value;
var NEWPASS2=document.updatepass.newpass2.value;
if(NEWPASS1==NEWPASS2&&NEWPASS1count>minlength)
{
document.getElementById("sp2").innerHTML="";
document.updatepass.newpass2.style.background="#FFFFFF";
document.updatepass.submit.disabled=false;
}
if (NEWPASS1!=NEWPASS2||NEWPASS1count<minlength)
{
document.getElementById("sp2").innerHTML="Passwords do not match";
document.updatepass.newpass2.style.background="#FD8FA7";
document.updatepass.submit.disabled=true;
}
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Update user password</title>
<style>
   <%@include file='style.css' %>
</style>
</head>
<body>
<div class="admininfo">
<c:out value="${admin.first_name}" /> <c:out value="${admin.last_name}" />

<br> <a href="/ProviderServlet/jsp/admin/mainadmin.jsp">Admin main</a>
<br><a href="<c:url value="${'/logout'}"></c:url>">Logout</a>
</div>
<div class="newuser">
	<div class="newuserinner">
<p align="center"> Update user password</p>
<form name="updatepass" method="post" action="/ProviderServlet/updateUserPass">
<p> ID* <input class="simple-input" style="background-color:#EDEDED" type="text" readonly name="id" value="<c:out value="${id}" />"> </p>
<p> New Password* <input class="simple-input" type="password" name="newpass" onBlur="ValRe()"><br><span id="sp1" style="font-size: 10px;">min 5 chars</span> </p>
<p> Confirm* <input class="simple-input" type="password" name="newpass2" onKeyUp="MaRe()"><br><span style="font-size: 10px;" id="sp2" class="passvalid"></span> </p>
<p> <input class="button" name="submit" type="submit" value="Renew" disabled> <input type="button" class="button" onclick="history.back();" value="Back"/> </p>
</form>
	</div>
</div>
</body>
</html>