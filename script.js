function setError(id, msg, inputId) {
    document.getElementById(id).innerText = msg;

    if (inputId) {
        document.getElementById(inputId).classList.add("error-border");
        document.getElementById(inputId).classList.remove("success");
    }
}

function setSuccess(id, inputId) {
    document.getElementById(id).innerText = "";

    if (inputId) {
        document.getElementById(inputId).classList.add("success");
        document.getElementById(inputId).classList.remove("error-border");
    }
}

function validateForm() {

    let valid = true;

    let name = document.getElementById("name").value.trim();
    let email = document.getElementById("email").value.trim();
    let mobile = document.getElementById("mobile").value.trim();
    let dept = document.getElementById("department").value;
    let feedback = document.getElementById("feedback").value.trim();
    let gender = document.getElementsByName("gender");

    document.getElementById("successMsg").innerText = "";

    // Name
    if (name === "") {
        setError("nameError", "Name required", "name");
        valid = false;
    } else setSuccess("nameError", "name");

    // Email
    let emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailPattern.test(email)) {
        setError("emailError", "Enter valid email", "email");
        valid = false;
    } else setSuccess("emailError", "email");

    // Mobile
    let mobilePattern = /^[0-9]{10}$/;
    if (!mobilePattern.test(mobile)) {
        setError("mobileError", "Enter 10 digit number", "mobile");
        valid = false;
    } else setSuccess("mobileError", "mobile");

    // Department
    if (dept === "") {
        document.getElementById("deptError").innerText = "Select department";
        valid = false;
    } else document.getElementById("deptError").innerText = "";

    // Gender
    let selected = false;
    for (let i = 0; i < gender.length; i++) {
        if (gender[i].checked) selected = true;
    }

    if (!selected) {
        document.getElementById("genderError").innerText = "Select gender";
        valid = false;
    } else document.getElementById("genderError").innerText = "";

    // Feedback
    let words = feedback.split(/\s+/).filter(w => w).length;

    if (words < 10) {
        setError("feedbackError", "Minimum 10 words required", "feedback");
        valid = false;
    } else setSuccess("feedbackError", "feedback");

    if (valid) {
        document.getElementById("successMsg").innerText = "Form submitted successfully!";
    }

    return valid;
}