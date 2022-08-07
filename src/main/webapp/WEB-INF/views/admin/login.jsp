<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<c:url value='/resources/css/default.css'/>" rel="stylesheet" />
<link href="<c:url value='/resources/css/admin_main.css'/>" rel="stylesheet" />
<link href="<c:url value='/resources/css/admin_login.css'/>" rel="stylesheet" />
</head>
<body>
<nav class="nav">
 	<jsp:include page="../incl/admin_header.jsp"/>
</nav>
<div class="admin_login_container container">
	<form action="login" method="post">
		<label>아이디</label>
		<input type="text" name="adminId" required>
		<label>비밀번호</label>
		<input type="password" name="adminPasswd" required>
		<input type="submit" class="submit" value="로그인">
	</form>
</div>
</body>
</html>