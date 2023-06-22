<%@ page contentType="text/html; charset=EUC-KR"%>
<jsp:useBean id="mMgr" class="www.MemberMgr"/>
<%
	  String id = (String)session.getAttribute("idKey");
	  boolean result = mMgr.deleteMember(id);
	  if(result){
%>
<script type="text/javascript">
   		alert('탈퇴 되었습니다.');//디비 연동해서 회원정보 삭제하기
  <%
        session.invalidate();
  %>
   	 	top.document.location.reload(); 
     	location.href="<%=request.getContextPath()%>/www/left.jsp";
</script>
<% }else{%>
<script type="text/javascript">
		alert("탈퇴에 실패 하였습니다.");
		history.back();
</script>
<%} %>


  
   