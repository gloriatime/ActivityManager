<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-dojo-tags" prefix="sx" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head theme="xhtml"/>
<sx:head parseContent="true"/>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>Insert title here</title>
</head>

<body>
	<!--<a href="ModifyInfo.jsp">修改个人信息</a>-->
	<div>
	
			<s:iterator  value="#session.user" id="item">

				<p>我的名称：<s:property value="name"/></p>
			
			</s:iterator>

	</div>
	<div>
		--------------------------我发布的活动----------------------
			<s:iterator  value="#session.MyActivity" id="item">

				<p>
					
					<s:url id="checkAct_url" action="show_ShowActInfo" >
 
   							<s:param name="activity.Id">
 
    		  					<s:property value="Id"/>

  			 				</s:param>
 
					</s:url>

					<s:a href="%{checkAct_url}">  <s:property value="name"/>    <s:property value="begin"/>  </s:a>
				</p>
			
			</s:iterator>

	</div>
	<div>
		--------------------------我参加的组队----------------------
	<s:iterator  value="#session.teamList" id="item">
		<p>队伍名称： <s:property value="name"/></p>	
			队伍宣言：<s:property value="message"/><br/><br/>
	
			队伍QQ群：<s:property value="QQ"/><br/><br/>
	
			队伍人数：<s:property value="memberNum"/><br/><br/>
	
			队伍状态：
			<s:if test="team.state==0">
				招聘人员。。。
			</s:if>
			<s:else>
				满员了~
			</s:else>
			
		<s:url id="checkAppList_url" action="app_ShowAppList" >
 
   				<s:param name="team.Id">
 
    		  			<s:property value="Id"/>

  			 	</s:param>
 
		</s:url>
		
		<p>  <s:a href="%{checkAppList_url}"> 查看申请列表  </s:a>  </p>
		
		<br/><br/>--------------------------------	
	</s:iterator>
	
	<br/><br/>
	--------------------------我申请的组队----------------------
	<s:iterator  value="#session.appTeamList" id="item">
		<p>队伍名称： <s:property value="name"/></p>	
		--------------------------------	
	</s:iterator>
	
	<br/><br/>
	--------------------------被拒绝的组队----------------------
	<s:iterator  value="#session.failTeamList" id="item">
		<p>队伍名称： <s:property value="name"/></p>	
		-------------------------------
	</s:iterator>
	
	</div>
</body>
</html>