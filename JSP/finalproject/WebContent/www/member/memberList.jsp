<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*, www.*"%>
<jsp:useBean id="memMgr" class="www.MemberMgr" />
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function admin_update_member(id){
	document.adminUpdate.id.value=id;
	document.adminUpdate.submit();
}
function admin_delete_member(id){
	document.adminDelete.id.value=id;
	document.adminDelete.submit();
}
</script>
<meta charset="EUC-KR">
</head>
<body bgcolor="#FFFFCC">
<div align="center">
<h3>회원정보</h3>
<table border="1">
<tr>
   <td><strong>id</strong></td>
   <td><strong>pwd</strong></td>
   <td><strong>name</strong></td>
   <td><strong>gender</strong></td>
   <td><strong>birthday</strong></td>
   <td><strong>email</strong></td>
   <td><strong>zipcode/address</strong></td>
   <td><strong>hobby</strong></td>
   <td><strong>job</strong></td>
   <td><strong>회원관리</strong></td>	
</tr>
<%
	Vector <MemberBean> vlist = memMgr.getMemberList();
	int counter = vlist.size();
	for(int i=0; i<vlist.size(); i++){
		MemberBean regBean =vlist.get(i);
%>
<tr>
	<td><%=regBean.getId()%></td>
	<td><%=regBean.getPwd()%></td>
	<td><%=regBean.getName()%></td>
	<td><%=regBean.getGender()%></td>
	<td><%=regBean.getBirthday()%></td>
	<td><%=regBean.getEmail()%></td>
	<td>[<%=regBean.getZipcode()%>]<%=regBean.getAddress()%></td>
	<td><%=Arrays.toString(regBean.getHobby())%></td><%--출력에 신경 쓴 부분!!!! --%>
	<td><%=regBean.getJob()%></td>
	<td><a href="javascript:admin_update_member('<%=regBean.getId() %>')">수정하기</a>
	<a href="javascript:admin_delete_member('<%=regBean.getId() %>')">삭제하기</a></td>
</tr>
<%
   }
%>
</table>
<br/>
<br/>
total records : <%= counter %> 
</div>
<form action="memberManagement.jsp" name="adminUpdate" method="post">
		<input type="hidden" name="id">
</form>

<form action="memberdelete.jsp" name="adminDelete" method="post">
		<input type="hidden" name="id">
</form>

</body>
</html>