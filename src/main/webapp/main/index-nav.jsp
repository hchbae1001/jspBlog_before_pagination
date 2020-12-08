<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
    <div class="container">
        <a class="navbar-brand" href="../main/index.jsp">
<c:choose>
    <c:when test="${sessionScope.login == null}">
            2학년2학기-JSP중요과제
    </c:when>
    <c:otherwise>
            ${sessionScope.login.email}
    </c:otherwise>
</c:choose>
        </a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            Menu
            <i class="fas fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="../main/index.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="../blog/list.do">Blogs</a>
                </li>
                <c:choose>
                    <c:when test="${sessionScope.login.email == 'root@induk.ac.kr'}">
                        <li class="nav-item">
                            <a class="nav-link" href="../member/mlist.do">Member List</a>
                        </li>
                    </c:when>
                </c:choose>
<c:choose>
    <c:when test="${sessionScope.login == null}">
                <li class="nav-item">
                    <a class="nav-link" href="../member/signup-form.jsp">Sign Up</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="../member/signin-form.jsp">Sign In</a>
                </li>
    </c:when>
    <c:otherwise>
                <li class="nav-item">
                    <a class="nav-link" href="../member/detail-form.jsp">Detail</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="../member/signout.do">Sign Out</a>
                </li>
    </c:otherwise>
</c:choose>
            </ul>
        </div>
    </div>
</nav>

