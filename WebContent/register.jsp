<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/lib/bootstrap-3.3.7-dist/css/bootstrap.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/lib/bootstrap-3.3.7-dist/js/bootstrap.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery/jquery-1.11.1.js" ></script>
		<script src="${pageContext.request.contextPath}/lib/layer/layer.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/js/mylayer.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<body>
		<div class="page-header" style="width: 100%; text-align: center;">
			<h1>
				<small>Do You Like What You See!</small>
			</h1>
			<h3>
				<small>Wellcome To 米奇妙妙屋!</small>
			</h3>
		</div>
		<div style="width: 100%; text-align: center;">
			<form action="${pageContext.request.contextPath}/login?method=register">
			  <div class="form-group">
			    <label for="name">登录名</label>
			    <input style="width: auto; margin: auto;" name="name" type="text" class="form-control" id="name" placeholder="">
			  </div>
			  <div class="form-group">
			    <label for="password">密码</label>
			    <input style="width: auto; margin: auto;" name="password" type="password" class="form-control" id="password" placeholder="">
			  </div>
			  <button type="submit" class="btn btn-default">注册</button>
			</form>
		</div>
		<script type="text/javascript">
			
		</script>
	</body>
</html>
