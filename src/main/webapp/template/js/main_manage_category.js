// Declare variable
var categories = [];

// Get data
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
    var cate = categories.find(function(value) {
        return value.id == id;
    });

    var modalDOM = document.querySelector('.modal__input');

    if(modalDOM.classList.contains('modal__input-create')) {
        modalDOM.classList.remove('modal__input-create');
    }
    if(!modalDOM.classList.contains('modal__input-edit')) {
        modalDOM.classList.add('modal__input-edit');
    }

    document.getElementById('cate-id').value = cate.id;
    document.getElementById('cate-name').value = cate.name;
}

function showCreate() {
    var modalDOM = document.querySelector('.modal__input');

    if(modalDOM.classList.contains('modal__input-edit')) {
        modalDOM.classList.remove('modal__input-edit');
    }
    if(!modalDOM.classList.contains('modal__input-create')) {
        modalDOM.classList.add('modal__input-create');
    }

    document.getElementById('cate-id').value = '';
    document.getElementById('cate-name').value = '';
}

// load list categories
function loadListCate() {
    var listCatesDOM = document.querySelector('.app-container-content__list tbody');
    listCatesDOM.innerHTML = '';

    categories.forEach(function(value) {
        var cate = document.createElement('tr');

        cate.innerHTML = `
        <td>DA${formatItemID(value.id)}</td>
        <td>${value.name}</td>
        <td style="text-align: center;">
            <label for="cbo-show-modal" class="app__btn" onclick="showEdit(${value.id})">Chi tiết</label>
        </td>
        `;

        listCatesDOM.appendChild(cate);
    });
}

// Create - Update - Delete cate
function editCate(method) {
    var cate = {
        id: document.getElementById('cate-id').value,
        name: document.getElementById('cate-name').value.trim()
    }

    var http = new XMLHttpRequest();

    http.open(method, path + `admin/api/category`, true);
    http.setRequestHeader('Content-Type', 'application/json');
    http.send(JSON.stringify(cate));

    http.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var responseData = JSON.parse(this.responseText);
            if(responseData.data == 'success') {
                if (method == 'POST') {
                    showToast({
                        message: `Bạn đã thêm danh mục thành công: ${cate.name}`,
                        type: 'success',
                        duration: 3000
                    });
                }
                else if (method == 'PUT') {
                    showToast({
                        message: `Bạn đã cập nhật danh mục thành công: ${cate.name}`,
                        type: 'success',
                        duration: 3000
                    });
                }
                else {
                    showToast({
                        message: `Bạn đã xóa danh mục thành công: ${cate.name}`,
                        type: 'error',
                        duration: 3000
                    });
                }
                getDataCate();
            }
            else {
                showToast({
                    message: `Có lỗi sảy ra! Vui lòng thử lại`,
                    type: 'error',
                    duration: 3000
                });
            }
        }
    }
}

// Call function
getDataCate();