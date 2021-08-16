<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="fm" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resource/js/jquery-1.8.3.min.js"></script>

</head>
<body>
	<a href='download?fileName=angelababy.jpg'>angelababy.jpg</a>
	<a href='dl?fileName=angelababy.jpg'>angelababy.jpg</a>
	
	<form action="regist" method="post">
	<table>
		<tr>
			<td>用户名：</td>
			<td><input name="username"/>
				<fm:errors path="usersVo.username"/>
			</td>
		</tr>
		<tr>
			<td>密码：</td>
			<td><input name="password" type="password"/>
				<fm:errors path="usersVo.password"/>
			</td>
		</tr>
	
		<tr>
			<td></td>
			<td><input type="submit" value="注册"/></td>
		</tr>
	</table>
		
	</form>
	
</body>
</html>