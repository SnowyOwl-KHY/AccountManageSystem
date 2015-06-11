<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="login-bg">
<head>
  <title>Online Payment - Sign in</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <meta http-equiv="content-type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" href="/static/css/signin.css" type="text/css" media="screen" />
</head>

<body>
<div class="login-wrapper">
  <div class="box">
    <div style="width:82%;margin:auto;">
      <h6 align="center">SIGN IN</h6>
      <input type="text" id="un" placeholder="Username" />
      <input type="password" id="pw" placeholder="Password" />
      <a class="forgot" href="forget_password.html">forget password?</a>
      <div class="remember">
        <input id="remember-me" type="checkbox" />
        <label for="remember-me">Remember me</label>
      </div>
      <a class="btn" onclick="signin()">sign in</a>
    </div>
  </div>
  <div class="no-account">
    <p>No account?</p>
    <a href="signup.html">sign up</a>
  </div>
</div>
<!-- scripts -->
<script type="text/javascript">
  function signin(){
    var un = document.getElementById("un").value;
    var pw = document.getElementById("pw").value;
    if(un==""){
      alert("Please enter username!");
      return false;
    }
    if(pw==""){
      alert("Please enter password!");
      return false;
    }
    window.location.href="main.html";
  }
</script>
</body>
</html>
