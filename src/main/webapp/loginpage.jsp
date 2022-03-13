<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>Login Page</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Fira+Mono:wght@400&display=swap');
        body {
        font-family: 'Fira Mono', monospace;
        }
    </style>
</head>
<body class="center">
<h1 class="center">Login Page</h1>
<form action="login" method="post" class="center">
    <p>Enter Email:</p>
    <input type="email" name="email">
    <br><br>
    <p>Enter Password:</p>
    <input type="password" name="password">
    <br><br>
    <input type="submit" value="Login">
</form>
</body>
</html>