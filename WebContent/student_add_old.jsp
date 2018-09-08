<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增学生信息</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/student?method=insert"
		method="post">
		姓名：<input type="text" name="name" /><br> 年龄：<input type="text"
			name="age" /><br> 性别：<input type="text" name="gender" /><br>
		<input type="submit" value="添加" /> <input type="reset" value="重置" />
	</form>
</body>
</html>