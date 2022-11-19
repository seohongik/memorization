<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hongc
  Date: 2021-03-17
  Time: 오전 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>독후감</title>
    <link href="<c:url value="${pageContext.request.contextPath}/resources/css/reset.css" />" rel="stylesheet">
    <link href="<c:url value="${pageContext.request.contextPath}/resources/css/report.css" />" rel="stylesheet">

    <link href="<c:url value="${pageContext.request.contextPath}/resources/css/lightbox.css" />" rel="stylesheet" />
    <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="<c:url value="${pageContext.request.contextPath}/resources/js/lightbox.js" />"></script>
    <script>
        $(document).ready(function(){

            $("input[name='Btn']").on("click",function (){


                let title = $("input[name='book_title']").val();
                let author=$("input[name='book_author']").val();
                let publisher=$("input[name='book_publisher']").val();

                let subject=$("input[name='report_subject']").val();
                let content=$("textarea[name='report_content']").val();
                let comment=$("input[name='report_comment']").val();
                let hashKey=$("input[name='report_hashKey']").val();


                let isbn=$("input[name='book_isbn']").val();


                //추천 내용
                $.ajax({

                type : "GET",
                url : "/result/GetCentralLibraryData",
                data: {
                    "title":title,
                    "author":author,
                    "publisher":publisher,



                },
                dataType : "json",
                contentType: "application/json; charset=UTF-8" ,
                error : function(){
                    alert('통신실패!!');
                },
                success : function(data){

                    console.log(data);

                }


                });//endOfAjax

                //독후감 내용
                $.ajax({

                    type : "GET",
                    url : "/result/MyLibraryData",
                    data: {
                        "subject":subject,
                        "content":content,
                        "comment":comment,
                        "title":title,
                        "author":author,
                        "publisher":publisher,
                        "isbn":isbn,
                        "hashKey":hashKey

                    },
                    dataType : "json",
                    contentType: "application/json; charset=UTF-8" ,
                    error : function(){
                        alert('통신실패!!');
                    },
                    success : function(data){
                        console.log(data);



                        $("#img_form_url").attr("src", data.data);


                    }


                });//endOfAjax


            });

        });




    </script>

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
            <a><span id="dairy">독후감</span></a>


        </div>
    </header>
    <!--[E]해더-->

    <form>
        <!--[S]콘텐츠-->
        <div id="content">
            <h1>독후감</h1>
            <hr>
            <div id="reportWrap">


                <div id="reportBox">
                    <label for="report_subject">제목</label>
                    <input id="report_subject" type="text" name="report_subject">
                    <br>
                    <label for="report_content">내용</label>
                    <textarea id="report_content" name="report_content"></textarea>
                    <br>
                    <label for="report_comment">한줄평</label>
                    <input id="report_comment" type="text" name="report_comment">

                    <br>

                    <label for="report_hashKey">키워드</label>
                    <input id="report_hashKey" type="text" name="report_hashKey">

                </div>

            </div>


        </div>


    </form>


    <form>
        <div id="book_info">

            <hr>
            <div class="">

                <img style="width: 250px;height: 300px;object-fit: cover; z-index: 100; box-shadow: #44aaee;" id="img_form_url">

                <label for="book_title">도서 제목</label>
                <input id="book_title" type="text" name="book_title" >


                <label for="book_author">작가</label>
                <input id="book_author" type="text" name="book_author">


                <label for="book_publisher">출판사</label>
                <input id="book_publisher" type="text" name="book_publisher">


                <label for="book_isbn">*필수 ISBN</label>
                <input id="book_isbn" type="text" name="book_isbn">

            </div>


            <input type="button" value="등록" name="Btn">
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
