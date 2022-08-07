<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="header_container">
	<c:choose>
		<c:when test="${admin eq '관리자'}">
			<a class="header_logo" href="<c:url value='/admin/admin_main'/>">Paak's coffee</a>
			<div class="ul-container">
				<ul class="nav-ul">
					<li class="nav-item"><a class="nav-link" href="<c:url value='/admin/view_menu'/>">현재메뉴보기</a></li>
					<li class="nav-item"><a class="nav-link" href="<c:url value='/admin/add_category'/>">카테고리추가</a></li>
					<li class="nav-item"><a class="nav-link" href="<c:url value='/admin/add_menu_item'/>">메뉴추가</a></li>
					<li class="nav-item"><a class="nav-link" href="<c:url value='/admin/logout'/>">로그아웃</a></li>
				</ul>				
			</div>
		</c:when>
		<c:otherwise>
			<a class="header_logo" href="<c:url value='/kiosk/main'/>">Paak's coffee</a>
			<div class="ul-container">
				<ul class="nav-ul">
					<li class="nav-item"><a class="nav-link" href="<c:url value='/admin/login'/>">관리자메뉴</a></li>
				</ul>
			</div>
		</c:otherwise>
	</c:choose>
	
</div>

