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
  <h1 class="center">Employee Home Page</h1>
  <form action="submitrequestpage.jsp" method="get" class="center">
    <button class="float-left submit-button" >Submit a reimbursement request</button>
  </form>
  <br><br>
  <form action="viewpendingpage.jsp" method="get" class="center">
    <button class="float-left submit-button" >View pending reimbursement requests</button>
  </form>
  <br><br>
  <form action="viewresolvedpage.jsp" method="get" class="center">
    <button class="float-left submit-button" >View resolved reimbursement requests</button>
  </form>
  <br><br>
  <form action="viewinfo.jsp" method="get" class="center">
    <button class="float-left submit-button" >View your information</button>
  </form>
  <br><br>
  <form action="updateinfopage.jsp" method="get" class="center">
    <button class="float-left submit-button" >Update your information</button>
  </form>
  <br><br>
  <form action="logout" method="get" class="center">
      <input type="submit" value="Logout">
  </form>
</body>
</html>