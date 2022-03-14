<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<script>document.title = 'Kiểm tra đơn hàng | Book Buy'</script>
<link rel="stylesheet" href="<c:url value='/template/css/style_purchase.css' />">
<div class="app__content">
    <div class="app-content__linker">
        <div class="grid wide">
            <ul class="app-content__linker-wrapper">
                <li><a href="<c:url value='home' />"><span class="material-icons-outlined">home</span>Trang chủ</a></li>
                <li><a href="#">/ Kiểm tra đơn hàng</a></li>
            </ul>
        </div>
    </div>
    <div class="app-content__body">
        <div class="grid wide">
            <ul class="app-content-body__navbar">
                <li class="app-content-body__navbar-item item--active">Tất cả</li>
                <li class="app-content-body__navbar-item">Chờ xác nhận</li>
                <li class="app-content-body__navbar-item">Đang giao</li>
                <li class="app-content-body__navbar-item">Đã giao</li>
                <li class="app-content-body__navbar-item">Đã hủy</li>
            </ul>
            <div class="app-container-content__search">
                <!-- Re-use header search -->
                <div class="app-header__search" style="margin-top: 12px">
                    <span class="material-icons-outlined" onclick="getDataPurchase()">search</span>
                    <input type="text" id="search-id" name="search-id" placeholder="Nhập mã đơn hàng hoặc tên đơn hàng muốn tìm...">
                </div>
            </div>
            <div id="search__text" class="active-color" style="line-height: 3rem; margin-top: 12px;">Bạn hãy nhập mã đơn hàng của bạn để xem thông tin chi tiết nhé!</div>
            <ul class="app-content-body__list">
                <%-- <li class="app-content-body__list-item">
                    <div class="app-content-body-list-item__info">
                        <div class="app-content-body-list-item__img">
                            <img src="../assets/images/tho-peter-cuoc-giai-cuu-ngay-giang-sinh_32047_1.png" alt="">
                        </div>
                        <div class="app-content-body-list-item__name">
                            <h2>NHÀ SÁCH TRỰC TUYẾN BOOKBUY.VN
                                Mua sách online tại nhà sách trực tuyến Bookbuy.vn để được cập nhật nhanh nhất các tựa sách đủ thể loại với mức giảm 15 – 35% cùng nhiều ưu đãi, quà tặng kèm. Qua nhiều năm, không chỉ là địa chỉ tin cậy để bạn mua sách trực tuyến, Bookbuy còn có quà tặng, văn phòng phẩm, vật dụng gia đình,…với chất lượng đảm bảo, chủng loại đa dạng, chế độ bảo h</h2>
                            <p>Nguyễn Văn A</p>
                            <span>x 2</span>
                        </div>
                        <div class="app-content-body-list-item__price">
                            <div class="app-content-body-list-item__price-current">99,000đ</div>
                            <div class="app-content-body-list-item__price-old">100,000đ</div>
                        </div>
                    </div>
                    <div class="app-content-body-list-item__control">
                        <div class="app-content-body-list-item-control__left">
                            <h2>Q Khanh</h2>
                            <p>Nam Định</p>
                            <span>091221892</span>
                        </div>
                        <div class="app-content-body-list-item-control__center">Chờ xác nhận</div>
                        <div class="app-content-body-list-item-control__right">
                            <h2><i class="fas fa-tags"></i> Tổng số tiền: &nbsp;<p>99,000đ</p>
                            </h2>
                            <span class="app__btn">Hủy</span>
                        </div>
                    </div>
                </li> --%>
            </ul>
            <div id="btn-cancel" style="height: 60px;"></div>
        </div>
    </div>
</div>
<script src="<c:url value='/template/js/main_base.js' />"></script>
<script src="<c:url value='/template/js/main_purchase.js' />"></script>