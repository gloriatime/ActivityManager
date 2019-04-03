<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	申请人：<s:property value="user.name"/><br/><br/>
	
	年级：
	<s:if test="detail.grade==0">
		不给看
	</s:if>
	<s:elseif test="detail.grade==1">
		大一
	</s:elseif>
	<s:elseif test="detail.grade==2">
		大二
	</s:elseif>
	<s:elseif test="detail.grade==3">
		大三
	</s:elseif>
	<s:elseif test="detail.grade==4">
		大四
	</s:elseif>
	
	<br/><br/>
	
	专业：<s:property value="detail.major"/><br/><br/>
	
	个性签名：<s:property value="detail.message"/><br/><br/>
	
	QQ：<s:property value="detail.QQ"/><br/><br/>
	
	
</body>
</html>