<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thanh toán | Book Buy</title>
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
    <link rel="stylesheet" href="<c:url value='/template/css/style_payment.css' />">

    <script>
        var url = window.location.href.split('/');
        url.pop();
        url.pop();
        var path = url.join('/') + '/';
        if (localStorage.getItem('carts') == null || localStorage.getItem('customer') == null) {
            window.location = `${path}home`;
        }
    </script>
</head>

<body>
    <div class="app">
        <header class="app__header">
            <div class="grid wide">
                <div class="app__header-wrapper">
                    <div class="app-header__logo">
                        <a href="#">
                            <img src="<c:url value='/template/images/logo-new.png' />" alt="">
                        </a>
                    </div>
                    <div class="app-header__navbar">
                        <div class="app-header-navbar__item">
                            <p>1</p>
                            <span>Điền thông tin</span>
                        </div>
                        <div class="app-header-navbar__item item--active">
                            <p>2</p>
                            <span>Thanh toán và hoàn tất</span>
                        </div>
                    </div>
                    <div class="app-header__hotline">
                        <div class="app-header-main-cart__hotline">
                            <span class="material-icons-outlined">headset_mic</span>
                            <div class="app-header-main-cart__hotline-sub">
                                <h2>0933 109 009</h2>
                                <p>Hotline</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>

        <div class="app__body">
            <div class="grid wide">
                <div class="row">
                    <div class="col l-7 m-6 c-12">
                        <div class="app-body__payment-type">
                            <div class="app-body-payment-type__text">Phương thức thanh toán</div>
                            <div class="app-body-payment-type__content">
                                <div class="app-body-payment-type__content-group">
                                    <input type="radio" name="payment-type" id="type-atm">
                                    <label for="type-atm">Thẻ ATM đăng ký Internet Banking (miễn phí thanh toán)</label>
                                </div>
                                <div class="app-body-payment-type__content-group">
                                    <input type="radio" name="payment-type" id="type-wallet">
                                    <label for="type-wallet">Ví điện tử</label>
                                </div>
                                <div class="app-body-payment-type__content-group">
                                    <input type="radio" name="payment-type" id="type-gobal">
                                    <label for="type-gobal">Thẻ quốc tế / Thẻ nội địa ACB, VPBank (Moca) (miễn phí thanh
                                        toán)</label>
                                </div>
                                <div class="app-body-payment-type__content-group">
                                    <input type="radio" name="payment-type" id="type-banking">
                                    <label for="type-banking">Chuyển khoản ngân hàng</label>
                                </div>
                                <div class="app-body-payment-type__content-group">
                                    <input type="radio" name="payment-type" id="type-pay-when-receive">
                                    <label for="type-pay-when-receive">Thanh toán tiền mặt khi nhận hàng (COD)</label>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col l-5 m-6 c-12">
                        <div class="app-body__step-payment">
                            <div class="app-body-step-payment__text">Giao hàng đến</div>
                            <div class="app-body-step-payment__content">
                                <div class="app-body-step-payment-content__info" id="receiver-name">Quốc Khánh</div>
                                <div class="app-body-step-payment-content__info" id="receiver-address">Hải Hậu, Nam Định
                                </div>
                                <div class="app-body-step-payment-content__info" id="receiver-info-extra">Hải Hậu, Nam
                                    Định</div>
                                <div class="app-body-step-payment-content__info" id="receiver-phone-email">0182918212 -
                                    quockhanh@gmail.com</div>
                            </div>
                        </div>
                        <div class="app-body__bill">
                            <div class="app-body-bill__text">Đơn hàng (1 sản phẩm)</div>
                            <div class="app-body-bill__list-cart">
                                <div class="app-body-bill__list-item">
                                    <div class="app-body-bill-list-item__name">1 x Câu chuyện ngôn ngữ Câu chuyện ngôn
                                        ngữ Câu chuyện ngôn ngữ Câu chuyện ngôn ngữ Câu chuyện ngôn ngữ</div>
                                    <div class="app-body-bill-list-item__price">136,000đ</div>
                                </div>
                            </div>
                            <div class="app-body-bill__total">
                                <div class="app-body-bill__total-item">
                                    <p>Tiền hàng</p>
                                    <span id="totalPrice">136,000đ</span>
                                </div>
                                <div class="app-body-bill__total-item">
                                    <p>Phí vận chuyển</p>
                                    <span id="feeShip">30,000đ</span>
                                </div>
                            </div>
                            <div class="app-body-bill__total-payment">
                                <p>Tổng cộng</p>
                                <span id="totalPayment">166,000đ</span>
                            </div>
                        </div>
                        <span class="app-body__btn app__btn" onclick="showDialogQuestion()">Xác nhận đặt hàng</span>
                    </div>
                </div>
            </div>

            <div class="app-body__toast">
                <div class="app-body-toast__model"></div>
                <div class="app-body-toast__wrapper">
                    <div class="app-body-toast-wrapper__message">Chúc mừng bạn đã đặt hàng thành công đơn hàng! Mã đơn hàng của bạn là <b id="id-purchase">DH0005</b> và số điện thoại người nhận là <b id="customer-phone">0828281128</b>, hãy nhớ nhé!</div>
                    <img src="<c:url value='/template/images/success.gif' />" alt="success" class="app-body-toast-wrapper__img">
                    <p class="app-body-toast-wrapper__time-remain">Tự động quay về trang chủ sau 20 giây!</p>
                    <a class="app__btn app-body-toast-wrapper__btn" href="<c:url value='/home' />">Quay về trang chủ</a>
                </div>
            </div>
        </div>

        <div class="toast"></div>
        <div class="modal"></div>

        <footer class="app__footer">
            <p>Powered by <a href="https://github.com/kasisoiqk">Khanh dz 2021</a></p>
        </footer>
    </div>

    <script src="<c:url value='/template/js/toast.js' />"></script>
    <script src="<c:url value='/template/js/main_payment.js' />"></script>
</body>

</html>