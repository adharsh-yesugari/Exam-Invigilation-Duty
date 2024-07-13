function updateEmailId() {
    var facultyName = document.getElementById("faculty_name").value;
    var options = document.getElementById("faculty_name").getElementsByTagName("option");
    var selectedOption = null;
    for (var i = 0; i < options.length; i++) {
        if (options[i].value === facultyName) {
            selectedOption = options[i];
            break;
        }
    }
    var facultyEmailId = selectedOption.getAttribute("data-email");
    // Example: Update email display or perform other actions based on selected faculty
}