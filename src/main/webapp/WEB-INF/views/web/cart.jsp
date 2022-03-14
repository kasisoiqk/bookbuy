<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<script>document.title = 'Giỏ hàng | Book Buy'</script>
<link rel="stylesheet" href="<c:url value='/template/css/style_cart.css' />">
<link rel="stylesheet" href="<c:url value='/template/css/responsive_cart.css' />">
<div class="app__content">
    <div class="grid wide">
        <div class="app-content__linker">
            <div class="grid wide">
                <ul class="app-content__linker-wrapper">
                    <li><a href="<c:url value='/home' />"><span class="material-icons-outlined">home</span>Trang chủ</a></li>
                    <li><a href="#">/ Giỏ hàng</a></li>
                </ul>
            </div>
        </div>
        <div class="app-content__cart-list">
            <div class="row">
                <div class="col l-9 m-9 c-12">
                    <div class="app-content-cart-list__text">Giỏ Hàng</div>
                    <!-- Cart empty class: cart-empty -->
                        <div class="app-content-cart-list__list"></div>
                    </div>
                    <div class="col l-3 m-3 c-12">
                        <div class="app-content-cart-list__checkout">
                            <div class="app-content-cart-list-checkout__body">
                                <div class="app-content-cart-list-checkout-body__quantity">2 sản phẩm</div>
                                <div class="app-content-cart-list-checkout-body__total-price">636,000đ</div>
                                <div class="app-content-cart-list-checkout-body__extra">( Chưa có cước vận chuyển )
                                </div>
                            </div>
                            <a href="<c:url value='/checkout/address' />" class="app-content-cart-list-checkout__btn">Tiến hành đặt
                                hàng</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="<c:url value='/template/js/main_base.js' />"></script>
<script src="<c:url value='/template/js/main_cart.js' />"></script>