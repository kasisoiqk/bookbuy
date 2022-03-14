function registerUser() {
    var data = {
        username: document.getElementById('username').value,
        password: document.getElementById('password').value,
        rePassword: document.getElementById('re-password').value
    }

    var http = new XMLHttpRequest();
    http.open('POST', `${path}api/create-user`);
    http.setRequestHeader('Content-Type', 'application/json');
    http.send(JSON.stringify(data));

    http.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200) {
            var mes = JSON.parse(this.responseText);
            switch (mes.data) {
                case 'invalidUsername':
                    document.location.href = `${path}signup?invalidUsername`;
                    break;
                case 'invalidPassword':
                    document.location.href = `${path}signup?invalidPassword`;
                    break;
                case 'hadUsername':
                    document.location.href = `${path}signup?hadUsername`;
                    break;
                case 'incorectRepassword':
                    document.location.href = `${path}signup?incorectRepassword`;
                    break;
                case 'signupSuccess':
                    document.location.href = `${path}login?signupSuccess`;
                    break;
                default:
                    showToast({
                        message: 'Có lỗi sảy ra! Bạn vui lòng thử lại sau nhé.',
                        type: 'error',
                        duration: '4000'
                    });
                    break;
            }
        }
    }
}