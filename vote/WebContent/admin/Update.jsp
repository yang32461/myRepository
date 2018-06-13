<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title></title>
	<base href="${pageContext.request.contextPath}/" > 
<link rel="stylesheet" href="css/reg.css" />
<script type="text/javascript" src="js/changeH.js" ></script>
<script type="text/javascript" src="js/jquery-1.x.js" ></script>
<script type="text/javascript">

/* function IFrameResize(){
	//alert(this.document.body.scrollHeight); //弹出当前页面的高度
	var obj = parent.document.getElementById("win"); //取得父页面IFrame对象
	//alert(obj.height); //弹出父页面中IFrame中设置的高度
	obj.height = this.document.body.scrollHeight+40; //调整父页面中IFrame的高度为此页面的高度
}  */
var i=3;
function add(){
	  var newatr="<tr id='"+i+"'><td></td><td><input type='text' name='choose' class='bb'/></td><td><a onclick='del(this)'>删除</a></td></tr>";
	  $("#"+(i-1)).after(newatr);
	  i++;
}

  function del(k) {
	  $(k).parent().parent().remove();
	  i--;
	
}
  
</script>

	</head>
	<body>
		<div style="width:800px;height:auto;border:2px solid #79A3CF;
margin: 30px auto;" >
		
				<div class="head">投票维护</div>
				<form action="" method="post">
					<table>
					<input type="hidden" name="id" value=${sessionScope.user.id}>
						<tr>
							<td>投票内容：</td>
							<td><input type="text" name="title" class="bb" value="${article.title}"/></td>
						    <td></td>
						</tr>
						<tr>
							<td>投票类型：</td>
							<td><input type="text" width="80px" name="desc" class="bb" value="${article.desc}"/></td>
							<td>0：单选 1：多选</td>
						</tr>
						<tr>
							<td>投票选项：</td>
								<c:forEach items="${requestScope.optionList}" var="o" varStatus="status">
				
				        <tr>
				
					  <td width="40px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${status.count}.</td>
					   <td><input type="text" name="choose" class="bb" value="${o.optionvalue}"/></td>
					</tr>
					</c:forEach>
							
							<td><input type="text" name="choose" class="bb"/></td>
						</tr>
						<tr id="2">
							<td></td>
							<td><input  type="text" name="choose" class="bb"/></td>
						</tr>
						<tr>
							<td></td>
							<td align="left">
								<input type="image" src="img/button_submit.gif" style="vertical-align:middle" onclick="checkbox()"/>
								&nbsp;&nbsp;&nbsp;
								<a href="Javascript:add()" onclick="Javascript:IFrameResize()">添加选项</a>&nbsp;&nbsp;&nbsp;&nbsp;
								
								<a href="articleServlet?goPage=1">取消操作</a>
							</td>
						</tr>
					</table>
				</form>
		
			</div>
			<div class="bottom"></div>
	</body>
</html>