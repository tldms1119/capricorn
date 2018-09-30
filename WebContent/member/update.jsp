<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<c:set var="context" scope="request" value="${ pageContext.request.contextPath }"/>

<title>Capricorn</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
<link rel="stylesheet" href="${context}/bower_components/bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="${context}/css/main.css">
 
<script src="${context}/bower_components/jquery/dist/jquery.min.js"></script>
<script src="${context}/bower_components/popper.js/dist/umd/popper.min.js"></script>
<script src="${context}/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="${context}/js/common.js"></script>
<script>
$(function(){
	
});
</script>
</head>
<body>
	<div class="container bg-light">
		<jsp:include page="/common/header.jsp"/>
		<jsp:include page="/common/menu.jsp"/>
		
		<h3 class="font_weight_bold pl-5 mt-3">
			<i class="far fa-edit"></i> Edit </h3>
		
		<form method="post">
		<!-- 사용자는 보이지 않게하고 파라미터로 전달은 할 수 있게 만들어주는 좋은 기법! -->
		<input type="hidden" name="userId" value="${ member.userId }">
		<input type="hidden" name="name" value="${ member.name }">
		<div class="mt-2 w-50 ml-5">
			<span class="font_weight_bold"><i class="fas fa-user"></i> ${ member.userId } (${ member.name })</span><br><br>
			<label for="phone">Phone</label><br>
			<input type="text" id="phone" name="phoneNumber"
			<c:if test="${ not empty member.phoneNumber }"></c:if> value="${ member.phoneNumber }"
			<c:if test="${ empty member.phoneNumber }"></c:if> required placeholder="번호 입력"
			/><br><br>
			
			<label for="email">Email</label><br>
			<input type="text" id="email" name="email"
			<c:if test="${ not empty member.email }"></c:if> value="${ member.email }"
			<c:if test="${ empty member.email }"></c:if> required placeholder="Email 입력"
			/><br><br>
		
			<label for="nickname">Nick Name</label><br>
			<input type="text" id="nickname" name="nickName"
			<c:if test="${ not empty member.nickName }"></c:if> value="${ member.nickName }"
			<c:if test="${ empty member.nickName }"></c:if> required placeholder="닉네임 입력"
			/><br><br>
			
			<label for="address">Address</label><br>
			<input type="text" id="address" name="address"
			<c:if test="${ not empty member.address }"></c:if> value="${ member.address }"
			<c:if test="${ empty member.address }"></c:if> required placeholder="주소 입력"
			/><br><br>
			
			<label for="pw">Password</label><br>
				<input type="password" id="pw" name="password" required placeholder="Password 입력"/><br><br>
		</div>
		<div class="text-danger ml-5">${ error }</div>
		
		<div class="mx-auto">
				<button type="submit" class="btn mt-3 ml-5 btn-outline-info"><i class="fas fa-check"></i> Submit</button>
				<a href="javascript:history.back()" class="btn mt-3 ml-1 btn-outline-secondary">
							<i class="fas fa-undo"></i> Back</a>
		</div> 
		</form>
		
		<jsp:include page="/common/footer.jsp"/>
	</div>
</body>
</html>