<%@ page import="com.softwareengineering.accountmanager.model.data.PurchaseRecord" %>
<%@ page import="java.util.List" %>
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
      <h6 align="center">Hello ${account_name}</h6>
      <h6 align="center">Your new password is ${password}</h6>
      <h6 align="center">Please signin and change your password as soon as possible.</h6>
      <h6 align="center">Thank you.</h6>
      <a class="btn" href="signin">Signin</a>
    </div>
  </div>
</div>
<!-- scripts -->
<script type="text/javascript">
</script>
</body>
</html>