<%@ page contentType="text/html; charset=EUC-KR"%>
<%
	  request.setCharacterEncoding("EUC-KR");
	  String id = (String)session.getAttribute("idKey");
%>
<html>
<head>
<title>�α���</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">//�ڹٽ�ũ��Ʈ
	function loginCheck() {
		if (document.loginFrm.id.value == "") {
			alert("���̵� �Է��� �ּ���.");
			document.loginFrm.id.focus();//���̵� �Է� ���ϸ� id �Է�â�� �Ѽ� �����Ÿ���
			return;
		}
		if (document.loginFrm.pwd.value == "") {
			alert("��й�ȣ�� �Է��� �ּ���.");//��� �Է� ���ϸ� id �Է�â�� �Ѽ� �����Ÿ���
			document.loginFrm.pwd.focus();
			return;
		}
		document.loginFrm.action = "member/loginProc.jsp";//�� �� �� ��ٸ� �ű�(member/loginProc.jsp)�� ����
		document.loginFrm.submit();//����
	}
	
	function memberForm(){
		document.loginFrm.target = "content";
		document.loginFrm.action = "member/member.jsp";//member/member.jsp�� ����.
		document.loginFrm.submit();
	}
</script>
</head>
<body bgcolor="#FFFFCC">
<br/><br/>
 <div align="center">
		<% if(id!=null && id.equals("admin")){
		%>
		<b>������</b>�� ȯ�� �մϴ�.
		<p>
			<a href="member/logout.jsp">�α׾ƿ�</a>
		<%}
		else if(id != null) {//id�� ���� �ż��� �ִ� ��.
		%>
		<b><%=id%></b>�� ȯ�� �մϴ�.
		<p>���ѵ� ����� ��� �� ���� �ֽ��ϴ�.
		<p>
			<a href="member/logout.jsp">�α׾ƿ�</a>
			<a href="member/memberout.jsp">ȸ��Ż��</a><!-- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
			<%} else {%><!--�α��� ���н� or �ƿ� �õ� �� ���� ��-->
		<form name="loginFrm" method="post" action="member/loginProc.jsp">
			<table>
				<tr>
					<td align="center" colspan="2"><h4>�α���</h4></td>
				</tr>
				<tr>
					<td>�� �� ��</td>
					<td><input name="id" value=""></td>
				</tr>
				<tr>
					<td>��й�ȣ</td>
					<td><input type="password" name="pwd" value=""></td>
				</tr>
				<tr>
					<td colspan="2">
						<div align="right">
							<input type="button" value="�α���" onclick="loginCheck()">&nbsp;<!--���⼭ �ڹٽ�ũ��Ʈ-->
							<input type="button" value="ȸ������" onClick="memberForm()" >
						</div>
					</td>
				</tr>
			</table>
		</form>
		<%}%>
	</div>
</body>
</html>