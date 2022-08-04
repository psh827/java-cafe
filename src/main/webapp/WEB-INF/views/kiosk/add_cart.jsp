<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 구매 OR 카트 담기</title>
</head>
<body>

<div class="menu-content">
	<h1>${menuItem.menuItemName }</h1>
	<div class="menu_img">
		<img src='<c:url value="/resources/menuImg/${menuItem.image.imgName}"/>'>
	</div>
	<div class="menu_description">
		<p class="description_text">${menuItem.description}</p>
	</div>
	<div class="menu_detail">
		<span>가격 : </span>
		<span class="menu_price">${menuItem.menuPrice}원</span>
		<c:choose>
			<c:when test="${fn:contains(menuItem.ihb, 'I')}">
				<p class="menu_ihb">Ice</p>
			</c:when>
			<c:otherwise>
				<p class="menu_ihb">Hot</p>
			</c:otherwise>
		</c:choose>
	</div>
	<label>구매 수량</label>
	<input type="number" class="buyCount" name="buyCount" value="1"/><br>
	<button type="button" class="plus_btn">+</button>
	<button type="button" class="minus_btn">-</button>
	<button type="button"class="incart" value="카트에 담기">카트에 담기</button>
	<button type="button" class="buyMenu" value="메뉴구입">메뉴 구입</button>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/add_cart_main.js'/>"></script>
<script>
let ihb = $(".menu_ihb").text()
let form = {
		menuid : '${menuItem.menuid}',
		menuItemName : '${menuItem.menuItemName}',
		menuPrice : '${menuItem.menuPrice}',
		ihb : ihb,
		imgName : '${menuItem.image.imgName}', 
		buyCount : ''
	}

	$(".incart").on("click", function(){
		form.buyCount = $(".buyCount").val();
		console.log(form.menuid)
			$.ajax({
				url: '/java-cafe/kiosk/incart',
				type: 'POST',
				data: form,
				success: function(result){
					console.log(result)
				}
			})
	})
</script>
</body>
</html>