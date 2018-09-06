<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="button" value="get方式访问服务器" onclick="ajaxGet()" />
	<br />
	<input type="button" value="post方式访问服务器" onclick="ajaxPost()" />
	<br />
	<input type="button" value="ajax方式访问服务器" onclick="ajax()" />
	<br />
	<script
		src="${pageContext.request.contextPath}/lib/jquery/jquery-1.11.1.js"
		type="text/javascript" charset="utf-8"></script>
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
		function ajax() {
			//$.ajax( { option1:value1,option2:value2... } ); 
			$.ajax({
				async : true, //async：是否异步，默认是true代表异步。
				data : {"name":"zhangsan", "age":20}, //data：发送到服务器的参数，建议使用json格式
				dataType : "json", //dataType：服务器端返回的数据类型，常用text和json
				success : function(data) {//success：成功响应执行的函数，对应的类型是function类型
					alert("name: " + data.name + ", age: " + data.age);
				},
				type : "GET", //type：请求方式，POST/GET
				url : "${pageContext.request.contextPath}/ajax1"
			});
		}
		
	</script>
</body>
</html>