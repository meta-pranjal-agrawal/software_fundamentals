var inputField:string;
var name1:string;
var vehicleType:string;

(<HTMLElement>document.getElementById("messageFieldEmployee")).style.display = "block";
(<HTMLElement>document.getElementById("empName")).style.display = "block";
inputField = "empName";



class Employee {


    validateempName() {

        if ((<HTMLInputElement>document.getElementById('empName')).value == "") {
            (<HTMLElement>document.getElementById('empName')).style.borderBottomColor = "#ff0000";
            (<HTMLElement>document.getElementById('empName')).style.borderWidth = "3px";
            return false;
        } else if (((<HTMLInputElement>document.getElementById('empName')).value).length < 2) {
            (<HTMLElement>document.getElementById('empName')).style.borderBottomColor = "#ff0000";
            (<HTMLElement>document.getElementById('empName')).style.borderWidth = "3px";
            return false;
        } else if ((/^[A-Z]*[a-z]/.test((<HTMLInputElement>document.getElementById('empName')).value)) == false) {
            (<HTMLElement>document.getElementById('empName')).style.borderBottomColor = "#ff0000";
            (<HTMLElement>document.getElementById('empName')).style.borderWidth = "3px";
            return false;
        } else {
            (<HTMLElement>document.getElementById('empName')).style.borderBottomColor = "#ffffff";
            return true;
        }
    }

    validateGender() {
        if ((<HTMLInputElement>document.getElementById("maleGender")).checked == false &&(<HTMLInputElement>document.getElementById("femaleGender")).checked == false) {
            (<HTMLElement>document.getElementById("empGender")).style.backgroundColor = "#ff0000";
            (<HTMLElement>document.getElementById('empGender')).style.borderWidth = "3px";
            return false;
        } else {
            return true;
        }
    }

    validateMail() {

        let a = (<HTMLInputElement>document.getElementById("empMail")).value ;
        if ((<HTMLInputElement>document.getElementById("empMail")).value.length < 4 || (!a.match("@") )) {
            (<HTMLElement>document.getElementById("empMail")).style.borderBottomColor = "#ff0000";
            (<HTMLElement>document.getElementById("empMail")).style.borderWidth = "3px";
            return false;
        } else {
            return true;
        }
    }

    validatePassword() {
        var regexPassword = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).+$/;
        if (!(<HTMLInputElement>document.getElementById("empPassword")).value.match(regexPassword)) {
            if ((<HTMLInputElement>document.getElementById("empPassword")).value.length < 4) {
                (<HTMLElement>document.getElementById("empPassword")).style.borderBottomColor = "#ff0000";
                (<HTMLElement>document.getElementById("empPassword")).style.borderWidth = "3px";
                return false;
            }
        } else {
            if ((<HTMLInputElement>document.getElementById("empPassword")).value.length < 8) {
                (<HTMLElement>document.getElementById("empPassword")).style.borderColor = "orange";
                (<HTMLElement>document.getElementById("empPassword")).style.borderWidth = "3px";
                return true;
            }
            if ((<HTMLInputElement>document.getElementById("empPassword")).value.length > 8) {
                (<HTMLElement>document.getElementById("empPassword")).style.borderColor = "green";
                (<HTMLElement>document.getElementById("empPassword")).style.borderWidth = "3px";
                return true;
            }
        }
    }
    validateConfirmPassword() {

        if ((<HTMLInputElement>document.getElementById("empPassword")).value != (<HTMLInputElement>document.getElementById("empConfirmPassword")).value) {
            (<HTMLElement>document.getElementById("empConfirmPassword")).style.borderBottomColor = "#ff0000";
            (<HTMLElement>document.getElementById("empConfirmPassword")).style.borderBottomWidth = "3px";
            return false;
        } else {
            return true;
        }
    }

    validatePhoneNumber() {

        var numbers = /^[+]?[0-9]+$/;
        if ((<HTMLInputElement>document.getElementById("empPhoneNumber")).value.length < 8 || !((<HTMLInputElement>document.getElementById("empPhoneNumber")).value.match(numbers))) {
            (<HTMLElement>document.getElementById("empPhoneNumber")).style.borderBottomColor = "#ff0000";
            (<HTMLElement>document.getElementById("empPhoneNumber")).style.borderBottomWidth = "3px";
            return false;
        } else {

            return true;
        }
    }
}

