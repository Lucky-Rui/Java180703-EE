<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/lib/bootstrap-3.3.7-dist/css/bootstrap.css" />
</head>
<body>
	<!--导航开始-->
	<nav class="navbar navbar-default">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">教务管理系统</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a
						href="${pageContext.request.contextPath}/student?method=pageList"><span
							class="glyphicon glyphicon-home" aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;学生管理
					</a></li>
					<li><a
						href="${pageContext.request.contextPath}/banji?method=pageList"><span
							class="glyphicon glyphicon-home" aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;班级管理</a></li>
					<li ><a
						href="${pageContext.request.contextPath}/course?method=pageList"><span
							class="glyphicon glyphicon-home" aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;课程管理</a></li>
					<li class="active"><a href="#"><span class="glyphicon glyphicon-home"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;教务管理</a></li>
					<li><a
						href="${pageContext.request.contextPath}/online_user_list.jsp"><span
							class="glyphicon glyphicon-home" aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;在线人数</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a
						href="${pageContext.request.contextPath}/student?method=pageList"><span>欢迎：${user.name}</span></a></li>
					<li><a
						href="${pageContext.request.contextPath}/login?method=logout">
							<span class="glyphicon glyphicon-home" aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;退出
					</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
	<!--导航结束-->
	<!--内容部分开始-->
	<div class="container">
		<div class="row">
			<!--左边部分（链接列表组）开始-->
			<div class="col-md-2">
				<div class="list-group">
					<a href="${pageContext.request.contextPath}/banjicourse_list.jsp"
						class="list-group-item active">班级选课</a>
					<a
						href="${pageContext.request.contextPath}/banji?method=pageList"
						class="list-group-item">班级列表</a>
					<a href="${pageContext.request.contextPath}/course?method=pageList"
						class="list-group-item">课程列表 </a> 
				</div>
			</div>
			<!--左边部分（链接列表组）结束-->
			<!--右边部分（table表显示信息）开始-->
			<div class="col-md-10">
				<form style="width: 100%; text-align: center;"
					action="#"
					method="post">
					<div class="form-group">
						<label for="gender">班级名称</label> 
						<select name="banjiId"
							class="form-control" style="width: auto; margin: auto;">
							<option>---------请选择班级---------</option>
							<c:forEach items="${list}" var="banji">
								<option value="${banji.id}">${banji.name}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="gender" >课程名称</label> 
						<select name="banjiId"
							class="form-control" style="width: auto; margin: auto;">
							<option>---------请选择课程---------</option>
							<c:forEach items="${list}" var="course">
								<option value="${course.id}">${course.name}</option>
							</c:forEach>
						</select>
					</div>
					<button type="submit" class="btn btn-default">保存</button>
				</form>
			</div>
			<!--右边部分（table表显示信息）结束-->
		</div>
	</div>
	<!--内容部分结束-->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/lib/jquery/jquery-1.11.1.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/lib/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
	<script src="${pageContext.request.contextPath}/lib/layer/layer.js"
		type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath}/js/mylayer.js"
		type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
			/* function deleteById(id,pageNo) {
				//用户点了确定，confirm返回的是true，
				//用户点了取消，confirm返回的是false，
				var isDel = confirm("您确认要删除这个信息吗？");
				if (isDel) {
					location.href = "${pageContext.request.contextPath}/course?method=deleteById&id="+ id+"&pageNo="+pageNo;
				}
			} */
			function deleteById(id,pageNo){
				mylayer.confirm("你确定要删除吗？","${pageContext.request.contextPath}/course?method=deleteById&id="+ id+"&pageNo="+pageNo);
			}
			
			function selectAll(){
				//得到上面全选、反选按钮的状态
				var isChecked = $("#selectAlls").prop("checked");
				//下面所有checkbox的状态和上面全选、反选checkbox的状态一致
				$("input[name=selectIds]").prop("checked", isChecked);
			}
			function deleteAll() {
				var isDel = confirm("您确认要删除这些信息吗？");
				if(isDel){
				$("#mainForm").attr("action", "${pageContext.request.contextPath}/course?method=deleteAll");
				//用代码方式提交表单
				$("#mainForm").submit();
				}
			}
		</script>
</body>
</html>
