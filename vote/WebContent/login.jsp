<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="css/login.css" />	
		<script type="text/javascript" src="js/jquery-1.x.js" ></script>
		<script>
			function check(){
				 var userid=document.getElementById("username").value;
				 var passid=document.getElementById("password").value;
				 if(userid!=""&&passid!="")
					{
					  return true;
					}else{
					  alert("用户名或密码不能为空！");
					  return false;
					}
			}
			
		</script>
	</head>
	<body>
		<div class="main">
			<div class="top">
				<img src="img/logo.gif" />
			</div>
			<div class="mid">
				<div class="mid01">
					<img src="img/voteBanner.jpg"/>
				</div>
				<div class="mid02">
					<p class="p1">青软实训</p>
					<p class="p2">网上投票系统...</p>
				</div>
				<div class="mid03">
					<div class="head">
						用户登录 &nbsp;  <img src="img/arrow_down.gif" />
					</div>
					<div class="line1"></div>
					<form  method="post" action="loginServlet" onsubmit="return check();">
						<table>
							<tr>
								<td>用户名：</td>
								<td><input type="text" name="username" id="username"/></td>
							</tr>
							<tr>
								<td>密码：</td>
								<td><input type="password" name="passwrod" id="password" /></td>
							</tr>
							<tr>
								<td></td>
								<td>
									
									<input type="submit" value="   登录" style="width:77px; height:32px;border:0;background:url(img/button_login.gif);"  />
									
									<a href="admin/register.jsp">新用户注册</a>
								</td>
							</tr>
						</table>
					</form>
				</div>
				
			</div>
			<div class="line2"></div>
			<div class="end">
				青软实训 &copy; 版权所有
			</div>
		</div>
	</body>
</html>