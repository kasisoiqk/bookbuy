// Declare variable
var users = [];

// Get data
function getListUsers() {
    var http = new XMLHttpRequest();

    http.open('GET', path + 'api/list-users');

    http.send();

    http.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200) {
            var responseData = JSON.parse(this.responseText);
            users = responseData.data;
            loadListUsers(users);
        }
    }
}

// Show modal input
function showEdit(id) {
    var user = users.find(function(value) {
        return value.id == id;
    });

    var modalDOM = document.querySelector('.modal__input');

    if(modalDOM.classList.contains('modal__input-create')) {
        modalDOM.classList.remove('modal__input-create');
    }
    if(!modalDOM.classList.contains('modal__input-edit')) {
        modalDOM.classList.add('modal__input-edit');
    }

    document.getElementById('user-id').value = user.id;
    document.getElementById('name').value = user.fullName;
    document.getElementById('birth').value = `${user.birthyear}-${user.birthmonth}-${user.birthday}`;
    if(user.gender == 0) male.checked = true;
    else if(user.gender == 1) female.checked = true;
    else genderElse.checked = true;
    document.getElementById('phone').value = user.phone;
    document.getElementById('email').value = user.email;
    document.getElementById('username').value = user.username;
    document.getElementById('password').value = '*Không thể thay đổi mật khẩu ở đây';
    document.getElementById('permission').value = user.role;

    document.querySelector('.modal__input form').method = 'PUT';
}

function showCreate() {
    var modalDOM = document.querySelector('.modal__input');

    if(modalDOM.classList.contains('modal__input-edit')) {
        modalDOM.classList.remove('modal__input-edit');
    }
    if(!modalDOM.classList.contains('modal__input-create')) {
        modalDOM.classList.add('modal__input-create');
    }

    document.getElementById('user-id').value = 0;
    document.getElementById('name').value = '';
    document.getElementById('birth').value = `2000-01-01`;
    genderElse.checked = true;
    document.getElementById('phone').value = '';
    document.getElementById('email').value = '';
    document.getElementById('username').value = '';
    document.getElementById('password').value = '';
    document.getElementById('permission').value = 'USER';

    document.querySelector('.modal__input form').method = 'POST';
}

// load list users
function loadListUsers() {
    var listUsersDOM = document.querySelector('.app-container-content__list tbody');
    listUsersDOM.innerHTML = '';

    users.forEach(function(value) {
        if(value.birthday < 10) value.birthday = '0' + value.birthday;
        if(value.birthmonth < 10) value.birthmonth = '0' + value.birthmonth;

        var user = document.createElement('tr');

        user.innerHTML = `
        <td>ND${formatItemID(value.id)}</td>
        <td>
            <div class="app-container-content__item-user">
                <img src="${path}template/images/user.png" alt="user">
                <p>${value.fullName}</p>
            </div>
        </td>
        <td>
            <div class="app-container-content__item-user-info">Ngày sinh: ${value.birthday}/${value.birthmonth}/${value.birthyear}</div>
            <div class="app-container-content__item-user-info">Giới tính: ${(value.gender == 0) ? 'Nam' : ((value.gender == 1) ? 'Nữ' : 'Khác')}</div>
            <div class="app-container-content__item-user-info">Số điện thoại: ${value.phone}</div>
            <div class="app-container-content__item-user-info">Email: ${value.email}</div>
        </td>
        <td>${value.username}</td>
        <td>*******</td>
        <td style="color: var(--red-color);">${value.role}</td>
        <td style="text-align: center;">
            <label for="cbo-show-modal" class="app__btn" onclick="showEdit(${value.id})">Chi tiết</label>
        </td>
        `;

        listUsersDOM.appendChild(user);
    });
}

// Create - Update - Delete user
function editUser(method) {
    var birthText = document.getElementById('birth').value.split('-');

    var user = {
        id: document.getElementById('user-id').value,
        fullName: document.getElementById('name').value.trim(),
        username: document.getElementById('username').value.trim(),
        password: (method == 'POST') ? document.getElementById('password').value.trim() : null,
        gender: (male.checked) ? 0 : ((female.checked) ? 1 : 2),
        phone: document.getElementById('phone').value.trim(),
        email: document.getElementById('email').value.trim(),
        role: (document.getElementById('permission').value=='ADMIN') ? 'ADMIN' : 'USER',
        birthday: parseInt(birthText[2]),
        birthmonth: parseInt(birthText[1]),
        birthyear: parseInt(birthText[0])
    }

    var http = new XMLHttpRequest();

    http.open(method, path + `admin/api/user`, true);
    http.setRequestHeader('Content-Type', 'application/json');
    http.send(JSON.stringify(user));

    http.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var responseData = JSON.parse(this.responseText);
            if(responseData.data == 'success') {
                if (method == 'POST') {
                    showToast({
                        message: `Bạn đã thêm người dùng thành công: ${user.fullName}`,
                        type: 'success',
                        duration: 3000
                    });
                }
                else if (method == 'PUT') {
                    showToast({
                        message: `Bạn đã cập nhật người dùng thành công: ${user.fullName}`,
                        type: 'success',
                        duration: 3000
                    });
                }
                else {
                    showToast({
                        message: `Bạn đã xóa người dùng thành công: ${user.fullName}`,
                        type: 'error',
                        duration: 3000
                    });
                }
                getListUsers();
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
getListUsers();