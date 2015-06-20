<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="bg">
<head>
  <title>Online Payment - New password</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <meta http-equiv="content-type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" href="/static/css/signup.css" type="text/css" media="screen" />
</head>

<body>
<div class="signup-wrapper" style="top:150px;">
  <div class="box">
    <div style="width:82%;margin:0 auto;">
      <h6 align="center">Hello </h6><input type="text"value="" id="email">
      <h6 align="center">Your new password is </h6><input type="text"value="" id="pw">
      <h6 align="center">Please signin and change your password as soon as possible.</h6>
      <h6 align="center">Thank you.</h6>
    </div>
  </div>
</div>
<!-- scripts -->
<script type="text/javascript">
  var email = ${account_name};
  var pw = ${password};
  document.getElementById("email").value = email;
  document.getElementById("pw").value = pw;
</script>
</body>
</html>