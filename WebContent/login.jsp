<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/user?method=login" method="post">
		用户名:<input type="text" name="name"/><br/>
		密码:<input type="password" name="password"/><br/>
		验证码：<input type="text" name="checkCode"/><br>
		<img id="codeImg" alt="" src="${pageContext.request.contextPath}/checkImg" onclick="refreshCode()"><br>
		<input type="submit" value="登录"/>
	</form>
	<script type="text/javascript" src="lib/jquery/jquery-1.11.1.js"></script>
	<script type="text/javascript">
	function refreshCode() {
		$("#codeImg").attr("src", "${pageContext.request.contextPath}/checkImg?"+Math.random());
	}
	</script>
</body>
</html>