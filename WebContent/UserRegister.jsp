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
		
		<h2>注册</h2>
			<s:form action="register_userRegister" method="post"  theme="simple">
				<div class="field">
					<s:textfield name="user.name" key="user.name" placeholder="用户名"></s:textfield>
				</div>
				<div class="field">
					<s:textfield name="user.pwd"  placeholder="密码"></s:textfield>
				</div>
				<div class="field">
					<s:textfield name="user.major" placeholder="专业"></s:textfield>
				</div>
				<div class="field">
					<div class="select-wrapper">
						<s:set name="list" value="# {'大一':'大一','大二':'大二','大三':'大三','大四':'大四'}"></s:set>
 						<s:select list="#list" listValue="value" name="user.grade" headerKey="保密" headerValue="--请选择你的年级--"></s:select>
					</div>
				</div>
				<div class="field">
					<s:textfield name="user.QQ"  placeholder="QQ"></s:textfield>
				</div>
				<div class="field">
					<s:textfield name="user.message"  placeholder="个性签名"></s:textfield>
				</div>
				<ul class="actions">
					<li><s:submit key="button" value="注册"></s:submit></li>
				</ul>
			</s:form>
		<hr />
	</section>
</div>

</body>
</html>