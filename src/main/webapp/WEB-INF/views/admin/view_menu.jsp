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
		<form action="changeDetail" method="post">
			<div>
				<img src="<c:url value='/resources/menuImg/${list.image.imgName}'/>">
				<p>제품명 : <span>${list.menuItemName}</span></p>
				<p>가격 : <span>${list.menuPrice}</span></p><label>수정</label><input type="text" name="menuPrice"/>
				<p>제품종류 : <span>${list.ihb}</span></p>
				<p>카테고리 : <span>${list.largeCategory.largeCategoryName}</span></p>
				<p>품절여부 : <span>${list.outOfStock}</span>
				<div class="radio-group">
					<label>N</label>
					<input type="radio" name="outOfStock" value="N">
					<label>Y</label>
					<input type="radio" name="outOfStock" value="Y">
				</div>
				<p>등록날짜 : <span>${list.regDate}</span></p>
				<label>비밀번호입력</label>
				<input type="password" name="passwd"/>
				<button type="submit">변경</button>
			</div>	
		</form>
	</c:forEach>
	</div>

</body>
</html>