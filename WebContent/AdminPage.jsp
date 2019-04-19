<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-dojo-tags" prefix="sx" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>

<%@page import="service.imp.ActivityServiceImp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>东华活动站</title>
		<link rel="stylesheet" type="text/css" href="css/head.css" />
        <link rel="stylesheet" type="text/css" href="css/main.css" />
	</head>

	<body>

		<form action="show_ShowActivity" method="post" id="load"></form>
		<s:if test="#session.loading != 5">
            <script>
                window.onload = function () {
                    document.getElementById("load").submit();
                }
            </script>
		</s:if>


<header id="header">
	<a href="index.jsp" class="logo"><strong>东华活动站</strong> 开启你的快乐之行</a>
	<ul class="icons">
		<li><a href="UserLogin.jsp" ><span class="label">登陆</span></a></li>
		<li><a href="UserRegister.jsp" ><span class="label">注册</span></a></li>
		<li><a href="AdminTest.jsp" ><span class="label">成为管理员</span></a></li>
		<s:if test="#session.user.isAdmin == 1">
			<li><a href="AdminPage.jsp" ><span class="label">站点统计信息</span></a></li>
		</s:if>
		<li><a href="publishAct.jsp"><span class="label">发布活动</span></a></li>
        <s:url id="showPersonalPage_url" action="show_ShowPersonalPage"></s:url>
		<li><s:a href="%{showPersonalPage_url}"><span class="label">我的账户</span></s:a></li>
	</ul>
</header>

<!-- Banner -->
<p class="\-1u">管理员，你好。  谢谢你为活动站做出的一切贡献！🙇</p>

<section>
	<header class="main">
		<h1> </h1>
		<h1>站点统计信息</h1>
	</header>
	
	<div class="row">
		<div class="4u 12u$(medium)">
			<h3>用户</h3>
			<p> 到目前为止，活动站共有注册账号<strong> <s:property value="adminPage.count_user"/> </strong>个。</p>
		</div>
		<div class="4u 12u$(medium)">
			<h3>小队</h3>
			<p> 到目前为止，活动站共有小队<strong> <s:property value="adminPage.count_team"/> </strong>个。 </p>
		</div>
		<div class="4u 12u$(medium)">
			<h3>活动</h3>
			<p> 到目前为止，活动站共有活动<strong> <s:property value="adminPage.count_act"/> </strong>个。</p>
		</div>
	</div>
	
	<hr class="major" />
	
	<div class="row">
		<div class="6u 12u$(small)">
			<h3>本周新增评论</h3>
			<ol>
				<s:iterator value="adminPage.new_comment_in_this_week">
					<li> <s:property value="content"/> </li>
				</s:iterator>
			</ol>
		</div>
		
		<div class="6u$ 12u$(small)">
			<h3>已有警告活动</h3>
			<ol>
				<s:iterator value="adminPage.act_have_warning" id="item">
					<s:url id="checkAct_url" action="show_ShowActInfo" >
   					<s:param name="activity.Id">
    		  			<s:property value="Id"/>
  			 		</s:param>
					</s:url>
					<li> <s:a href="%{checkAct_url}"> <s:property value="name"/> </s:a>  </li>
				</s:iterator>
			</ol>
		</div>
	</div>
	
	<hr class="major" />
	<h2>本周开始活动，请管理员认真审查</h2>
	
	<div class="posts">
   	
        
        <s:iterator  value="adminPage.act_begin_in_this_week" id="item">
        	<article>
			
				<s:url id="checkAct_url" action="show_ShowActInfo" >
   					<s:param name="activity.Id">
    		  			<s:property value="Id"/>
  			 		</s:param>
				</s:url>
					
				<s:a href="%{checkAct_url}" cssClass="image">
					<s:if test="img!=null">
						<img src="image/${img}" alt="" />
					</s:if>
					<s:else>
						<img src="img/bg.jpg" alt="" />
					</s:else>
				</s:a>
            	<h3> <s:property value="name"/> </h3>
				<p> 开始时间：<s:property value="begin"/> </p>
                <p> 结束时间：<s:property value="end"/> </p>
				<ul class="actions">
					<li><s:a href="%{checkAct_url}" cssClass="button">查看更多</s:a></li>
				</ul>
			</article>
                		
		</s:iterator>
            		
     </div>
	
</section>

</body>
</html>