<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>사원 등록 폼</h1>
	<form action="register.do" method="post">
		<p>아 이 디 : <input type="text" name="id"/></p>
		<p>이    름 : <input type="text" name="name"/></p>
		<p>소속부서 : <input type="text" name="dept"/></p>
		<p>직    급 : <input type="text" name="position"/></p>
		<p>급    여 : <input type="text" name="salary"/></p>
		<p>커 미 션 : <input type="text" name="commission"/></p>
		<p><button type="submit">등록</button></p>
	</form>
</body>
</html>