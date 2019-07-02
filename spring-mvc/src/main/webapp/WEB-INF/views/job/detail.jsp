<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>직종 상세정보</h1>
	
	<div>
		<p><strong>직종아이디 : </strong> ${job.id }</p>
		<p><strong>직종  제목 : </strong> ${job.title }</p>
		<p><strong>최소  급여 : </strong> ${job.minSalary }</p>
		<p><strong>최대  급여 : </strong> ${job.maxSalary }</p>
	</div>
	
	<div>
		<a href="list.do">목록으로</a>
	</div>
</body>
</html>