function validatePasswordHTML()
{
    employee.validatePassword();
}
function currencyChanger1()
{
    vehicle.currencyChanger();
}

class Vehicle {



    validateVehicleName() {
        if ((<HTMLInputElement>document.getElementById("empVehicleName")).value.length < 4) {
            (<HTMLElement>document.getElementById("empVehicleName")).style.borderBottomColor = "#ff0000";
            (<HTMLElement>document.getElementById("empVehicleName")).style.borderBottomWidth = "3px";
            return false;
        } else {
            return true;
        }
    }

    validateVehicleType() {
        if ((<HTMLInputElement>document.getElementById("empVehicleType")).value != "") {
            return true;
        } else {
            return false;
        }
    }

    validateVehicleIdentification() {
        if ((<HTMLInputElement>document.getElementById("vehicleIdentification")).value.length < 1) {
            (<HTMLElement>document.getElementById("vehicleIdentification")).style.borderBottomColor = "red";
            (<HTMLElement>document.getElementById("vehicleIdentification")).style.borderBottomWidth = "3px";
            return false;
        } else {
            return true;
        }
    }

    currencyChanger() {
        var currency = (<HTMLInputElement>document.getElementById("currencySelector")).value;
        
        let factor:number=0;
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
            
            (<HTMLInputElement>document.getElementById("daily")).value = (5 * factor).toFixed(2);
            (<HTMLInputElement>document.getElementById("monthly")).value = (100 * factor).toFixed(2);
            (<HTMLInputElement>document.getElementById("yearly")).value = (500 * factor).toFixed(2);
            
        }
        if (vehicleType == "Bike") {
            (<HTMLInputElement>document.getElementById("daily")).value = (100 * factor).toFixed(2);
            (<HTMLInputElement>document.getElementById("monthly")).value = (200 * factor).toFixed(2);
            (<HTMLInputElement>document.getElementById("yearly")).value = (1000 * factor).toFixed(2);
        }
        if (vehicleType == "Car") {
            (<HTMLInputElement>document.getElementById("daily")).value = (20 * factor).toFixed(2);
            (<HTMLInputElement>document.getElementById("monthly")).value = (500 * factor).toFixed(2);
            (<HTMLInputElement>document.getElementById("yearly")).value = (3500 * factor).toFixed(2);
        }

    }
}

var employee = new Employee();
var vehicle = new Vehicle();

