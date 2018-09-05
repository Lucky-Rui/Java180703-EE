<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="button" value="get方式访问服务器" onclick="ajaxGet()"/> <br/>
	<input type="button" value="post方式访问服务器" onclick="ajaxPost()"/> <br/>
	<script src="${pageContext.request.contextPath}/lib/jquery/jquery-1.11.1.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
		function ajaxGet() {
			//$.get(url, [data], [callback], [type])
			$.get(
				"${pageContext.request.contextPath}/ajax1", //url：代表请求的服务器端地址
				{"name":"zhangsanGet", "age":"20Get"}, //data：代表请求服务器端的数据
				function(data) { //callback：表示服务器端成功响应所触发的函数
					alert("name: " + data.name + ", age: " + data.age);
				},
				"json" //type：表示服务器端返回的数据类型
			);
		}
		function ajaxPost() {
			//$.get(url, [data], [callback], [type])
			$.post(
				"${pageContext.request.contextPath}/ajax1", //url：代表请求的服务器端地址
				{"name":"zhangsanPost", "age":"20Post"}, //data：代表请求服务器端的数据
				function(data) { //callback：表示服务器端成功响应所触发的函数
					alert("name: " + data.name + ", age: " + data.age);
				},
				"json" //type：表示服务器端返回的数据类型
			);
		}
	</script>
</body>
</html>