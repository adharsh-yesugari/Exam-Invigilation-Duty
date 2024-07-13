<!DOCTYPE html>
<html lang="en">
<head>
     <meta charset="UTF-8" />
     <meta http-equiv="X-UA-Compatible" content="IE=edge" />
     <meta name="viewport" content="width=device-width, initial-scale=1.0" />
     <link href="./CSS/styles.css" rel="stylesheet">
    <style>
        .message-container {
            width: 50%;
            margin: 20px auto;
            padding: 10px;
            text-align: center;
            background-color: #4CAF50;
            border: 1px solid #008000;
            border-radius: 5px;
        }
        .message {
            color: white;
            font-size: 18px;
        }
    </style>
     <title> Exam Invigilation Duty </title>
</head>
<body>
    <jsp:include page="header.jsp"/>
    <jsp:include page="AdminNavbar.jsp"/>
    <section id="add_faculty" class="faculty_info homepage">
    <div class="login">
        <h1 class="login_title"> Add Faculty Info </h1>
        <form action="add_faculty_info" method="post">
            <div class="input_box">
                <input type="text" name="facultyName" placeholder="Enter faculty name">
            </div>
            <div class="form-group selection">
                <label>Gender</label>
                <div class="common-input">
                    <input type="radio" name="gender" value="male"  />&nbsp;Male&nbsp;
                    <input type="radio" name="gender" value="female"  />&nbsp;Female&nbsp;
                    <input type="radio" name="gender" value="others"  />&nbsp;Others&nbsp;
                </div>
            </div>
            <div class="form-group input_box">
                <input type="text" name="phoneNumber" placeholder="Enter Phone Number" required />
            </div>
            <div class="form-group selection">
                <label>Qualification</label>
                <div class="common-input">
                    <input type="radio" name="qualification" value="M.Tech"  />&nbsp;M.Tech&nbsp;
                    <input type="radio" name="qualification" value="B.Tech"  />&nbsp;B.Tech&nbsp;
                    <input type="radio" name="qualification" value="Others"  />&nbsp;Others&nbsp;
                </div>
            </div>
            <div class="form-group input_box">
                <input type="email" name="email" placeholder="Enter faculty Email" required />
            </div>
            <div class="form-group input_box">
                <input type="password" name="password" placeholder="Enter the password" required />
            </div>
            <button type="submit" class="btn">Add Faculty</button>
            <% String messageClass = (String) request.getAttribute("messageClass"); %>
            <% if (messageClass != null && messageClass.equals("success-message")) { %>
                <% String message = (String) request.getAttribute("message"); %>
                <div class="message-container">
                    <p class="message"><i class="fas fa-check-circle"></i><%= message %></p>
                </div>
            <% } else { %>
                <% String errorMessage = (String) request.getAttribute("errorMessage"); %>
                <% if (errorMessage != null) { %>
                    <div class="message-container">
                        <p class="message"><i class="fas fa-exclamation-circle"></i><%= errorMessage %></p>
                    </div>
                <% } %>
            <% } %>
        </form>
    </div>
    </section>
</body>
</html>
