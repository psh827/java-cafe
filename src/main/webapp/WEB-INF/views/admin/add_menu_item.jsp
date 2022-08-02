<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴등록</title>
</head>
<body>
<form action="add_menu_item" method="post" enctype="multipart/form-data">
	<label>상품이름</label>
	<input type="text" name="menuItemName"/>
	<label>가격</label>
	<input type="text" name="menuPrice"/>
	<label>종류</label>
	<input type="text" name="ihb"/><br>
	<label>사진</label>
	<input type="file" name="report" /><br/>
	<input type="submit" value="go!!!!"/>
</form>

</body>
</html>