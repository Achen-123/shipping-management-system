<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>爱尚网扇品</title>
<link rel="stylesheet" rev="stylesheet" href="css/global.css" type="text/css" media="all" />
</head>
<body>

<tr align="center">
	 <td colspan="4">
		  第<s:property value="pageBean.page"/>/<s:property value="pageBean.totalPage"/>页     
		    <s:if test="pageBean.page!=1">
		       <a href="showProductAction.action?page=1">首页</a>|     
		       <a href="showProductAction.action?page=<s:property value="pageBean.page-1"/>">上一页</a>| 
		    </s:if>
		    <s:if test="pageBean.page!=pageBean.totalPage">
		       <a href="showProductAction.action?page=<s:property value="pageBean.page+1"/>">下一页</a>| 
		       <a href="showProductAction.action?page=<s:property value="pageBean.totalPage"/>">尾页</a>            
		    </s:if>
	 </td>
</tr>
</body>
</html>