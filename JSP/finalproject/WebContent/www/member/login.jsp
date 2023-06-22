<%@ page contentType="text/html; charset=EUC-KR"%>
<%
	  request.setCharacterEncoding("EUC-KR");
	  String id = (String)session.getAttribute("idKey");
%>
<html>
<head>
<title>로그인</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">//자바스크립트
	function loginCheck() {
		if (document.loginFrm.id.value == "") {
			alert("아이디를 입력해 주세요.");
			document.loginFrm.id.focus();//아이디 입력 안하면 id 입력창에 켜서 깜빡거리기
			return;
		}
		if (document.loginFrm.pwd.value == "") {
			alert("비밀번호를 입력해 주세요.");//비번 입력 안하면 id 입력창에 켜서 깜빡거리기
			document.loginFrm.pwd.focus();
			return;
		}
		document.loginFrm.action = "member/loginProc.jsp";//둘 다 잘 썼다면 거기(member/loginProc.jsp)로 가라
		document.loginFrm.submit();//전송
	}
	
	function memberForm(){
		document.loginFrm.target = "content";
		document.loginFrm.action = "member/member.jsp";//member/member.jsp로 가라.
		document.loginFrm.submit();
	}
</script>
</head>
<body bgcolor="#FFFFCC">
<br/><br/>
 <div align="center">
		<% if(id!=null && id.equals("admin")){
		%>
		<b>관리자</b>님 환영 합니다.
		<p>
			<a href="member/logout.jsp">로그아웃</a>
		<%}
		else if(id != null) {//id가 들어가면 셔센이 있는 거.
		%>
		<b><%=id%></b>님 환영 합니다.
		<p>제한된 기능을 사용 할 수가 있습니다.
		<p>
			<a href="member/logout.jsp">로그아웃</a>
			<a href="member/memberout.jsp">회원탈퇴</a><!-- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
			<%} else {%><!--로그인 실패시 or 아예 시도 안 했을 시-->
		<form name="loginFrm" method="post" action="member/loginProc.jsp">
			<table>
				<tr>
					<td align="center" colspan="2"><h4>로그인</h4></td>
				</tr>
				<tr>
					<td>아 이 디</td>
					<td><input name="id" value=""></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pwd" value=""></td>
				</tr>
				<tr>
					<td colspan="2">
						<div align="right">
							<input type="button" value="로그인" onclick="loginCheck()">&nbsp;<!--여기서 자바스크립트-->
							<input type="button" value="회원가입" onClick="memberForm()" >
						</div>
					</td>
				</tr>
			</table>
		</form>
		<%}%>
	</div>
</body>
</html>