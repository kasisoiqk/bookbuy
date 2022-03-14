// Declare variable
var carts = [], customer = {};
var totalPayment = 0;

var url = window.location.href.split('/');
url.pop();
url.pop();
var path = url.join('/') + '/';

// Get data
carts = JSON.parse(localStorage.getItem('carts'));
customer = JSON.parse(localStorage.getItem('customer'));

// render data
function renderDataCart() {
    var totalPrice = 0;
    var feeShip = 30000;

    var cartDOM = document.querySelector('.app-body-bill__list-cart');
    cartDOM.innerHTML = '';

    carts.forEach(function(value) {
        totalPrice += value.quantity * value.currentPrice;

        var cart = document.createElement('div');
        cart.classList.add('app-body-bill__list-item');

        cart.innerHTML = `
        <div class="app-body-bill-list-item__name">${value.quantity} x ${value.name}</div>
        <div class="app-body-bill-list-item__price">${new Intl.NumberFormat().format(value.currentPrice)}đ</div>
        `;

        cartDOM.appendChild(cart);
    });

    totalPayment = totalPrice + feeShip;
    document.getElementById('totalPrice').innerText = `${new Intl.NumberFormat().format(totalPrice)}đ`;
    document.getElementById('feeShip').innerText = `${new Intl.NumberFormat().format(feeShip)}đ`;
    document.getElementById('totalPayment').innerText = `${new Intl.NumberFormat().format(totalPayment)}đ`;
}

function renderDataReceiver() {
    document.getElementById('receiver-name').innerText = 'Tên: ' + customer.fullName;
    document.getElementById('receiver-address').innerText = 'Địa chỉ: ' + customer.number + ', ' + customer.ward 
            + ', ' + customer.district + ', ' + customer.province;
    document.getElementById('receiver-info-extra').innerText = 'Thông tin thêm: ' + customer.infoExtra;
    document.getElementById('receiver-phone-email').innerText = 'Số điện thoại: ' + customer.phone;
}

// Show Dialog
function showDialog({ title = '', content = '', btn1 = '', btn2 = ''}) {
    var modalDOM = document.querySelector('.modal');
    modalDOM.innerHTML = '';

    var dialog = document.createElement('div');
    dialog.classList.add('modal__dialog');

    dialog.innerHTML = `
    <div class="modal-dialog__title">${title}</div>
    <div class="modal-dialog__content">${content}</div>
    <div class="modal-dialog__btn">
        <span class="modal-dialog__btn-yes" onclick="closeDialog(), order()">${btn1}</span>
        <span class="modal-dialog__btn-no" onclick="closeDialog()">${btn2}</span>
    </div>
    `;

    modalDOM.appendChild(dialog);
    modalDOM.style.display = 'block';
}

function closeDialog() {
    var modalDOM = document.querySelector('.modal');
    modalDOM.innerHTML = '';
    modalDOM.style.display = 'none';

}

// order
function showDialogQuestion() {
    showDialog({
        title: 'Đặt hàng',
        content: `Bạn có muốn xác nhận đặt hàng không? Tổng số tiền bạn phải trả là ${new Intl.NumberFormat().format(totalPayment)}đ.`,
        btn1: 'Có',
        btn2: 'Không'
    });
}

function order() {
    var data = {
        carts: carts,
        customer: customer,
        totalPayment: totalPayment
    };

    var http = new XMLHttpRequest();

    http.open('POST', path + 'api/order');
    http.setRequestHeader('Content-Type', 'application/json');
    http.send(JSON.stringify(data));

    http.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200) {
            var responseData = JSON.parse(this.responseText);
            console.log(responseData);
            if(responseData.data > 0) {
                orderSuccess(responseData.data);
                localStorage.removeItem('carts');
                localStorage.removeItem('customer');

                showToast({
                    message: 'Bạn đã đặt hàng thành công! Chúng tôi sẽ liên hệ cho bạn sớm.',
                    type: 'success',
                    duration: 4000
                });
            }
        }
    }
}

function formatItemID(id) {
    var tmp = id;
    var count = 0;
    while (tmp > 0) {
        count++;
        tmp = (tmp - tmp % 10) / 10;
    }
    while (4 - count > 0) {
        id = '0' + id;
        count++;
    }
    return id;
}

function orderSuccess(idPurchase) {
    document.querySelector('.app-body__toast').style.display = 'block';
    document.getElementById('id-purchase').innerText = `DH${formatItemID(idPurchase)}`;
    document.getElementById('customer-phone').innerText = customer.phone;

    var time = 20;
    setInterval(function() {
        document.querySelector('.app-body-toast-wrapper__time-remain').innerHTML = `Tự động quay về trang chủ sau ${time} giây!`;
        if(time == 0) {
            document.location.href = `${path}home`;
        }
        time--;
    }, 1000);
}

// Call function
renderDataCart();
renderDataReceiver()