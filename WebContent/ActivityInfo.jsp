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
		<h1><s:property value="activity.name"/></h1>
	</header>
	
	<span class="image right">

					<s:if test="activity.img!=null">
						<img src="image/${activity.img}" alt="" height="300" width="450"/>
					</s:if>
					<s:else>
						<img src="img/bg.jpg" alt="" />
					</s:else>

	</span>
	
	<dl>
		<dt>发布人：</dt>
		<dd><p><s:property value="user.name"/></p></dd>
		<dt>活动类别：</dt>
		<dd>
			<s:if test="activity.name==1">
				<p>学习类</p>
			</s:if>
			<s:elseif test="activity.name==2">
				<p>运动类</p>
			</s:elseif>
			<s:elseif test="activity.name==3">
				<p>晚会类</p>
			</s:elseif>
			<s:elseif test="activity.name==4">
				<p>玩耍类</p>
			</s:elseif>
			<s:else>
				<p>其他</p>
			</s:else>
		</dd>
		<dt>活动时长：</dt>
		<dd>
			<s:if test="activity.isLong==1">
				<p>活动时长：短期</p>
			</s:if>
			<s:else>
				<p>活动时长：长期</p>
			</s:else>
		</dd>
		<dt>开始日期：</dt>
		<dd><s:property value="activity.begin"/></dd>
		<dt>结束日期：</dt>
		<dd><s:property value="activity.end"/></dd>
	</dl>
	
	<hr class="major" />
	
	<h2>活动介绍</h2>
	<p><s:property value="activity.content"/></p>
	
	<s:if test="activity.warning==null">
	</s:if>
	<s:else>
		<hr class="major" />
		<h2>管理员留言</h2>
		<p><s:property value="activity.warning"/></p>
	</s:else>
	
	<s:url id="showComments_url" action="comment_ShowComments"> 			
   		<s:param name="activity.Id">
    		  <s:property value="activity.Id"/>
  		</s:param>
	</s:url>
	<s:url id="showTeams_url" action="show_ShowActInfo"> 			
   		<s:param name="activity.Id">
    		  <s:property value="activity.Id"/>
  		</s:param>
	</s:url>
	

	<hr class="major" />
	<ul class="actions fit">
		<li><s:a href="%{showTeams_url}" cssClass="button special fit">小队 (<s:property value="activity.teamNum"/>) </s:a></li>
		<li><s:a href="%{showComments_url}" cssClass="button fit">评论 (<s:property value="activity.commentNum"/>)</s:a></li>
	</ul>
	
	<s:url id="showTeamForm_url" action="show_ShowTeamForm"> 			
   		<s:param name="activity.Id">
    		  <s:property value="activity.Id"/>
  		</s:param>
	</s:url>
	<s:url id="showCommentForm_url" action="show_ShowCommentForm" >
   		<s:param name="activity.Id">
    		<s:property value="Id"/>
  		</s:param>
	</s:url>
	
	<ul class="actions fit">
		<li><s:a href="%{showTeamForm_url}" cssClass="button fit">创建小队</s:a></li>
		<li><s:a href="%{showCommentForm_url}" cssClass="button special fit">发表评论</s:a></li>
	</ul>
	
	 <div class="posts">
	
	<s:iterator  value="#session.teamList" id="item">
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
	
	<div class="posts">
	
	<s:iterator  value="#session.commentList" id="item">
	<article>
	<div class="box">
		<h3> <s:property value="critic_user.name"/> </h3>
		
			<p> <s:property value="content"/></p>
			<p> <s:property value="date"/> </p>
			
	</div>
	</article>
	
	</s:iterator>
	
	</div>
	
	<s:if test="#session.user.isAdmin == 1">
	
		<hr class="major" />
		<h3>管理员好~ </h3>
		<s:form action="publish_PublishWarning">
		
		
		<div class="12u$">
			<p>这个活动有问题的话就在这里留言警告吧~</p>
			<s:textarea name="activity.warning" rows="6" placeHolder="这个活动有问题的话就在这里留言警告吧~"></s:textarea>
		</div>
	
		<div class="12u$">
			<p id="change_content">如果内容介绍中有和谐词也请尽情删除吧~</p>
			<s:textarea name="activity.content" rows="6"></s:textarea>
		</div>
		
		<s:hidden name="activity.Id"></s:hidden>
		
		<div class="12u$">
			<ul class="actions">
				<li><s:submit value="提交管理员神圣的审判"  cssClass="special" id="submit_button"></s:submit></li>
			</ul>
		</div>
			
		</s:form>
	</s:if>
	
	
</section>
</body>
</html>