<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제</title>
<link href="<c:url value='/resources/css/default.css'/>" rel="stylesheet" />
<link href="<c:url value='/resources/css/admin_main.css'/>" rel="stylesheet" />
<link href="<c:url value='/resources/css/kiosk/buyPage.css'/>" rel="stylesheet" />
</head>
<body>
<nav class="nav">
 	<jsp:include page="../incl/admin_header.jsp"/>
</nav>
<div class="view_container container">
		<table>
			<th>제품명</th>
			<th>수량</th>
			<th>제품종류</th>
			<th>금액</th>
			<c:forEach var="cart" items="${cartList}">
					<tr class="table_content">
						<td>${cart.menuItemName}</td>
						<td>${cart.buyCount}</td>
						<td>${cart.ihb}</td>
						<td class="each_total_money">${cart.menuPrice * cart.buyCount}</td>
					</tr>	
			</c:forEach>
		</table>
		<span class="total_text">총액 : </span> 
		<span class="total_price"></span>
		<form class="totalForm">
			<input hidden class="totalInput" name="totalPrice" type="number" value="">
			<button class="submitBtn" type="submit" formaction="main" formmethod="get">이전으로</button>
			<button class="submitBtn" type="submit" formaction="buyPage" formmethod="post">결제하기</button>
		</form>
	</div>


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