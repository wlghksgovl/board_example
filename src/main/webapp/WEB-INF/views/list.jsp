<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Board</title>
</head>
<body>
	<table border="1" style="width:100%;">
		<tr>
			<th colspan="2">게시판</th>
		</tr>
		<tr>
			<td style="width:100px;"><b>번호</b></td>
			<td><b>제목</b></td>
		</tr>
		<tr>
		<c:choose>
			<c:when test="${ empty list }">
				<td colspan="2">게시물이 없습니다.</td>
			</c:when >
			<c:otherwise>
				<c:forEach items="${ list }" var="title">
					
					<tr onclick="getBoard('${ title.u_num }')">
						<td>${ title.u_num }</td>
						<td>${ title.u_name }</td>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		<tr>
			<td colspan="2">
				<div class="paginate">
	  		      <c:forEach var="i" begin="${paging.startPageNo}" end="${paging.endPageNo}" step="1">
		               <a href="list?pageNum=${i}">${i}</a>
		        </c:forEach>
				</div>
				</td>
		</tr>
		<tr>
			<td colspan="2"><a href="addContent">게시물 추가</a></td>
		</tr>
	</table>
	<script>
		function getBoard(){
			location.href="showContent?u_num="+arguments[0];
		}
	</script>
</body>
</html>