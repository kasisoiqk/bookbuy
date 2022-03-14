<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>	
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng nhập | Book Buy</title>
    <link rel="shortcut icon" href="<c:url value='/template/favicon.ico' />" type="image/x-icon">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css"
        integrity="sha512-NmLkDIU1C/C88wi324HBc+S2kLhi08PN5GDeUVVVC/BVt/9Izdsc9SVeVfA1UZbY3sHUlDSyRXhCzHfr6hmPPw=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href="https://fonts.googleapis.com/icon?family=Poppins:display=swap|Material+Icons+Outlined" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css"
        integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="<c:url value='/template/css/base.css' />">
    <link rel="stylesheet" href="<c:url value='/template/css/grid.css' />">
    <link rel="stylesheet" href="<c:url value='/template/css/style_login.css' />">
</head>

<body>
    <div class="app" style="background-image: url(<c:url value='/template/images/bg-login-page.png' />); background-size: cover;">
        <div class="app__login">
            <div class="app-login__form modal__input">
                <div class="app-login__logo">
                    <a href="<c:url value='/home' />"><img src="<c:url value='/template/images/logo-new.png' />" alt="logo-new"></a>
                </div>
                
                <dec:body/>
            </div>
        </div>
    </div>
    
    <div class="toast"></div>

    <script src="<c:url value='/template/js/toast.js' />"></script>
    <c:if test="${param.accessDenied != null}">
    	<script>showToast({
            message: `Không có quyền truy cập vào địa chỉ!`,
            type: 'error',
            duration: 5000
        });</script>
    </c:if>
    <c:if test="${param.incorrectAccount != null}">
    	<script>showToast({
            message: `Bạn nhập sai tên tài khoản hoặc mật khẩu!`,
            type: 'error',
            duration: 5000
        });</script>
    </c:if>
    <c:if test="${param.sessionTimeout != null}">
    	<script>showToast({
            message: `Quá thời hạn đăng nhập! Bạn vui lòng đăng nhập lại nhé.`,
            type: 'info',
            duration: 5000
        });</script>
    </c:if>
    <c:if test="${param.signupSuccess != null}">
    	<script>showToast({
            message: `Đăng ký tài khoản thành công! Bạn hãy đăng nhập để vào trang chủ nhé.`,
            type: 'success',
            duration: 5000
        });</script>
    </c:if>
    <c:if test="${param.hadUsername != null}">
    	<script>showToast({
            message: `Tên tài khoản đã được sử dụng! Vui lòng chọn tên tài khoản khác nhé.`,
            type: 'info',
            duration: 5000
        });</script>
    </c:if>
    <c:if test="${param.incorectRepassword != null}">
    	<script>showToast({
            message: `Nhập lại mật khẩu không giống với mật khẩu trước đó! Vui lòng thử lại nhé.`,
            type: 'error',
            duration: 5000
        });</script>
    </c:if>
    <c:if test="${param.invalidUsername != null}">
    	<script>showToast({
            message: `Tên tài khoản phải dài hơn 5 ký tự! Vui lòng thử lại nhé.`,
            type: 'error',
            duration: 5000
        });</script>
    </c:if>
    <c:if test="${param.invalidPassword != null}">
    	<script>showToast({
            message: `Mật khẩu phải dài hơn 5 ký tự! Vui lòng thử lại nhé.`,
            type: 'error',
            duration: 5000
        });</script>
    </c:if>
    <c:if test="${param.changePasswordSuccess != null}">
    	<script>showToast({
            message: `Thay đổi mật khẩu thành công! Bạn hãy đăng nhập lại nhé!`,
            type: 'success',
            duration: 5000
        });</script>
    </c:if>
</body>

</html>