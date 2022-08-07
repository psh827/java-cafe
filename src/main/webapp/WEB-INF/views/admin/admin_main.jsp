<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<c:url value='/resources/css/default.css'/>" rel="stylesheet" />
<link href="<c:url value='/resources/css/admin_main.css'/>" rel="stylesheet" />
</head>
<body>
<nav class="nav">
 	<jsp:include page="../incl/admin_header.jsp"/>
</nav>
<div class="container">
	<div class="btnGrp">
		<button type="button" onclick="location.href='view_menu'">현재메뉴보기</button>
		<button type="button" onclick="location.href='add_category'">카테고리추가</button>
		<button type="button" onclick="location.href='add_menu_item'">메뉴추가</button>
	</div>
</div>
</body>
</html>