
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
			

		<form action="${pageContext.request.contextPath}/LoginServlet?login=1" method="get">
			<table>
				<caption>用户登录界面</caption>	
				<!-- ${msg} -->
				<tr>
					<td>用户名：</td>
					<td><input type="text" name="username"/></td>
				</tr>	
				<tr>
					<td>密码：</td>
					<td><input type="password" name="password"/></td>
					<td><input type="Checkbox" name="remb" value="rem"/>记住密码</td>
				</tr>			
				<tr>
					<td>
						<input type="radio" name="power" value="1"/>管理员						
					</td>
					<td>
						<input type="radio" name="power" value="0" checked="checked"/>用户
					</td>						
				</tr>		
				<tr>
					<td>
					<input type="submit" value="登录"/>
					</td>
					<td>
					<input type="reset" value="重置"/>
					</td>
				</tr>		
			</table>
		</form>
</body>
</html>