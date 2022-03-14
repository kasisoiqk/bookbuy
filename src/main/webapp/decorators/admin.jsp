<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin | Book Buy</title>
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
    <link rel="stylesheet" href="<c:url value='/template/css/style_admin.css' />">
    <link rel="stylesheet" href="<c:url value='/template/css/responsive_base.css' />">
    <link rel="stylesheet" href="<c:url value='/template/css/responsive_admin.css' />">
</head>

<body>
    <div class="app">
        <header class="app__header">
            <div class="grid wide">
                <div class="app__header-wrapper">
                    <div class="app-header__img hide-on-moblie">
                        <img src="<c:url value='/template/images/logo-new.png' />" alt="logo-new" srcset="">
                    </div>
                    <div class="app-header__search">
                        <span class="material-icons-outlined">search</span>
                        <input type="text" id="txt-search" name="txt-search" placeholder="Bạn muốn tìm gì?">
                    </div>
                    <a href="<c:url value='/logout' />" class="app-header__logout">
                        <span class="material-icons-outlined">logout</span>
                        <p class="hide-on-moblie">Đăng xuất</p>
                    </a>
                </div>
            </div>
        </header>

        <dec:body/>

        <footer class="app__footer">
            <p>Powered by <a href="https://github.com/kasisoiqk">Khanh dz 2021</a></p>
        </footer>
    </div>

    <a href="#" class="up-top">TOP</a>

    <div class="toast"></div>

    <script src="<c:url value='/template/js/toast.js' />"></script>
</body>

</html>