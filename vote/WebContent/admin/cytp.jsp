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
			<script type="text/javascript" src="js/jquery-1.x.js" ></script>
		<script>
			function checkNull(){
				var count=0;
				var type=${requestScope.article.desc};
				if(type=="0"){
					
					var radio=document.getElementsByName("radio");
					for(i=0;i<radio.length;i++){
						if(radio[i].checked==true){
							count++;
						}
					}
					if(count==0){
						alert("用户没有投票");
						return false;
					}else{
						return true;
					}
					
				}else{
					var checkbox=document.getElementsByName("checkbox");
					for(i=0;i<checkbox.length;i++){
						if(checkbox[i].checked==true){
							count++;
						}
					}
					if(count==0){
						alert("用户没有投票");
						return false;
					}else{
						return true;
					}
				}
				
			}
			
		</script>
	</head>
	<body>
		<form action="voteServlet" method="post" onsubmit="return checkNull();">
			<table class="table3">
				<tr>
					<td class="d1" colspan="2"><img src="img/title_ico.gif" style="vertical-align:middle" />&nbsp;&nbsp;参与投票</td>
				</tr>
				<tr>
					<td colspan="2">
						<div class="line3"></div>
						<p class="p11"><img src="img/vote_icon.gif" /> ${requestScope.article.title}</p>
						<span class="p2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;共有${requestScope.article.numofOption}  个选项，已有${requestScope.article.voteNum} 个网友参与了投票。</span>							
					</td>	
				</tr>
				<input type="hidden" name="id" value=${sessionScope.user.id}>
				<input type="hidden" name="articleId" value= ${requestScope.article.id}>
				<c:forEach items="${requestScope.optionList}" var="o" varStatus="status">
				
				<tr>
				
					<td width="40px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${status.count}.</td>
					<c:choose>
				  <c:when test="${requestScope.article.desc eq 0}">
				   
				    <td><input type="radio" name="radio" value="${o.id}"/><label>${o.optionvalue}</label></td>
				  </c:when>
				  <c:otherwise>
				  <td><input type="checkbox" name="checkbox" value="${o.id}"/><label>${o.optionvalue}</label></td>
				  </c:otherwise>
				</c:choose>
				   
				</tr>
				</c:forEach>
				<tr>
				</tr>
				
				<tr>
					<td></td>
					<td>
						<input type="image" src="img/button_vote.gif" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="lookArticleServlet?id=${requestScope.article.id}"><img src="img/button_view.gif"></a>
					</td>
				</tr>
		
			</table>
		</form>
	</body>
</html>
