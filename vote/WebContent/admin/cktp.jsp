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
		<form action="" method="get">
			<table class="table5">
				<tr>
					<td class="d1" colspan="4"><img src="img/title_ico.gif" style="vertical-align:middle" />&nbsp;&nbsp;查看投票</td>
				</tr>
				<tr>
					<td colspan="4">
						<div class="line3"></div>
						<p class="p11"><img src="img/vote_icon.gif" /> ${requestScope.article.title}</p>
						<span class="p2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;共有${requestScope.article.numofOption}个选项，已有${requestScope.article.voteNum}个网友参与了投票。</span>							
					</td>	
				</tr>
			</table>
				
				<table class="table4">
					<c:forEach items="${requestScope.optionList}" var="o" varStatus="status">
					
				<tr>
					<td width="40px">${status.count}.</td>
					<td width="50px"><label>${o.optionvalue}</label></td>
					<td width="610px">
						<div class="b1">
							<div class="b11" style="width:${o.percent*600}px"></div>
						</div>
					</td>
					<td width="30px">${o.num}票</td>
					<td width="165px">(${o.per})</td>
				
				</tr>
				</c:forEach>
				<tr></tr>
				
				<tr >
					<td colspan="4" style="margin-top: 120px;">
						<img src="img/goback.gif" style="vertical-align:middle"> &nbsp;&nbsp;<a href="articleServlet?goPage=1" target="mainframe">返回投票列表</a>
					</td>
				</tr>
			</table>
		</form>
		
		
		
	</body>
</html>
