<%@ page contentType="text/html; charset=EUC-KR" %>
<jsp:useBean id="mMgr" class="www.MemberMgr"/>
<%
	  request.setCharacterEncoding("EUC-KR");
	  String cPath = request.getContextPath();
	  String id = request.getParameter("id");
	  String pass = request.getParameter("pwd");
	  String url = cPath+"/www/left.jsp";//������ �ٲٸ� �� ��!!
	  String msg = "�α��ο� ���� �Ͽ����ϴ�.";
	  
	  boolean result = mMgr.loginMember(id,pass);//ctrl���� ��ũ ������ loginMember�� �Ѿ
	  //boolean admin = mMgr.admin_login(id,pass);
	  //if(admin){
		    //session.setAttribute("idKey",id);
		   // msg = "������ �α��ο� ���� �Ͽ����ϴ�.";
		 // }
	  //else 
		  if(result){
	    session.setAttribute("idKey",id);
	    msg = "�α��ο� ���� �Ͽ����ϴ�.";
	  }//�� Ÿ�� Ʈ�� ������ ���� �Ҵ� ����!!
%>
<script>
	alert("<%=msg%>");//â���� ���ٰ�!!
	top.document.location.reload(); 
	location.href="<%=url%>";
</script>