<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-dojo-tags" prefix="sx" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<script language="JavaScript" type="text/javascript">
dojo.require("dojo.widget.DateTimePicker");

function setStyle(id)
{
    document.getElementById(id).childNodes(1).style.width = "30.7em";
}
 
 
dojo.addOnLoad(function(){
        setStyle("begin");
        setStyle("end");
});
</script>

<head>
	<s:head theme="xhtml"/>
	<sx:head/>
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
		
		<h2>发布活动</h2>
		
		<s:if test="#session.user == null">
                      登陆了吗？就想发活动？
            <a href="index.jsp">喏~回主页的链接</a> 
		</s:if>
		<s:else>
			<s:form action="publish_PublishAct" method="post" accept-charset="UTF-8"  enctype="multipart/form-data" theme="simple">
				<div class="field">
					<s:textfield name="activity.name" placeholder="活动名称" lable=""></s:textfield>
				</div>
				<div class="field">
					<div class="select-wrapper">
					<s:set name="list2" value="# {'1':'学习类','2':'体育类','3':'晚会类','4':'玩耍','5':'其他'}"></s:set>
 					<s:select list="#list2" placeholder="活动分类" listValue="value" name="activity.classes" headerKey="5" headerValue="请选择活动类别"></s:select>
					</div>
				</div>
				<div class="field">
					<div class="select-wrapper">
					<s:set name="list1" value="# {'1':'短期','2':'长期'}"></s:set>
 					<s:select list="#list1" placeholder="活动时长" listValue="value" name="activity.isLong" headerKey="1" headerValue="请选择活动时长"></s:select>
					</div>
				</div>
				<div class="field">
					<p>活动开始日期</p>
 					<sx:datetimepicker name="activity.begin" displayFormat="yyyy-MM-dd" id="begin"/>
 				</div>
 				<div class="field">
 					<p>活动结束日期</p>
 					<sx:datetimepicker name="activity.end" displayFormat="yyyy-MM-dd" id="end" />
 				</div>
 				<div class="field">	
 					<s:textarea name="activity.content" placeholder="活动介绍" lable="" rows="8"></s:textarea>
 				</div>
 				<div class="field">
 					<p>选择活动宣传图</p>
 					<s:file name="activity.image" accept="image/*"></s:file>
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
