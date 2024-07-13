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
        .login_link {
            display: block;
            text-align: center;
            margin-top: 20px;
            text-decoration: none;
            color: black;
        }
        .error-message-container {
            width: 50%;
            margin: 20px auto;
            padding: 10px;
            text-align: center;
            background-color: #f44336;
            border: 1px solid #d32f2f;
            border-radius: 5px;
        }
        .error-message {
            color: white;
            font-size: 18px;
        }
     </style>
     <title> Admin Register </title>
</head>
<body>
    <header id="head">
        <h1 class="main_title"> Exam Invigilation Duty</h1>
        <img class="college_logo" src="./images/CMR logo.jfif">
    </header>
     <main id="main" class="homepage">
     	<div class="admin_login login">
        	<form action="registration" method="post" class="login_form">
            	<h1 class="login_title"> Admin Register</h1>
            	<div class="input_box">
               		<input type="text" name="firstname" placeholder="Your First Name">
            	</div>
            	<div class="input_box">
                	<input type="text" name="lastname" placeholder="Your Last Name">
            	</div>
            	<div class="input_box">
            		<input type="email" name="email" placeholder="Enter your mail" required>
        		</div>
         		<div class="input_box">
             		<input type="password" name="password" placeholder="Enter your password" required>
         		</div>
         		<input type="submit" class="btn" value="Register">
                <%
                String messageClass = (String) request.getAttribute("messageClass");
                String message = (String) request.getAttribute("message");
                if (messageClass != null && messageClass.equals("success-message")) { %>
                    <div class="message-container">
                        <p class="message"><i class="fas fa-check-circle"></i><%= message %></p>
                    </div>
                <% } else if (messageClass != null && messageClass.equals("error-message")) { %>
                    <div class="error-message-container">
                        <p class="error-message"><i class="fas fa-exclamation-circle"></i><%= message %></p>
                    </div>
                <% } %>
                <a class="login_link" href="index.jsp">Login</a>
        	</form>
     	</div>
     </main>
</body>
</html>
