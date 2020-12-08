<%--
  Created by IntelliJ IDEA.
  User: hchbae1001@gmail.com
  Date: 2020-12-05
  Time: 오전 9:58
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>중요과제</title>

    <jsp:include page="../main/index-head.jsp" />

</head>

<body>

<!-- Navigation -->
<%@ include file="../main/index-nav.jsp"%>

<!-- Page Header -->
<header class="masthead" style="background-image: url('../img/home-bg.jpg')">
    <div class="overlay"></div>
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-md-10 mx-auto">
                <div class="site-heading">
                    <h1>JSP 중요과제</h1>
                    <span class="subheading">201712045 배현철</span>
                </div>
            </div>
        </div>
    </div>
</header>

<!-- Main Content -->
<h2 class="text-center">MVC Model 2 웹 애플리케이션 개발 절차</h2>
<hr/>
<div class="container">
    <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
            <div class="post-preview">
                <h3 class="post-subtitle">
                    DB Schema 정의
                </h3>
                <span class="meta">
                    Table, Sequence, Index, Record ...
                </span>
            </div>
            <hr>
            <div class="post-preview">
                <h3 class="post-subtitle">
                    Model - DTO(Data Transfer Object) 정의
                </h3>
                <span class="meta">
                    POJO(Plain Old Java Object), Java
                </span>
            </div>
            <hr>
            <div class="post-preview">
                <h3 class="post-subtitle">
                    Service 정의 (소규모인 경우 Controller가 수행)
                </h3>
                <span class="meta">
                    Business Logic,  Java
                </span>
            </div>
            <hr>
            <div class="post-preview">
                <h3 class="post-subtitle">
                    DAO(Data Access Object) 정의
                </h3>
                <span class="meta">
                    Data Access Layer, JDBC,  SQL
                </span>
            </div>
            <hr>
            <div class="post-preview">
                <h3 class="post-subtitle">
                    Controller 정의
                </h3>
                <span class="meta">
                    Servlet
                </span>
            </div>
            <hr>
            <div class="post-preview">
                <h3 class="post-subtitle">
                    View 생성
                </h3>
                <span class="meta">
                    JSP
                </span>
            </div>
            <hr>
        </div>
    </div>
</div>

<hr>

<!-- Footer -->
<%@ include file="../main/index-footer.jsp" %>

</body>

</html>
