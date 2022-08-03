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
				<input type="checkbox" id="${category.lcId}" class="category_name" value="${category.lcId}">
				<label for="${category.lcId}">${category.largeCategoryName}</label>
			</div>
		</c:forEach>
	</div>
	<ul class="menuItem_ul">
		
	</ul>
	<%-- <c:forEach var="menuItem" items="${menuList}">
		<div class="menu_box">
			<img style="width:500px; height:500px;" alt="menu" src='<c:url value="/resources/menuImg/${menuItem.image.imgName}"/>'>
			<p>${menuItem.menuItemName}</p>
			<p>${menuItem.menuPrice}</p>
			<p>${menuItem.ihb}</p>
		</div>
	</c:forEach>
	<c:choose>
	
	</c:choose> --%>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/view_main.js'/>"></script>
	<script>
		$('.category_name').on('click', function(){
			var categoryId = $(this).val();
			console.log(categoryId)
	        $.ajax({
	            url: "requestObject",
	            type: "POST",
	            contentType: "application/json; charset=utf-8",
	            dataType: "text",
	            data: JSON.stringify({
				'categoryId': categoryId
				}),
	            success: function(data){
					var html = "<li><a href='#'>"
					$.each(JSON.parse(data), function(index, el){
						console.log(el.image.imgName)
						html += "<img src=/java-cafe/resources/menuImg/" + el.image.imgName + ">"
						html += "<p>" + el.menuItemName + "</p></a><li>"
					})
					
					$(".menuItem_ul").append(html)
	            },
	            error: function(){
	                alert("simpleWithObject err");
	            }
	        });
		});
	</script>
</body>
</html>