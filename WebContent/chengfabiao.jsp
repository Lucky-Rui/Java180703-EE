<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- JSP脚本 -->
	<%-- <%java代码 %> --%>
    
	<!-- JSP表达式 :在Html页面上输出-->
	<%-- <%=变量或表达式%> --%>
    
    
	<table border="0">
		<%
			for (int i = 1; i <= 9; i++) { 
		%>
		<tr>
			<%
				for (int j = 1; j <= i; j++) { 
			%>
			<td style="border: 1px solid black; padding: 2px">
				<%=j%>*<%=i%>=<%=i * j%>
			</td>
			<%
				}
			%>
		</tr>
		<%
			}
		%>
	</table>



</body>
</html>