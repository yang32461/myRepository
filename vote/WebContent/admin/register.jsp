<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>注册页面</title>
<link rel="stylesheet" href="../css/reg.css" />
<script type="text/javascript">
   var xmlHttp;
   function flag(){
    var userid=document.getElementById("userId").value;
	var passid=document.getElementById("passId").value;
	var nickname=document.getElementById("nickname").value;
	var repassId=document.getElementById("repassId").value;
	if(userid!=""&&passid!=""&&nickname!=""&&repassId!="")
	{
		if(passid==repassId){
			return true; 
			
		}else{
			
			alert("密码不一致请重新输入");
			return false;
		}
		
	 
	}else{
	  alert("用户名,昵称或密码不能为空！");
	  return false;
	}
 }
 function checkName(obj){
	 var account=obj.value;
	 var patrn = /(^0{0,1}1[3|4|5|6|7|8|9][0-9]{9}$)/;
	 if(account==""||account==null){
		 alert("账号不能为空");
	 }else{
		
		 if(!patrn.exec(account)){
			 alert("该手机号不存在,请重新输入");
	         obj.value="";
		 }else{
			 xmlHttp=new XMLHttpRequest();
			 var url="../checknameservlet?account="+account;
			 xmlHttp.open("POST",url);
			 xmlHttp.onreadystatechange=processResult;
			 xmlHttp.send();
			 function processResult(){
				 if(xmlHttp.readState==4&&xmlHttp.status==200){}
				     var msg=xmlHttp.responseText;
				     document.getElementById("msg").innerHTML=msg;
			 }
		 }
	 }
	 
 }
 function checknickname(obj){
	   var nickname=obj.value;;
	  if(nickname!=""){
		   xmlHttp=new XMLHttpRequest();
			 var url="../checkNicoName?nickname="+nickname;
			 xmlHttp.open("POST",url);
			 xmlHttp.onreadystatechange=processResult;
			 xmlHttp.send();
			 function processResult(){
				 if(xmlHttp.readState==4&&xmlHttp.status==200){}
				     var msg=xmlHttp.responseText;
				     document.getElementById("msgnico").innerHTML=msg;
			 }
	  }
 }


 
 </script>
</head>
<body>
	<div class="main">
		<div class="top">
			<img src="../img/logo.gif" />
		</div>
		<div class="line1"></div>
		<div class="second"></div>
		<div class="third">
			<div class="head">新用户注册</div>
			<form method="post" action="../registerServlet"
				onsubmit="return flag()">
				<table>
					<tr>
						<td>账号：</td>
						<td><input type="text" id="userId" name="account" class="aa"
							onblur="checkName(this)" /></td>
						<td><lable id="msg"></lable></td>
					</tr>
					<tr>
						<td>昵称：</td>
						<td><input type="text" id="nickname" name="nickname"
							class="aa" onblur="checknickname(this)" /></td>
						<td><lable id="msgnico"></lable></td>
					</tr>
					<tr>
						<td>密码：</td>
						<td><input type="password" id="passId" name="password"
							class="aa" onblur="checkpassword()" /></td>
					</tr>
					<tr>
						<td>确认密码：</td>
						<td><input type="password" id="repassId" name="repassword"
							class="aa" /></td>
					</tr>
					<tr>
						<td></td>
						<td align="left"><input type="image"
							src="../img/button_register.gif " /></td>
					</tr>
				</table>
			</form>
		</div>
		<div class="line2"></div>
		<div class="end">青软实训 &copy; 版权所有</div>
	</div>
</body>
</html>
