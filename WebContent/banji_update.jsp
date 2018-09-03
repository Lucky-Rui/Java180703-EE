<%@page import="com.situ.weekend07.banji.entity.BanJi"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		BanJi banJi = (BanJi)request.getAttribute("banJi");
	%>
	<form action="<%=request.getContextPath()%>/banJi?method=update" method="post">
		<input type="hidden" name="id" value="${banJi.classId}"/><br/>
		班级：<input type="text" name="className" value="${banJi.className}"/><br/>
		<input type="submit" value="保存"/>
		<input type="reset" value="重置"/>
	</form>
</body>
</html>