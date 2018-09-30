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
<link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
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
		
		<h3 class="font_weight_bold pl-5 mt-3"><i class="fas fa-user"></i> Log in</h3>
		<h4 class="font_weight_bold pl-5 mt-3 text-warning">${ message }</h4>
		<div class="mt-3 text-center">
		<form method="post">
			<input type="hidden" name="destination" value="${ destination }">
			<label for="id">&nbsp; &nbsp;User ID : </label>
			<input type="text" id="id" name="id"
			<c:if test="${ not empty userId }"></c:if> value="${ userId }"
			<c:if test="${ empty userId }"></c:if> required placeholder="ID 입력"
			/><br>
			<label for="pw">Password : </label>
			<input type="password" id="pw" name="pw" required placeholder="Password 입력"/><br>
			<div class="text-warning" style="margin-left: 80px">${ error }</div>
			<button type="submit" class="btn mt-3 btn-dark" style="margin-left: 80px"><i class="fas fa-check"></i> Submit</button>
			<button type="reset" class="btn mt-3 btn-dark"><i class="fas fa-undo"></i> Reset</button> 
		</form>
		</div>
		
		<jsp:include page="/common/footer.jsp"/>
	</div>
</body>
</html>