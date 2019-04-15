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
		<h1 id="big_title"><s:property value="team.name"/></h1>
	</header>
	
	<div class="row 200%">
	
	<div class="6u 12u$(medium)">
		<div class="row">
			<div class="6u 12u$(small)">
		
				<h4>小队基本信息</h4>
				<ul class="alt">
					<li>队伍名称：<s:property value="team.name"/></li>
					<li>队伍QQ群：<s:property value="team.QQ"/></li>
					<li>队伍人数：<s:property value="team.memberNum"/></li>
					<li>
					队伍状态：
					<s:if test="team.state==0">
					招聘人员。。。
					</s:if>
					<s:else>
					满员了~
					</s:else>
					</li>
				</ul>
		
			</div>
		</div>
	</div>
	
	<div class="6u$ 12u$(medium)">
		<div class="box">
			<h3>队伍宣言</h3>
			<p><s:property value="team.message"/></p>
		</div>
	</div>
	
	</div>
	
	 <hr class="major" />
	
	<h3>队伍动态 </h3>
	
	<div class="posts">
	
	<s:iterator  value="#session.teamCommentList" id="item">
	<article>
	<div class="box">
		<h3> <s:property value="date"/> </h3>
		
			<p> <s:property value="content"/></p>
			
	</div>
	</article>
	
	</s:iterator>
	
	</div>
	
	<hr class="major" />
	
	<!-- 如果不是队员显示申请框，如果是队员显示发表动态框 -->
	<s:if test="#session.IsTeamMember == true">
         <h3>发表动态 </h3>
	
		<s:form action="comment_AddTeamComment">
		<s:hidden name="team.Id"></s:hidden>
		<div class="12u$">
			<s:textarea name="teamComment.content" rows="6" placeHolder="动态内容（提示：注意需要先登陆，否则跳转到出错提示后编辑的东西都没了哟~）"></s:textarea>
		</div>
		
		<ul class="actions">
			<li><s:submit value="发表"  cssClass="special" id="submit_button"></s:submit></li>
		</ul>
		
		</s:form>
	</s:if>
	<s:else>
		<h3>加入小队 </h3>
	
		<s:form action="app_AddApplication">
	
		<div class="12u$">
			<s:textarea name="applicationForm.content" rows="6" placeHolder="申请信息（提示：注意需要先登陆，否则跳转到出错提示后编辑的东西都没了哟~）"></s:textarea>
			<s:hidden name="team.Id"></s:hidden>
		</div>
		
		<ul class="actions">
			<li><s:submit value="申请加入"  cssClass="special" id="submit_button"></s:submit></li>
		</ul>
		
		</s:form>
	</s:else>
	
	<!--<h3>发表动态 </h3>
	
	<s:form action="comment_AddTeamComment">
		<s:hidden name="team.Id"></s:hidden>
		<div class="12u$">
			<s:textarea name="teamComment.content" rows="6" placeHolder="动态内容（提示：注意需要先登陆，否则跳转到出错提示后编辑的东西都没了哟~）"></s:textarea>
		</div>
		
		<ul class="actions">
			<li><s:submit value="发表"  cssClass="special" id="submit_button"></s:submit></li>
		</ul>
		
	</s:form>
	
	<hr class="major" />
	
	<h3>加入小队 </h3>-->
	
	<!--<s:url id="showApplicationForm_url" action="app_AddApplication">
 
   			
   			<s:param name="team.Id">
 
    		  	<s:property value="team.Id"/>

  			</s:param>
 
	</s:url>
	<s:a href="%{showApplicationForm_url}"> ~申请加入 ~</s:a>-->
	
	<!--<s:form action="app_AddApplication">
	
		<div class="12u$">
			<s:textarea name="applicationForm.content" rows="6" placeHolder="申请信息（提示：注意需要先登陆，否则跳转到出错提示后编辑的东西都没了哟~）"></s:textarea>
			<s:hidden name="team.Id"></s:hidden>
		</div>
		
		<ul class="actions">
			<li><s:submit value="申请加入"  cssClass="special" id="submit_button"></s:submit></li>
		</ul>
		
	</s:form>-->
	
</section>

</body>
</html>