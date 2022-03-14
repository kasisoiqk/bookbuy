<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<script>document.title = 'Đăng nhập | Book Buy'</script>
<form action='<c:url value="j_spring_security_check"/>' method="POST">
<div class="modal-input__text">
    <h2>Đăng nhập vào Book Buy!</h2>
</div>
<div class="modal-input__info">
    <div class="modal-input__group">
        <i class="fas fa-user"></i>
        <input type="text" name="j_username" id="j_username" placeholder="Username" required>
    </div>
    <div class="modal-input__group">
        <i class="fas fa-lock"></i>
        <input type="password" name="j_password" id="j_password" placeholder="Password" required>
    </div>
    <div class="modal-input__text" style="text-align: left; margin: 12px; display: flex; align-items: center;">
        <input type="checkbox" name="remember-pass" id="remember-pass">
        <label for="remember-pass">Remember me</label>
    </div>
    <div class="modal-input__btn">
        <button class="hide-on-edit">Đăng nhập</button>
    </div>
    <div class="modal-input__text" style="margin-top: 8px;">
        <p>Bạn chưa có tài khoản? <a href="<c:url value='/signup' />">Đăng ký</a></p>
        <p>Bạn muốn đổi mật khẩu? <a href="<c:url value='/change-password' />">Đổi mật khẩu</a></p>
    </div>
</div>
</form>