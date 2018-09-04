<%@page import="java.io.PrintWriter"%>
<%@page import="com.situ.student.entity.PageBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="lib/bootstrap-3.3.7-dist/css/bootstrap.css" />
</head>
<body>
	<%
		PageBean pageBean = (PageBean) request.getAttribute("pageBean");
	%>
	<div style="text-align: center;">
		<h2>班级信息表</h2>
	</div>
	<div style="text-align: center; height: 40px;">
		<a href="banji_add.jsp">新增</a>
		<a style="margin-left: 40px;" href="javascript:deleteAll()">批量删除</a>
		
		<!-- 解决jsp中路径写死问题  <%=request.getContextPath()%>-->
		<form style="display: inline; margin-left: 40px;"
			action="<%=request.getContextPath()%>/banji?method=pageList"
			method="post">
			姓名：<input type="text" name="name" /> <input type="submit" value="搜索" />
		</form>
	</div>
	<!--table表格开始  -->
	<!--前端数据传到后台可以用form表单、超链接、location.href -->
	<form action="" id="mainForm" method="post">
		<table
			class="table table-striped table-bordered table-hover table-condensed">
			<tr>
				<td><input type="checkbox" id="selectAlls" onclick="selectAll()"/>全选</td>
				<td>ID</td>
				<td>班级名称</td>
				<td>修改</td>
				<td>删除</td>
			</tr>
			<c:forEach items="${pageBean.list}" var="banji">
				<tr>
					<td><input type="checkbox" name="selectIds" value="${banji.id}"/></td>
					<td>${banji.id}</td>
					<td>${banji.name}</td>
					<td>
						<a href="<%=request.getContextPath()%>/banji?method=toUpdate&id=${banji.id}">修改</a></td>
					<td>
						<a href="javascript:deleteById(${banji.id},${pageBean.pageNo})">删除</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</form>
	<!--table表格结束  -->
	<!--选择页开始  -->
	<div  style=" text-align: center ;">
		<nav aria-label="Page navigation" style="align-self: center;">
			<ul class="pagination">
				<!--上一页开始  -->
				<c:if test="${pageBean.pageNo == 1}">
					<li class="disabled">
						<a href="#" aria-label="Previous"> 
							<spanaria-hidden="true">&laquo;</span>
						</a>
					</li>
				</c:if>
				<c:if test="${pageBean.pageNo != 1}">
					<li>
						<a href="<%=request.getContextPath()%>/banji?method=pageList&pageNo=${pageBean.pageNo - 1}&pageSize=3"
							aria-label="Previous"> 
							<span aria-hidden="true">&laquo;</span>
						</a>
					</li>
				</c:if>
				<!--上一页结束  -->
				<!--中间页码开始 -->
				<c:forEach var="i" begin="1" end="${pageBean.totalPage}" step="1">
					<c:if test="${pageBean.pageNo == i}">
						<li class="active"><a href="#">${i}</a></li>
					</c:if>
					<c:if test="${pageBean.pageNo != i}">
						<li><a href="<%=request.getContextPath()%>/banji?method=pageList&pageNo=${i}&pageSize=3">${i}</a></li>
					</c:if>
				</c:forEach>
				<!--中间页码结束  -->
				<!--下一页开始  -->
				<c:if test="${pageBean.pageNo == pageBean.totalPage}">
					<li class="disabled">
						<a href="#" aria-label="Next"> 
							<span aria-hidden="true">&raquo;</span>
						</a>
					</li>
				</c:if>	
				<c:if test="${pageBean.pageNo != pageBean.totalPage}">
					<li>
						<a href="<%=request.getContextPath()%>/banji?method=pageList&pageNo=${pageBean.pageNo + 1}&pageSize=3"
							aria-label="Next"> 
							<span aria-hidden="true">&raquo;</span>
						</a>
					</li>
				</c:if>
				<!--下一页结束  -->
			</ul>
		</nav>
	</div>
	<!--选择页结束 -->
	<!--bootstrap.js用到了jquery，所以要首先引入jquery -->
	<script type="text/javascript" src="lib/jquery/jquery-1.11.1.js"></script>
	<script type="text/javascript"
		src="lib/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
	<script type="text/javascript">
		function deleteById(id,pageNo) {
			//点了确定，confirm返回的是true，
			//点了取消，confirm返回的是false，
			var isDel = confirm("您确认要删除么？");
			if (isDel) {
				location.href = "<%=request.getContextPath()%>/banji?method=deleteById&id="+ id+"&pageNo="+pageNo;
			}
		}
		
		function selectAll(){
			//得到上面全选、反选按钮的状态
			var isChecked = $("#selectAlls").prop("checked");
			//下面所有checkbox的状态和上面全选、反选checkbox的状态一致
			$("input[name=selectIds]").prop("checked", isChecked);
		}
		function deleteAll() {
			var isDel = confirm("您确认要删除么？");
			if (isDel){
			$("#mainForm").attr("action", "<%=request.getContextPath()%>/banji?method=deleteAll");
			//用代码方式提交表单
			$("#mainForm").submit();
			}
		}
	</script>
</body>
</html>