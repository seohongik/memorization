<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hongc
  Date: 2021-03-17
  Time: 오전 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>메인</title>
    <link href="<c:url value="${pageContext.request.contextPath}/resources/css/reset.css" />" rel="stylesheet">
    <link href="<c:url value="${pageContext.request.contextPath}/resources/css/unReadMain.css" />" rel="stylesheet">

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


    <!--[S]콘텐츠-->
    <div id="content">
        <h1>추천 책</h1>
        <hr>
        <div class="not_already_read">


            <div class="not_already_read_detail">
                <img src="${pageContext.request.contextPath}/resources/img/already_read_book/x9788954675987.jpg" class="not_already_read_img">

                <div class="colorBox">
                    <p class="color">책제목</p>

                    <p class="title">일인칭단수시점 dddddddddddddddddddddddddd</p>

                    <p class="color">작가</p>

                    <p class="author">무라카미하루키</p>

                    <p class="color">왓챠 평점</p>

                    <p class="watcha_star">5</p>

                    <p class="color">추천날짜</p>

                    <p class="year">2020/12/15</p>

                </div>
            </div>

        </div>
        <hr>

    </div>
    <!--[E]콘텐츠-->


</div>

<!--[S]푸터-->

<footer>


</footer>

<!--[E]푸터-->
</body>

</html>
