<%@ page contentType="text/html; charset=EUC-KR" %>

<%request.setCharacterEncoding("EUC-KR");%>

<jsp:useBean id="mMgr" class="www.MemberMgr"/>
<jsp:useBean id="mBean" class="www.MemberBean"/>
<jsp:setProperty  name="mBean" property="*"/>
<%
	  boolean result = mMgr.insertMember(mBean);
	  if(result){
%>
<script type="text/javascript">
		alert("ȸ�������� �Ͽ����ϴ�.");
		location.href="../main.jsp";
</script>
<% }else{%>
<script type="text/javascript">
		alert("ȸ�����Կ� ���� �Ͽ����ϴ�.");
		history.back();
</script>
<%} %>