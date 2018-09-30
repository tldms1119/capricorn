<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
	// confirm -> yes = true, no = false return
	$('#delete-btn').click(function(){
		var result = confirm('${member.userId} 회원을 삭제할까요?');
		if(result) {
			location = 'delete?userId=${member.userId}';
		}
	});
	
});
</script>
</head>
<body>
	<div class="container bg-light">
		<jsp:include page="/common/header.jsp"/>
		<jsp:include page="/common/menu.jsp"/>
		
		<h3 class="font_weight_bold pl-5 mt-3"><i class="fas fa-user"></i> Member's Details.. </h3>
		<div class="row w-50 mx-5">
			<div class="col-sm-4">
				ID	        <br>
				Name        <br>
				User Level  <br>
				Phone	    <br>
				Nick Name   <br>
				Email       <br>
				Address     <br>
				Register Date 
			</div>
			<div class="col-sm-8">
				${ member.userId } <br>
				${ member.name } <br>
			    ${ member.userLevel } <br>
				${ member.phoneNumber } <br>
				${ member.nickName } <br>
				${ member.email } <br>
				${ member.address } <br>
				<fmt:formatDate value="${ member.regDate }" pattern="yyyy-MM-dd"></fmt:formatDate>
			</div>
		</div>
		
		<div class="mx-auto">
				<a href="javascript:history.back()" class="btn mt-3 btn-outline-secondary" style="margin-left:100px">
							<i class="fas fa-undo"></i> Back</a>
				<button id="delete-btn" class="btn mt-3 ml-2 btn-outline-danger"><i class="fas fa-trash-alt"></i> Remove</button>
			</div> 
		<jsp:include page="/common/footer.jsp"/>
	</div>
</body>
</html>