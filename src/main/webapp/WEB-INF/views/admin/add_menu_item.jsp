<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴등록</title>
<link href="<c:url value='/resources/css/default.css'/>" rel="stylesheet" />
<link href="<c:url value='/resources/css/admin_main.css'/>" rel="stylesheet" />
<link href="<c:url value='/resources/css/add_menu.css'/>" rel="stylesheet" />
</head>
<body>
<nav class="nav">
 	<jsp:include page="../incl/admin_header.jsp"/>
</nav>
<div class="add_menu_container">
	<div class="add_menu_inner">
		<form:form modelAttribute="menuItemCommand" method="post" enctype="multipart/form-data">
			<label>상품이름</label>
			<form:input class="add_menu_input name" path="menuItemName"/><br>
			<label>가격</label>
			<form:input class="add_menu_input price" path="menuPrice"/><br>
			<label>종류</label>
			<select name="ihb" class="add_menu_select ihb">
				<option value="">선택하세요</option>
				<option>Ice</option>
				<option>Hot</option>
				<option>Bakery</option>
			</select><br>
			<label>카테고리</label>
			<form:select path="categoryId" class="add_menu_select categoryId">
				<form:options
					items="${categoryProvider}"
					itemLabel="categoryName"
					itemValue="cid"/>
			</form:select><br>
			<label>설명</label>
			<form:textarea class="add_menu_textarea description" path="description"/>
			<label>사진</label>
			<form:input path="files" class="add_menu_file file" type="file"/><br/>
			<input type="submit" class="add_menu_btn submit" value="go!!!!"/>
		</form:form>
	</div>
</div>

</body>
</html>