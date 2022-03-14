// Declare variable
var purchases = [];

// Get data
function getDataPurchases() {
    var http = new XMLHttpRequest();
    http.open('GET', `${path}admin/api/list-purchases`);
    http.send();

    http.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200) {
            var responseData = JSON.parse(this.responseText);
            purchases = responseData.data;
            renderPurchases();
        }
    }
}

// Render purchase
function renderPurchases() {
    var purchasesDOM = document.querySelector('.app-container-content__list tbody');
    purchasesDOM.innerHTML = '';

    purchases.forEach(function(value) {
        var purchaseItem = document.createElement('tr');

        var persudoClass = '';
        if(value.status == 0) {
            value.status = 'Chờ xác nhận';
            persudoClass = 'status-waiting';
        }
        else if(value.status == 1) {
            value.status = 'Đang đóng gói';
            persudoClass = 'status-packing';
        }
        else if(value.status == 2) {
            value.status = 'Đang vận chuyển';
            persudoClass = 'status-delivering';
        }
        else if(value.status == 3) {
            value.status = 'Đã giao';
            persudoClass = 'status-delivered';
        }
        else {
            value.status = 'Đã hủy';
            persudoClass = 'status-canceled';
        }

        var listCartsDOM = '', total = 0;
        value.carts.forEach(function(cart) {
            total += (cart.quantity * cart.currentPrice);
            listCartsDOM += `<div class="app-container-content__item-user-info">SA${formatItemID(cart.id)} - ${cart.bookName} - Giá: ${new Intl.NumberFormat().format(cart.currentPrice)}đ - SL: ${cart.quantity}</div>`;
        });

        purchaseItem.innerHTML = `
        <td>DH${formatItemID(value.id)}</td>
        <td style="text-align: center;"><p class="app-container-content__status ${persudoClass}">${value.status}</p></td>
        <td>
            <div class="app-container-content__item-user" style="flex-direction: column; align-items: baseline;">
                <p style="line-height: 2rem;">Họ và tên: ${value.customer.fullName}</p>
                <p style="line-height: 2rem;">Số điện thoại: ${value.customer.phone}</p>
                <p style="line-height: 2rem;">Thông tin thêm: ${value.customer.infoExtra}</p>
                <p style="line-height: 2rem;">Địa chỉ: ${value.customer.number}, ${value.customer.ward}, ${value.customer.district}, ${value.customer.province}</p>
            </div>
        </td>
        <td>
            ${listCartsDOM}
            <div class="app-container-content__item-user-info">Tổng tiền: <b style="font-weight: 600;">${new Intl.NumberFormat().format(total)}đ</b></div>
        </td>
        <td>Thanh toán khi nhận hàng</td>
        <td>30,000đ</td>
        <td style="color: var(--red-color);">${new Intl.NumberFormat().format(value.totalPayment)}đ</td>
        <td style="text-align: center;">
            <label for="cbo-show-modal" class="app__btn" onclick="showEdit(${value.id})">Chi tiết</label>
        </td>
        `;

        purchasesDOM.appendChild(purchaseItem);
    });
}

// Show modal input
function showEdit(id) {
    var purchase = purchases.find(function(value) {
        return value.id == id;
    });

    var modalDOM = document.querySelector('.modal__input');

    if(modalDOM.classList.contains('modal__input-create')) {
        modalDOM.classList.remove('modal__input-create');
    }
    if(!modalDOM.classList.contains('modal__input-edit')) {
        modalDOM.classList.add('modal__input-edit');
    }

    document.getElementById('purchase-id').value = `DH${formatItemID(purchase.id)}`;
    document.getElementById('purchase-status').value = purchase.status;
    
    if(purchase.status == 'Chờ xác nhận') {
        document.getElementById('change-status').innerText = 'Xác nhận đơn hàng';
    }
    else if(purchase.status == 'Đang đóng gói') {
        document.getElementById('change-status').innerText = 'Chuyển sang khu vận chuyển';
    }
    else if(purchase.status == 'Đang vận chuyển') {
        document.getElementById('change-status').innerText = 'Xác nhận đã giao';
    }
    else if(purchase.status == 'Đã giao') {
        document.getElementById('change-status').innerText = 'Thành công';
    }
    else {
        document.getElementById('change-status').innerText = 'Bỏ hủy đơn hàng';
    }
}

// edit purchase
function editPurchase(method) {
    var text = document.getElementById('purchase-id').value;
    var id = parseInt(text.replaceAll('DH', ''));

    var http = new XMLHttpRequest();
    http.open(method, `${path}admin/api/purchase?id=${id}`)
    http.send()

    http.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200) {
            var responseData = JSON.parse(this.responseText);
            if(responseData.data == 'success') {
                if(method == 'PUT') {
                    showToast({
                        message: 'Thay đổi trạng thái đơn hàng thành công! ' + text,
                        type: 'success',
                        duration: 3000
                    });
                }
                else if(method == 'DELETE') {
                    showToast({
                        message: 'Hủy đơn hàng thành công! ' + text,
                        type: 'success',
                        duration: 3000
                    });
                }
                getDataPurchases();
            }
            else if(responseData.data == "can't") {
                if(method == 'PUT') {
                    showToast({
                        message: 'Đơn hàng đã đạt trạng thái thành công! ' + text,
                        type: 'info',
                        duration: 3000
                    });
                }
                else if(method == 'DELETE') {
                    showToast({
                        message: 'Không thể hủy đơn hàng! ' + text,
                        type: 'info',
                        duration: 3000
                    });
                }
            }
            else {
                showToast({
                    message: 'Có lỗi sảy ra, bạn vui lòng thử lại nhé! ' + text,
                    type: 'error',
                    duration: 3000
                });
            }
        }
    }
}

// Call function
getDataPurchases();