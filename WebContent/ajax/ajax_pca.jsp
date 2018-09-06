<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script src="${pageContext.request.contextPath}/lib/jquery/jquery-1.11.1.js" type="text/javascript" charset="utf-8"></script>
	省：
	<select id="province" onchange="selectCitys(this)">
		<option>--------请选择--------</option>
	</select>
	
	
	市：
	<select id="city" onchange="selectAreas(this)">
		<option>--------请选择--------</option>
	</select>
	区:
	<select id="area">
		<option>--------请选择--------</option>
	</select>
	
	<script type="text/javascript">
		$(function() {
			$.post(
				"${pageContext.request.contextPath}/selectArea?method=selectProvince",
				function(data) {
					console.log(data);
					var html = "<option>--------请选择--------</option>";
					for (var i = 0; i < data.length; i++) {
						html += "<option value='"+data[i].id+"'>"+data[i].province+"</option>";
					}
					$("#province").html(html);
				},
				"json"
			);
		});
		
		function selectCitys(obj) {
			//清空区县下来选中的内容
			$("#area option:gt(0)").remove();
			
			//var provinceId = obj.value;
			var provinceId = $(obj).val();
			$.post(
				"${pageContext.request.contextPath}/selectArea?method=selectCity",
				{"provinceId" : provinceId},
				function(data) {
					console.log(data);
					var html = "<option>--------请选择--------</option>";
					for (var i = 0; i < data.length; i++) {
						html += "<option value='"+data[i].id+"'>"+data[i].city+"</option>";
					}
					$("#city").html(html);
				},
				"json"
			);
		}
		
		function selectAreas(obj) {
			//var provinceId = obj.value;
			var cityId = $(obj).val();
			$.post(
				"${pageContext.request.contextPath}/selectArea?method=selectArea",
				{"cityId" : cityId},
				function(data) {
					console.log(data);
					var html = "<option>--------请选择--------</option>";
					for (var i = 0; i < data.length; i++) {
						html += "<option value='"+data[i].id+"'>"+data[i].area+"</option>";
					}
					$("#area").html(html);
				},
				"json"
			);
		}
		
	</script>
</body>
</html>