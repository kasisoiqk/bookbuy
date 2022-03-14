// Declare variable
var categories = [];
var author = '';

var carts = [];
if (localStorage.getItem('carts') != null) {
    carts = JSON.parse(localStorage.getItem('carts'));
}

var url = window.location.href.split('/');
url.pop();
var path = url.join('/') + '/';

// Get data
function getDataCate() {
    var http = new XMLHttpRequest();

    http.open('GET', path + `api/list-categories`, true);

    http.send();

    http.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var responseData = JSON.parse(this.responseText);
            categories = responseData.data;
            loadCategory();
        }
    }
}

// Set action for category box
function loadCategory() {
    var cateDOM = document.querySelector('.app-header-main-search-filter__choose');
    cateDOM.innerHTML = '<li class="app-header-main-search-filter-choose__item active-color" onclick="categoryChange(-1, 0)">Tất cả</li>';

    categories.forEach(function (value, index) {
        cateDOM.innerHTML += `<li class="app-header-main-search-filter-choose__item" onclick="categoryChange(${index}, ${value.id})">${value.name}</li>`;
    });
}

function categoryChange(index, id) {
    var cateList = document.querySelectorAll('.app-header-main-search-filter-choose__item').forEach(function (value) {
        if (value.classList.contains('active-color')) {
            value.classList.remove('active-color');
        }
    });
    var dom = document.querySelector(`.app-header-main-search-filter-choose__item:nth-child(${index + 2})`);
    dom.classList.add('active-color');

    var textDOM = document.querySelector('.app-header-main-search-filter__current > p');
    textDOM.innerHTML = dom.innerHTML;

    document.querySelector('#cate').value = id;
}

// Get param
function GetURLParameter(sParam) {
    var sPageURL = window.location.search.substring(1);
    var sURLVariables = sPageURL.split('&');
    for (var i = 0; i < sURLVariables.length; i++) {
        var sParameterName = sURLVariables[i].split('=');
        if (sParameterName[0] == sParam) {
            return sParameterName[1];
        }
    }
    return -1;
}

// Authorization
function authorization() {
    var http = new XMLHttpRequest();

    http.open('GET', path + `api/authorization`, true);

    http.send();

    http.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var responseData = JSON.parse(this.responseText);
            author = responseData.data;
            console.log(author);
            if(author == 'ADMIN') {
                var bodyDOM = document.querySelector('body');
            
                var btnGoToAdmin = document.createElement('a');
                btnGoToAdmin.classList.add('go-to-admin');
                btnGoToAdmin.href = `${path}admin/home`;
                btnGoToAdmin.innerHTML = `
                <i class="fas fa-tools"></i>
                <p>Quay về trang quản trị</p>
                `;
                bodyDOM.appendChild(btnGoToAdmin);
            }
            else {

            }
        }
    }
}

// Set action for add to cart
function addToCart(id) {
    var hasCart = carts.find(function (value) {
        return value.id == id;
    });
    if (hasCart) {
        hasCart.quantity += 1;
        showToast({
            message: `Số lượng sách trong giỏ hàng vừa được tăng thêm 1 : ${hasCart.name}`,
            type: 'info',
            duration: 2000
        });
    }
    else {
        var newCart = books.find(function (value) {
            return value.id == id;
        });
        carts.push({
            id: newCart.id,
            name: newCart.name,
            author: newCart.author,
            image: newCart.image,
            currentPrice: newCart.currentPrice,
            quantity: 1
        });
        showToast({
            message: `Bạn đã thêm vào giỏ hàng sách: ${newCart.name}`,
            type: 'success',
            duration: 2000
        });
    }
    localStorage.setItem('carts', JSON.stringify(carts));
    loadCart();
}

function removeFromCart(id) {
    var cart = books.find(function (value) {
        return value.id == id;
    });
    carts = carts.filter(function (value) {
        return value.id != id;
    });
    showToast({
        message: `Bạn vừa xóa trong giỏ hàng sách : ${cart.name}`,
        type: 'error',
        duration: 2000
    });
    localStorage.setItem('carts', JSON.stringify(carts));
    loadCart();
}

function loadCart() {
    var cartDOM = document.getElementById('cart-list');

    document.querySelector('.number-books-cart').innerHTML = carts.length

    if (carts.length > 0) {
        if (cartDOM.classList.contains('header-main--no-cart')) {
            cartDOM.classList.remove('header-main--no-cart');
        }

        var cartListDOM = document.querySelector('.app-header-main-cart__list-list');
        cartListDOM.innerHTML = '';

        carts.forEach(function (value) {
            var item = document.createElement('li');
            item.classList.add('app-header-main-cart-list__item');

            item.innerHTML = `
            <div class="app-header-main-cart-list-item__img">
                <img src="${path}template/images/${value.image}" alt="">
            </div>
            <div class="app-header-main-cart-list-item__info">
                <div>${value.name}</div>
                <p>${value.author}</p>
                <span onclick="removeFromCart(${value.id})">Xóa</span>
            </div>
            <div class="app-header-main-cart-list-item__price">
                <h4>${new Intl.NumberFormat().format(value.currentPrice)}</h4>
                <p>${value.quantity}</p>
            </div>
            `;
            cartListDOM.append(item);
        });
    }
    else {
        if (!cartDOM.classList.contains('header-main--no-cart')) {
            cartDOM.classList.add('header-main--no-cart');
        }
    }
}


// Authentication
function getCurrentAccount() {
    var http = new XMLHttpRequest();

    http.open('GET', path + `api/current-account`, true);

    http.send();

    http.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var responseData = JSON.parse(this.responseText);
            account = responseData.data;
            loadHeader();
        }
    }
}

function loadHeader() {
    var headerDOM = document.querySelector('.app-header-navbar__right');
    headerDOM.innerHTML = `
    <a href="#" class="app-header-navbar__item">
        <span class="material-icons-outlined">card_giftcard</span>
        <p>Ưu đãi & tiện ích</p>
    </a>
    <a href="${path}purchase" class="app-header-navbar__item">
        <span class="material-icons-outlined">inventory</span>
        <p>Kiểm tra đơn hàng</p>
    </a>
    `;

    if(account) {
        headerDOM.innerHTML += `
        <a href="${path}user-info" class="app-header-navbar__item">
            <span class="material-icons-outlined">account_circle</span>
            <p>${account.fullName}</p>
        </a>
        <a href="${path}logout" class="app-header-navbar__item">
            <span class="material-icons-outlined">logout</span>
            <p>Đăng xuất</p>
        </a>
        `;
    }
    else {
        headerDOM.innerHTML += `
        <a href="${path}login" class="app-header-navbar__item">
            <span class="material-icons-outlined">login</span>
            <p>Đăng nhập</p>
        </a>
        <a href="${path}signup" class="app-header-navbar__item">
            <span class="material-icons-outlined">logout</span>
            <p>Đăng ký</p>
        </a>
        `;
    }
    
}

// Call function
getDataCate();
authorization();
loadCart();