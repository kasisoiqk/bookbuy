<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<script>document.title = 'Tin nhắn | Book Buy'</script>
<link rel="stylesheet" href="<c:url value='/template/css/style_chat.css' />">
<div class="app__content">
    <div class="app-content__linker">
        <div class="grid wide">
            <ul class="app-content__linker-wrapper">
                <li><a href="<c:url value='home' />"><span class="material-icons-outlined">home</span>Trang chủ</a></li>
                <li><a href="#">/ Tin nhắn</a></li>
            </ul>
        </div>
    </div>
    <div class="app-content__body">
        <div class="grid wide">
            <div class="row">
                <div class="col l-4 m-4 c-12">
                    <div class="app-content-body__list-chat">
                        <div class="app-content-body-list-chat__text">Danh sách những người trò chuyện</div>
                        <div class="app-content-body-list-chat__search">
                            <i class="fas fa-search"></i>
                            <input type="text" name="txt-search" id="txt-search" placeholder="Tìm kiếm trò chuyện...">
                        </div>
                        <ul class="app-content-body-list-chat__navbar">
                            <li class="app-content-body-list-chat-navbar__item active-color">
                                <img src="<c:url value='/template/images/user.png' />" alt="user">
                                <p>Chăm sóc khách hàng</p>
                            </li>
                            <li class="app-content-body-list-chat-navbar__item message-unread">
                                <img src="<c:url value='/template/images/user.png' />" alt="user">
                                <p>Nguyễn Quốc Khánh</p>
                            </li>
                            <li class="app-content-body-list-chat-navbar__item">
                                <img src="<c:url value='/template/images/user.png' />" alt="user">
                                <p>Nguyễn Thị Thùy Duyên</p>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col l-8 m-8 c-12">
                    <div class="app-content-body__message">
                        <div class="app-content-body-message__text">
                            <div>
                                <img src="<c:url value='/template/images/user.png' />" alt="user">
                                <h2 id="name-user-chat">Chọn một người để bắt đầu cuộc trò chuyện</h2>
                            </div>
                            <div>
                                <i class="fas fa-phone-alt"></i>
                                <i class="fas fa-video"></i>
                                <i class="fas fa-info-circle"></i>
                            </div>
                        </div>
                        <div class="app-content-body-message__read-wrapper">
                            <div class="app-content-body-message__read">
                                <a>
                                    <img src="<c:url value='/template/images/message.png" alt="message' />">
                                </a>
                            </div>
                        </div>
                        <div class="app-content-body-message__control">
                            <i class="fas fa-plus-circle"></i>
                            <i class="fas fa-image"></i>
                            <i class="fas fa-microphone"></i>
                            <div>
                                <input type="text" id="txtmessage" name="txtmessage" placeholder="Nội dung tin nhắn..." required>
                                <span class="app__btn" onclick="sendMessage()"><i class="fas fa-paper-plane"></i> Gửi</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="<c:url value='/template/js/main_base.js' />"></script>
<script src="<c:url value='/template/js/main_chat.js' />"></script>