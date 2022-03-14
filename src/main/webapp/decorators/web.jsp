<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mua sách online nhanh nhất | Book buy</title>
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
    <link rel="stylesheet" href="<c:url value='/template/css/style_home.css' />">
    <link rel="stylesheet" href="<c:url value='/template/css/responsive_home.css' />">
</head>

<body>
    <div class="app">
        <header class="app__header">
            <div class="app-header__navbar hide-on-lower-tablet">
                <div class="grid wide">
                    <div class="app-header__navbar-wapper">
                        <div class="app-header-navbar__left">
                            <a href="#" class="app-header-navbar__item">
                                <span class="material-icons-outlined">info</span>
                                <p>Trợ giúp</p>
                            </a>
                            <a href="#" class="app-header-navbar__item">
                                <span class="material-icons-outlined">feed</span>
                                <p>Tin tức</p>
                            </a>
                            <a href="#" class="app-header-navbar__item">
                                <span class="material-icons-outlined">confirmation_number</span>
                                <p>Khuyễn mãi</p>
                            </a>
                        </div>
                        <div class="app-header-navbar__right"></div>
                    </div>
                </div>
            </div>
            <div class="app-header__mobile hide-on-lower-pc">
                <div class="grid wide">
                    <div class="app-header__mobile-wrapper">
                        <div class="app-header-mobile__left">
                            <div class="app-header-mobile-left__menu">
                                <input type="checkbox" id="cbo-mobile-menu" hidden>
                                <label for="cbo-mobile-menu"
                                    class="app-header-mobile-left__menu-icon material-icons-outlined">subject</label>
                                <label for="cbo-mobile-menu" class="app-header-mobile-left-menu__list-modal"></label>
                                <label for="cbo-mobile-menu"
                                    class="app-header-mobile-left-menu__close material-icons-outlined">close</label>
                                <label for="none" class="app-header-mobile-left-menu__list">
                                    <ul>
                                        <li class="app-header-mobile-left-menu__item">
                                            <a href="#" class="app-header-navbar__item">
                                                <span class="material-icons-outlined">login</span>
                                                <p>Đăng nhập</p>
                                            </a>
                                        </li>
                                        <li class="app-header-mobile-left-menu__item">
                                            <a href="#" class="app-header-navbar__item">
                                                <span class="material-icons-outlined">logout</span>
                                                <p>Đăng ký</p>
                                            </a>
                                        </li>
                                        <li class="app-header-mobile-left-menu__item">
                                            <a href="#" class="app-header-navbar__item">
                                                <div class="app-header-main-cart__cart">
                                                    <span class="material-icons-outlined">shopping_cart</span>
                                                    <p>2</p>
                                                </div>
                                            </a>
                                        </li>
                                        <li class="app-header-mobile-left-menu__item">
                                            <a href="#" class="app-header-navbar__item">
                                                <span class="material-icons-outlined">inventory</span>
                                                <p>Kiểm tra đơn hàng</p>
                                            </a>
                                        </li>
                                        <li class="app-header-mobile-left-menu__item">
                                            <a href="#" class="app-header-navbar__item">
                                                <span class="material-icons-outlined">card_giftcard</span>
                                                <p>Ưu đãi & tiện ích</p>
                                            </a>
                                        </li>
                                        <li class="app-header-mobile-left-menu__item">
                                            <a href="#" class="app-header-navbar__item">
                                                <span class="material-icons-outlined">confirmation_number</span>
                                                <p>Khuyễn mãi</p>
                                            </a>
                                        </li>
                                        <li class="app-header-mobile-left-menu__item">
                                            <a href="#" class="app-header-navbar__item">
                                                <span class="material-icons-outlined">feed</span>
                                                <p>Tin tức</p>
                                            </a>
                                        </li>
                                        <li class="app-header-mobile-left-menu__item">
                                            <a href="#" class="app-header-navbar__item">
                                                <span class="material-icons-outlined">info</span>
                                                <p>Trợ giúp</p>
                                            </a>
                                        </li>
                                    </ul>
                                </label>
                            </div>
                            <a href="#" class="app-header-mobile-left__logo">
                                <img src="<c:url value='/template/images/logo-new.png' />" alt="logo-new">
                            </a>
                        </div>
                        <div class="app-header-mobile__right">
                            <div class="app-header-main-cart__hotline">
                                <span class="material-icons-outlined">headset_mic</span>
                                <div class="app-header-main-cart__hotline-sub">
                                    <h2>0933 109 009</h2>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="app-header__main">
                <div class="grid wide">
                    <div class="app-header__main-wrapper">
                        <a href="<c:url value='/home' />" class="app-header-main__logo hide-on-lower-tablet">
                            <img src="<c:url value='/template/images/logo-new.png' />" alt="logo-new">
                        </a>
                        <form action="search" method="GET" class="app-header-main__search">
                            <div class="app-header-main-search__filter">
                                <div class="app-header-main-search-filter__current">
                                    <p>Tất cả</p>
                                    <span class="material-icons-outlined">unfold_more</span>
                                </div>
                                <ul class="app-header-main-search-filter__choose">
                                    <li class="app-header-main-search-filter-choose__item active-color">Tất cả</li>
                                    <li class="app-header-main-search-filter-choose__item">Truyện tranh</li>
                                    <li class="app-header-main-search-filter-choose__item">Kinh tế</li>
                                    <li class="app-header-main-search-filter-choose__item">Xã hội</li>
                                    <li class="app-header-main-search-filter-choose__item">Văn hóa - Chính trị</li>
                                    <li class="app-header-main-search-filter-choose__item">Ngoại ngữ</li>
                                    <li class="app-header-main-search-filter-choose__item">Công nghệ</li>
                                    <li class="app-header-main-search-filter-choose__item">Lập trình</li>
                                </ul>
                            </div>
                            <div class="app-header-main-search__input">
                                <input type="hidden" name="cate" id="cate" value="">
                                <input type="text" name="search" id="search" placeholder="Bạn cần tìm gì?">
                            </div>
                            <button class="app-header-main-search__btn">
                                <span class="material-icons-outlined">search</span>
                                <p class="hide-on-moblie">Tìm kiếm</p>
                            </button>
                        </form>
                        <div class="app-header-main__cart hide-on-moblie">
                            <div class="app-header-main-cart__hotline hide-on-lower-tablet">
                                <span class="material-icons-outlined">headset_mic</span>
                                <div class="app-header-main-cart__hotline-sub">
                                    <h2>0933 109 009</h2>
                                    <p>Hotline</p>
                                </div>
                            </div>
                            <!-- No cart: header-main--no-cart -->
                            <div id="cart-list" class="app-header-main-cart__cart">
                                <span class="material-icons-outlined">shopping_cart</span>
                                <a href="<c:url value='/cart' />" class="number-books-cart">2</a>
                                <div class="app-header-main-cart__list">
                                    <h2>Sách trong giỏ hàng</h2>
                                    <h2 class="header-main-no-cart__text">Giỏ hàng trống</h2>
                                    <div class="header-main-no-cart__img">
                                        <img src="<c:url value='/template/images/empty-cart.png' />" alt="empty-cart">
                                    </div>
                                    <ul class="app-header-main-cart__list-list"></ul>
                                    <div class="app-header-main-cart__view-cart">
                                        <a href="<c:url value='/cart' />">Đi tới giỏ hàng</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>

        <dec:body/>

        <footer class="app__footer">
            <div class="gird wide">
                <div class="footer__content">
                    <div class="row">
                        <div class="col l-3 m-6 c-12 footer-content__item">
                            <img src="<c:url value='/template/images/logo-new.png' />" alt="logo">
                            <p>NHÀ SÁCH TRỰC TUYẾN BOOKBUY.VN</p>
                            <div class="header-info__left footer-info">
                                <div class="header-info-left__item">
                                    <i class="far fa-envelope"></i>
                                    <a href="mailto: setsail@qode.com">bookbuy@gmail.com</a>
                                </div>
                                <div class="header-info-left__item">
                                    <i class="fas fa-phone-alt"></i>
                                    <a href="tel: 0933 109 009">0933 109 009</a>
                                </div>
                                <div class="header-info-left__item">
                                    <i class="fas fa-map-marker-alt"></i>
                                    <a href="#">Trung Hòa, Cầu Giấy, Hà Nội, Việt Nam</a>
                                </div>
                            </div>
                        </div>
                        <div class="col l-3 m-6 c-12 footer-content__item">
                            <h2 class="footer-content__title">Danh mục sách hay</h2>
                            <a href="#" class="footer-content__posts-place">
                                <p class="footer-content-posts-place__place">Truyện Thiếu nhi</p>
                                <p class="footer-content-posts-place__time">Truyện tranh</p>
                            </a>
                            <a href="#" class="footer-content__posts-place">
                                <p class="footer-content-posts-place__place">Văn học</p>
                                <p class="footer-content-posts-place__time">Văn học trong nước</p>
                            </a>
                            <a href="#" class="footer-content__posts-place">
                                <p class="footer-content-posts-place__place">Đời sống</p>
                                <p class="footer-content-posts-place__time">Bài học cuộc sống</p>
                            </a>
                        </div>
                        <div class="col l-3 m-6 c-12 footer-content__item">
                            <h2 class="footer-content__title">Đăng ký nhận bản tin từ Bookbuy</h2>
                            <p>Đừng bỏ lỡ những tin nhắn ưu đãi độc quyền dành riêng cho bạn</p>
                            <form class="footer-content__form" action="" method="POST">
                                <div class="footer-content__group">
                                    <i class="fas fa-user"></i>
                                    <input type="text" id="" name="" placeholder="Tên của bạn" required>
                                </div>
                                <div class="footer-content__group">
                                    <i class="far fa-envelope"></i>
                                    <input type="email" id="" name="" placeholder="Email" required>
                                </div>
                                <button class="footer-content__group footer-content__group--button">Đăng ký</button>
                            </form>
                        </div>
                        <div class="col l-3 m-6 c-12 footer-content__item">
                            <h2 class="footer-content__title">Trợ giúp</h2>
                            <p>Hướng dẫn mua hàng</p>
                            <p>Cách thức thanh toán</p>
                            <p>Phương thức vận chuyển</p>
                            <p>Chính sách đổi - trả</p>
                        </div>
                    </div>
                </div>
                <div class="footer__copyright">
                    <p>Powered by</p>
                    <a href="#" class="footer-copyright__info">Khanhdz 2021</a>
                </div>
            </div>
        </footer>
    </div>

    <a href="#" class="up-top">TOP</a>
    <a href="<c:url value='/chat' />" class="go-to-message">
        <i class="fas fa-comment-alt"></i>
        <p>Xem tin nhắn</p>
    </a>

    <div class="modal"></div>
    <div class="toast"></div>

    <script src="<c:url value='/template/js/toast.js' />"></script>
</body>

</html>