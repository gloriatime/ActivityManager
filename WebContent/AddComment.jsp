<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>东华活动站</title>
		<link rel="stylesheet" type="text/css" href="css/sign.css" />
</head>

<body>

<div id="wrapper">

	<section id="main">
    	<header>
				<h1>东华活动站</h1>
				<p>开启你的快乐之行</p>
		</header>
		
		<h2>评论</h2>
		
		<s:if test="#session.user == null">
                      登陆了吗？就想评论？
            <a href="index.jsp">喏~回主页的链接</a> 
		</s:if>
		<s:else>
		
		<p>当前活动：<s:property value="activity.name"/></p>
		
			<s:form action="comment_AddComment" method="post" theme="simple">
				<div class="field">
					<s:textarea name="comment.content"  rows="6" placeHolder="评论内容"></s:textarea>
				</div>
					<s:hidden name="activity.Id"></s:hidden>
				<ul>
					<s:submit value="发表"></s:submit>
				</ul>
				
			</s:form>
		<hr />
		
		</s:else>
	</section>
</div>

</body>
</html>