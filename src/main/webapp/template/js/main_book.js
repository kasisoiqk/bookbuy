// Declare variable
var account;
var comments = [], book = {};

var url = window.location.href.split('/');
url.pop();
url.pop();
var path = url.join('/') + '/';

var id = window.location.href.split('/')[window.location.href.split('/').length - 1];

// Get data
function getDataComment() {
    var http = new XMLHttpRequest();

    http.open('GET', path + `api/list-comments?id=${id}`, true);

    http.send();

    http.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var responseData = JSON.parse(this.responseText);
            comments = responseData.data;
            renderComments();
        }
    }
}

function renderComments() {
    if(account == null) {
        document.querySelector('.app-content-comment__not-auth').style.display = 'block';
        document.querySelector('.app-content-comment__input').style.display = 'none';
    }
    else {
        document.querySelector('.app-content-comment__not-auth').style.display = 'none';
        document.querySelector('.app-content-comment__input').style.display = 'flex';
    }

    var commentDOM = document.querySelector('.app-content-comment__list');
    commentDOM.innerHTML = '';

    if(comments.length <= 0) {
        commentDOM.innerHTML = '<li class="app-content-comment__no-comment">Chưa có bình luận nào.</li>';
    }
    else {
        comments.forEach(function(value) {
            var commentItem = document.createElement('li');
            commentItem.classList.add('app-content-comment__item');

            var btnRemove = '';
            if(account != null) {
                if(account.id == value.userId || author == 'ADMIN') {
                    btnRemove = `
                    <div class="app-content-comment-item-info__remove">
                        <span onclick="showDialogQuestion(${value.id})">Xóa</span>
                    </div>
                    `;
                }
            }

            var time = '';
            if(value.time != '0') {
                time = `Bình luận ${value.time} trước`;
            }
            else {
                time = 'Vừa xong';
            }

            var name = value.fullName;
            if(account != null) {
                if(value.userId == account.id) {
                    name += ' (Bạn)';
                }
            }

            commentItem.innerHTML = `
            <div class="app-content-comment-item__info">
                <div class="app-content-comment-item-info__user">
                    <img src="${path}template/images/user.png" alt="user">
                    <div>
                        <span class="app-content-comment-item-info__user-username">${value.userName}</span>
                        <span class="app-content-comment-item-info__user-fullname">${value.fullName}</span>
                    </div>
                </div>
                <div class="app-content-comment-item-info__time">
                    <span class="material-icons-outlined">schedule</span>
                    ${time}
                </div>
                ${btnRemove}
            </div>
            <div class="app-content-comment-item__content">${value.content}</div>
            `;

            commentDOM.appendChild(commentItem);
        });
    }
}

// Send comment
function sendComment() {
    if(document.getElementById('txt-comment').value.trim() == '') return;

    var data = {
        id: null,
        userId: account.id,
        bookId: id,
        fullName: account.fullName,
        userName: account.userName,
        content: document.getElementById('txt-comment').value.trim(),
        time: null
    }

    var http = new XMLHttpRequest();
    http.open('POST', path + 'api/comment');
    http.setRequestHeader('Content-Type', 'application/json');
    http.send(JSON.stringify(data));

    http.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200) {
            var responseData = JSON.parse(this.responseText);
            if(responseData.data == 'success') {
                showToast({
                    message: 'Bình luận của bạn đã được chúng tôi ghi nhận!',
                    type: 'success',
                    duration: 3000 
                });
            }
            else {
                showToast({
                    message: 'Có lỗi sảy ra, bạn vui lòng thử lại sau nhé!',
                    type: 'error',
                    duration: 3000 
                });
            }
            getDataComment();
        }
    }
    document.getElementById('txt-comment').value = '';
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
        <span class="modal-dialog__btn-yes" onclick="closeDialog(), removeComment(${id})">${btn1}</span>
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

// Remove comment
function showDialogQuestion(id) {
    var comment = comments.find(function(value) {
        return value.id == id;
    });

    showDialog({
        title: 'Xóa',
        content: `Bạn có chắc chắn muốn xóa bình luận này không? "${comment.content}"`,
        btn1: 'Có',
        btn2: 'Không',
        id: comment.id
    });
}

function removeComment(id) {
    var comment = comments.find(function(value) {
        return value.id == id;
    });

    var http = new XMLHttpRequest();
    http.open('DELETE', path + 'api/comment');
    http.setRequestHeader('Content-Type', 'application/json');
    http.send(JSON.stringify(comment));

    http.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200) {
            var responseData = JSON.parse(this.responseText);
            if(responseData.data == 'success') {
                showToast({
                    message: 'Bình luận đã được xóa!',
                    type: 'success',
                    duration: 3000 
                });
            }
            else {
                showToast({
                    message: 'Có lỗi sảy ra, bạn vui lòng thử lại sau nhé!',
                    type: 'error',
                    duration: 3000 
                });
            }
            getDataComment()
        }
    }
}

// Get data book
function getDataBook() {
    var http = new XMLHttpRequest();
    http.open('GET', `${path}api/book?id=${id}`);
    http.send();

    http.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200) {
            var responseData = JSON.parse(this.responseText);
            book = responseData.data;
            document.title = `${book.name} | Book Buy`;
        }
    }
}

// Add cart
function addToCart() {
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
        carts.push({
            id: book.id,
            name: book.name,
            author: book.author,
            image: book.image,
            currentPrice: book.currentPrice,
            quantity: 1
        });
        showToast({
            message: `Bạn đã thêm vào giỏ hàng sách: ${book.name}`,
            type: 'success',
            duration: 2000
        });
    }
    localStorage.setItem('carts', JSON.stringify(carts));
    loadCart();
}

function removeFromCart(id) {
    var cart = carts.find(function (value) {
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

// Call function
getDataCate();
authorization();
loadHeader();
loadCart();
getCurrentAccount();
getDataBook();
setTimeout(getDataComment(), 1000);

document.getElementById('txt-comment').addEventListener('keyup', function(event) {
    if(event.keyCode == 13) {
        sendComment();
    }
});