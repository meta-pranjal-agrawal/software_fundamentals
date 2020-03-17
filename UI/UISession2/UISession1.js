$(document).ready(function() {
    //scroll to respective form on click nav tag elements
    $(".navlink").on('click', function(event) {
        if (this.hash !== "") {
            event.preventDefault();
            var hash = this.hash;
            if ($(hash).is(":hidden")) {
                $(".forms").hide();
                $(hash).show(500);
            }
            $('html, body').animate({
                scrollTop: $(hash).offset().top - 70
            }, 800);
        }
    });
});

function hideAllForms() {
    var forms = document.getElementsByClassName("forms");
    for (let i = 0; i < forms.length; i++) {
        forms[i].style.display = "none";
    }
}
hideAllForms();

function addEmployeeRegistration() {
    hideAllForms();
    document.getElementById("empRegistrationForm").style.display = "block";
}

function addVehicleRegistration() {
    hideAllForms();
    document.getElementById("vehicleForm").style.display = "block";
}

function addFeedback() {
    hideAllForms();
    document.getElementById("feedbackForm").style.display = "block";
}

function addPricing() {
    hideAllForms();
    document.getElementById("pricing").style.display = "block";
}