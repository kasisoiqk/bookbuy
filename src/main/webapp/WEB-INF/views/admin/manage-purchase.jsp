<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<script>document.title = 'Quản lý đơn đặt hàng | Book Buy'</script>
<div class="app__container">
    <div class="app-content__linker">
        <div class="grid wide">
            <ul class="app-content__linker-wrapper">
                <li><a href="<c:url value='/home' />"><span class="material-icons-outlined">home</span>Trang chủ</a></li>
                <li><a href="<c:url value='/admin/home' />">/ Quản trị</a></li>
                <li><a href="#">/ Quản lý đơn đặt hàng</a></li>
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
                            <div class="app-container-menu-user-info__name">Nguyễn Quốc Khánh</div>
                            <div class="app-container-menu-user-info__email">quockhanh01091@gmail.com</div>
                        </div>
                    </div>
                    <ul class="app-container-menu__control">
                        <li class="app-container-menu-control__item">
                            <a href="<c:url value='/admin/manage-book' />">
                                <span class="material-icons-outlined">book</span>
                                Quản lý thông tin sách
                            </a>
                        </li>
                        <li class="app-container-menu-control__item">
                            <a href="<c:url value='/admin/manage-category' />">
                                <span class="material-icons-outlined">category</span>
                                Quản lý danh mục sách
                            </a>
                        </li>
                        <li class="app-container-menu-control__item active-color">
                            <a href="<c:url value='/admin/manage-purchase' />">
                                <span class="material-icons-outlined">inventory</span>
                                Quản lý đơn đặt hàng
                            </a>
                        </li>
                        <li class="app-container-menu-control__item">
                            <a href="<c:url value='/admin/manage-user-info' />">
                                <span class="material-icons-outlined">manage_accounts</span>
                                Quản lý thông tin người dùng
                            </a>
                        </li>
                        <li class="app-container-menu-control__item">
                            <a href="<c:url value='/chat' />">
                                <span class="material-icons-outlined">question_answer</span>
                                Chat với khách hàng
                            </a>
                        </li>
                        <li class="app-container-menu-control__item">
                            <a href="#">
                                <span class="material-icons-outlined">info</span>
                                Thông tin cửa hàng
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="col l-9 m-12 c-12">
                <div class="app-container__content">
                    <div class="app-container-content__text">Danh sách thông tin đơn đặt hàng</div>
                    <div class="app-container-content__search">
                        <!-- Re-use header search -->
                        <div class="app-header__search" style="background-color: transparent;">
                            <span class="material-icons-outlined">search</span>
                            <input type="text" id="txt-search" name="txt-search" placeholder="Nhập mã người dùng hoặc tên người dùng muốn tìm...">
                        </div>
                    </div>
                    <div class="app-container-content__search-text active-color">Nội dung tìm kiếm: AAA</div>
                    <div class="app-container-content__list">
                        <table>
                            <thead>
                                <th>Mã đơn hàng</th>
                                <th>Trạng thái</th>
                                <th>Thông tin chi tiết người nhận</th>
                                <th>Thông tin chi tiết sản phẩm</th>
                                <th>Cách thức thanh toán</th>
                                <th>Phí ship</th>
                                <th>Tổng tiền trả</th>
                                <th>Thao tác</th>
                            </thead>
                            <!-- Render data -->
                            <tbody>
                                <tr>
                                    <td>DH00002</td>
                                    <!-- Chờ xác nhận: status-waiting; Đang đóng gói: status-packing; -->
                                    <!-- Đang vận chuyển: status-delivering; Đã giao: status-delivered; Đã hủy: status-canceled -->
                                    <td style="text-align: center;"><p class="app-container-content__status status-waiting">Đang giao hàng</p></td>
                                    <td>
                                        <div class="app-container-content__item-user" style="flex-direction: column; align-items: baseline;">
                                            <p style="line-height: 2rem;">Họ và tên: Nguyễn Quốc Khánh</p>
                                            <p style="line-height: 2rem;">Số điện thoại: 09121921922</p>
                                            <p style="line-height: 2rem;">Thông tin thêm: Nam</p>
                                            <p style="line-height: 2rem;">Địa chỉ: xóm 13, Hải Anh, Hải Hậu, Nam Định</p>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="app-container-content__item-user-info">SA0002 - Đây là tên sách đây là tên sách đây là tên sách - Giá: 20,000đ - SL: 2</div>
                                        <div class="app-container-content__item-user-info">SA0002 - Đây là tên sách đây là tên sách đây là tên sách - Giá: 20,000đ - SL: 2</div>
                                        <div class="app-container-content__item-user-info">SA0002 - Đây là tên sách đây là tên sách đây là tên sách - Giá: 20,000đ - SL: 2</div>
                                        <div class="app-container-content__item-user-info">Tổng tiền: <b style="font-weight: 600;">220,000đ</b></div>
                                    </td>
                                    <td>Thanh toán khi nhận hàng</td>
                                    <td>30,000đ</td>
                                    <td style="color: var(--red-color);">250,000đ</td>
                                    <td style="text-align: center;">
                                        <label for="cbo-show-modal" class="app__btn" onclick="showEdit(id)">Chi tiết</label>
                                    </td>
                                </tr>
                            </tbody>
                        </table>

                        <input type="checkbox" id="cbo-show-modal" hidden>
                        <label for="cbo-show-modal" class="modal">
                            <!-- Prefix class: create: modal__input-create; edit: modal__input-edit -->
                            <label for="none" class="modal__input modal__input-edit" style="max-width: 600px;">
                                <form method="POST"> 
                                    <div class="modal-input__text hide-on-create">
                                        <h2>Chi tiết thông tin người dùng!</h2>
                                        <p>Bạn có thể cập nhật hoặc xóa người dùng</p>
                                    </div>
                                    <div class="row">
                                        <div class="col l-12">
                                            <div class="modal-input__info">
                                                <div class="modal-input__group">
                                                    <i class="fas fa-clipboard-list"></i>
                                                    <input type="text" name="purchase-id" id="purchase-id" readonly>
                                                </div>
                                                <div class="modal-input__group">
                                                    <i class="fas fa-shipping-fast"></i>
                                                    <input type="text" name="purchase-status" id="purchase-status" readonly>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="modal-input__btn">
                                        <span id="change-status" class="hide-on-create" style="flex: 2;" onclick="editPurchase('PUT')">Đã xác nhận</span>
                                        <span class="hide-on-create" style="flex: 1;" onclick="editPurchase('DELETE')">Hủy đơn hàng</span>
                                    </div>
                                </form>
                            </label>
                        </label>
                    </div>
                    
                    <div class="grid wide">
                        <div class="row">
                            <div class="col l-12 m-12 c-12">
                                <!-- Pagination -->
                                <div class="app-content__pagination">
                                    <a href="#" class="app-content-pagination__first-page">Về trang đầu</a>
                                    <a href="#" class="app-content-pagination__before-page"><</a>
                                    <a href="#" class="app-content-pagination__item-page current-page">1</a>
                                    <a href="#" class="app-content-pagination__item-page">2</a>
                                    <a href="#" class="app-content-pagination__item-page">3</a>
                                    <a href="#" class="app-content-pagination__item-page">4</a>
                                    <a href="#" class="app-content-pagination__item-page">...</a>
                                    <a href="#" class="app-content-pagination__item-page">9</a>
                                    <a href="#" class="app-content-pagination__affter-page">></a>
                                    <a href="#" class="app-content-pagination__last-page">Về trang cuối</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="<c:url value='/template/js/main_base_admin.js' />"></script>
<script src="<c:url value='/template/js/main_manage_purchase.js' />"></script>