function passValid()
{
var minlength=5;
var PASS1count=document.newuserform.password.value.length;
if (PASS1count<minlength)
{
document.getElementById("span1").innerHTML="Min 5 chars!";
document.newuserform.password.style.background="#FD8FA7";
document.newuserform.submit.disabled=true;
}
else {
document.getElementById("span1").innerHTML="";
document.newuserform.password.style.background="#FFFFFF";
}
}

function passMatch()
{
var minlength=5;
var PASS1count=document.newuserform.password.value.length;
var PASS1=document.newuserform.password.value;
var PASS2=document.newuserform.password2.value;
if(PASS1==PASS2&&PASS1count>minlength)
{
document.getElementById("span2").innerHTML="";
document.newuserform.password2.style.background="#FFFFFF";
document.newuserform.submit.disabled=false;
}
if (PASS1!=PASS2||PASS1count<minlength)
{
document.getElementById("span2").innerHTML="Passwords do not match";
document.newuserform.password2.style.background="#FD8FA7";
document.newuserform.submit.disabled=true;
}
}
function validateEmail() {
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    var x = document.newuserform.email.value;
    if (x.match(mailformat)) {
		document.newuserform.email.style.background="#FFFFFF";
		document.getElementById("span3").innerHTML="";
		document.newuserform.submit.disabled=false;
        
    } else {
		document.newuserform.email.style.background="#FD8FA7";
		document.getElementById("span3").innerHTML="Wrong email format";
		document.newuserform.submit.disabled=true;
		}
}
function isValidDate(){
	var str = document.newuserform.birthday.value

if(str=="" || str==null){
	document.newuserform.birthday.style.background="#FD8FA7";
	document.newuserform.submit.disabled=true;
	}
if (str.match(/(\d{4})-(\d{2})-(\d{2}$)/)) {
	document.newuserform.birthday.style.background="#FFFFFF";
	document.newuserform.submit.disabled=false;
	} else {
		document.newuserform.birthday.style.background="#FD8FA7";
	document.newuserform.submit.disabled=true;
		}
}