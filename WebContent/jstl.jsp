<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.situ.student.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--JSTL  -->
	
	<%
		pageContext.setAttribute("age", 18);
		pageContext.setAttribute("gender", "男");
	%>
	<c:set var="age" value="20"></c:set>
	${age}
	
	<hr/>
	<!-- 1、单条件判断 -->
	<c:if test="${age == 20}">
		今年20岁了
	</c:if>
	<hr/>
	<c:if test="${gender == '男'}">
		男
	</c:if>
	<c:if test="${gender == '女'}">
		女
	</c:if>
	
	<!-- 2、多条件判断 
		<c:choose>
		     <c:when test=""></c:when>
		     <c:when test=""></c:when>
		     <c:when test=""></c:when>
		     <c:otherwise test=""></c:otherwise >
		</c:choose>
	-->
	<%
		int score = 70;
		pageContext.setAttribute("score", score);
	%>
	<c:set var="score" value="80"></c:set>
	<c:choose>
		<c:when test="${score >= 90 && score <= 100}">
			优秀
		</c:when>
		<c:when test="${score >= 80 && score < 90}">
			良好
		</c:when>
		<c:when test="${score >= 70 && score < 80}">
			一般
		</c:when>
		<c:when test="${score >= 60 && score < 70}">
			及格
		</c:when>
		<c:otherwise>
			不及格
		</c:otherwise>
	</c:choose>
	<hr/>
	
	<!-- 
	3、集合遍历
	  3.1、遍历List<String>
	  3.2、遍历 List<Studnet>
	  3.3、遍历Map<String, String>
     	   Map<String, Student> 
    -->
    <!-- step="2"  类似于for循环中i++改为i=i+2 -->
	<c:forEach begin="0" end="5" var="i" >
		${i} <br/>
	</c:forEach>
	
	<!-- 3.2、遍历 List<Studnet> -->
	<%
		List<Student> list = new ArrayList<Student>();
		Student student1 = new Student("张三11", 34, "男");
		Student student2 = new Student("张三22", 34, "男");
		list.add(student1);
		list.add(student2);
		application.setAttribute("list", list);
	%>
	<c:forEach items="${list}" var="student">
		${student.name} -- ${student.age}
	</c:forEach>
	<hr/>
	<!-- 
		3.3、遍历Map<String, String>
     	   Map<String, Student>  -->
    <%
    	Map<String, String> map = new HashMap<String, String>();
    	map.put("cn", "中国");
    	map.put("us", "美国");
    	request.setAttribute("map", map);
    %>
    <c:forEach items="${map}" var="entry">
    	${entry.key} -- ${entry.value} <br/>
    </c:forEach>
    <hr/>
    <%
	    Student stu1 = new Student("李四11", 34, "男");
		Student stu2 = new Student("李四22", 34, "男");
		Map<String, Student> map2 = new HashMap<String, Student>();
		map2.put("stu1", stu1);
		map2.put("stu2", stu2);
		pageContext.setAttribute("map2", map2);
    %>
    <c:forEach items="${map2}" var="entry">
    	${entry.key} -- ${entry.value} <br/>
    	${entry.key} -- ${entry.value.name} <br/>
    </c:forEach>
</body>
</html>