

<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%@ include file="/page/header.jsp" %>

	
	<%-- 显示所有用户信息 --%>
	<table  border="1px" align="center" style="width:800px">
		<caption>用户信息表</caption>
		<tr>
			<td>用户名</td>
			<td>性别</td>
			<td>级别</td>
			<th>功能列表</th>
		</tr>
		<c:if test="${not empty sessionScope.user	}">
			<c:forEach items="${requestScope.userList}" var="user">
			<c:if test="${sessionScope.user.id == user.id}">
			<tr>
				<td><font color="red">${user.username}</font></td>
				<td><font color="red">${user.sex}</font></td>
				<td><font color="red">${user.power==1?'管理员':'普通员工'}</font></td>
				<td align="center">
					<a href="${pageContext.request.contextPath}/FindInfoServlet?id=${user.id}&page=userinfo">查看详细信息</a>					
					<a href="${pageContext.request.contextPath}/FindInfoServlet?id=${user.id}&page=updateinfo">修改</a>					
					
				</td>
			</tr>
			</c:if>
			<c:if test="${sessionScope.user.id != user.id}">
				<td>${user.username}</td>
				<td>${user.sex}</td>
				<td>${user.power==1?'管理员':'普通员工'}</td>
				<td align="center">
					<a href="${pageContext.request.contextPath}/FindInfoServlet?id=${user.id}&page=userinfo">查看详细信息</a>					
					<a href="${pageContext.request.contextPath}/FindInfoServlet?id=${user.id}&page=updateinfo">修改</a>											
					<a href="${pageContext.request.contextPath}/DeleteInfoServlet?id=${user.id}">删除</a>
					
				</td>
			</tr>
			</c:if>
		</c:forEach>
		</c:if>
		
	</table>
	
</body>
</html>