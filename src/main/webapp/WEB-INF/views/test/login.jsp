<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>로그인</h2>
<form action="login" method="post">
	<label>아이디</label>
	<input type="text" name="id"/>
	<label>비밀번호</label>
	<input type="password" name="passwd"/>
	<input type="submit" value="go!">
</form>
</body>
</html>