<%@page import="com.situ.student.entity.PageBean"%>
<%@page import="com.situ.student.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改学生信息</title>
</head>
<body>
	<%
		Student student = (Student)request.getAttribute("student");
		//PageBean pageBean = (PageBean) request.getAttribute("pageBean");
	%>
	<form action="<%=request.getContextPath() %>/student?method=update"
		method="post">
		<input type="hidden" name="id" value="${student.id}" /> 
		姓名：<input
			type="text" name="name" value="${student.name}" /><br> 
		年龄：<input
			type="text" name="age" value="${student.age}" /><br>
		性别：<input
			type="text" name="gender" value="${student.gender}" /><br> 
		<input type="submit" value="修改" /> <input type="reset" value="重置" />
	</form>
</body>
</html>