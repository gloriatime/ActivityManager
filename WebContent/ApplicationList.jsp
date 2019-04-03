<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>东华活动站</title>
        <link rel="stylesheet" type="text/css" href="css/main.css" />
</head>

<body>

<header id="header">
	<a href="index.jsp" class="logo"><strong>东华活动站</strong> 开启你的快乐之行</a>
	<ul class="icons">
		<li><a href="UserLogin.jsp" ><span class="label">登陆</span></a></li>
		<li><a href="UserRegister.jsp" ><span class="label">注册</span></a></li>
		<li><a href="AdminTest.jsp" ><span class="label">成为管理员</span></a></li>
		<li><a href="publishAct.jsp"><span class="label">发布活动</span></a></li>
        <s:url id="showPersonalPage_url" action="show_ShowPersonalPage"></s:url>
		<li><s:a href="%{showPersonalPage_url}"><span class="label">我的账户</span></s:a></li>
	</ul>
</header>

<section>

	<header class="main">
		<h1> </h1>
		<h1><s:property value="team.name"/> 的申请</h1>
	</header>
	
	<hr class="major"/>
	
	<div class="posts">
	
		<s:iterator  value="#session.appUserList" id="item">	
		
		<s:url id="checkUser_url" action="show_ShowUserInfo" >
 
   				<s:param name="user.Id">
 
    		  			<s:property value="Id"/>

  			 	</s:param>
 
		</s:url>
		<s:url id="yesUser_url" action="app_ChangeToRegular" >
 
   				<s:param name="user.Id">
 
    		  			<s:property value="Id"/>

  			 	</s:param>

		</s:url>
		<s:url id="noUser_url" action="app_ChangeToRefused" >
 
   				<s:param name="userTeam.user">
 
    		  			<s:property value="Id"/>

  			 	</s:param>
 				<s:param name="userTeam.team">
 				
  			 		<s:property value="team.Id"/>
  			 		
  			 	</s:param>
		</s:url>
		
		<article>
			<p>申请人： <s:a href="%{checkUser_url}">  <s:property value="name"/></s:a> </p>
			<p> 
				<s:a href="%{yesUser_url}" cssClass="special"> 同意  </s:a>  
				<s:a href="%{noUser_url}" cssClass="special"> 拒绝  </s:a>
			</p>
		</article>

		</s:iterator>
	
	</div>
	
</section>
	
</body>
</html>