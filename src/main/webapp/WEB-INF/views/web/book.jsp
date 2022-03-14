<%@ page import="com.laptrinhjavaweb.utils.FormatNumberUltils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<link rel="stylesheet" href="<c:url value='/template/css/style_book.css' />">
<div class="app__content">
    <div class="app-content__linker">
        <div class="grid wide">
            <ul class="app-content__linker-wrapper">
                <li><a href="<c:url value='/home' />"><span class="material-icons-outlined">home</span>Trang chủ</a></li>
                <li><a href="#">/ ${book.cateName}</a></li>
                <li><a href="#">/ ${book.name}</a></li>
            </ul>
        </div>
    </div>

    <div class="app-content__info">
        <div class="grid wide">
            <div class="app-content__info-wrapper">
                <div class="row">
                    <div class="col l-3 m-4 c-12">
                        <div class="app-content-info__img">
                            <img src="<c:url value='/template/images/${book.image}' />" alt="">
                        </div>
                    </div>
                    <div class="col l-6 m-8 c-12">
                        <div class="app-content-info__name" >${book.name}</div>
                        <div class="app-content-info__author">${book.author}</div>
                        <div class="app-content-info__current-price">${FormatNumberUltils.priceToString(book.currentPrice)}đ</div>
                        <div class="app-content-info__sale">-${book.sale}%</div>
                        <div class="app-content-info__old-price">${FormatNumberUltils.priceToString(book.oldPrice)}đ</div>
                        <div class="app-content-info__status">Tình trạng: <p>Còn hàng</p></div>
                        <div class="app-content-info__cate">Danh mục: <a href="#">${book.cateName}</a></div>
                        <div class="app-content-info__quantity">
                            Số lượng: &nbsp; &nbsp;
                            <span>-</span>
                            <input type="text" value="1">
                            <span>+</span>
                        </div>
                        <div class="app-content-info__btn">
                            <span class="app__btn app-content-info__btn--btn-add" onclick="addToCart()">Thêm vào giỏ hàng</span>
                            <span class="app__btn">Mua ngay</span>
                        </div>
                        <div class="app-content-info__tel">
                            Gọi đặt hàng: <a href="tel: 0961271218">0961271218</a> 
                            hoặc <a href="tel: 0961271218">0961271218</a>
                        </div>
                    </div>
                    <div class="col l-3 m-0 c-12">
                        <div class="app-content-info__extra">
                            <div class="app-content-info-extra__item">
                                <i class="far fa-heart"></i>
                                <p>Thêm vào danh sách yêu thích</p>
                            </div>
                            <div class="app-content-info-extra__item">
                                <i class="fas fa-user-shield"></i>
                                <p>Ưu đãi cho khách hàng thân thiết</p>
                            </div>
                            <div class="app-content-info-extra__item">
                                <i class="fas fa-truck-moving"></i>
                                <p>Để được miễn phí vận chuyển</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row2">
                    <div class="row2__title">Giới thiệu sản phẩm</div>
                    <div class="row2__introduce">
                        <p>${book.name}</p>
                        <span>${book.description}</span>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="app-content__comment">
        <div class="grid wide">
            <div class="app-content__comment-wrapper">
                <div class="app-content-comment__text">Nhận xét của khách hàng</div>
                <div class="app-content-comment__not-auth">
                    Bạn cần đăng nhập để bình luận.
                    <a href="<c:url value='/login' />">Đăng nhập tại đây.</a>
                </div>
                <div class="app-content-comment__input">
                    <span class="app__btn" onclick="sendComment()">
                        <span class="material-icons-outlined">question_answer</span>
                        Bình luận
                    </span>
                    <input type="text" name="txt-comment" id="txt-comment" placeholder="Nhập đánh giá của bạn vào đây nhé...">
                </div>
                <ul class="app-content-comment__list">
                    <%-- <li class="app-content-comment__item">
                        <div class="app-content-comment-item__info">
                            <div class="app-content-comment-item-info__user">
                                <img src="../assets/images/user.png" alt="user">
                                <div>
                                    <span class="app-content-comment-item-info__user-username">qkhanh</span>
                                    <span class="app-content-comment-item-info__user-fullname">Nguyễn Quốc Khánh</span>
                                </div>
                            </div>
                            <div class="app-content-comment-item-info__time">
                                <span class="material-icons-outlined">schedule</span>
                                Bình luận 3 phút trước
                            </div>
                        </div>
                        <div class="app-content-comment-item__content">Sách hay. Mọi người hãy mua và đọc cảm nhận nhé!</div>
                    </li> --%>
                    <li class="app-content-comment__no-comment">Chưa có bình luận nào.</li>
                </ul>
            </div>
        </div>
    </div>
</div>
<script src="<c:url value='/template/js/main_base.js' />"></script>
<script src="<c:url value='/template/js/main_book.js' />"></script>