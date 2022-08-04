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
<form:form modelAttribute="menuItemCommand" method="post" enctype="multipart/form-data">
	<label>상품이름</label>
	<form:input path="menuItemName"/><br>
	<label>가격</label>
	<form:input path="menuPrice"/><br>
	<label>종류</label>
	<select name="ihb">
		<option value="">선택하세요</option>
		<option>Ice</option>
		<option>Hot</option>
		<option>Bakery</option>
	</select><br>
	<label>카테고리</label>
	<form:select path="categoryId">
		<form:options
			items="${categoryProvider}"
			itemLabel="categoryName"
			itemValue="cid"/>
	</form:select><br>
	<label>설명</label>
	<form:textarea path="description"/>
	<label>사진</label>
	<form:input path="files" type="file"/><br/>
	<input type="submit" value="go!!!!"/>
</form:form>

</body>
</html>