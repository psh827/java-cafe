<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form method="post" modelAttribute="testCommand">
	<label>이름</label>
	<form:input path="name"/><br>
	<label>전화번호</label>
	<form:input path="phone"/><br>

	<input type="submit" value="등록"/>
</form:form>

</body>
</html>