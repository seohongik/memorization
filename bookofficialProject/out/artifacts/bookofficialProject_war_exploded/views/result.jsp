<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hongc
  Date: 2021-03-17
  Time: 오전 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="<c:url value="${pageContext.request.contextPath}/resources/css/reset.css" />" rel="stylesheet">
    <link href="<c:url value="${pageContext.request.contextPath}/resources/css/report.css" />" rel="stylesheet">

</head>

<body>
<!--[S]해더-->
<div id="wrap">
    <header id="header">
        <div id="info">
            <img src="${pageContext.request.contextPath}/resources/img/fairy-tale-1077863.jpg" id="logo">
            <a><span id="login">개인 공간 로그인</span></a>
        </div>


        <div id="searchBox">
            <input type="text" placeholder="검색 해 보세요" id="search" name="search">
            <a><span id="read">읽은책</span></a>
            <a><span id="recom">추천책</span></a>
            <a><span id="dairy">일기장</span></a>

        </div>
    </header>
    <!--[E]해더-->

    <form>
        <!--[S]콘텐츠-->
        <div id="content">
            <h1>독후감</h1>
            <hr>
            <div id="reportWrap">

                <div id="weatherBox">
                    <select name="weather">
                        <option value="">날씨</option>
                        <option value="snow">눈</option>
                        <option value="rain">비</option>
                        <option value="sun">해</option>
                        <option value="cloudy">구름</option>
                        <option value="foggy">안개</option>
                    </select>
                </div>

                <div id="seasonBox">
                    <select name="season">
                        <option value="">계절</option>
                        <option value="spring">봄</option>
                        <option value="summer">여름</option>
                        <option value="fall">가을</option>
                        <option value="winter">겨울</option>
                    </select>
                </div>

                <div id="yearBox">
                    <select name="year">
                        <option value="">년도</option>
                        <option value="yearList"></option>
                    </select>
                    <select name="month">
                        <option value="">달</option>
                        <option value="monthList"></option>
                    </select>

                    <select name="day">
                        <option value="">일</option>
                        <option value="dayList"></option>
                    </select>
                </div>


                <div id="reportBox">
                    <label  for="report_title">제목</label>
                    <input id="report_title" type="text" name="report_title">

                    <label for="report_content">내용</label>
                    <textarea id="report_content" name="report_content"></textarea>

                    <label for="report_comment">한줄평</label>
                    <input id="report_comment" type="text" name="report_comment">
                </div>

                <input type="button" value="수정">
                <input type="button" value="삭제">
                <hr>
            </div>


        </div>
    </form>


    <form>
        <div id="book_info">
            <h1>책 정보</h1>
            <hr>
            <div class="">

                <label for="book_title">도서 제목</label>
                <input id="book_title" type="text" name="book_title" >


                <label for="book_author">작가</label>
                <input id="book_author" type="text" name="book_author">


                <label for="book_publisher">출판사</label>
                <input id="book_publisher" type="text" name="book_publisher">


                <label for="book_isbn">*필수 ISBN</label>
                <input id="book_isbn" type="text" name="book_isbn">

            </div>


            <input type="button" value="등록">
            <hr>

        </div>
        <!--[E]콘텐츠-->

    </form>



</div>

<!--[S]푸터-->

<footer>


</footer>

<!--[E]푸터-->
</body>
</html>
