<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="bg">
<head>
  <title>Online Payment - Forget Password</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <meta http-equiv="content-type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" href="/static/css/forget.css" type="text/css" media="screen" />
</head>

<body>
<div class="forget-wrapper">
  <div class="box">
    <div style="width:82%;margin:0 auto;">
      <h6>RETRIVE PASSWORD</h6>
      <input type="text" id="email" placeholder="Email-address" />
      <br />
      <br />
      <a class="btn" onclick="check1()">By Email</a>
      <br />
      <br />
      <a class="btn" onclick="check2()">By Questions</a>
      <br />
      <br />
      <a class="btn" onclick="back()">Back</a>
    </div>
  </div>
</div>
<!-- scripts -->
<script type="text/javascript">
  function check1(){
    var email = document.getElementById("email").value;
    var chose = "email";
    if(email==""){
      alert("Please enter email address!");
      return false;
    }
    submit(email, chose);
  }
  function check2(){
    var email = document.getElementById("email").value;
    var chose = "question";
    if(email==""){
      alert("Please enter email address!");
      return false;
    }
    submit(email, question);
  }
  function back(){
    window.location.href="signin.html";
  }
  function submit(email, chose){
    var posturl = "";
    var email = email;
    var chose = chose;
    var form = document.createElement("FORM");
    document.body.appendChild(form);
    form.method = "POST";
    var newElement = document.createElement("input");
    newElement.setAttribute("name", "email");
    newElement.setAttribute("type", "hidden");
    var newElement2 = document.createElement("input");
    newElement2.setAttribute("name", "chose");
    newElement2.setAttribute("type", "hidden");
    form.appendChild(newElement);
    form.appendChild(newElement2);
    newElement.value = email;
    newElement2.value = chose;
    form.action = posturl;
    form.submit();
  }
</script>
</body>
</html>