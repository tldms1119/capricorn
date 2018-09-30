<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<c:set var="context" scope="request" value="${ pageContext.request.contextPath }"/>

<title>Capricorn</title>
<!-- 스마트폰에게 내리는 지시/ 폭이 좁다고 해서 작게 만들지 마라 내가 알아서 반응형 웹 할거다 -->
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
		
		<h3 class="font_weight_bold pl-5 mt-3"><i class="fas fa-plane-departure"></i> 추천 여행지</h3><hr>
		
		<div id="demo" class="carousel slide mx-auto w-75 mt-4" style="height:500px" data-ride="carousel">

			<!-- Indicators -->
			<ul class="carousel-indicators">
				<c:forEach var = "item" items="${list}" varStatus="status">
					<li data-target="#demo" data-slide-to="${ status.index }"
					<c:if test="${status.first}">class="active"</c:if>
					></li>
				</c:forEach>
			</ul>

			<!-- The slideshow -->
			<div class="carousel-inner">
				<c:forEach var = "item" items="${list}" varStatus="status">
					<div class="carousel-item
					<c:if test="${status.first}">active</c:if>
					">
						<img class="img-fluid" style="width:100%; height:500px" src="${ context }/images/${ item.imageList.get(0) }">
							<div class="carousel-caption">
    							<h3>${ item.title }</h3>
    							<p>${ item.summary }</p>
  							</div>
					</div>
				</c:forEach>
			</div>

			<!-- Left and right controls -->
			<a class="carousel-control-prev" href="#demo" data-slide="prev">
				<span class="carousel-control-prev-icon"></span>
			</a> <a class="carousel-control-next" href="#demo" data-slide="next">
				<span class="carousel-control-next-icon"></span>
			</a>

		</div>
		
		<div class="row mt-3 w-75 mx-auto">
			<c:forEach var = "item" items="${list2}" varStatus="status">
				<div class="col-md-4">
					<div class="card mb-4">
						<img class="card-img-top" src="${ context }/images/${ item.imageList[0] }">
						<div class="card-body">
							<h4 class="card-title">${ item.title }
								<small>${ item.region }</small>
							</h4>
							<p class="card-text">${ item.summary }</p>
							<a class="card-link" href="${ item.homePage }" target="_blank">
									<i class="fas fa-home"></i> 홈페이지</a>
						</div> 
					</div>
				</div>
			</c:forEach>
		</div>
		
		<jsp:include page="/common/footer.jsp"/>
	</div>
</body>
</html>