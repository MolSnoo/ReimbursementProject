<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>Manager Home Page</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Fira+Mono:wght@400&display=swap');
        body {
        font-family: 'Fira Mono', monospace;
        }
    </style>
</head>
<body>
    <h1 class="center">Manager Home Page</h1>
    <form action="approvedenypage.jsp" method="get" class="center">
        <button class="float-left submit-button" >Approve/Deny pending reimbursement requests</button>
    </form>
    <br><br>
    <form action="viewallpendingpage.jsp" method="get" class="center">
        <button class="float-left submit-button" >View all pending requests of all employees</button>
    </form>
    <br><br>
    <form action="viewallresolvedpage.jsp" method="get" class="center">
        <button class="float-left submit-button" >View all resolved requests of all employees</button>
    </form>
    <br><br>
    <form action="viewspecific.jsp" method="get" class="center">
        <button class="float-left submit-button" >View reimbursement requests of a specific employee</button>
    </form>
    <br><br>
    <form action="viewemployees.jsp" method="get" class="center">
        <button class="float-left submit-button" >View all employees</button>
    </form>
    <br><br>
    <form action="logout" method="get" class="center">
        <input type="submit" value="Logout">
    </form>
    </body>
</html>