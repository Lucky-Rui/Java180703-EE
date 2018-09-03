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
		//四个域对象：pageContext、request、session、application
		//自动在四个域中搜索数据
		//pageContext.findAttribute("name");
		//顺序：page域->request域->session域->application域（context域）

		request.setAttribute("name", "zhangsan");
		session.setAttribute("name", "lisi");
		application.setAttribute("name", "wangwu");

		pageContext.setAttribute("age", 12);
		pageContext.setAttribute("age", 23, PageContext.SESSION_SCOPE);
		//等价于
		session.setAttribute("age", 23);

		//session.setAttribute("gender", "男");
		pageContext.setAttribute("gender", "男", PageContext.SESSION_SCOPE);
	%>

	<%=request.getAttribute("name")%>
	<%=session.getAttribute("name")%>
	<%=application.getAttribute("name")%>
	<br />
	<%=pageContext.getAttribute("name", PageContext.SESSION_SCOPE)%>
	<%=pageContext.getAttribute("name", PageContext.REQUEST_SCOPE)%>

	<br />
	<%=session.getAttribute("gender")%>
	<%=pageContext.getAttribute("gender", PageContext.SESSION_SCOPE)%>
	<%=pageContext.findAttribute("gender")%>
</body>
</html>