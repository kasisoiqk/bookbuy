<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<script>document.title = 'Quản lý danh mục sách | Book Buy'</script>
<div class="app__container">
    <div class="app-content__linker">
        <div class="grid wide">
            <ul class="app-content__linker-wrapper">
                <li><a href="<c:url value='/home' />"><span class="material-icons-outlined">home</span>Trang chủ</a></li>
                <li><a href="<c:url value='/admin/home' />">/ Quản trị</a></li>
                <li><a href="#">/ Quản lý danh mục sách</a></li>
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
                        <li class="app-container-menu-control__item active-color">
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
                    <div class="app-container-content__text">Danh sách danh mục sách</div>
                    <div class="app-container-content__search">
                        <!-- Re-use header search -->
                        <div class="app-header__search" style="background-color: transparent;">
                            <span class="material-icons-outlined">search</span>
                            <input type="hidden" name="id-cate" id="id-cate" value="">
                            <input type="text" id="txt-search" name="txt-search"
                                placeholder="Nhập mã danh mục hoặc tên danh mục muốn tìm...">
                        </div>
                    </div>
                    <div class="app-container-content__search-text active-color">Nội dung tìm kiếm: AAA</div>
                    <div class="app-container-content__btn-add">
                        <label for="cbo-show-modal" class="app__btn" onclick="showCreate()"
                            style="display: inline-block;">+ Thêm mới danh mục</label>
                    </div>
                    <div class="app-container-content__list">
                        <table>
                            <thead>
                                <th>Mã danh mục</th>
                                <th>Tên danh mục</th>
                                <th>Thao tác</th>
                            </thead>
                            <!-- Render data -->
                            <tbody></tbody>
                        </table>

                        <input type="checkbox" id="cbo-show-modal" hidden>
                        <label for="cbo-show-modal" class="modal">
                            <!-- Prefix class: create: modal__input-create; edit: modal__input-edit -->
                            <label for="none" class="modal__input modal__input-edit" style="max-width: 600px;">
                                <form action="" method="POST">
                                    <div class="modal-input__text hide-on-create">
                                        <h2>Chi tiết thông tin danh mục!</h2>
                                        <p>Bạn có thể cập nhật hoặc xóa danh mục</p>
                                    </div>
                                    <div class="modal-input__text hide-on-edit">
                                        <h2>Thêm danh mục mới!</h2>
                                        <p>Bạn có thể thêm danh mục</p>
                                    </div>
                                    <div class="row">
                                        <div class="col l-12">
                                            <div class="modal-input__info">
                                                <div class="modal-input__group">
                                                    <i class="fas fa-book"></i>
                                                    <input type="hidden" name="cate-id" id="cate-id">
                                                    <input type="text" name="cate-name" id="cate-name"
                                                        placeholder="Nhập tên danh mục..." required>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="modal-input__btn">
                                        <span class="hide-on-edit" style="flex: 1;" onclick="editCate('POST')">Thêm mới</span>
                                        <span class="hide-on-create" style="flex: 2;" onclick="editCate('PUT')">Cập nhật</span>
                                        <span class="hide-on-create" style="flex: 1;" onclick="editCate('DELETE')">Xóa</span>
                                    </div>
                                </form>
                            </label>
                        </label>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="<c:url value='/template/js/main_base_admin.js' />"></script>
<script src="<c:url value='/template/js/main_manage_category.js' />"></script>