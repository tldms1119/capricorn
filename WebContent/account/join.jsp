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
	$('#id-check').click(function(){
		var id = $('#id').val();
		var url = '${context}/idcheck'; // ?id=' + id;
		//var url = `${context}/idcheck?id=\${id}`; //Js 템플릿으로 하려면 el 표현 방식과 동일하므로 \ 붙여줘야 함(jsp가 먼저 보기 때문에)
		
		var params = { id : id };		// get의 두번째로 이 객체를 보내면 url인코딩까지 알아서 다 해줌
		
		// 얘가 AJAX - post 방식으로 보내고 싶으면 $.post
		// $.get의 응답으로 들어온 값 (out.print) 는 매개변수 data로 들어오게된다
		// 만약 doGet 메소드에서 forwarding을 하면 forwarding하게 되는 페이지 자체가 data로 들어옴
		$.get(url, params, function(data){
			console.log(url);
			console.log(data);
			if(data == "ok"){	// id 중복 아님
				$('.check-result').text("사용 가능 합니다")
								.removeClass('text-warning')
								.addClass('text-success');
				$('[type=submit]').prop('disabled', false);				
				
			} else {			// id 중복 됨
				$('.check-result').text("이미 사용 중 입니다")
								.removeClass('text-success')
								.addClass('text-warning');
				$('[type=submit]').prop('disabled', true);
			}
		});
	});
	
	$('#id').keyup(function(){
		$('.check-result').text("중복 검사를 하세요")
						.removeClass('text-success')
						.addClass('text-warning');
		$('[type=submit]').prop('disabled', true);
	});
	
	$('form').submit(function(event){
		event.preventDefault();
		var pw1 = $('#pw').val();
		var pw2 = $('#pw2').val();
		if(pw1 != pw2){
			alert("비밀번호가 일치하지 않습니다");
			$('[name=pw]').focus();
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
		
		<h3 class="font_weight_bold pl-5 mt-3"><i class="fas fa-user-plus"></i> Join </h3>
		<div class="text-danger pl-5">${ error }</div>
		<div class="mt-3">
		<form method="post" class="row w-50 mx-auto">			
			<div class="col-md-6">
				<label for="id">User ID</label><br>
				<input type="text" id="id" name="id"
				<c:if test="${ not empty member.userId }"></c:if> value="${ member.userId }"
				<c:if test="${ empty member.userId }"></c:if> required placeholder="ID 입력"
				/><br>
				
				<div class="mt-1">
					<span class="check-result text-warning small"> ID 중복 검사를 하세요 &nbsp;</span>
					<button type="button" id="id-check" class="btn btn-sm btn-outline-warning">
										 <i class="fas fa-check"></i></button>
				</div>
			
				<label for="pw">Password</label><br>
				<input type="password" id="pw" name="pw" required placeholder="Password 입력"/><br><br>
			
				<label for="pw2">Confirm Password</label><br>
				<input type="password" id="pw2" name="pw2" required placeholder="Password 확인"/><br><br>
			
				<label for="name">Name</label><br>
				<input type="text" id="name" name="name"
				<c:if test="${ not empty member.name }"></c:if> value="${ member.name }"
				<c:if test="${ empty member.name }"></c:if> required placeholder="이름 입력"
				/><br><br>
			</div>
			
			<div class="col-md-6">
				<label for="phone">Phone</label><br>
				<input type="text" id="phone" name="phone"
				<c:if test="${ not empty member.phoneNumber }"></c:if> value="${ member.phoneNumber }"
				<c:if test="${ empty member.phoneNumber }"></c:if> required placeholder="번호 입력"
				/><br><br>
			
				<label for="email">Email</label><br>
				<input type="text" id="email" name="email"
				<c:if test="${ not empty member.email }"></c:if> value="${ member.email }"
				<c:if test="${ empty member.email }"></c:if> required placeholder="Email 입력"
				/><br><br>
			
				<label for="nickname">Nick Name</label><br>
				<input type="text" id="nickname" name="nickname"
				<c:if test="${ not empty member.nickName }"></c:if> value="${ member.nickName }"
				<c:if test="${ empty member.nickName }"></c:if> required placeholder="닉네임 입력"
				/><br><br>
			
				<label for="address">Address</label><br>
				<input type="text" id="address" name="address"
				<c:if test="${ not empty member.address }"></c:if> value="${ member.address }"
				<c:if test="${ empty member.address }"></c:if> required placeholder="주소 입력"
				/><br><br>
			</div>
			
			<div class="mx-auto">
				<button type="submit" class="btn mt-3 mr-3 btn-outline-dark" disabled><i class="fas fa-check"></i> Submit</button>
				<button type="reset" class="btn mt-3 btn-outline-warning"><i class="fas fa-undo"></i> Reset</button>
			</div> 
		</form>
		</div>
		
		<jsp:include page="/common/footer.jsp"/>
	</div>
</body>
</html>