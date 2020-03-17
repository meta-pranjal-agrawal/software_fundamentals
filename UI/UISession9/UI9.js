var inputField;
var name1;
var vehicleType;
document.getElementById("messageFieldEmployee").style.display = "block";
document.getElementById("empName").style.display = "block";
inputField = "empName";
var Employee = /** @class */ (function () {
    function Employee() {
    }
    Employee.prototype.validateempName = function () {
        if (document.getElementById('empName').value == "") {
            document.getElementById('empName').style.borderBottomColor = "#ff0000";
            document.getElementById('empName').style.borderWidth = "3px";
            return false;
        }
        else if ((document.getElementById('empName').value).length < 2) {
            document.getElementById('empName').style.borderBottomColor = "#ff0000";
            document.getElementById('empName').style.borderWidth = "3px";
            return false;
        }
        else if ((/^[A-Z]*[a-z]/.test(document.getElementById('empName').value)) == false) {
            document.getElementById('empName').style.borderBottomColor = "#ff0000";
            document.getElementById('empName').style.borderWidth = "3px";
            return false;
        }
        else {
            document.getElementById('empName').style.borderBottomColor = "#ffffff";
            return true;
        }
    };
    Employee.prototype.validateGender = function () {
        if (document.getElementById("maleGender").checked == false && document.getElementById("femaleGender").checked == false) {
            document.getElementById("empGender").style.backgroundColor = "#ff0000";
            document.getElementById('empGender').style.borderWidth = "3px";
            return false;
        }
        else {
            return true;
        }
    };
    Employee.prototype.validateMail = function () {
        var a = document.getElementById("empMail").value;
        if (document.getElementById("empMail").value.length < 4 || (!a.match("@"))) {
            document.getElementById("empMail").style.borderBottomColor = "#ff0000";
            document.getElementById("empMail").style.borderWidth = "3px";
            return false;
        }
        else {
            return true;
        }
    };
    Employee.prototype.validatePassword = function () {
        var regexPassword = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).+$/;
        if (!document.getElementById("empPassword").value.match(regexPassword)) {
            if (document.getElementById("empPassword").value.length < 4) {
                document.getElementById("empPassword").style.borderBottomColor = "#ff0000";
                document.getElementById("empPassword").style.borderWidth = "3px";
                return false;
            }
        }
        else {
            if (document.getElementById("empPassword").value.length < 8) {
                document.getElementById("empPassword").style.borderColor = "orange";
                document.getElementById("empPassword").style.borderWidth = "3px";
                return true;
            }
            if (document.getElementById("empPassword").value.length > 8) {
                document.getElementById("empPassword").style.borderColor = "green";
                document.getElementById("empPassword").style.borderWidth = "3px";
                return true;
            }
        }
    };
    Employee.prototype.validateConfirmPassword = function () {
        if (document.getElementById("empPassword").value != document.getElementById("empConfirmPassword").value) {
            document.getElementById("empConfirmPassword").style.borderBottomColor = "#ff0000";
            document.getElementById("empConfirmPassword").style.borderBottomWidth = "3px";
            return false;
        }
        else {
            return true;
        }
    };
    Employee.prototype.validatePhoneNumber = function () {
        var numbers = /^[+]?[0-9]+$/;
        if (document.getElementById("empPhoneNumber").value.length < 8 || !(document.getElementById("empPhoneNumber").value.match(numbers))) {
            document.getElementById("empPhoneNumber").style.borderBottomColor = "#ff0000";
            document.getElementById("empPhoneNumber").style.borderBottomWidth = "3px";
            return false;
        }
        else {
            return true;
        }
    };
    return Employee;
}());
function validatePasswordHTML() {
    employee.validatePassword();
}
function currencyChanger1() {
    vehicle.currencyChanger();
}
var Vehicle = /** @class */ (function () {
    function Vehicle() {
    }
    Vehicle.prototype.validateVehicleName = function () {
        if (document.getElementById("empVehicleName").value.length < 4) {
            document.getElementById("empVehicleName").style.borderBottomColor = "#ff0000";
            document.getElementById("empVehicleName").style.borderBottomWidth = "3px";
            return false;
        }
        else {
            return true;
        }
    };
    Vehicle.prototype.validateVehicleType = function () {
        if (document.getElementById("empVehicleType").value != "") {
            return true;
        }
        else {
            return false;
        }
    };
    Vehicle.prototype.validateVehicleIdentification = function () {
        if (document.getElementById("vehicleIdentification").value.length < 1) {
            document.getElementById("vehicleIdentification").style.borderBottomColor = "red";
            document.getElementById("vehicleIdentification").style.borderBottomWidth = "3px";
            return false;
        }
        else {
            return true;
        }
    };
    Vehicle.prototype.currencyChanger = function () {
        var currency = document.getElementById("currencySelector").value;
        var factor = 0;
        if (currency == "INR") {
            factor = 1;
        }
        if (currency == "USD") {
            factor = 0.014;
        }
        if (currency == "YEN") {
            factor = 0.65;
        }
        if (vehicleType == "Cycle") {
            document.getElementById("daily").value = (5 * factor).toFixed(2);
            document.getElementById("monthly").value = (100 * factor).toFixed(2);
            document.getElementById("yearly").value = (500 * factor).toFixed(2);
        }
        if (vehicleType == "Bike") {
            document.getElementById("daily").value = (100 * factor).toFixed(2);
            document.getElementById("monthly").value = (200 * factor).toFixed(2);
            document.getElementById("yearly").value = (1000 * factor).toFixed(2);
        }
        if (vehicleType == "Car") {
            document.getElementById("daily").value = (20 * factor).toFixed(2);
            document.getElementById("monthly").value = (500 * factor).toFixed(2);
            document.getElementById("yearly").value = (3500 * factor).toFixed(2);
        }
    };
    return Vehicle;
}());
var employee = new Employee();
var vehicle = new Vehicle();
function empRegForm() {
    switch (inputField) {
        case 'empName':
            name1 = document.getElementById(inputField).value;
            if (employee.validateempName()) {
                document.getElementById("messageFieldEmployee").innerHTML = "Hi " + name + ". May I know your gender?";
                document.getElementById("empGender").style.display = "block";
                inputField = "empGender";
                document.getElementById("empName").style.display = "none";
            }
            break;
        case 'empGender':
            if (employee.validateGender()) {
                document.getElementById("messageFieldEmployee").innerHTML = "Hi " + name + ". May I know your mail?";
                document.getElementById("empMail").style.display = "block";
                document.getElementById("empMail").focus();
                inputField = "empMail";
                document.getElementById("empGender").style.display = "none";
            }
            break;
        case 'empMail':
            if (employee.validateMail()) {
                document.getElementById("messageFieldEmployee").innerHTML = "Hi " + name + ". May I know your password?";
                document.getElementById("empPassword").style.display = "block";
                document.getElementById("empPassword").focus();
                inputField = "empPassword";
                document.getElementById("empMail").style.display = "none";
            }
            break;
        case 'empPassword':
            if (employee.validatePassword()) {
                document.getElementById("messageFieldEmployee").innerHTML = "Hi " + name + ". Please enter your password again to confirm.";
                document.getElementById("empConfirmPassword").style.display = "block";
                document.getElementById("empConfirmPassword").focus();
                inputField = "empConfirmPassword";
                document.getElementById("empPassword").style.display = "none";
            }
            break;
        case 'empConfirmPassword':
            if (employee.validateConfirmPassword()) {
                document.getElementById("messageFieldEmployee").innerHTML = "Hi " + name + ". May I know your Phone Number?";
                document.getElementById("empPhoneNumber").style.display = "block";
                document.getElementById("empPhoneNumber").focus();
                inputField = "empPhoneNumber";
                document.getElementById("empConfirmPassword").style.display = "none";
            }
            break;
        case 'empPhoneNumber':
            if (employee.validatePhoneNumber()) {
                document.getElementById("messageFieldEmployee").innerHTML = "Hi " + name + ". You are Registered.";
                document.getElementById("empPhoneNumber").style.display = "none";
                inputField = "vehicleName";
                document.getElementById("vehicleFieldSet").style.display = "block";
                document.getElementById("vehicleLabel").style.display = "block";
                document.getElementById("empVehicleName").style.display = "block";
                document.getElementById("empVehicleName").focus();
            }
            break;
        case 'vehicleName':
            if (vehicle.validateVehicleName()) {
                document.getElementById("empVehicleName").style.display = "none";
                document.getElementById("vehicleLabel").innerHTML = "Hi " + name + ". What is the number of your vehicle?";
                document.getElementById("empVehicleType").style.display = "block";
                document.getElementById("empVehicleType").focus();
                inputField = "vehicleType";
            }
            break;
        case 'vehicleType':
            if (vehicle.validateVehicleType()) {
                document.getElementById("empVehicleType").style.display = "none";
                document.getElementById("vehicleLabel").innerHTML = "Hi " + name + ". What is the identification of your vehicle?";
                document.getElementById("vehicleIdentification").style.display = "block";
                document.getElementById("vehicleIdentification").focus();
                inputField = "vehicleIdentification";
            }
            break;
        case 'vehicleIdentification':
            document.getElementById("vehicleLabel").innerHTML = "Hi " + name + ". Your vehicle is registered";
            if (vehicle.validateVehicleIdentification()) {
                document.getElementById("vehicleIdentification").style.display = "none";
                document.getElementById("passesFieldSet").style.display = "block";
                document.getElementById("passesLabel").style.display = "block";
                var parent = document.getElementById("passesForm");
                var children = parent.children;
                for (var i = 0; i < children.length; i++) {
                    var ch = children[i];
                    ch.style.display = "block";
                }
                inputField = "vehiclePass";
                vehicleType = document.getElementById("empVehicleType").value;
                vehicle.currencyChanger();
            }
            break;
    }
}
window.addEventListener("keypress", function (event) {
    if (event.keyCode == 13) {
        empRegForm();
    }
});
