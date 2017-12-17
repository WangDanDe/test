<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form action="${pageContext.request.contextPath }/RegistServlet" method="post">
			<table>
				<caption>注册一个用户请填写下面信息</caption>
			<tr>
				<td>用户名</td>
				<td><input type="text" name="username"/></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="text" name="password"/></td>
			</tr>
			<tr>
				<td>年龄</td>
				<td><input type="text" name="age"/></td>
			</tr>
			<tr>
				<td>性别</td>
				<td>
					<input type="radio" name="sex" checked="checked" value="1"/>男
					<input type="radio" name="sex"  value="0"/>女
				</td>
			</tr>
			<tr>
				<td>是否单身</td>
				<td>
					<input type="radio" name="single" checked="checked" value="1"/>是
					<input type="radio" name="single"  value="0"/>不是					
				</td>
			</tr>
			<tr>
				<td>个人简历信息</td>
				<td><input type="text" name="info"/></td>
			</tr>
			<tr>
				<td>职位级别</td>
				<td>	
					<input type="radio" name="power" checked="checked" value="1"/>管理员
					<input type="radio" name="power"  value="0"/>普通职员
				</td>
			</tr>				
			<tr>
				<td><input type="submit" value="提交"/></td>
			</tr>
			</table>
			
		</form>
</body>
</html>