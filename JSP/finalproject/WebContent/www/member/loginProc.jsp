<%@ page contentType="text/html; charset=EUC-KR" %>
<jsp:useBean id="mMgr" class="www.MemberMgr"/>
<%
	  request.setCharacterEncoding("EUC-KR");
	  String cPath = request.getContextPath();
	  String id = request.getParameter("id");
	  String pass = request.getParameter("pwd");
	  String url = cPath+"/www/left.jsp";//폴더명 바꾸면 안 됨!!
	  String msg = "로그인에 실패 하였습니다.";
	  
	  boolean result = mMgr.loginMember(id,pass);//ctrl으로 링크 누르면 loginMember로 넘어감
	  //boolean admin = mMgr.admin_login(id,pass);
	  //if(admin){
		    //session.setAttribute("idKey",id);
		   // msg = "관리자 로그인에 성공 하였습니다.";
		 // }
	  //else 
		  if(result){
	    session.setAttribute("idKey",id);
	    msg = "로그인에 성공 하였습니다.";
	  }//불 타입 트루 받으면 세션 할당 받음!!
%>
<script>
	alert("<%=msg%>");//창으로 띄운다고!!
	top.document.location.reload(); 
	location.href="<%=url%>";
</script>