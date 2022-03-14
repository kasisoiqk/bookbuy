<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<script>document.title = 'Đổi mật khẩu | Book Buy'</script>
<form action="<c:url value='/change-password'/>" method="POST">
    <div class="modal-input__text">
        <h2>Đổi mật khẩu tài khoản Book Buy!</h2>
    </div>
    <div class="modal-input__info">
        <div class="modal-input__group">
            <i class="fas fa-user"></i>
            <input type="text" name="username" id="username" placeholder="Username" required>
        </div>
        <div class="modal-input__group">
            <i class="fas fa-lock"></i>
            <input type="password" name="password" id="password" placeholder="Password" required>
        </div>
        <div class="modal-input__group">
            <i class="fas fa-lock"></i>
            <input type="password" name="new-password" id="new-password" placeholder="New password" required>
        </div>
        <div class="modal-input__group">
            <i class="fas fa-key"></i>
            <input type="password" name="re-password" id="re-password" placeholder="Repeat password" required>
        </div>
        <div class="modal-input__btn">
            <button class="hide-on-edit">Đổi mật khẩu</button>
        </div>
        <div class="modal-input__text" style="margin-top: 8px;">
            <p>Bạn muốn đăng nhập? <a href="<c:url value='/login'/>">Đăng nhập</a></p>
        </div>
    </div>
</form>