<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
		boolean flag = (boolean)request.getAttribute("flag");
		String userId = request.getParameter("userId");
	%>

<style>
	div{
		display:flex;
		flex-direction: column;
		margin-right:auto;
		margin-left:auto;
	}
	
	#container{
		background-color: rgb(218, 218, 218);
		border-radius:15px;
	}
	#tp{
		margin-top:120px;
	
	}
	
	
	#hr1{
		margin-top:130px;
		width: 550px;
	}
	
	#bttm{
		
		padding: 7px 15px;
		width: 100px;
		
		margin-top:30px;
		margin-bottom:30px;
	
	    background-color: black; /* 버튼 배경 */
	    border-radius:25px; /* 버튼을 둥글게! */
	    border: 0; /* 박스 선 없애기! */
	    font-size: small; /* 폰트 사이즈 */
	    color: white; /* 폰트 컬러 */
	}
	#hr2{
		margin-top:70px;
		width: 550px;
	}
	
	input{
		width: 200px;
		height: 30px;
	}
	
	#bttm2{
		
		padding: 7px 15px;
		width: 100px;

	    background-color: black; /* 버튼 배경 */
	    border-radius:25px; /* 버튼을 둥글게! */
	    border: 0; /* 박스 선 없애기! */
	    font-size: small; /* 폰트 사이즈 */
	    color: white; /* 폰트 컬러 */
	}
	
	#row{
		display:flex;
		flex-direction: row;
		margin-right:auto;
		margin-left:auto;
	}
</style>
<section>
	<article>
		
		<!-- 아이디 중복확인 팝업창 -->
		<div id="checkid-container">

			<%if(!flag){ %>
					
					<br/>
					<div id="tp">[<%=userId %>] 해당 아이디는 사용 가능합니다.</div>
					<br/>
					<hr/ id="hr1">
					<div ><button id="bttm"type='button' onclick="setUserId();">닫기</button></div>
					
				
			<%} else {%>
				<br/>
				<div id="tp">[<%=userId %>] 해당 아이디는 이미 사용 중 입니다.</div>
				<br/>
				<hr/ id="hr2">
				<div id="row"><input type="text" id="userId" placeholder="아이디를 입력하세요"/>&nbsp; &nbsp; 
				<button id="bttm2" type="button" onclick="fn_duplicate();">중복검사</button></div>
			<%} %>
	</div>
	<script>
		function fn_duplicate(){
			var id=document.querySelector("#userId").value;
			if(id.trim().length<4){
				alert("아이디를 4글자 이상 입력하세요");
				return;
			}
			location.replace('<%=request.getContextPath()%>/UserIdDuplicate?userId='+id);
		}
		function setUserId(){
			//부모창에 있는 userId입력창에 userId값을 넣기!
			opener.document.getElementById("user_id").value='<%=userId%>';
			self.close();	
		}	
	</script>
	</article>
</section>