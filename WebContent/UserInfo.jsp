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
		<s:if test="#session.user == null">
            <li><a href="UserLogin.jsp" ><span class="label">登陆</span></a></li> 
		</s:if>
		<s:else>
			<li><span class="label">欢迎你，<s:property value="#session.user.name"/></span></li> 
		</s:else>
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
		<h1 id="big_title"><s:property value="user.name"/></h1>
	</header>
	
	<div class="row 200%">
	
	<div class="6u 12u$(medium)">
		<div class="row">
			<div class="6u 12u$(small)">
		
				<h4>个人基本信息</h4>
				<ul class="alt">
					<li>年级：<s:property value="user.grade"/></li>
					<li>专业：<s:property value="user.major"/></li>
					<li>QQ：<s:property value="user.QQ"/></li>
				</ul>
		
			</div>
		</div>
	</div>
	
	<div class="6u$ 12u$(medium)">
		<div class="box">
			<h3>个人宣言</h3>
			<p><s:property value="user.message"/></p>
		</div>
	</div>
	
	</div>
	
	<hr class="major" />
	
	<h2>ta参与的小队</h2>
	
	 <div class="posts">
	 	<s:iterator  value="user.teamList" id="item">
			<article>
				<div class="box">
					<h3> <s:property value="name"/> </h3>
		
					<p>队伍宣言： <s:property value="message"/></p>
					<p>队伍状态 
		
					<s:if test="state == 0">
					招聘队员中。。。
					</s:if>
					<s:else>
					不好意思，我们满员了。O(∩_∩)O
					</s:else>
		
					</p>
		
					<s:if test="visible == 1">
			
					<p>
					<s:url id="checkTeam_url" action="show_ShowTeamInfo" >
 
   							<s:param name="team.Id">
 
    		  					<s:property value="Id"/>

  			 				</s:param>
 
					</s:url>

					<s:a href="%{checkTeam_url}" cssClass="button"> 查看队伍详细信息 </s:a>
					</p>
					</s:if>
				</div>
			</article>
	
		</s:iterator>
	</div>
	
</section>

</body>
</html>