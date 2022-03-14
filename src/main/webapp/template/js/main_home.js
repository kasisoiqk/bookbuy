// Declare variable
var account;

var books = [];

var page = 1, size = 20;

if(GetURLParameter('page') != -1) {
    page = parseInt(GetURLParameter('page'));
}
if(GetURLParameter('size') != -1) {
    size = parseInt(GetURLParameter('size'));
}

function getCurrentAccount() {
    var http = new XMLHttpRequest();

    http.open('GET', path + `api/current-account`, true);

    http.send();

    http.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var responseData = JSON.parse(this.responseText);
            account = responseData.data;
            loadHeader();

            if(account != null) {
                showToast({
                    message: `Chào mừng ${account.fullName} đến với Book Buy!`,
                    type: 'success',
                    duration: 4000
                });
            }
        }
    }
}

// Get data
function getDataBook() {
    var http = new XMLHttpRequest();

    http.open('GET', path + `api/list-books?page=${page}&size=${size}`, true);

    http.send();

    http.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var responseData = JSON.parse(this.responseText);
            books = responseData.data;
            renderBooks();
        }
    }
}

// Render data books
function renderBooks() {
    var listBooksDOM = document.querySelector('.app-content-books__list');
    listBooksDOM.innerHTML = '';
    var row = document.createElement('div');
    row.classList.add('row');

    books.forEach(function (value, index) {
        var col = document.createElement('div');
        col.classList.add('col', 'l-2-4', 'm-6', 'c-12');
        col.style.position = 'relative';

        col.innerHTML = `
        <div class="app-content-books__container">
            <a href="book-info/${value.id}" class="app-content-books__item">
                <div class="app-content-books-item__img">
                    <img src="template/images/${value.image}" alt="">
                </div>
                <div class="app-content-books-item__info">
                    <div class="app-content-books-item-info__name">${value.name}</div>
                    <div class="app-content-books-item-info__author">${value.author}</div>
                    <div class="app-content-books-item-info__price">
                        <div class="app-content-books-item-info__price-current">${new Intl.NumberFormat().format(value.currentPrice)}đ</div>
                        <div class="app-content-books-item-info__price-old">${new Intl.NumberFormat().format(value.oldPrice)}đ</div>
                        <div class="app-content-books-item-info__price-sale">-${value.sale}%</div>
                    </div>
                </div>
            </a>
            <div class="app-content-books__pop-up">
                <div class="app-content-books-pop-up__name">${value.name}</div>
                <div class="app-content-books-pop-up__author">${value.author}</div>
                <div class="app-content-books-pop-up__price">
                    <div class="app-content-books-pop-up__price-current">${new Intl.NumberFormat().format(value.currentPrice)}đ</div>
                    <div class="app-content-books-pop-up__price-old">${new Intl.NumberFormat().format(value.oldPrice)}đ</div>
                </div>
                <div class="app-content-books-pop-up__sale">Giảm giá: ${value.sale}%</div>
                <div class="app-content-books-pop-up__btn">
                    <span onclick="addToCart(${value.id})">Thêm vào giỏ hàng</span>
                </div>
                <div class="app-content-books-pop-up__btn">
                    <a href="book-info/${value.id}">Xem chi tiết</a>
                </div>
            </div>
        </div>
        `;

        row.append(col);
    });

    listBooksDOM.append(row);
}


// Load pagination
function loadPagination() {
    var http = new XMLHttpRequest();

    http.open('GET', path + `api/number-books`, true);

    http.send();

    http.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var responseData = JSON.parse(this.responseText);
            loadPaginationToView(responseData.data);
        }
    }
}

function loadPaginationToView(numberBook) {
    var tmp = (numberBook - numberBook%size)/size; // Chia lay nguyen
    var numberPage = (numberBook/size) > tmp ? tmp + 1 : tmp;
    var pageDOM = document.querySelector('.app-content__pagination');
    pageDOM.innerHTML = `
    <a href="home.html?page=1&size=${size}" class="app-content-pagination__first-page">Về trang đầu</a>
    <a href="home.html?page=${(page - 1 > 1) ? page - 1 : 1}&size=${size}" class="app-content-pagination__before-page"><</a>
    `;

    var from, to;
    if(page <= 3) {
        from = 1;
        to = 5;
    }
    else if(page + 2 > numberPage) {
        from = numberPage - 4;
        to = numberPage;
    }
    else {
        from = page - 2;
        to = page + 2;
    }
    for(let i = from; i <= to; i++) {
        pageDOM.innerHTML += `
        <a href="home.html?page=${i}&size=${size}" class="app-content-pagination__item-page">${i}</a>
        `;
        if(i == numberPage) break;
    }
    if(to < numberPage) {
        pageDOM.innerHTML += `
        <a href="home.html?page=${numberPage}&size=${size}" class="app-content-pagination__item-page">...</a>
        `;
    }

    pageDOM.innerHTML += `
    <a href="home.html?page=${(page + 1 < numberPage) ? page + 1 : numberPage}&size=${size}" class="app-content-pagination__before-page">></a>
    <a href="home.html?page=${numberPage}&size=${size}" class="app-content-pagination__last-page">Về trang cuối</a>
    `;

    var arr = document.querySelectorAll('.app-content-pagination__item-page');
    arr.forEach(function(value) {
        if(value.innerHTML == page) {
            value.classList.add('current-page');
        }
    })
}


// Call function
loadHeader();
getCurrentAccount();
loadCategory();
getDataBook();
loadPagination();