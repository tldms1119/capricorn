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
	$('form').submit(function(event){
		event.preventDefault();
		var pw1 = $('#pw1').val();
		var pw2 = $('#pw2').val();
		if(pw1 != pw2){
			alert("비밀번호가 일치하지 않습니다");
			$('[name=newPassword]').focus();
			return;
		}
		this.submit();
	});
});
</script>
</head>
<body>
	<div class="container bg-light">
		<jsp:include page="/common/header.jsp"/>
		<jsp:include page="/common/menu.jsp"/>
		
		<h3 class="font_weight_bold pl-5 mt-3">
			<i class="fas fa-unlock"></i> Change Password </h3>
		
		<form method="post">
		<div class="mt-2 w-50 ml-5">
			<span class="font_weight_bold"><i class="fas fa-user"></i> ${ member.userId } (${ member.name })</span><br><br>
			
		<label for="pw">Password</label><br>
		<input type="password" id="pw" name="oldPassword" required placeholder="Current Password 입력"/><br><br>
			
		<label for="pw1">Password</label><br>
		<input type="password" id="pw1" name="newPassword" required placeholder="New Password 입력"/><br><br>
			
		<label for="pw2">Confirm Password</label><br>
		<input type="password" id="pw2" name="newPassword2" required placeholder="New Password 확인"/><br><br>	
			
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