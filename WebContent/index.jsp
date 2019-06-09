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
	
	<s:url id="showIndexPage_url" action="show_ShowActivity"></s:url>
	<a href="index.jsp" class="logo"><strong>东华活动站</strong> 开启你的快乐之行</a>
	
	<ul class="icons">
		<s:if test="#session.user == null">
            <li><a href="UserLogin.jsp" ><span class="label">登陆</span></a></li> 
		</s:if>
		<s:else>
			<li><span class="label">欢迎你，<s:property value="#session.user.name"/></span></li> 
		</s:else>
		<li><a href="UserRegister.jsp" ><span class="label">注册</span></a></li>
		<li><s:a href="%{showIndexPage_url}" ><span class="label">刷新</span></s:a></li>	
		<li><a href="AdminTest.jsp" ><span class="label">成为管理员</span></a></li>
		<s:if test="#session.user.isAdmin == 1">
			<s:url id="showAdminPage_url" action="admin_showAdminPage"></s:url>
			<li><s:a href="%{showAdminPage_url}" ><span class="label">站点统计信息</span></s:a></li>
		</s:if>
		<li><a href="publishAct.jsp"><span class="label">发布活动</span></a></li>
        <s:url id="showPersonalPage_url" action="show_ShowPersonalPage"></s:url>
		<li><s:a href="%{showPersonalPage_url}"><span class="label">我的账户</span></s:a></li>
	</ul>
</header>


<div  style="z-index: 9999; position: fixed ! important; right: 5px; bottom: 20px;">

	<table width="100%" style="position: absolute; width:260px; right: 0px; top: 0px;">
		<div class="features">
		<article>
			<a href="#top" id="backTopButton" style="text-decoration: none; color:rgba(0,0,0,0);"><span class="icon fa-diamond" id="backTopButton"></span></a>
		</article>
		</div>
	</table>

</div>


<!-- Banner -->
<p class="\-1u">活动有两种分类方式：按时间长短分类和按活动性质分类。前者分为长期活动和短期活动，后者则分为学习活动、体育活动、晚会活动、玩乐活动、其他活动。</p>
<!-- Section -->
<section id="top">
	<header class="major">
		<h2>活动分类简介</h2>
	</header>
	<div class="features">
		<article>
			<span class="icon fa-short-activity"></span>
			<div class="content">
				<a href="#short"><h3>短期活动</h3></a>
				<p>短期活动，活动时间一般在一月以内，时间短，一次性，过期不候。一般开展的活动基本都属于短期活动范围。</p>
			</div>
		</article>
		<article>
			<span class="icon fa-long-activity"></span>
			<div class="content">
				<a href="#long"><h3>长期活动</h3></a>
				<p>长期活动，活动时间维持在一月以上，时间长，随时参与。例如：社团招新，找课程搭档等</p>
			</div>
		</article>
		<article>
			<span class="icon fa-study-activity"></span>
			<div class="content">
				<a href="#study"><h3>学习活动</h3></a>
				<p>有关于学习的活动，都可以分为此类。例如：约人图书馆，约人教学楼，找课程搭档等</p>
			</div>
		</article>
		<article>
			<span class="icon fa-sport-activity"></span>
			<div class="content">
				<a href="#sport"><h3>体育活动</h3></a>
				<p>有关于运动的活动，都可以分为此类。例如：找人一起晨跑，约健身房，赢免跑单等。</p>
			</div>
		</article>
		<article>
			<span class="icon fa-party-activity"></span>
			<div class="content">
				<a href="#meet"><h3>晚会活动</h3></a>
				<p>使用了学校大礼堂、小礼厅等场地，具有聚众听讲性质的活动，分为此类。例如：大礼堂放电影，小礼堂讲相声等。</p>
			</div>
		</article>
		<article>
			<span class="icon fa-play-activity"></span>
			<div class="content">
				<a href="#play"><h3>玩耍活动</h3></a>
				<p>聚众娱乐性质的活动分为此类。例如：约人吃烧烤，约人购物，约人KTV等等。</p>
			</div>
		</article>
		<article>
			<span class="icon fa-other-activity"></span>
			<div class="content">
				<a href="#other"><h3>其他活动</h3></a>
				<p>以上类别不能满足发布者时，可以选择此类。比如：找女朋友等。</p>
			</div>
		</article>
										
	</div>
</section>
<!-- Section -->
<section>
	<header class="major">
    	<h2 id="short">有时间么？约一次！(短期活动)</h3>
    </header>
    <div class="posts">
   	
        
        <s:iterator  value="#session.isLong_1" id="item">
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

<!-- Section -->
<section>
	<header class="major">
    	<h2 id="long">看你顺眼，多玩一个月！(长期活动)</h3>
    </header>
    <div class="posts">
   	
        
        <s:iterator  value="#session.isLong_2" id="item">
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
<!-- Section -->
<section>
	<header class="major">
    	<h2 id="study">学霸~学吧~(学习活动)</h3>
    </header>
    <div class="posts">
   	
        
        <s:iterator  value="#session.class_1" id="item">
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

<!-- Section -->
<section>
	<header class="major">
    	<h2 id="sport">每天运动一小时，健康生活一辈子。(体育活动)</h3>
    </header>
    <div class="posts">
   	
        
        <s:iterator  value="#session.class_2" id="item">
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

<!-- Section -->
<section>
	<header class="major">
    	<h2 id="meet">锦绣会堂还是图文报告厅？(晚会活动)</h3>
    </header>
    <div class="posts">
   	
        
        <s:iterator  value="#session.class_3" id="item">
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

<!-- Section -->
<section>
	<header class="major">
    	<h2 id="play">嗨起来~！(玩乐活动)</h3>
    </header>
    <div class="posts">
   	
        
        <s:iterator  value="#session.class_4" id="item">
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

<!-- Section -->
<section>
	<header class="major">
    	<h2 id="other">前面没找到我想要的(其他活动)</h3>
    </header>
    <div class="posts">
   	
        
        <s:iterator  value="#session.class_5" id="item">
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

<div class="footer">
	<b>联系管理员 QQ：*******</b>
</div>
</body>
</html>