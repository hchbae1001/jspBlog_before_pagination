<%--
  Created by IntelliJ IDEA.
  User: hchbae1001@gmail.com
  Date: 2020-12-04
  Time: 오후 6:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>

    <%@ include file="../main/index-head.jsp" %>
    <title>Blog List : Clean Blog - Start Bootstrap Theme</title>

</head>

<body>

<!-- Navigation -->
<jsp:include page="../main/index-nav.jsp" />

<!-- Page Header -->
<header class="masthead" style="background-image: url('../img/home-bg.jpg')">
    <div class="overlay"></div>
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-md-10 mx-auto">
                <div class="site-heading">
                    <h1>Member List</h1>
                    <span class="subheading">멤버 목록</span>
                </div>
            </div>
        </div>
    </div>
</header>

<!-- Main Content -->
<c:choose>
    <c:when test="${sessionScope.login.email == 'root@induk.ac.kr'}">
<div class="container">
</div>
<div class="row">
    <div class="col-lg-8 col-md-10 mx-auto">
        <c:forEach items="${requestScope.memberList }" var="member">
            <div class="post-preview">
                    <h3 class="post-title">
                            이메일:${member.email }
                    </h3>
                    <h5 class="post-subtitle">
                            이름:${member.name } <br>
                            핸드폰:${member.phone } <br>
                            주소:${member.address } <br>
                    </h5>
                </a>
            </div>
            <hr>
        </c:forEach>
    </div>
</div>
</div>
    </c:when>
    <c:otherwise>
        <h2>You should be root@induk.ac.kr for Member List</h2>
    </c:otherwise>
</c:choose>
<hr>

<!-- Footer -->
<%@ include file="../main/index-footer.jsp" %>

<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Custom scripts for this template -->
<script src="js/clean-blog.min.js"></script>

</body>

</html>
