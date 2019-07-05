<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
   <title>Bootstrap Example</title>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
   <style>
      th, td {
         text-align: center;
      }
   </style>
</head>
<body>
<div class="container">
   <div class="page-header">
      <h1>자유게시판</h1>
   </div>
   
   <table class="table">
      <colgroup>
         <col width="10%">
         <col width="50%">
         <col width="20%">
         <col width="20%">
      </colgroup>
      <thead>
         <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>등록일</th>
         </tr>
      </thead>
      <tbody>
      <c:forEach var="board" items="${boards }">
         <tr>
            <td>${board.no }</td>
            <td><a href="#">${board.contents }</a></td>
            <td>${board.name }</td>
            <td>${board.createDate }</td>
         </tr>
      
      </c:forEach>
      </tbody>
   </table>
   
   <div class="text-right">
      <a class="btn btn-warning" href="add.do">새 글쓰기</a>
   </div>
</div>
</body>
</html>