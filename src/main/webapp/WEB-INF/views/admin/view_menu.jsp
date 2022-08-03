<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품관리</title>
</head>
<body>
	<div class="view_container">
	<c:forEach var="list" items="${menuList}">
			<div>
				<img src="<c:url value='/resources/menuImg/${list.image.imgName}'/>">
				<p>제품명 : <span>${list.menuItemName}</span></p>
				<p>가격 : <span>${list.menuPrice}</span></p>
				<p>제품종류 : <span>${list.ihb}</span></p>
				<p>카테고리 : <span>${list.largeCategory.largeCategoryName}</span></p>
				<p>품절여부 : <span>${list.outOfStock}</span>
				<p>등록날짜 : <span>${list.regDate}</span></p>
			</div>	
	</c:forEach>
	</div>

</body>
</html>