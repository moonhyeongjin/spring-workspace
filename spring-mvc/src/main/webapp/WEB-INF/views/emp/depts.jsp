<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>부서정보 </h1>
		
		<table>
			<tr >
				<th>부서아이디</th>
				<th>부서명</th>
				<th>매니저 아이디</th>
				<th>지역번호</th>
			</tr>
			<c:forEach var="dept" items="${depts }">
			<tr style="text-align: center;">
				<td><a href="">${dept.id }</a></td>
				<td><a href="">${dept.name }</a></td>
				<td>${dept.managerId }</td>
				<td>${dept.locationId }</td>
			</tr>
			</c:forEach>
		</table>
		<div>
			<a href=""><button type="button">새 사원 등록</button></a>
		</div>
</body>
</html>