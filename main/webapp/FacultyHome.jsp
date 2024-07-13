<!DOCTYPE html>
<html lang="en">
<head>
     <meta charset="UTF-8" />
     <meta http-equiv="X-UA-Compatible" content="IE=edge" />
     <meta name="viewport" content="width=device-width, initial-scale=1.0" />
     <link href="./CSS/styles.css" rel="stylesheet">
     <title> Faculty Login </title>
</head>
<body>
    <jsp:include page="header.jsp"/>
    <section id="navlinks">
        	<a class="login_link" href="ViewFacultySchedule">View Allotment</a>
        	<a class="login_link" href="logout">Logout</a>
    </section>
    <main class="admin_home">
            <%
                String faculty_emailId = (String)session.getAttribute("facultyEmailId");
            %>
            <h1 class="admin_title">Welcome Faculty</h1>
            <p class="paragraph">Lets view invigialtion Duty</p>
     </main>

</body>
</html>