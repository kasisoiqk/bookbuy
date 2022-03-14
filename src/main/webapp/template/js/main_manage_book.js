// Declare variable
var categories = [];
var books = [];

var page = 1, size = 20;

if (GetURLParameter('page') != -1) {
    page = parseInt(GetURLParameter('page'));
}
if (GetURLParameter('size') != -1) {
    size = parseInt(GetURLParameter('size'));
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
            loadListBooks();
        }
    }
}

function getDataCate() {
    var http = new XMLHttpRequest();

    http.open('GET', path + `api/list-categories`, true);

    http.send();

    http.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var responseData = JSON.parse(this.responseText);
            categories = responseData.data;
            loadListCate();
        }
    }
}

// Show modal input
function showEdit(id) {
    var book = books.find(function (value) {
        return value.id == id;
    });

    var modalDOM = document.querySelector('.modal__input');

    if (modalDOM.classList.contains('modal__input-create')) {
        modalDOM.classList.remove('modal__input-create');
    }
    if (!modalDOM.classList.contains('modal__input-edit')) {
        modalDOM.classList.add('modal__input-edit');
    }
    
    var cate = categories.find(function (cate) {
        return cate.name == book.cateName;
    });

    document.getElementById('book-id').value = book.id;
    document.getElementById('book-name').value = book.name;
    document.getElementById('book-author').value = book.author;
    document.getElementById('book-cate').value = cate.id;
    document.getElementById('book-current-price').value = book.currentPrice;
    document.getElementById('book-old-price').value = book.oldPrice;
    document.getElementById('book-sale').value = book.sale;
    document.getElementById('book-quantity').value = book.quantity;
    document.getElementById('book-description').value = book.description;
    document.querySelector('.modal-input__img img').src = `${path}template/images/${book.image}`;
}

function showCreate() {
    var modalDOM = document.querySelector('.modal__input');

    if (modalDOM.classList.contains('modal__input-edit')) {
        modalDOM.classList.remove('modal__input-edit');
    }
    if (!modalDOM.classList.contains('modal__input-create')) {
        modalDOM.classList.add('modal__input-create');
    }

    document.getElementById('book-id').value = 0;
    document.getElementById('book-name').value = '';
    document.getElementById('book-author').value = '';
    document.getElementById('book-cate').value = 0;
    document.getElementById('book-current-price').value = '';
    document.getElementById('book-old-price').value = '';
    document.getElementById('book-sale').value = '';
    document.getElementById('book-quantity').value = '';
    document.getElementById('book-description').value = '';
}

// load list books
function loadListBooks() {
    var listBooksDOM = document.querySelector('.app-container-content__list tbody');
    listBooksDOM.innerHTML = '';

    books.forEach(function (value) {
        var book = document.createElement('tr');

        book.innerHTML = `
        <td>SA${formatItemID(value.id)}</td>
        <td>
            <div class="app-container-content__item-img">
                <img src="${path}template/images/${value.image}" alt="">
            </div>
        </td>
        <td>
            <div class="app-container-content__item-name">${value.name}</div>
            <div class="app-container-content__item-author">${value.author}</div>
            <div class="app-container-content__item-category">${value.cateName}</div>
        </td>
        <td>
            <div class="app-container-content__item-current-price">${new Intl.NumberFormat().format(value.currentPrice)}đ</div>
            <div class="app-container-content__item-old-price">${new Intl.NumberFormat().format(value.oldPrice)}đ</div>
            <div class="app-container-content__item-sale">-${value.sale}%</div>
        </td>
        <td style="white-space: nowrap;">${value.quantity} quyển</td>
        <td style="text-align: center;">
            <label for="cbo-show-modal" class="app__btn" onclick="showEdit(${value.id})">Chi tiết</label>
        </td>
        `;

        listBooksDOM.appendChild(book);
    });
}

