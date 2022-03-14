// Declare variable
var account, users = [];

var clear;

var recipientId;

// Get list user
function getListUser() {
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

function loadListUsers(users) {
    var chatDOM = document.querySelector('.app-content-body-list-chat__navbar');
    chatDOM.innerHTML = '';
    
    var user = users.find(function(value) {
        return value.username == 'admin';
    });

    var usersTmp;
    if(user) {
        usersTmp = users.filter(function(value) {
            return value.id != user.id;
        });
        usersTmp.unshift(user);
    }
    else {
        usersTmp = users;
        user = {};
        user.id = -1;
    }

    usersTmp.forEach(function(value) {
        if(value.id == user.id) {
            chatDOM.innerHTML += `
            <li class="app-content-body-list-chat-navbar__item" onclick="recipientId = ${value.id};openMessage(${value.id})">
                <img src="template/images/user.png" alt="user">
                <p>Chăm sóc khách hàng</p>
            </li>
            `;
        }
        else {
            chatDOM.innerHTML += `
            <li class="app-content-body-list-chat-navbar__item" onclick="recipientId = ${value.id};openMessage(${value.id})">
                <img src="template/images/user.png" alt="user">
                <p>${value.fullName}</p>
            </li>
            `;
        }
    });
}

function openMessage(id) {
    var user = users.find(function(value) {
        return value.id == id;
    });
    document.getElementById('name-user-chat').innerText = (user.username == 'admin') ? 'Chăm sóc khách hàng' : user.fullName;
    getDataMessage();
}

// Get data message
function getDataMessage() {
    var http = new XMLHttpRequest();

    http.open('GET', path + `api/message?recipientId=${recipientId}&senderId=${account.id}`);

    http.send();

    http.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200) {
            var responseData = JSON.parse(this.responseText);
            loadMessage(responseData.data);
        }
    }
    clearInterval(clear);
    clear = setInterval(function(){
        getDataMessage();
    }, 1000);
}

// Load Message
function loadMessage(messages) {
    var messageDOM = document.querySelector('.app-content-body-message__read');
    messageDOM.innerHTML = '';

    messages.forEach(function(value) {
        var message = document.createElement('div');
        message.classList.add('app-content-body-message-read__item');
        message.innerHTML = `<span>${value.content}</span>`;
        
        if(value.senderId == account.id) {
            message.classList.add('message-reply');
        }

        messageDOM.append(message);
    });
}

// Send message
function sendMessage() {
    if(document.getElementById('txtmessage').value == '') {
        return;
    }

    var data = {
        id: null,
        senderId: account.id,
        recipientId: recipientId,
        content: document.getElementById('txtmessage').value
    }

    var http = new XMLHttpRequest();
    http.open('POST', path + 'api/message');
    http.setRequestHeader('Content-Type', 'application/json');
    http.send(JSON.stringify(data));

    http.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200) {
            var responseData = JSON.parse(this.responseText);
            console.log(responseData);
            if(responseData.data == 'success') {
                document.getElementById('txtmessage').value = '';
                getDataMessage();
            }
        }
    }
}

// Call function
getCurrentAccount();
getListUser();
loadHeader();

document.getElementById('txtmessage').addEventListener('keyup', function(event) {
    if(event.keyCode == 13) {
        sendMessage();
    }
});