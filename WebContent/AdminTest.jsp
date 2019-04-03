<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>东华活动站</title>
		<link rel="stylesheet" type="text/css" href="css/adminTest.css" />
</head>

<body>

<div id="wrapper">

	<section id="main">
    	<header>
				<h1>东华活动站</h1>
				<p>开启你的更加快乐之行</p>
		</header>
		
		<h2>成为管理员测试</h2>
			<s:if test="#session.user == null">
            	登陆了吗？就想成为管理员？ <a href="index.jsp">喏~回主页的链接</a> 
			</s:if>
			<s:else>
				<s:form  action="app_AdminTest" method="post" theme="simple">
					<div class="field">
						<label>1.请回答巴拉巴拉巴拉：</label>
						<s:set name="list" value="# {'1':'这个是对的	','2':'这个是错的','3':'这个是错的','4':'这个是错的'}"></s:set>
						<s:radio list="#list" name="answer.first"></s:radio>
					</div>
					<div class="field">
	 					<label>2.请回答巴拉巴拉巴拉：</label>
	 					<s:radio list="#list" name="answer.second"></s:radio>
	 				</div>
	 				<div class="field">
	 					<label>3.请回答巴拉巴拉巴拉：</label>
	 					<s:radio list="#list" name="answer.third"></s:radio>
	 				</div>
	 				<ul class="actions">
						<li><s:submit value="提交试卷"></s:submit></li>
					</ul>
				</s:form> 
			</s:else>
		<hr />
	</section>
</div>

</body>
</html>