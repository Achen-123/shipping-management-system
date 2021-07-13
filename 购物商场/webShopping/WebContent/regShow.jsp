<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" rev="stylesheet" href="css/global.css" type="text/css" media="all" />
</head>
<body>
	<div id="page">
		<div id="header">
			<jsp:include page="header.jsp" />      
       	</div>
       	
       	<div id="div_reg">
       		<h3>注册成功</h3><br>
       		<hr size=1>  
			<table align="center">
				<tr>
					<td>username:</td>
					<td><s:property value="#request.userinfo.username"/></td>
				</tr>  
				<tr>
					<td>password:</td>
					<td><s:property value="#request.userinfo.pwd"/></td>
				</tr>
				<tr>
					<td>sex:</td>
					<td><s:property value="#request.userinfo.sex"/></td>
				</tr>
				<tr>
					<td>hobby:</td>
					<td><s:property value="#request.userinfo.hobby"/></td>
				</tr>
			</table>
        </div>

       	<div id="footer">
			<jsp:include page="bottom.jsp" />  
		</div>
	</div>	
</body>
</html>