function empRegForm():void 
{

    switch (inputField) 
    {
        case 'empName':
            name1 = (<HTMLInputElement>document.getElementById(inputField)).value;
            if (employee.validateempName()) 
            {
                (<HTMLElement>document.getElementById("messageFieldEmployee")).innerHTML = "Hi " + name + ". May I know your gender?";
                (<HTMLElement>document.getElementById("empGender")).style.display = "block";

                inputField = "empGender";
                (<HTMLElement>document.getElementById("empName")).style.display = "none";
            }
            break;
        case 'empGender':
            if (employee.validateGender()) {
                (<HTMLElement>document.getElementById("messageFieldEmployee")).innerHTML = "Hi " + name + ". May I know your mail?";
                (<HTMLElement>document.getElementById("empMail")).style.display = "block";
                (<HTMLElement>document.getElementById("empMail")).focus();
                inputField = "empMail";
                (<HTMLElement>document.getElementById("empGender")).style.display = "none";
            }
            break;
        case 'empMail':
            if (employee.validateMail()) {
                (<HTMLElement>document.getElementById("messageFieldEmployee")).innerHTML = "Hi " + name + ". May I know your password?";
                (<HTMLElement>document.getElementById("empPassword")).style.display = "block";
                (<HTMLElement>document.getElementById("empPassword")).focus();
                inputField = "empPassword";
                (<HTMLElement>document.getElementById("empMail")).style.display = "none";
            }
            break;
        case 'empPassword':
            if (employee.validatePassword()) {
                (<HTMLElement>document.getElementById("messageFieldEmployee")).innerHTML = "Hi " + name + ". Please enter your password again to confirm.";
                (<HTMLElement>document.getElementById("empConfirmPassword")).style.display = "block";
                (<HTMLElement>document.getElementById("empConfirmPassword")).focus();
                inputField = "empConfirmPassword";
                (<HTMLElement>document.getElementById("empPassword")).style.display = "none";
            }
            break;
        case 'empConfirmPassword':
            if (employee.validateConfirmPassword()) {
                (<HTMLElement>document.getElementById("messageFieldEmployee")).innerHTML = "Hi " + name + ". May I know your Phone Number?";
                (<HTMLElement>document.getElementById("empPhoneNumber")).style.display = "block";
                (<HTMLElement>document.getElementById("empPhoneNumber")).focus();
                inputField = "empPhoneNumber";
                (<HTMLElement>document.getElementById("empConfirmPassword")).style.display = "none";
            }
            break;
        case 'empPhoneNumber':

            if (employee.validatePhoneNumber()) {

                (<HTMLElement>document.getElementById("messageFieldEmployee")).innerHTML = "Hi " + name + ". You are Registered.";
                (<HTMLElement>document.getElementById("empPhoneNumber")).style.display = "none";
                inputField = "vehicleName";
                (<HTMLElement> document.getElementById("vehicleFieldSet")).style.display = "block";
                (<HTMLElement>document.getElementById("vehicleLabel")).style.display = "block";
                (<HTMLElement>document.getElementById("empVehicleName")).style.display = "block";
                (<HTMLElement>document.getElementById("empVehicleName")).focus();

            }
            break;
        case 'vehicleName':
            if (vehicle.validateVehicleName()) {
                (<HTMLElement>document.getElementById("empVehicleName")).style.display = "none";
                (<HTMLElement>document.getElementById("vehicleLabel")).innerHTML = "Hi " + name + ". What is the number of your vehicle?";
                (<HTMLElement>document.getElementById("empVehicleType")).style.display = "block";
                (<HTMLElement>document.getElementById("empVehicleType")).focus();
                inputField = "vehicleType";
            }
            break;


        case 'vehicleType':
            if (vehicle.validateVehicleType()) {
                (<HTMLElement>document.getElementById("empVehicleType")).style.display = "none";
                (<HTMLElement>document.getElementById("vehicleLabel")).innerHTML = "Hi " + name + ". What is the identification of your vehicle?";
                (<HTMLElement>document.getElementById("vehicleIdentification")).style.display = "block";
                (<HTMLElement>document.getElementById("vehicleIdentification")).focus();
                inputField = "vehicleIdentification";
            }
            break;
        case 'vehicleIdentification':
            (<HTMLElement>document.getElementById("vehicleLabel")).innerHTML = "Hi " + name + ". Your vehicle is registered";
            if (vehicle.validateVehicleIdentification()) {
                (<HTMLElement>document.getElementById("vehicleIdentification")).style.display = "none";
                (<HTMLElement>document.getElementById("passesFieldSet")).style.display = "block";
                (<HTMLElement>document.getElementById("passesLabel")).style.display = "block";
                var parent = (<HTMLElement>document.getElementById("passesForm"));
                var children = parent.children;
                for (var i = 0; i < children.length; i++) {
                    var ch = children[i] as HTMLElement;
                    ch.style.display = "block";
                }
                inputField = "vehiclePass";
                vehicleType = (<HTMLInputElement>document.getElementById("empVehicleType")).value;
                vehicle.currencyChanger();
            }
            break;


    }
}

window.addEventListener("keypress", function(event) {
    if (event.keyCode == 13) {
        empRegForm();
    }
});
