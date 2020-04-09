<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



	<!-- 내가 적용한 CSS : 회원가입 -->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/joinForm.css">
	<!-- 내가 적용한 jQuery -->
	<script src="<%=request.getContextPath()%>/js/jquery-3.4.1.min.js"></script>
	<!-- Daum 우편번호 서비스 API  -->
	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>


<!-- 회원가입 영역 -->
<section>
    <h1>회원가입</h1>
    
    <article>

        <form action="<%=request.getContextPath()%>/joinEnd" method="post" onsubmit="return all_join_check();">
            <table id="enrollTB">

                <tr class="tr-blank">
                    <td>아이디</td>
                    <td class="second-td">
                    	<input id="user_id" name="user_id" type="text" required>&nbsp;&nbsp;&nbsp;
                    	<button id="check-btn" onclick="duplicate();">중복 확인</button>
                    </td>
                </tr>

                <tr class="tr-blank">
                    <td>비밀번호</td>
                    <td class="second-td">
                    	<input type="password" id="password" name="password" required> 
                    </td>
                </tr>

                <tr class="tr-blank">
                    <td></td>
                    <td class="div-msg"><div>비밀번호 중복확인 메세지 영역</div></td>
                </tr>

                <tr class="tr-blank">
                    <td>비밀번호 확인</td>
                    <td class="second-td">
                    	<input type="password" id="pwck" name="pwck" required>
                    </td>
                </tr>

                <tr class="tr-blank">
                    <td>이름</td>
                    <td class="second-td">
                    	<input type="text" id="user_name" name="user_name">
                    </td>
                </tr>
                
                <tr>
                	<td>성별</td>
	                <td style="padding-left: 10%;">
						<input type="radio" name="gender" id="gender0" value="남">
						<label for="gender0">남</label>
						<input type="radio" name="gender" id="gender1" value="여">
						<label for="gender1">여</label>
					</td>
                </tr>

                <tr class="tr-blank">
                    <td>생년월일</td>
                    <td class="second-td">
                    	<input type="date" id="user_birth_day" name="user_birth_day" min="1900-01-01" max="<%=System.currentTimeMillis() %>"
			            style="width: 175px; padding-left: 10px;">
                   </td>
               </tr>
               
               <tr class="tr-blank">
                   <td>이메일</td>
                   <td class="second-td" id="emailSelect">
                   		<div style="display:flex-direction: row;">
	                   		<input id="email" type="email" name="email">	
	                   	</div>
                   </td>
               </tr>

               <tr class="tr-blank">
                   <td></td>
                   <td class="div-msg"><div>이메일 중복확인 메세지 영역</div></td>
               </tr>
               
               <tr class="tr-blank">
                   <td>핸드폰 번호</td>
                   <td class="second-td">
                   		<input type="text" id="phone" name="phone" required>
                   		&nbsp;&nbsp;&nbsp;<span style="familly-weight:small; color: gray;">입력 예 : 010-1234-5656</span>
                       <!-- <input type="text" style="width: 100px;" required> - <input type="text" style="width: 100px;" required> - <input type="text" style="width: 100px;" required > -->
                   </td>
               </tr>
               
                <tr class="tr-blank">
                    <td>우편변호</td>
                    <td class="second-td">
                    	<input type="text" id="postNum" name="postNum" placeholder="우편번호">&nbsp;&nbsp;&nbsp;
                    	<button type="button" id="check-btn" onclick="zip_code();">우편번호 찾기</button>
                    	
                    </td>
                </tr>
                
                <tr class="tr-blank">
                    <td></td>
                    <td class="second-td">
                    	<input id="streetAddress" name="address" type="text" placeholder="도로명주소">
                    </td>
                </tr>
                
                <!-- <tr class="tr-blank">
                    <td></td>
                    <td class="second-td">
                    	<input id="jibunAddress" type="text" placeholder="지번주소">
                    </td>
                </tr> -->
                
                <tr class="tr-blank">
                    <td>상세주소</td>
                    <td class="second-td">
                    	<input id="addressInput" name="detail" type="text" placeholder="상세주소 입력">
                   	</td>
                   	<td><input type="hidden" name="type" value="일반"/></td>
                </tr>
                
            </table>

            <br>

            <button type="submit" id="enroll-btn">완료</button>
            
        </form>

    </article>

</section>

<script>
/* --------------------------------------------------------------------------------------- */
	var userId = $("#user_id").val();
	var password = $("#password").val();
	var pwck = $("#pwck").val();
	var email= $("#email").val();
	var userName = $("#user_name").val();
	var birth = $("#user_birth_day").val();
	console.log(birth);

