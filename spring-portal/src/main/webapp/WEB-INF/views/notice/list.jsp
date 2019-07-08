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
<%@ include file="/WEB-INF/views/common/nav.jsp" %>
<div class="container">
    <div class="page-header">
       <h1>공지사항</h1>
    </div>
    
    <div class="row">
       <div class="col-sm-12">
          <table class="table">
             <thead>
                <tr>
                   <th>순번</th>
                   <th>제목</th>
                   <th>등록일</th>
                   <th>첨부파일</th>
                </tr>
             </thead>
             <tbody>
                <c:choose>
                   <c:when test="${empty notices }">
                      <tr>
                        <td class="text-center" colspan="4">
                           조회된 공지사항이 없습니다.
                        </td>
                      </tr>
                   </c:when>
                   <c:otherwise>
                      <c:forEach var="notice" items="${notices }" varStatus="loop"> <!-- var는 뽑혀 나온 하나이므로 단수형, items은 배열이므로 복수형으로 하자 -->
                         <tr>
                            <td>${loop.count }</td>
                            <td>${notice.title }</td>
                            <td><fmt:formatDate value="${notice.createDate}"/></td>
                            <td>
                                 <c:if test="${not empty notice.attachment }">
                                    <a href="download.do?no=${notice.no }" class="btn btn-default btn-xs">다운로드</a>
                                 </c:if>
                            </td>
                         </tr>
                      </c:forEach>   
                   </c:otherwise>
                </c:choose>
             </tbody>
          </table>
       </div>
    </div>
      <div class="row">
         <div class="col-sm-12 text-right">
            <a href="form.do" class="btn btn-primary">새 글</a>
         </div>
      </div>
</div>
</body>
</html>