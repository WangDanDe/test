

<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
			<jsp:include page="/page/header.jsp"></jsp:include>
		<form action="${pageContext.request.contextPath}/UpdateInfoServlet" method="post">
		<table border="1px" align="center" style="width:800px">
			<caption>${requestScope.user.username}的个人信息情况</caption>
			<input type="hidden" name="id" value="${requestScope.user.id}"/>
			<tr>
				<td>用户名</td>
				<td><input type="text" name="username" value="${requestScope.user.username }"/></td>
			</tr>
			<tr>
				<td>年龄</td>
				<td><input type="text" name="age" value="${requestScope.user.age }"/></td>
			</tr>
			<tr>
				<td>性别</td>
				<td>${requestScope.user.sex }</td>
			</tr>
			<tr>
				<td>是否单身</td>
				<td>
					<c:if test="${requestScope.user.single}">
						<input type="radio" name="single" checked="checked" value="1"/>是
						<input type="radio" name="single"  value="0"/>不是
					</c:if>
					<c:if test="${requestScope.user.single?false:true}">
						<input type="radio" name="single" value="1"/>是
						<input type="radio" name="single" checked="checked" value="0"/>	不是
					</c:if>
					
					
				</td>
			</tr>
			<tr>
				<td>个人简历信息</td>
				<td><input type="text" name="info" value="${requestScope.user.info}"/></td>
			</tr>
			<tr>
				<td>职位级别</td>
				<td>
					<c:if test="${requestScope.user.power==1?true:false}">
						<input type="radio" name="power" checked="checked" value="1"/>管理员
						<input type="radio" name="power"  value="0"/>普通职员
					</c:if>
					<c:if test="${requestScope.user.power==0?true:false}">
						<input type="radio" name="power" value="1"/>管理员
						<input type="radio" name="power" checked="checked" value="0"/>普通职员
					</c:if>					
				</td>
			</tr>				
			<tr>
				<td><input type="submit" value="提交"/></td>
			</tr>
		</table>
		</form>
</body>
</html>