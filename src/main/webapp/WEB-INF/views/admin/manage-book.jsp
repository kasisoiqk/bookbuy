<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<script>document.title = 'Quản lý thông tin sách | Book Buy'</script>
<div class="app__container">
    <div class="app-content__linker">
        <div class="grid wide">
            <ul class="app-content__linker-wrapper">
                <li><a href="<c:url value='/home' />"><span class="material-icons-outlined">home</span>Trang chủ</a></li>
                <li><a href="<c:url value='/admin/home' />">/ Quản trị</a></li>
                <li><a href="#">/ Quản lý thông tin sách</a></li>
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
                        <li class="app-container-menu-control__item active-color">
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
                    <div class="app-container-content__text">Danh sách thông tin sách</div>
                    <div class="app-container-content__search">
                        <!-- Re-use header search -->
                        <div class="app-header__search" style="background-color: transparent;">
                            <span class="material-icons-outlined">search</span>
                            <input type="hidden" name="id-cate" id="id-cate" value="">
                            <input type="text" id="txt-search" name="txt-search"
                                placeholder="Nhập mã sách hoặc tên sách muốn tìm...">
                        </div>
                        <!-- Re-use header filter home page -->
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
                    </div>
                    <div class="app-container-content__search-text active-color">Nội dung tìm kiếm: AAA - Danh
                        mục: Tất cả</div>
                    <div class="app-container-content__btn-add">
                        <label for="cbo-show-modal" class="app__btn" onclick="showCreate()"
                            style="display: inline-block;">+ Thêm mới sách</label>
                    </div>
                    <div class="app-container-content__list">
                        <table>
                            <thead>
                                <th>Mã sách</th>
                                <th>Ảnh</th>
                                <th>Thông tin</th>
                                <th>Giá bán</th>
                                <th>Số lượng</th>
                                <th>Thao tác</th>
                            </thead>
                            <!-- Render data -->
                            <tbody></tbody>
                        </table>

                        <input type="checkbox" id="cbo-show-modal" hidden>
                        <label for="cbo-show-modal" class="modal">
                            <!-- Prefix class: create: modal__input-create; edit: modal__input-edit -->
                            <label for="none" class="modal__input modal__input-edit">
                                <div>
                                    <div class="modal-input__text hide-on-create">
                                        <h2>Chi tiết thông tin sách!</h2>
                                        <p>Bạn có thể cập nhật hoặc xóa sách</p>
                                    </div>
                                    <div class="modal-input__text hide-on-edit">
                                        <h2>Thêm sách mới!</h2>
                                        <p>Bạn có thể thêm sách</p>
                                    </div>
                                    <div class="row">
                                        <div class="col l-8">
                                            <div class="modal-input__info">
                                                <div class="modal-input__group">
                                                    <i class="fas fa-book"></i>
                                                    <input type="hidden" name="id" id="book-id">
                                                    <input type="text" name="book-name" id="book-name"
                                                        placeholder="Nhập tên sách..." required>
                                                </div>
                                                <div class="modal-input__group">
                                                    <i class="fas fa-user-shield"></i>
                                                    <input type="text" name="book-author" id="book-author"
                                                        placeholder="Nhập tác giả..." required>
                                                </div>
                                                <div class="modal-input__group">
                                                    <i class="fas fa-bookmark"></i>
                                                    <select name="book-cate" id="book-cate"></select>
                                                </div>
                                                <div class="modal-input__group"
                                                    style="gap: 0 4px; background-color: transparent;">
                                                    <div class="modal-input__group" style="margin: 0;">
                                                        <i class="fas fa-money-bill-alt"></i>
                                                        <input type="text" name="book-current-price"
                                                            id="book-current-price"
                                                            placeholder="Nhập giá bán..." required>
                                                    </div>
                                                    <div class="modal-input__group" style="margin: 0;">
                                                        <i class="far fa-money-bill-alt"></i>
                                                        <input type="text" name="book-old-price"
                                                            id="book-old-price"
                                                            placeholder="Nhập giá chưa giảm..." required>
                                                    </div>
                                                </div>
                                                <div class="modal-input__group">
                                                    <i class="fas fa-ticket-alt"></i>
                                                    <input type="text" name="book-sale" id="book-sale"
                                                        placeholder="Nhập phần trăm giảm giá..." required>
                                                </div>
                                                <div class="modal-input__group">
                                                    <i class="fas fa-sort-numeric-up-alt"></i>
                                                    <input type="text" name="book-quantity" id="book-quantity"
                                                        placeholder="Nhập số lượng..." required>
                                                </div>
                                                <div class="modal-input__group">
                                                    <i class="fas fa-file-alt"></i>
                                                    <input type="text" name="book-description"
                                                        id="book-description" placeholder="Nhập mô tả..."
                                                        required>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col l-4">
                                            <form id="post-form" class="modal-input__img" enctype="multipart/form-data">
                                                <input type="file" name="book-img" id="book-img" hidden>
                                                <input type="text" name="test" id="test" value="test123" hidden>
                                                <img id="image-change" src="<c:url value='/template/images/tho-peter-cuoc-giai-cuu-ngay-giang-sinh_32047_1.png' />"
                                                    alt="">
                                                <span class="app__btn" onclick="document.getElementById('book-img').click()">Chọn ảnh</span>
                                                <p>(Kích thước ảnh tối đa 1MB)</p>
                                            </form>
                                        </div>
                                    </div>
                                    <div class="modal-input__btn">
                                        <span class="hide-on-edit" style="flex: 1;" onclick="editBook('POST')">Thêm mới</span>
                                        <span class="hide-on-create" style="flex: 2;" onclick="editBook('PUT')">Cập nhật</span>
                                        <span class="hide-on-create" style="flex: 1;" onclick="editBook('DELETE')">Xóa</span>
                                    </div>
                                </div>
                            </label>
                        </label>
                    </div>

                    <div class="grid wide">
                        <div class="row">
                            <div class="col l-12 m-12 c-12">
                                <!-- Pagination -->
                                <div class="app-content__pagination"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="<c:url value='/template/js/main_base_admin.js' />"></script>
<script src="<c:url value='/template/js/main_manage_book.js' />"></script>