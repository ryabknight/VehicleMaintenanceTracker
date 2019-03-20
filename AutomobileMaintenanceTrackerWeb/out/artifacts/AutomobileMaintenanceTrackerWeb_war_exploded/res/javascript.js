$(document).ready(function () {
    loadVehicles();
    loadAddVehicleElement();
});

function loadVehicles() {
    $("#vehicleList").load("http://localhost:8080/CarTracker/getVehicles");
}

function loadAddVehicleElement() {
    $('#maintenanceContainer').load("http://localhost:8080/CarTracker/addVehicle");
}

function loadViewVehicleElement(vehicleId) {
    $('#maintenanceContainer').load("http://localhost:8080/CarTracker/viewVehicle?id=" + vehicleId);
}

function loadUpdateVehicleElement(vehicleId) {
    $('#maintenanceContainer').load("http://localhost:8080/CarTracker/updateVehicle?id=" + vehicleId);
}

function submitAddVehicle() {
    var form = {
        carName: document.getElementById('carName').value,
        carModel: document.getElementById('carModel').value,
        carOdometerReading: document.getElementById('carOdometerReading').value,
        carMake: document.getElementById('carMake').value,
        carOwner: document.getElementById('carOwner').value,
        carColour: document.getElementById('carColour').value,
        carYear: document.getElementById('carYear').value,
        carType: document.getElementById('carType').value
    };
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/CarTracker/addVehicle',
        data: form,
        success: function (data) {
            loadVehicles();
            loadAddVehicleElement();
        }
    }).fail(function () {
        document.getElementById('addErrorMessage').innerText = 'Error occured';
    });
}

function submitUpdateVehicle(vehicleId) {
    var form = {
        carName: document.getElementById('carName').value,
        carModel: document.getElementById('carModel').value,
        carOdometerReading: document.getElementById('carOdometerReading').value,
        carMake: document.getElementById('carMake').value,
        carOwner: document.getElementById('carOwner').value,
        carColour: document.getElementById('carColour').value,
        carYear: document.getElementById('carYear').value,
        carId: vehicleId
    };
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/CarTracker/updateVehicle',
        data: form,
        success: function (data) {
            loadVehicles();
            loadAddVehicleElement();
        }
    }).fail(function () {
        document.getElementById('addErrorMessage').innerText = 'Error occured';
    });
}

function addMaintenanceItem(vehicleId) {
    var form = {
        carId: vehicleId,
        date: document.getElementById('maintenanceDate').value,
        type: document.getElementById('maintenanceType').value
    };
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/CarTracker/addMaintenanceItem',
        data: form,
        complete: function (data) {
            loadViewVehicleElement(vehicleId);
        }
    });
}

function deleteMaintenanceItem(itemId, vehicleId) {
    var form = {
        id: itemId
    };
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/CarTracker/deleteMaintenanceItem',
        data: form,
        complete: function (data) {
            loadViewVehicleElement(vehicleId);
        }
    });
}

function deleteAutomobile(vehicleId) {
    var form = {
        id: vehicleId
    };
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/CarTracker/deleteVehicle',
        data: form,
        complete: function (data) {
            loadAddVehicleElement();
        }
    });
}