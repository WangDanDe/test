
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<jsp:include page="/page/header.jsp"></jsp:include>
		
		<table border="1px" align="center" style="width:800px">
			<caption>${requestScope.user.username}的个人信息情况</caption>
			<tr>
				<td>用户名</td>
				<td>年龄</td>
				<td>性别</td>
				<td>个人简历信息</td>
				<td>职位级别</td>
			</tr>
			<tr>
				<td>${requestScope.user.username }</td>
				<td>${requestScope.user.age }</td>
				<td>${requestScope.user.sex }</td>
				<td>${requestScope.user.single?'是':'否 '}</td>
				<td>${requestScope.user.info}</td>
				<td>${requestScope.user.power==1?'管理员':'普通职员' }</td>
			</tr>
			
		</table>
</body>
</html>