// Delare variable
var provinces = [];
var districtes = [];
var wards = [];

var url = window.location.href.split('/');
url.pop();
url.pop();
var path = url.join('/') + '/';

// Get data
function getDataProvinces() {
    // AJAX
    var http = new XMLHttpRequest();

    // method: GET, POST, PUT, DELETE - POST: create , PUT: update, DELETE: delete
    http.open('GET', path + 'api/list-provinces');

    http.send();

    http.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200) {
            var responseData = JSON.parse(this.responseText);
            provinces = responseData.data;
            renderDataProvinces();
        }
    }
}

function getDataDistricts() {
    var value = document.getElementById('province').value;

    var http = new XMLHttpRequest();

    http.open('GET', path + `api/list-districtes?matp=${value}`);

    http.send();

    http.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200) {
            var responseData = JSON.parse(this.responseText);
            districtes = responseData.data;
            renderDataDistricts();
        }
    }
}

function getDataWards() {
    var value = document.getElementById('district').value;

    var http = new XMLHttpRequest();

    http.open('GET', path + `api/list-wards?maqh=${value}`);

    http.send();

    http.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200) {
            var responseData = JSON.parse(this.responseText);
            wards = responseData.data;
            renderDataWards();
        }
    }
}

// render data
function renderDataProvinces() {
    var provinceDOM = document.getElementById('province');
    provinceDOM.innerHTML = '<option value="0">--Tỉnh / Thành phố--</option>';

    provinces.forEach(function(value) {
        var province = document.createElement('option');
        province.innerText = value.name;
        province.value = value.matp;

        provinceDOM.appendChild(province);
    });
}

function renderDataDistricts() {
    var districtDOM = document.getElementById('district');
    districtDOM.innerHTML = '<option value="0">--Quận / Huyện--</option>';

    districtes.forEach(function(value) {
        var district = document.createElement('option');
        district.innerText = value.name;
        district.value = value.maqh;

        districtDOM.appendChild(district);
    });
}

function renderDataWards() {
    var wardDOM = document.getElementById('ward');
    wardDOM.innerHTML = '<option value="0">--Xã / Phường--</option>';

    wards.forEach(function(value) {
        var ward = document.createElement('option');
        ward.innerText = value.name;
        ward.value = value.maxp;

        wardDOM.appendChild(ward);
    });
}

function saveCustomerInfo() {
    var province = provinces.find(function(value) {
        return value.matp == document.getElementById('province').value;
    });
    var district = districtes.find(function(value) {
        return value.maqh == document.getElementById('district').value;
    });
    var ward = wards.find(function(value) {
        return value.maxp == document.getElementById('ward').value;
    });

    var customer = {
        fullName: document.getElementById('name').value,
        phone: document.getElementById('phone').value,
        infoExtra: document.getElementById('info-extra').value,
        province: province.name,
        district: district.name,
        ward: ward.name,
        number: document.getElementById('number').value
    };

    // Save in local storage
    localStorage.setItem('customer', JSON.stringify(customer));
}

// Call function
getDataProvinces();