<%@page import="com.situ.student.entity.BanJi"%>
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
		BanJi banji = (BanJi)request.getAttribute("banji");
	%>
	<form action="${pageContext.request.contextPath}/banji?method=update"
		method="post">
		<input type="hidden" name="id" value="${banji.id}" /><br /> 班级：<input
			type="text" name="name" value="${banji.name}" /><br /> <input
			type="submit" value="保存" /> <input type="reset" value="重置" />
	</form>
</body>
</html>