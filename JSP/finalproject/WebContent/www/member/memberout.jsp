<%@ page contentType="text/html; charset=EUC-KR"%>
<jsp:useBean id="mMgr" class="www.MemberMgr"/>
<%
	  String id = (String)session.getAttribute("idKey");
	  boolean result = mMgr.deleteMember(id);
	  if(result){
%>
<script type="text/javascript">
   		alert('Ż�� �Ǿ����ϴ�.');//��� �����ؼ� ȸ������ �����ϱ�
  <%
        session.invalidate();
  %>
   	 	top.document.location.reload(); 
     	location.href="<%=request.getContextPath()%>/www/left.jsp";
</script>
<% }else{%>
<script type="text/javascript">
		alert("Ż�� ���� �Ͽ����ϴ�.");
		history.back();
</script>
<%} %>


  
   