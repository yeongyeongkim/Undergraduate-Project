<%@ page contentType="text/html;charset=EUC-KR" %>
<%@ page import="www.MemberBean"%>
<jsp:useBean id="mMgr" class="www.MemberMgr" />
<%
	String id = request.getParameter("id");
	  boolean result = mMgr.deleteMember(id);
	  if(result){
%>
<script type="text/javascript">
   		alert('�ش� ȸ���� Ż�� ó���Ǿ����ϴ�.');//��� �����ؼ� ȸ������ �����ϱ�
  
     	location.href="memberList.jsp";
</script>
<% }else{%>
<script type="text/javascript">
		alert("�ش� ȸ���� Ż�� ó���� ���� �Ͽ����ϴ�.");
		history.back();
</script>
<%} %>