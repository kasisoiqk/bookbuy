<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<script>document.title = 'Đăng ký | Book Buy'</script>
<form action='<c:url value="/create-user"/>' method="POST">
    <div class="modal-input__text">
        <h2>Đăng ký tài khoản vào Book Buy!</h2>
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
            <i class="fas fa-key"></i>
            <input type="password" name="re-password" id="re-password" placeholder="Repeat password" required>
        </div>
        <div class="modal-input__text" style="text-align: left; margin: 12px; display: flex; align-items: center;">
            <input type="checkbox" name="remember-pass" id="remember-pass">
            <label for="remember-pass">Tôi đồng ý với các điều khoản của Book Buy</label>
        </div>
        <div class="modal-input__btn">
            <span class="hide-on-edit" onclick="registerUser()">Đăng ký</span>
        </div>
        <div class="modal-input__text" style="margin-top: 8px;">
            <p>Bạn đã có tài khoản? <a href="<c:url value='/login' />">Đăng nhập</a></p>
        </div>
    </div>
</form>
<script src="<c:url value='/template/js/main_base.js' />"></script>
<script src="<c:url value='/template/js/main_signup.js' />"></script>