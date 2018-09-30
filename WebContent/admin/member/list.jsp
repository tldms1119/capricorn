<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<c:set var="context" scope="request" value="${pageContext.request.contextPath }"/>

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
	$('[type = submit]').click(function(e){
		e.preventDefault();
		location = "?userId=" + $('#search').val().trim();
	});
});
</script>
</head>
<body>
	<div class="container bg-light">
		<jsp:include page="/common/header.jsp"/>
		<jsp:include page="/common/menu.jsp"/>
		
		<h3 class="font_weight_bold pl-3 mt-3"><i class="fas fa-users"></i> Member List</h3>
		<div class="text-right mb-2">
			<input type="text" id="search" class="text-secondary bg-light" name="search" style="border:dashed 1.5px" required placeholder=" ID Search...">
			<button type="submit" class="btn btn-outline-secondary btn-sm mr-2">
			<i class="fas fa-search"></i></button>
			<span class="mr-4 font-weight-bold">Total Count : ${ total }</span>
		</div>
		<div class="text-danger">${ error }</div>
		<table class="table table-striped">
			<tr>
				<th>#</th>
				<th>ID</th>
				<th>Name</th>
				<th>Phone Number</th>
				<th>Email</th>
				<th>User Level</th>
				<th>Register Date</th>
			</tr>
			<c:forEach var = "item" items="${list}" varStatus="status">
			<fmt:formatDate var="regDate" value="${ item.regDate }" pattern="yyyy-MM-dd"></fmt:formatDate>
			<tr>
				<td>${ total - item.seq + 1 }</td>
				<td><a href = "view?userId=${ item.userId }">${ item.userId }</a>
					<c:if test="${today == regDate}">
						<span class="badge badge-pill badge-info">New!</span></c:if></td>
				<td>${ item.name }</td>
				<td>${ item.phoneNumber }</td>
				<td>${ item.email }</td>
				<td>${ item.userLevel }</td>
				<td>${ regDate }</td>
			</tr>
			</c:forEach>
		</table>
		
		<jsp:include page="/common/pagination.jsp"/>
		
		<jsp:include page="/common/footer.jsp"/>
	</div>
</body>
</html>