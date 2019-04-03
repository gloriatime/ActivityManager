<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<p>队伍   <s:property value="team.name"/>  的申请：</p>
	---------------------申请列表--------------------------
	<s:iterator  value="#session.appUserList" id="item">	
		
		<s:url id="checkUser_url" action="show_ShowUserInfo" >
 
   				<s:param name="user.ID">
 
    		  			<s:property value="ID"/>

  			 	</s:param>
 
		</s:url>
		<s:url id="yesUser_url" action="app_ChangeToRegular" >
 
   				<s:param name="user.ID">
 
    		  			<s:property value="ID"/>

  			 	</s:param>

		</s:url>
		<s:url id="noUser_url" action="app_ChangeToRefused" >
 
   				<s:param name="userTeam.user">
 
    		  			<s:property value="ID"/>

  			 	</s:param>
 				<s:param name="userTeam.team">
 				
  			 		<s:property value="team.Id"/>
  			 		
  			 	</s:param>
		</s:url>
		
		<p>申请人： <s:a href="%{checkUser_url}">  <s:property value="name"/></s:a> </p>
		<p> 
			<s:a href="%{yesUser_url}"> 同意  </s:a>  
			<s:a href="%{noUser_url}"> 拒绝  </s:a>
		</p>
		-------------------------------
	</s:iterator>
	
</body>
</html>