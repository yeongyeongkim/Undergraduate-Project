<%@ page contentType="text/html; charset=EUC-KR" %>
<%
	  String id = (String) session.getAttribute("idKey");
	  String cPath = request.getContextPath();
	  String url = "member/member.jsp";
	  String label = "회원가입";
      if(id!=null){
        url = "member/memberUpdate.jsp";
        label = "회원수정";
      }
      if(id!=null && id.equals("admin")){ 
    	  url = "member/memberList.jsp";
          label = "회원관리";
      }

%>
<html>
<head>
<title>head</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="#ffe6fa">
<div align="center">
	<table width="1280" cellpadding="0" cellspacing="0" >
		<tr>
			<td colspan="5">
				<table>
					<tr>
						<td height="50">
						<a href="<%=cPath%>/www/index.jsp" target="_parent" onFocus="this.blur();">
						<img src="images/logo.PNG" width=250 height=70 border="0"></a>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr height="20" >
			<td colspan="5">&nbsp;</td>
		</tr>
		<tr>
			<td width="250">&nbsp;</td>
			<td><font size="3"><a href="<%=url%>" target="content"><b><%=label%></b></a></font></td>
			<td><font size="3"><a href="board/list.jsp" target="content"><b>게시판</b></a></font></td>
			<!--<td><font size="3"><a a href="poll/pollList.jsp" target="content"><b>투표프로그램</b></a></font></td>-->
		</tr>
	</table>
	</div>
</body>
</html>