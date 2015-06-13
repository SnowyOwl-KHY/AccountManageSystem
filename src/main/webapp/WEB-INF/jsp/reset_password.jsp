<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html class="bg">
<head>
  <title>Online Payment - Reset Password</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <meta http-equiv="content-type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" href="/static/css/forget.css" type="text/css" media="screen" />
</head>

<body>
<div class="forget-wrapper">
  <div class="box">
    <div style="width:82%;margin:0 auto;">
      <h6>Set New Password</h6>
      <label>New Password:</label>
      <input type="password" id="pw1" placeholder="Password" />
      <label>Confirm New Password:</label>
      <input type="password" id="pw2" placeholder="Confirm Password" />
      <br />
      <br />
      <a class="btn" onclick="reset()">Done</a>
    </div>
  </div>
</div>
<!-- scripts -->
<script type="text/javascript">
  var __ACCOUNT = ${account_name};
  function reset(){
    var pw1 = document.getElementById("pw1").value;
    var pw2 = document.getElementById("pw2").value;
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
    submit(pw1);
  }
  function submit(pw){
    var posturl = "reset_password_";
    var pw = pw;
    var form = document.createElement("FORM");
    document.body.appendChild(form);
    form.method = "POST";
    var newElement = document.createElement("input");
    newElement.setAttribute("name", "password");
    newElement.setAttribute("type", "hidden");
    form.appendChild(newElement);
    newElement.value = pw;

    var newElement2 = document.createElement("input");
    newElement2.setAttribute("name", "account_name");
    newElement2.setAttribute("type", "hidden");
    form.appendChild(newElement2);
    newElement2.value = __ACCOUNT;

    form.action = posturl;
    form.submit();
  }
</script>
</body>
</html>