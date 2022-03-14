<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<script>document.title = 'Quản lý thông tin người dùng | Book Buy'</script>
<div class="app__container">
    <div class="app-content__linker">
        <div class="grid wide">
            <ul class="app-content__linker-wrapper">
                <li><a href="<c:url value='/home' />"><span class="material-icons-outlined">home</span>Trang chủ</a></li>
                <li><a href="<c:url value='/admin/home' />">/ Quản trị</a></li>
                <li><a href="#">/ Quản lý thông tin người dùng</a></li>
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
                        <li class="app-container-menu-control__item">
                            <a href="<c:url value='/admin/manage-purchase' />">
                                <span class="material-icons-outlined">inventory</span>
                                Quản lý đơn đặt hàng
                            </a>
                        </li>
                        <li class="app-container-menu-control__item active-color">
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
                    <div class="app-container-content__text">Danh sách thông tin người dùng</div>
                    <div class="app-container-content__search">
                        <!-- Re-use header search -->
                        <div class="app-header__search" style="background-color: transparent;">
                            <span class="material-icons-outlined">search</span>
                            <input type="text" id="txt-search" name="txt-search" placeholder="Nhập mã người dùng hoặc tên người dùng muốn tìm...">
                        </div>
                    </div>
                    <div class="app-container-content__search-text active-color">Nội dung tìm kiếm: AAA</div>
                    <div class="app-container-content__btn-add">
                        <label for="cbo-show-modal" class="app__btn" onclick="showCreate()" style="display: inline-block;">+ Thêm mới người dùng</label>
                    </div>
                    <div class="app-container-content__list">
                        <table>
                            <thead>
                                <th>Mã người dùng</th>
                                <th>Họ tên</th>
                                <th>Thông tin</th>
                                <th>Tên tài khoản</th>
                                <th>Mật khẩu</th>
                                <th>Phân quyền</th>
                                <th>Thao tác</th>
                            </thead>
                            <!-- Render data -->
                            <tbody></tbody>
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
                                    <div class="modal-input__text hide-on-edit">
                                        <h2>Thêm người dùng mới!</h2>
                                        <p>Bạn có thể thêm người dùng</p>
                                    </div>
                                    <div class="row">
                                        <div class="col l-12">
                                            <div class="modal-input__info">
                                                <div class="modal-input__group">
                                                    <i class="fas fa-user-edit"></i>
                                                    <input type="hidden" name="user-id" id="user-id">
                                                    <input type="text" name="name" id="name" placeholder="Nhập họ tên..." required>
                                                </div>
                                                <div class="modal-input__group" style="gap: 0 4px; background-color: transparent;">
                                                    <div class="modal-input__group" style="margin: 0;">
                                                        <i class="fas fa-birthday-cake"></i>
                                                        <input type="date" name="birth" id="birth" required>
                                                    </div>
                                                    <div class="modal-input__group" style="margin: 0;">
                                                        <i class="fas fa-restroom"></i>
                                                        <input type="radio" style="width: 16px; height: 16px; " name="gender" id="male">
                                                        <label style="flex: 2;" for="male">Nam</label>
                                                        <input type="radio" style="width: 16px; height: 16px; " name="gender" id="female">
                                                        <label style="flex: 2;" for="female">Nữ</label>
                                                        <input type="radio" style="width: 16px; height: 16px; " name="gender" id="genderElse">
                                                        <label style="flex: 2;" for="genderElse">Khác</label>
                                                    </div>
                                                </div>
                                                <div class="modal-input__group" style="gap: 0 4px; background-color: transparent;">
                                                    <div class="modal-input__group" style="margin: 0;">
                                                        <i class="fas fa-phone-square-alt"></i>
                                                        <input type="text" name="phone" id="phone" placeholder="Nhập số điện thoại..." required>
                                                    </div>
                                                    <div class="modal-input__group" style="margin: 0;">
                                                        <i class="fas fa-envelope"></i>
                                                        <input type="text" name="email" id="email" placeholder="Nhập email..." required>
                                                    </div>
                                                </div>
                                                <div class="modal-input__group">
                                                    <i class="fas fa-user"></i>
                                                    <input type="text" name="username" id="username" placeholder="Nhập tên tài khoản..." required>
                                                </div>
                                                <div class="modal-input__group">
                                                    <i class="fas fa-key"></i>
                                                    <input type="text" name="password" id="password" placeholder="Nhập mật khẩu..." required>
                                                </div>
                                                <div class="modal-input__group">
                                                    <i class="fas fa-users-cog"></i>
                                                    <select name="permisstion" id="permission">
                                                        <option value="USER">USER</option>
                                                        <option value="ADMIN">ADMIN</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="modal-input__btn">
                                        <span class="hide-on-edit" style="flex: 1;" onclick="editUser('POST')">Thêm mới</span>
                                        <span class="hide-on-create" style="flex: 2;" onclick="editUser('PUT')">Cập nhật</span>
                                        <span class="hide-on-create" style="flex: 1;" onclick="editUser('DELETE')">Xóa</span>
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
<script src="<c:url value='/template/js/main_manage_user.js' />"></script>