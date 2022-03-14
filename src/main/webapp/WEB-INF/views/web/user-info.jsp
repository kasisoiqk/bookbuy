<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<script>document.title = 'Quản lý thông tin cá nhân | Book Buy'</script>
<link rel="stylesheet" href="<c:url value='/template/css/style_userinfo.css' />">
<div class="app__content">
    <div class="app-content__linker">
        <div class="grid wide">
            <ul class="app-content__linker-wrapper">
                <li><a href="<c:url value='/home' />"><span class="material-icons-outlined">home</span>Trang chủ</a></li>
                <li><a href="#">/ Quản lý thông tin cá nhân</a></li>
            </ul>
        </div>
    </div>

    <div class="grid wide">
        <div class="row">
            <div class="col l-3 m-12 c-12">
                <div class="app-container__menu">
                    <div class="app-container-menu__user">
                        <div class="app-container-menu-user__img">
                            <img src="<c:url value='/template/images/user.png' />" alt="user-image">
                        </div>
                        <div class="app-container-menu-user__info">
                            <div class="app-container-menu-user-info__name">Admin</div>
                            <div class="app-container-menu-user-info__email">admin@gmail.com</div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col l-9 m-12 c-12">
                <div class="app-container__content">
                    <div class="app-container-content__text">Thông tin cá nhân của bạn</div>
                    <div class="app-container-content__body">
                        <table>
                            <tbody>
                                <tr>
                                    <td class="app-container-content-body__text">Tên đăng nhập:</td>
                                    <td class="app-container-content-body__input"><input type="text" name="username" id="username" readonly placeholder="Tên đăng nhập"></td>
                                </tr>
                                <tr>
                                    <td class="app-container-content-body__text">Mật khẩu:</td>
                                    <td class="app-container-content-body__input">
                                        <input type="password" name="password" id="password" readonly required placeholder="Mật khẩu">
                                        <a href="<c:url value='/change-password' />" class="app__btn">Đổi mật khẩu</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="app-container-content-body__text">Tên của bạn:</td>
                                    <td class="app-container-content-body__input"><input type="text" name="fullName" id="fullName" placeholder="Tên của bạn"></td>
                                </tr>
                                <tr>
                                    <td class="app-container-content-body__text">Giới tính:</td>
                                    <td>
                                        <input type="radio" name="gender" id="male">
                                        <label for="male">Nam</label>
                                        <input type="radio" name="gender" id="female">
                                        <label for="female">Nữ</label>
                                        <input type="radio" name="gender" id="genderElse">
                                        <label for="genderElse">Khác</label>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="app-container-content-body__text">Email:</td>
                                    <td class="app-container-content-body__input"><input type="email" name="userEmail" id="userEmail" placeholder="Email"></td>
                                </tr>
                                <tr>
                                    <td class="app-container-content-body__text">Số điện thoại:</td>
                                    <td class="app-container-content-body__input"><input type="phone" name="phone" id="phone" placeholder="Số điện thoại"></td>
                                </tr>
                                <tr>
                                    <td class="app-container-content-body__text">Ngày sinh:</td>
                                    <td class="app-container-content-body__input"><input type="date" name="birth" id="birth" placeholder="Ngày sinh"></td>
                                </tr>
                            </tbody>
                        </table>
                        <span class="app-container-content-body__btn app__btn" onclick="updateInfo()">Lưu thông tin</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="<c:url value='/template/js/main_base.js' />"></script>
<script src="<c:url value='/template/js/main_userinfo.js' />"></script>