<%@ page contentType="text/html;charset=EUC-KR" %>
<%@ page import="www.MemberBean"%>
<jsp:useBean id="mMgr" class="www.MemberMgr" />
<%
	String id = request.getParameter("id");
	  boolean result = mMgr.deleteMember(id);
	  if(result){
%>
<script type="text/javascript">
   		alert('해당 회원이 탈퇴 처리되었습니다.');//디비 연동해서 회원정보 삭제하기
  
     	location.href="memberList.jsp";
</script>
<% }else{%>
<script type="text/javascript">
		alert("해당 회원이 탈퇴 처리에 실패 하였습니다.");
		history.back();
</script>
<%} %>