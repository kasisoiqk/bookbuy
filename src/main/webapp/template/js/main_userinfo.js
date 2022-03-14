// Declare variable
var account;

var carts = [];
if(localStorage.getItem('carts') != null) {
    carts = JSON.parse(localStorage.getItem('carts'));
}

// Load data
function loadInfo() {
    document.querySelector('.app-container-menu-user-info__name').innerHTML = account.fullName;
    document.querySelector('.app-container-menu-user-info__email').innerHTML = account.email;
    document.getElementById('username').value = account.username;
    document.getElementById('password').value = '******';
    document.getElementById('fullName').value = account.fullName;
    if(account.gender == 0) male.checked = true;
    else if(account.gender == 1) female.checked = true;
    else genderElse.checked = true;
    document.getElementById('userEmail').value = account.email;
    document.getElementById('phone').value = account.phone;
    if(account.birthday < 10) account.birthday = '0' + account.birthday;
    if(account.birthmonth < 10) account.birthmonth = '0' + account.birthmonth;
    document.getElementById('birth').value = `${account.birthyear}-${account.birthmonth}-${account.birthday}`;
}

function updateInfo() {
    account.fullName = document.getElementById('fullName').value;
    if(male.checked) account.gender = 0;
    else if(female.checked) account.gender = 1;
    else account.gender = 2;
    account.email = document.getElementById('userEmail').value;
    account.phone = document.getElementById('phone').value;
    var birthText = document.getElementById('birth').value.split('-');
    account.birthday = parseInt(birthText[2]);
    account.birthmonth = parseInt(birthText[1]);
    account.birthyear = parseInt(birthText[0]);

    var http = new XMLHttpRequest();
    http.open('PUT', path + 'api/user');
    http.setRequestHeader('Content-Type', 'application/json');
    http.send(JSON.stringify(account));

    http.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200) {
            var responseData = JSON.parse(this.responseText);
            if(responseData.data == 'success') {
                showToast({
                    message: 'Cập nhật thông tin thành công!',
                    type: 'success',
                    duration: 3000 
                });
                loadInfo();
            }
            else {
                showToast({
                    message: 'Có lỗi sảy ra, bạn vui lòng thử lại sau nhé!',
                    type: 'error',
                    duration: 3000 
                });
            }
        }
    }
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
            loadInfo()
        }
    }
}

// Call function
getCurrentAccount();