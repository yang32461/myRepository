<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<base href="${pageContext.request.contextPath}/" > 
		<link rel="stylesheet" href="css/index.css" />
	</head>
	<body>
		<div class="main">
		<form action="" method="post">
			<table class="table2">
				<tr>
					<td class="d1" colspan="2"><img src="img/title_ico.gif" style="vertical-align:middle" />&nbsp;&nbsp;投票列表</td>
				</tr>
				<c:forEach items="${requestScope.article}" var="a">	
				<tr>
					<td width="810px">
						<span class="p1"><img src="img/vote_icon.gif" /> 
						<a href="lookArticleServlet?id=${a.id}" id="h1" target="mainframe">${a.title}</a></span><br>
						<span class="p2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;共有${a.numofOption}个选项，已有 ${a.voteNum} 个网友参与了投票。</span>								
					</td>	
					<td width="90px">
					<c:if test="${empty mantain }">
						<img src="img/join.gif" /> <a href="articleSearchServlet?id=${a.id}" class="p3" target="mainframe">我要参与</a>
						</c:if>
						<c:if test="${not empty mantain }">
						<a href="MaintainServlet?id=${a.id}" class="p3" target="mainframe">维护</a>
						</c:if>
					</td>
				</tr>
				 </c:forEach>
				 <tr><td align="center" colspan="3">
     <a href="articleServlet?flag=a&goPage=1&mantain=${mantain}">首页</a>
     <c:if test="${goPage!=1 }"><a href="articleServlet?flag=a&goPage=${goPage-1}&mantain=${mantain}">上一页</a></c:if>
     <c:if test="${goPage!=page}"><a href="articleServlet?flag=a&goPage=${goPage+1}&mantain=${mantain}">下一页</a></c:if>
     <a href="articleServlet?flag=a&goPage=${page}&mantain=${mantain}">尾页</a>
     </td>
  </tr>
			</table>
		</form>
		</div>
	</body>
</html>
