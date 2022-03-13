<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>Employee Home Page</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Fira+Mono:wght@400&display=swap');
        body {
        font-family: 'Fira Mono', monospace;
        }
    </style>
</head>
<body>
    <h1 class="center">Approve/Deny Reimbursement Request Page</h1>
    <form action="approvedeny" method="post" class="center">
        <p>Enter Reimbursement Request Id:</p>
        <input type="number" name="id">
        <br><br>
        <p>Select Action:</p>
        <select name="action">
            <option value="APPROVE">Approve</option>
            <option value="REJECT">Reject</option>
        </select>
        <br><br>
        <input type="submit" value="Submit">
        </form>
    <br><br>
    <form action="backtohomepage" method="get" class="center">
        <input type="submit" value="Back to homepage">
    </form>
</body>
</html>