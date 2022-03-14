<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Địa chỉ | Book Buy</title>
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
    <link rel="stylesheet" href="<c:url value='/template/css/style_address.css' />">
    <script>
        var url = window.location.href.split('/');
        url.pop();
        url.pop();
        var path = url.join('/') + '/';
        if (localStorage.getItem('carts') == null) {
            window.location = `${path}home`;
        }
    </script>
</head>

<body>
    <div class="app">
        <div class="modal"></div>
        <label class="modal__input" style="width: 1000px; max-width: 95%;">
            <form action="<c:url value='/checkout/payment' />" method="POST">
                <div class="modal-input__text">
                    <h2>Nhập thông tin và địa chỉ nhận hàng của bạn!</h2><br>
                </div>
                <div class="row">
                    <div class="col l-6 m-6 c-12">
                        <div class="modal-input__info">
                            <div class="modal-input__group">
                                <i class="fas fa-book"></i>
                                <input type="text" name="txtName" id="name" placeholder="Nhập họ và tên của bạn..."
                                    required>
                            </div>
                            <div class="modal-input__group">
                                <i class="fas fa-user-shield"></i>
                                <input type="text" name="phone" id="phone" placeholder="Nhập số điện thoại..." required>
                            </div>
                            <div class="modal-input__group" style="height: 160px;">
                                <i class="fas fa-ticket-alt"></i>
                                <textarea name="info-extra" id="info-extra"
                                    placeholder="Nhập thông tin thêm (nếu có)..."></textarea>
                            </div>
                        </div>
                    </div>
                    <div class="col l-6 m-6 c-12">
                        <div class="modal-input__info">
                            <div class="modal-input__group">
                                <i class="fas fa-map-marked-alt"></i>
                                <select name="province" id="province" onchange="getDataDistricts()">
                                    <option value="1">--Tỉnh / Thành phố--</option>
                                </select>
                            </div>
                            <div class="modal-input__group">
                                <i class="fas fa-map-marked-alt"></i>
                                <select name="district" id="district" onchange="getDataWards()">
                                    <option value="1">--Quận / Huyện--</option>
                                </select>
                            </div>
                            <div class="modal-input__group">
                                <i class="fas fa-map-marked-alt"></i>
                                <select name="ward" id="ward">
                                    <option value="1">--Xã / Phường--</option>
                                </select>
                            </div>
                            <div class="modal-input__group" style="height: 114px;">
                                <i class="fas fa-map-signs"></i>
                                <textarea name="number" id="number"
                                    placeholder="Nhập số nhà hoặc địa chỉ cụ thể..." required></textarea>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-input__btn">
                    <button style="flex: 1;" onclick="saveCustomerInfo()">Xác nhận</button>
                    <a href="<c:url value='/home' />" style="flex: 1;">Hủy</a>
                </div>
            </form>
        </label>
    </div>

    <script src="<c:url value='/template/js/main_address.js' />"></script>
</body>

</html>