function loadListCate() {
    var cateDOM = document.getElementById('book-cate');
    cateDOM.innerHTML = '';

    var itemFirst = document.createElement('option');
    itemFirst.value = 0;
    itemFirst.innerText = '--Chọn danh mục sách--';
    cateDOM.appendChild(itemFirst);

    categories.forEach(function (value) {
        var item = document.createElement('option');
        item.value = value.id;
        item.innerText = value.name;

        cateDOM.appendChild(item);
    });

    cateDOM.value = 0;
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
    <a href="${path}admin/manage-book?page=1&size=${size}" class="app-content-pagination__first-page">Về trang đầu</a>
    <a href="${path}admin/manage-book?page=${(page - 1 > 1) ? page - 1 : 1}&size=${size}" class="app-content-pagination__before-page"><</a>
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
        <a href="${path}admin/manage-book?page=${i}&size=${size}" class="app-content-pagination__item-page">${i}</a>
        `;
        if(i == numberPage) break;
    }
    if(to < numberPage) {
        pageDOM.innerHTML += `
        <a href="${path}admin/manage-book?page=${numberPage}&size=${size}" class="app-content-pagination__item-page">...</a>
        `;
    }

    pageDOM.innerHTML += `
    <a href="${path}admin/manage-book?page=${(page + 1 < numberPage) ? page + 1 : numberPage}&size=${size}" class="app-content-pagination__before-page">></a>
    <a href="${path}admin/manage-book?page=${numberPage}&size=${size}" class="app-content-pagination__last-page">Về trang cuối</a>
    `;

    var arr = document.querySelectorAll('.app-content-pagination__item-page');
    arr.forEach(function(value) {
        if(value.innerHTML == page) {
            value.classList.add('current-page');
        }
    });

}

// Create - Update - Delete book
function editBook(method) {
    var cate = categories.find(function (cate) {
        return cate.id == document.getElementById('book-cate').value;
    });
    
    var book = {
        id: document.getElementById('book-id').value,
        name: document.getElementById('book-name').value.trim(),
        author: document.getElementById('book-author').value.trim(),
        cateName: cate.name,
        currentPrice: document.getElementById('book-current-price').value,
        oldPrice: document.getElementById('book-old-price').value,
        sale: document.getElementById('book-sale').value,
        quantity: document.getElementById('book-quantity').value,
        description: document.getElementById('book-description').value.trim(),
        image: document.querySelector('.modal-input__img img').src.split('/')[document.querySelector('.modal-input__img img').src.split('/').length-1]
    }

    var http = new XMLHttpRequest();

    http.open(method, path + `admin/api/book`, true);
    http.setRequestHeader('Content-Type', 'application/json');
    http.send(JSON.stringify(book));

    http.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var responseData = JSON.parse(this.responseText);
            console.log(responseData);
            if(responseData.data > 0) {
                if(method == 'POST') {
                    book.id = parseInt(responseData.data);
                    uploadImage(method, book);
                }
                else if(method == 'PUT') {
                    uploadImage(method, book);
                }
                else {
                    showToast({
                        message: `Bạn đã xóa sách thành công: ${book.name}`,
                        type: 'error',
                        duration: 2000
                    });
                    getDataBook();
                }
            }
            else {
                showToast({
                    message: `Có lỗi sảy ra! Vui lòng thử lại`,
                    type: 'error',
                    duration: 2000
                });
            }
        }
    }
}

// Choose file
document.getElementById('book-img').onchange = function (event) {
    document.getElementById('image-change').setAttribute('src', URL.createObjectURL(event.target.files[0]))
}

function uploadImage(method, book) {
    var formData = new FormData(document.getElementById('post-form'));
    formData.append('id', book.id);
    var http = new XMLHttpRequest();
    http.open('POST', `${path}admin/api/upload/image`);
    // http.setRequestHeader('Content-Type', 'multipart/form-data');
    http.send(formData);

    http.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200) {
            var responseData = JSON.parse(this.responseText);
            if(responseData.data == 'success') {
                if (method == 'POST') {
                    showToast({
                        message: `Bạn đã thêm sách thành công: ${book.name}`,
                        type: 'success',
                        duration: 2000
                    });
                }
                else if (method == 'PUT') {
                    showToast({
                        message: `Bạn đã cập nhật sách thành công: ${book.name}`,
                        type: 'success',
                        duration: 2000
                    });
                }
                getDataBook();
            }
            else {
                showToast({
                    message: `Có lỗi sảy ra khi tải ảnh lên! Vui lòng thử lại`,
                    type: 'error',
                    duration: 2000
                });
            }
        }
    }
}

// Call function
getDataCate();
getDataBook();
loadPagination();