<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카테고리추가</title>
<link href="<c:url value='/resources/css/default.css'/>" rel="stylesheet" />
<link href="<c:url value='/resources/css/admin_main.css'/>" rel="stylesheet" />
<link href="<c:url value='/resources/css/add_category.css'/>" rel="stylesheet" />
</head>
<body>
<nav class="nav">
 	<jsp:include page="../incl/admin_header.jsp"/>
</nav>
<div class="add_category_container">
	<div class="add_category_inner">
		<form:form method="post" modelAttribute="largeCategory">
			<label>카테고리명</label>
			<form:input class="add_category_input" path="largeCategoryName"/>
			<input type="submit" class="submit" value="등록"/>
		</form:form>
	</div>
</div>
<div class="category_list">
	<table>
		<th>no</th>
		<th>카테고리명</th>
		<c:forEach var="cate" items="${largeCategoryList}">
			<tr>
				<td>${cate.cid}</td>
				<td>${cate.categoryName}
			</tr>
		</c:forEach>

	</table>
</div>
</body>
</html>