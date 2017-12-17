
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
			<a href="${pageContext.request.contextPath}/LoginServlet?login=0">主页</a>
	<%--显示登录者的信息，从session域中拿,因为session域合适 --%>
	<c:if test="${empty sessionScope.user }">
		<a href="${pageContext.request.contextPath }/page/login.jsp">请登录</a>
	</c:if>
	<c:if test="${not empty sessionScope.user}">	
		<c:if test="${sessionScope.user.power==1}">
			<c:out value="欢迎您！${sessionScope.user.username }管理员"></c:out>
			<a href="${pageContext.request.contextPath }/LogoutServlet">注销</a>
			<a href="${pageContext.request.contextPath }/page/regist.jsp">注册</a>		
		</c:if>	
		<c:if test="${sessionScope.user.power!=1}">
			<c:out value="欢迎您！${sessionScope.user.username }员工"></c:out>
			<a href="${pageContext.request.contextPath }/LogoutServlet">注销</a>		
		</c:if>	
	</c:if>	

</body>
</html>