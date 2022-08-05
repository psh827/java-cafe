<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제</title>
</head>
<body>
<ul>
	<c:forEach var="cart" items="${cartList}">
		<li>메뉴이름 : ${cart.menuItemName } | 수량 : ${cart.buyCount } | 종류 : ${cart.ihb} | 금액 : <span class="each_total_money">${cart.menuPrice * cart.buyCount }</span>원</li>
	</c:forEach>
</ul>
총액 : 
<span class="total_price"></span>
<form class="totalForm">
	<input hidden class="totalInput" name="totalPrice" type="number" value="">
	<button class="submitBtn" type="submit" formaction="buyPage" formmethod="post">결제하기</button>
</form>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script>
var sum = 0
window.onload = function(){
	var total = $(".total_price")
	$(".each_total_money").each(function(index, el){
		let money = $(el).text().split("원")[0]
		console.log(money)
		sum += Number(money)
	})
	total.text(sum + "원")
	$(".totalInput").attr('value', sum)
};


</script>
</body>
</html>