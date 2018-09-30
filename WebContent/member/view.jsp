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
	
});
</script>
</head>
<body>
	<div class="container bg-light">
		<jsp:include page="/common/header.jsp"/>
		<jsp:include page="/common/menu.jsp"/>
		
		<h3 class="font_weight_bold pl-5 mt-3"><i class="fas fa-user"></i> My Page </h3>
		<div class="ml-5 text-info"> ${ success }</div>
		<div class="row w-50 mx-5 mt-1">
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
				${ USER.userId } <br>
				${ USER.name } <br>
			    ${ USER.userLevel } <br>
				${ USER.phoneNumber } <br>
				${ USER.nickName } <br>
				${ USER.email } <br>
				${ USER.address } <br>
				<fmt:formatDate value="${ USER.regDate }" pattern="yyyy-MM-dd"></fmt:formatDate>
			</div>
		</div>
		
		<div class="mx-auto">
				<a href="change_password" class="btn mt-3 btn-outline-danger" style="margin-left:60px">
							<i class="fas fa-unlock"></i> Change Password</a>
				<a href="update" id="delete-btn" class="btn mt-3 ml-2 btn-outline-info">
					<i class="far fa-edit"></i> Edit</a>
			</div> 
		<jsp:include page="/common/footer.jsp"/>
	</div>
		
</body>
</html>