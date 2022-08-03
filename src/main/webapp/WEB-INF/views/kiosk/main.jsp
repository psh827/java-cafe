<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<c:url value='/resources/css/default.css'/>" rel="stylesheet" />
<link href="<c:url value='/resources/css/kiosk/main.css'/>" rel="stylesheet" />
</head>
<body>
	<div class="category_container">
		<c:forEach var="category" items="${categoryList}">
			<div class="category_name_box">
				<button type="button" class="category_name">${category.largeCategoryName}</button>
				<span hidden vlaue="${category.lcId}"></span>
			</div>
		</c:forEach>
	</div>
	<c:choose>
	
	</c:choose>
</body>
</html>