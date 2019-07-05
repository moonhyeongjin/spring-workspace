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
</head>
<body>
<div class="container">
   <div class="page-header">
      <h1>새 글쓰기</h1>
   </div>
   
   <div class="row">
      <div class="col-sm-12">
         <form class="well" method="post" action="add.do" enctype="multipart/form-data">
            <div class="form-group">
               <label>제목</label>
               <input type="text" class="form-control" name="title" />
            </div>
            <div>
               <label>작성자</label>
               <input type="text" class="form-control" name="writer" />
            </div>
            <div>
               <label>내용</label>
               <textarea rows="15" cols="60" class="form-control" name="contents"></textarea>
            </div>
            <div>
               <label>첨부파일1</label>
               <input type="file" class="form-control" name="upFile1" />
            </div>
            <div>
               <label>첨부파일2</label>
               <input type="file" class="form-control" name="upFile2" />
            </div>
            <div>
               <label>첨부파일3</label>
               <input type="file" class="form-control" name="upFile3" />
            </div>
            <div class="text-right" style="margin-top: 20px;">
               <a class="btn btn-default" href="list.do">취소</a>
               <button type="submit" class="btn btn-success">등록</button>
            </div>
         </form>
      </div>
   </div>
</div>
</body>
</html>