<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MainPage</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/common.css" type = "text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/PST.css" type = "text/css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>

</head>
<body>
 <header>
    <div id="headerMenuBar">
        <img src="<%=request.getContextPath()%>/img/common/rogo.png" alt="로고이미지" width="35" height="53"/>
	        <ul id="headerDefault">
	            <li><a href="#">펫 시터 찾기</a></li>
	            <li><a href="#">펫 시터 지원</a></li>
	        </ul>
	        <% if(session.getAttribute("loginMember")!=null){ %>
	        <ul id="headerUnlogin">
	        	<li><a href="#">로그인</a></li>
	            <li><a href="#">회원가입</a></li>
	        </ul>
	        <% } else { %>
	        <ul id="headerlogin">
	        	<li><a href="#"><img alt="유저" src="<%=request.getContextPath()%>/img/common/Profile.png"
	        						width="30px" height="30px"></a></li>
	            <li><p>OOO님</p></li>
	            <li><a href="#">로그아웃</a></li>
	            <li><a href="#"><img alt="종소리" src="<%=request.getContextPath()%>/img/common/Bell.png"
	            					width="30px" height="30px"></a></li>
	        </ul>
	        <% } %>
    </div>
</header>

