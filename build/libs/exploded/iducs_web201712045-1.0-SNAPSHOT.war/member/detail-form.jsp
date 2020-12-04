<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Clean Blog - Start Bootstrap Theme</title>

    <jsp:include page="../main/index-head.jsp" />

</head>

<body>

<!-- Navigation -->
<%@ include file="../main/index-nav.jsp"%>

<!-- Page Header -->
<header class="masthead" style="background-image: url('../img/contact-bg.jpg')">
    <div class="overlay"></div>
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-md-10 mx-auto">
                <div class="page-heading">
                    <h1>Member Detail</h1>
                    <span class="subheading">Your Detail Information</span>
                </div>
            </div>
        </div>
    </div>
</header>

<!-- Main Content -->
<div class="container">
    <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
            <form action="./update.do" method="post">
                <div class="control-group">
                    <div class="form-group floating-label-form-group controls">
                        <label>Email Address</label>
                        <input type="email" readonly value="${sessionScope.login.email}" name="email" class="form-control" placeholder="Email Address" required data-validation-required-message="Please enter your email.">
                        <p class="help-block text-danger"></p>
                    </div>
                </div>
                <div class="control-group">
                    <div class="form-group floating-label-form-group controls">
                        <label>PassWord Check</label>
                        <input type="password" name="pwcheck" class="form-control" placeholder="PassWord Check" required data-validation-required-message="Please enter your password.">
                        <p class="help-block text-danger"></p>
                    </div>
                </div>
                <div class="control-group">
                    <div class="form-group floating-label-form-group controls">
                        <label>Update PassWord</label>
                        <input type="password" name="pw" class="form-control" placeholder="Update PassWord" data-validation-required-message="Please enter your email.">
                        <p class="help-block text-danger"></p>
                    </div>
                </div>
                <div class="control-group">
                    <div class="form-group floating-label-form-group controls">
                        <label>Name</label>
                        <input type="text" name="name" value="${sessionScope.login.name}" class="form-control" placeholder="Name" required data-validation-required-message="Please enter your Name.">
                        <p class="help-block text-danger"></p>
                    </div>
                </div>
                <div class="control-group">
                    <div class="form-group floating-label-form-group controls">
                        <label>Phone</label>
                        <input type="text" name="phone" value="${sessionScope.login.phone}" class="form-control" placeholder="Phone">
                        <p class="help-block text-danger"></p>
                    </div>
                </div>
                <div class="control-group">
                    <div class="form-group floating-label-form-group controls">
                        <label>Address</label>
                        <input type="text" name="address" value="${sessionScope.login.address}" class="form-control" placeholder="Address">
                        <p class="help-block text-danger"></p>
                    </div>
                </div>
                <br>
                <div id="success"></div>
                <button type="submit" class="btn btn-primary" id="sendMessageButton">Update</button>
            </form>
            <form action="./delete.do" method="post" id="contactForm" novalidate>
                <div class="control-group">
                    <div class="form-group floating-label-form-group controls">
                        <label>Email Address</label>
                        <input type="email" readonly value="${sessionScope.login.email}" name="email" class="form-control" placeholder="Email Address" required data-validation-required-message="Please enter your email.">
                        <p class="help-block text-danger"></p>
                    </div>
                </div>
                <div class="control-group">
                    <div class="form-group floating-label-form-group controls">
                        <label>PassWord</label>
                        <input type="password" name="pw" class="form-control" placeholder="PassWord" required data-validation-required-message="Please enter your password.">
                        <p class="help-block text-danger"></p>
                    </div>
                </div>
                <br>
                <button type="submit" class="btn btn-primary">Delete User</button>
            </form>
        </div>
    </div>
</div>

<hr>

<!-- Footer -->
<%@ include file="../main/index-footer.jsp" %>

</body>

</html>

