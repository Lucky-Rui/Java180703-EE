<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/lib/bootstrap-3.3.7-dist/css/bootstrap.css" />
		<style type="text/css">
			.ok{
				color: green;
			}
			.error{
				color: red;
			}
		</style>
	</head>
	<body>
		<div class="page-header" style="width: 100%; text-align: center;">
			<h1>
				<small>Do You Like What You See!</small>
			</h1>
			<h3>
				<small>Welcome to register for 米奇妙妙屋 account</small>
			</h3>
		</div>
		<div style="width: 100%; text-align: center;">
			<form action="${pageContext.request.contextPath}/login?method=register" method="post">
			  <div class="form-group">
			    <label for="name">登录名</label>
			    <input  onblur="checkName()" style="width: auto; margin: auto;" name="name" id="name" type="text" class="form-control"  placeholder="">
			    <span id="nameMsg">3-10位字母、数字、下划线</span>
			  </div>
			  <div class="form-group">
			    <label for="password">密码</label>
			    <input onblur="checkPassword()" style="width: auto; margin: auto;" name="password" id="password" type="password" class="form-control"  placeholder="">
			    <span id="passwordMsg">3-20位字母、数字、下划线</span>
			  </div>
			  <button type="submit" class="btn btn-default">注册</button>
			</form>
		</div>
		<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery/jquery-1.11.1.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/lib/bootstrap-3.3.7-dist/js/bootstrap.js" ></script>
		<script src="${pageContext.request.contextPath}/lib/layer/layer.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/js/mylayer.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			function checkName(){
				/* 3-10位字母、数字、下划线 */
				var name = document.getElementById("name").value;
				var span = document.getElementById("nameMsg");
				var reg = /^\w{3,10}$/;
				if (name.match(reg)) {
					span.className = "ok";
				} else {
					span.className = "error";
					//js正则表达式验证非法，就直接返回，不需要验证ajax验证用户名是否重名
					return;
				}
				
				//ajax请求验证这个用户名
				$.post(
					"${pageContext.request.contextPath}/login?method=checkName",
					{"name":name},
					function(data) {
						//{"isExist":isExist}
						if (data.isExist){
							//错误弹窗
							mylayer.errorAlert("该用户名已经存在，请使用其它名称");
							//$("#nameExistMsg").html("该用户已经存在");
							//$("#nameExistMsg").css("color", "red");
						} else {
							//正确弹窗
							mylayer.success("该用户名可以使用");
							//$("#nameExistMsg").html("该用户名可以使用");
							//$("#nameExistMsg").css("color", "green");
						}
					},
					"json"
				);
			}
			
			function checkPassword() {
				var emial = document.getElementById("password").value;
				var span = document.getElementById("passwordMsg");
				var reg = /^\w{3,20}$/;
				if (emial.match(reg)) {
					span.className = "ok";
				} else {
					mylayer.errorAlert("密码应为：3-10位字母、数字、下划线 ");
					span.className = "error";
					
				}
			}
		</script>
	</body>
</html>
