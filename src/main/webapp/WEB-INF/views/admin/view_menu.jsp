<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품관리</title>
<link href="<c:url value='/resources/css/default.css'/>" rel="stylesheet" />
<link href="<c:url value='/resources/css/admin_main.css'/>" rel="stylesheet" />
<link href="<c:url value='/resources/css/view_menu.css'/>" rel="stylesheet" />
</head>
<body>
	<nav class="nav">
 		<jsp:include page="../incl/admin_header.jsp"/>
	</nav>
	<c:choose>
		<c:when test="${fn:length(menuList) == 0}">
		<div class="view_container container">
			<h2>메뉴가 없습니다.</h2>
		</div>
		</c:when>
		<c:otherwise>
	<div class="view_container container">
		<table>
		<tr>
			<th>사진</th>
			<th>제품명</th>
			<th>가격</th>
			<th>제품종류</th>
			<th>카테고리</th>
			<th>품절여부</th>
			<th>등록날짜</th>
			<th>삭제</th>
		</tr>
			<c:forEach var="list" items="${menuList}">
					<tr class="table_content">
						<td><img src="<c:url value='/resources/menuImg/${list.image.imgName}'/>"></td>
						<td>${list.menuItemName}</td>
						<td>${list.menuPrice}</td>
						<td>${list.ihb}</td>
						<td>${list.largeCategory.largeCategoryName}</td>
						<td>${list.outOfStock}
						<td>${list.regDate}</td>
						<td><form action="delete_menu" method="post"><input hidden name="menuid" value="${list.menuid}"><button type="submit" class="deleteBtn">X</button></form></td>
					</tr>	
			</c:forEach>
		</table>
	</div>
		</c:otherwise>
	</c:choose>
	

</body>
</html>