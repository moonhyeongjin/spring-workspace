<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>직종 등록폼</h1>
	<form action="add.do">
		<p>아 이 디 : <input type="text" name="id"></p>
		<p>제    목 : <input type="text" name="title"></p>
		<p>최소급여 : <input type="number" name="minSalary"></p>
		<p>최대급여 : <input type="number" name="maxSalary"></p>
		<button type="submit">등록</button>
	</form>
</body>
</html>