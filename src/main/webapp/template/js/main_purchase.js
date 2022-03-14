// Declare variable
var account, id;
var purchases = [];
var customer = {};

// Get data
function getDataPurchase() {
    id = document.getElementById('search-id').value;
    id = id.replaceAll('DH', '');
    if(id == '') {
        document.getElementById('search__text').innerText = `Bạn hãy nhập vào mã đơn hàng của bạn để xem chi tiết nhé!`;
        return;
    }
    if(isNaN(parseInt(id))) {
        document.getElementById('search__text').innerText = `Không tồn tại đơn hàng có mã: ${document.getElementById('search-id').value}`
        return;
    }
    id = parseInt(id);

    var http = new XMLHttpRequest();

    http.open('GET', path + `api/list-purchases?id=${id}`, true);

    http.send();

    http.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var responseData = JSON.parse(this.responseText);
            var data = responseData.data;
            purchases = data.purchases;
            customer = data.customer;
            renderPurchases();
        }
    }
}

// Render data
function renderPurchases() {
    const purchaseDOM = document.querySelector('.app-content-body__list');
    purchaseDOM.innerHTML = '';

    if(purchases.length <= 0) {
        document.getElementById('search__text').innerText = `Không tồn tại đơn hàng có mã: ${document.getElementById('search-id').value}`
        return;
    }

    document.getElementById('search__text').innerText = `Bạn đang tìm với đơn hàng có mã: ${document.getElementById('search-id').value}`;

    purchases.forEach(function(value) {
        var purchaseItem = document.createElement('li');
        purchaseItem.classList.add('app-content-body__list-item');

        if(value.status < 2) {
            document.getElementById('btn-cancel').innerHTML = '<span class="app__btn" style="float: right; margin: 10px 0;" onclick="showDialogQuestion()">Hủy đơn hàng</span>';
        }

        var status = '';
        if(value.status == 0) status = 'Chờ xác nhận';
        else if(value.status == 1) status = 'Đã đóng gói';
        else if(value.status == 2) status = 'Đang vận chuyển';
        else if(value.status == 3) status = 'Đã giao hàng';
        else if(value.status == 4) status = 'Đã hủy';

        purchaseItem.innerHTML = `
        <div class="app-content-body-list-item__info">
            <div class="app-content-body-list-item__img">
                <img src="template/images/${value.image}" alt="">
            </div>
            <div class="app-content-body-list-item__name">
                <h2>${value.bookName}</h2>
                <p>${value.author}</p>
                <span>x ${value.quantity}</span>
            </div>
            <div class="app-content-body-list-item__price">
                <div class="app-content-body-list-item__price-current">${new Intl.NumberFormat().format(value.currentPrice)}đ</div>
                <div class="app-content-body-list-item__price-old">${new Intl.NumberFormat().format(value.oldPrice)}đ</div>
            </div>
        </div>
        <div class="app-content-body-list-item__control">
            <div class="app-content-body-list-item-control__left">
                <h2>${customer.fullName}</h2>
                <p>${customer.number + ', ' + customer.ward + ', ' + customer.district + ', ' + customer.province}</p>
                <span>${customer.phone}</span>
            </div>
            <div class="app-content-body-list-item-control__center">${status}</div>
            <div class="app-content-body-list-item-control__right">
                <h2>
                    <i class="fas fa-tags"></i> 
                    Tổng số tiền: &nbsp;<p>${new Intl.NumberFormat().format(value.currentPrice*value.quantity)}đ</p>
                </h2>
            </div>
        </div>
        `;

        purchaseDOM.appendChild(purchaseItem);
    });
}

// Show Dialog
function showDialog({ title = '', content = '', btn1 = '', btn2 = '' , id = 0}) {
    var modalDOM = document.querySelector('.modal');
    modalDOM.innerHTML = '';

    var dialog = document.createElement('div');
    dialog.classList.add('modal__dialog');

    dialog.innerHTML = `
    <div class="modal-dialog__title">${title}</div>
    <div class="modal-dialog__content">${content}</div>
    <div class="modal-dialog__btn">
        <span class="modal-dialog__btn-yes" onclick="closeDialog(), cancelPurchase()">${btn1}</span>
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

function showDialogQuestion() {
    showDialog({
        title: 'Hủy',
        content: `Bạn có muốn hủy đơn hàng có mã ${id} không?`,
        btn1: 'Có',
        btn2: 'Không',
        id: id
    });
}

function cancelPurchase() {
    var http = new XMLHttpRequest();
    http.open('GET', path + `api/cancel-purchase?id=${id}`);
    http.send();
   
    http.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200) {
            var responseData = JSON.parse(this.responseText);
            if(responseData.data == 'success') {
                showToast({
                    message: 'Bạn vừa hủy thành công đơn hàng có mã: ' + id,
                    type: 'success',
                    duration: 3000 
                });
                document.querySelector('.app-content-body__list').innerHTML = '';
                document.getElementById('btn-cancel').innerHTML = '';
                document.getElementById('search__text').innerText = `Bạn hãy nhập mã đơn hàng của bạn để xem thông tin chi tiết nhé!`;
            }
            else {
                showToast({
                    message: 'Có lỗi sảy ra khiến đơn hàng của bạn không được hủy.',
                    type: 'error',
                    duration: 3000 
                });
            }
        }
    }
}

// Call function
loadHeader();
getCurrentAccount();

document.getElementById('search-id').addEventListener('keyup', function(event) {
    if(event.keyCode == 13) {
        getDataPurchase();
    }
});