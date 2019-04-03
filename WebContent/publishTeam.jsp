<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-dojo-tags" prefix="sx" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<s:head theme="xhtml"/>
	<sx:head parseContent="true"/>
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
		
		<h2>创建小队</h2>
		
		<s:if test="#session.user == null">
                      登陆了吗？就想建队？
            <a href="index.jsp">喏~回主页的链接</a> 
		</s:if>
		<s:else>
			<h3> 当前活动 <s:property value="activity.name"/> </h3>
		
			<s:form action="publish_PublishTeam" method="post" accept-charset="UTF-8" theme="simple">
			
				<s:hidden name="activity.Id"></s:hidden>
			
				<div class="field">
					<s:textfield name="team.name" placeholder="队伍名称 "></s:textfield>
				</div>
				
				<div class="field">	
 					<s:textarea name="team.message" placeholder="队伍宣言/规则等"  rows="8"></s:textarea>
 				</div>
				
				<div class="field">
					<s:textfield name="team.QQ" placeholder="队伍Q群" ></s:textfield>
				</div>
				
				<div class="field">
					<div class="select-wrapper">
						<s:set name="list1" value="# {'1':'给看','0':'不给看'}"></s:set>
 						<s:select list="#list1" key="拒绝他人查看队伍详情？" listValue="value" name="team.visible" headerKey="1" headerValue="请选择队伍是否可见"></s:select>
 					</div>
				</div>
				
				<ul class="actions">
 					<li><s:submit key="button" value="提交"></s:submit></li>
 				</ul>
				
			</s:form>
		</s:else>
		<hr />
	</section>
</div>
</body>
</html>