// 이 함수에서는 각각의 input값을 확인하는 '함수'를 호출하는 함수
	function all_join_check() {
		
		if(!checkUserId(form.user_id.value)) {
			return false;
		}
		else if(!checkPassword(form.user_id.value, form.password.value, form.pwck.value)) {
			return false;
		}
		else if(!checkEmail(form.email.value)) {
			return false;
		}
		else if(!checkName(form.name.value)) {
			return false;
		}
		else if (!checkBirth(form.identi1.value, form.identi2.value)) {
	        return false;
	    } 
		else if (!checkFavorite()) {
	        return false;
	    } 
		else if (!checkIntro()) {
	        return false;
	    }
	    return true;
	}
	
	// 공백확인 함수
	function checkExistData(value, dataName) {
		if(value=="") {
			alert(dataName+"입력해주세요.");
			return false;
		}
		return true;
	}
	
	
	// 아이디가 입력되었는지 확인하는 함수
	function checkUserId(user_id) {
		if(!checkExistData(user_id, "아이디를")) {
			return false;
		}
		
		// 아이디 유효성 검사
		var idReg = /^[a-zA-z0-9]{5,12}$/g;
		if(!idReg.test(user_id)) {
			alert("아이디는 영문 대소문자와 숫자 5~12자리로 입력해야 한다.");
			form.user_id.value = ""; // 공백으로 초기화
			form.user_id.focus();
			return false;
		}
		return true; // 확인이 되었을 때
	}
	
	// 비밀번호가 입력되었는지 확인하는 함수
	// 비밀번호 만족 조건 3가지
	// 1. 영문 대/소문자와 숫자로 8~15자리 입력할 것
	// 2. 비밀번호 두 번 입력했을 때 두 번 다 일치할 것
	// 3. 아이디와 비밀번호는 불일치할 것
	function checkPassword(user_id, password, pwck) {
		if(!checkExistData(password, "비밀번호를 ")) {
			return false;
		}
		if(!checkExistData(pwck, "비밀번호 확인을 ")) {
			return false;
		}
		
		// 비밀번호 유효성 검사
		var pwReg = /^[a-zA-z0-9]{8,15}$/g;
		if(!pwReg.test(password)) {
			alert("비밀번호는 영문 대소문자와 숫자 8~15자리로 입력해야 합니다.");
			form.password.value="";
			form.password.focus();
			return false;
		}
		
		// 비밀번호와 비밀번호 확인이 일치하지 않다면?
		if(password != pwck) {
			alert("비밀번호가 일치하지 않습니다.");
			form.pwck.value="";
			form.pwck.focus();
			return false;
		}
		
		// 아이디와 비밀번호가 일치할 때
		if(user_id==password) {
			alert("아이디와 비밀번호는 일치할 수 없습니다.");
			form.password.value="";
			form.password.focus();
			form.pwck.value="";
			return false;
		}
		return true; // 확인이 완료되었을 때
	}
	
	
	// 이름 검사 함수
	function checkName(userName) {
		if(!checkExistData(userName, "이름을 ")) {
			return false;
		}
		
		var nameReg = /^[가-힣]{2,4}$/g; // 한글만 입력하도록 설정
		if(!nameReg.test(userName)) {
			alert("이름이 올바르지 않습니다.");
			return false;
		}
		return true; // 확인이 완료되었을 때
	}
	
	
	// 이메일이 입력되었는지 확인하기
	// 이메일 좀 봐달라고 해야겠다! (정규식 표현)
	function checkEmail() {
		if(!checkExistData(email, "이메일을 ")) {
			return false;
		} 
		
		// 특수문자 @와 .는 반드시 하나만 입력되어야 한다.
		var emailReg = /^[A-Za-z0-9_]+[A-Za-z0-9]*[@]{1}[A-Za-z0-9]+[A-Za-z0-9]*[.]{1}[A-Za-z]{1,3}$/g;
		if(!emailReg.test(email)) {
			alert("이메일 형식이 올바르지 않습니다.");
			form.email.value="";
			form.email.focus();
			return false;
		}
		return true; // 확인이 완료되었을 때
	}
	
	
	/* --------------------------------------------------------------------------------------- */
	//아이디 중복확인 팝업창
	function duplicate() {	
		var userId=$("#user_id").val();
		// 새 창을 띄워서 userId의 값을 비교하는 함수!
		var url = "<%=request.getContextPath()%>/UserIdDuplicate?userId="+userId;
		var status = "height=420px, width=600px, top=200px, left=500px";
		window.open(url, "_blank", status);
	}
	
	
	
	
	/* --------------------------------------------------------------------------------------- */
	
	
	/* Daum 우편번호 로직 */
	function zip_code() {
		new daum.Postcode({
			oncomplete: function(data) {
	        // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
	
	        // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
	        // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	        var roadAddr = data.roadAddress; // 도로명 주소 변수
	        var extraRoadAddr = ''; // 참고 항목 변수
	
	        // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	        // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	        if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	            extraRoadAddr += data.bname;
	        }
	        // 건물명이 있고, 공동주택일 경우 추가한다.
	        if(data.buildingName !== '' && data.apartment === 'Y'){
	           extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	        }
	        // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	        if(extraRoadAddr !== ''){
	            extraRoadAddr = ' (' + extraRoadAddr + ')';
	        }
	
	        // 우편번호와 주소 정보를 해당 필드에 넣는다.
	        document.getElementById("postNum").value = data.zonecode; // 우편번호
	        document.getElementById("streetAddress").value = roadAddr; // 도로명주소
	        /* document.getElementById("jibunAddress").value = data.jibunAddress; // 지번주소 */
	        
	        // 참고항목 문자열이 있을 경우 해당 필드에 넣는다. (상세주소)
	        if(roadAddr !== ''){
	            document.getElementById("addressInput").value = extraRoadAddr;
	        } else {
	            document.getElementById("addressInput").value = '';
	        }
	
	        var guideTextBox = document.getElementById("guide");
	        // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
	        if(data.autoRoadAddress) {
	            var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
	            guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
	            guideTextBox.style.display = 'block';
	
	        } else if(data.autoJibunAddress) {
	            var expJibunAddr = data.autoJibunAddress;
	            guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
	            guideTextBox.style.display = 'block';
	        } else {
	            guideTextBox.innerHTML = '';
	            guideTextBox.style.display = 'none';
	        }
	    }
	}).open();
	} // function()
</script>

