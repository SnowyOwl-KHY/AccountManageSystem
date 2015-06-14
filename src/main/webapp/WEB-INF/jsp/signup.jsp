<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="bg">
<head>
  <title>Online Payment - Sign up</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <meta http-equiv="content-type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" href="/static/css/signup.css" type="text/css" media="screen" />
</head>

<body>
<div class="signup-wrapper">
  <div class="box">
    <div style="width:82%;margin:0 auto;">
      <h6 align="center">SIGN UP</h6>
      <input type="text" id="email" placeholder="Email-address" name="account_name"/>
      <input type="password" id="pw1" placeholder="Password"/>
      <input type="password" id="pw2" placeholder="Confirm Password"/>
      <br />
      <br />
      <a class="btn" onclick="signup()">sign up</a>
    </div>
  </div>
  <div class="already-have">
    <p>Already have an account?</p>
    <a href="signin">sign in</a>
  </div>
</div>
<!-- scripts -->
<script type="text/javascript">
  function signup(){
    var email = document.getElementById("email").value;
    //console.log(email);
    var pw1 = document.getElementById("pw1").value;
    var pw2 = document.getElementById("pw2").value;
    //var sReg = /[_a-zA-Z\d\-\.]+@[_a-zA-Z\d\-]+(\.[_a-zA-Z\d\-]+)+$/;
    if(email==""){
      alert("Please enter email address!");
      return false;
    }
//    if(!sReg.test(email)){
//      alert("Please enter valid email address!");
//      return false;
//    }
    if(pw1==""){
      alert("Please enter password!");
      return false;
    }
    if(pw2==""){
      alert("Please confirm password!");
      return false;
    }
    if(pw1!=pw2){
      alert("Password confirm false!");
      return false;
    }
    submit(email, pw1);
  }
  function submit(email,pw1){
    var form = document.createElement("FORM");
    document.body.appendChild(form);
    form.method = "POST";
    var newElement = document.createElement("input");
    newElement.setAttribute("name", "account_name");
    newElement.setAttribute("type", "hidden");
    var newElement2 = document.createElement("input");
    newElement2.setAttribute("name", "password");
    newElement2.setAttribute("type", "hidden");
    form.appendChild(newElement);
    form.appendChild(newElement2);
    newElement.value = email;
    newElement2.value = pw1;
    form.action = "signup";
    form.submit();
  }
</script>
</body>
</html>