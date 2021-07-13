<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>爱尚网扇品</title>
<link rel="stylesheet" rev="stylesheet" href="css/global.css" type="text/css" media="all" />
</head>
<body>
	
	<div id="page">
		<div id="header">
			<jsp:include page="header.jsp" />      
       	</div>
			
		<div id="left_column">
			<jsp:include page="left_column.jsp" />  
		</div>
			
		<div id="center_column">		
			<div class="divBorder">
				<img src="images/all_fans.gif" /><br>
			
			
			<s:iterator value="#request.listProduct">
				<div id='sort_product'>
					<ul>
						<li><p class='gpic'><a href='showProductDetailAction.action?id=<s:property value="id"/>'><img width='205' height='154' src="<s:property value="img"/>"></a></p></li> 
						<li><p class='gbt'><a href='showProductDetailAction.action?id=<s:property value="id"/>'><s:property value="name"/> </a></p></li>
						<li><p class='gprice'>促销价：<span style="color:#FF6600;font-weight:bold;"></span>￥<s:property value="price"/>元</p></li>
						<li><p class='gsale'>已售出：<span style='font-weight:bold;'><s:property value="sale"/></span>&nbsp;笔</p></li>
					</ul>
				</div>
			</s:iterator>	
				
			<%-- <div id="page">
				<jsp:include page="page.jsp" />  
			</div> --%>
			</div>	
				
				<div id='page_next'><a class="pageLink" href="">上一页</a>&nbsp;<a class="pageLink" href="">下一页</a>&nbsp;</div>   	
			</div>
					
		<div id="footer">
			<jsp:include page="bottom.jsp" />  
		</div>
		
	</div>
</body>
</html>