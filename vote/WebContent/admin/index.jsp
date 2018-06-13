<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>

<html>
<script type="text/javascript">
function setMaintain(){
    document.getElementById("isMaintain").value=1;
}
function removeMaintain(){
	   document.getElementById("isMaintain").value=0;	
}
</script>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<base href="${pageContext.request.contextPath}/" > 
		<link rel="stylesheet" href="css/index.css" />
		<script type="text/javascript" src="js/changeH.js" ></script>
	</head>
	<body>
		<div class="main">
			<div class="top">
				<img src="img/logo.gif"  />
				<a href="LogoutServlet" style="float:right;margin-top:15px;">退出登录</a>
			</div>
			<div class="line1"></div>
			<div class="second">
			<form action="searchServlet" method="post" target="mainframe">
				<table class="table1">
					<tr>
						<td width="220px">您好， ${user.nickname }</td>
						<td width="260px"><img src="img/new.gif" /> <a href="articleServlet?goPage=1" target="mainframe" onclick="removeMaintain()" >返回列表</a></td>
						<td width="280px"><img src="img/addnew.gif" /> <a href="admin/addNewtp.jsp" target="mainframe" >添加新投票</a></td>
						<td width="280px"><img src="img/edit.gif" /> <a href="articleServlet?mantain=true&goPage=1" target="mainframe" onclick="setMaintain()">维护</a></td>
						<td width="150px"><input type="text" name="search" style="margin-bottom: 4px;"/><input type="hidden" value="0" id="isMaintain" name="isMaintain"></td>
						<td width="50px"><input type="image" src="img/button_search.gif" /></td>						
					</tr>
				</table>
				</form>
			</div>
			
			<div class="mid">
				
				<iframe src="articleServlet" width="900" id="win" name="mainframe" onload="Javascript:SetWinHeight(this)" frameborder="0" scrolling="no" /></iframe>
			</div>
			<div class="line2"></div>
			<div class="end">
				青软实训 &copy; 版权所有
			</div>
			
		</div>	
	</body>
</html>
