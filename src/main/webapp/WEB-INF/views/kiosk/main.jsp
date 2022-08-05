<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="<c:url value='/resources/css/default.css'/>" rel="stylesheet" />
<link href="<c:url value='/resources/css/kiosk/main.css'/>" rel="stylesheet" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="category_container">
		<c:forEach var="category" items="${categoryList}">
			<div class="category_name_box">
				<button type="button" id="${category.lcId}" class="category_name" value="${category.lcId}">${category.largeCategoryName}</button>
			</div>
		</c:forEach>
	</div>
	<ul class="menuItem_ul">
		<c:forEach var="menu" items="${menuList}">
			<li class="menuItem">
				<a class="modal-btn" data-toggle="modal" data-target="#exampleModal" >
					<img src="/java-cafe/resources/menuImg/${menu.image.imgName}">
					<p class="menu_text">${menu.menuItemName }</p>
					<p class="menu_text">${menu.description}</p>
					<p class="menu_text">${menu.menuPrice }원</p>
					<p class="menu_text">${menu.ihb }</p>
					<span hidden>${menu.menuid }</span>
				</a>
			</li>
		</c:forEach>
	</ul>
	
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">수량 선택</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	      </div>
	    </div>
	  </div>
	</div>
		<form>
	<div class="cart-container">
		<c:forEach var="cart" items="${cartList}">
			<div class="cart_content">
				<span class="delete_content">X</span>
				<img src="/java-cafe/resources/menuImg/${cart.imgName}" style="width: 150px; height: 150px;">
				<div class="cart_content_text">
					<span class="cart_menuName">${cart.menuItemName}</span>
					<span class="cart_menuPrice">${cart.menuPrice * cart.buyCount}원</span>
					<span class="cart_menuihb">${cart.ihb}</span>
					<span class="cart_buyCount">${cart.buyCount}개</span>
				</div>
			</div>
		</c:forEach>
		<div class="total_text">
			<span>총액</span>
			<span class="total_price"></span>
			<input hidden class="totalInput" name="totalPrice" value="">
			<button type="button" onclick="location.href='<c:url value="/kiosk/buyPage" />' ">결제하기</button>
		</div>
	</div>
		</form>
	
	
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/view_main.js'/>"></script>
	<script>
	</script>
</body>
</html>