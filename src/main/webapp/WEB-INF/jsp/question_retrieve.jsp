<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="bg">
<head>
  <title>Online Payment - Password Questions</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <meta http-equiv="content-type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" href="css/compiled/forget.css" type="text/css" media="screen" />
</head>

<body>
<div class="forget-wrapper">
  <div class="box">
    <div style="width:82%;margin:0 auto;">
      <h6>Password Questions</h6>
      <label>Q1:</label>
      <input type="text" id="ans1" placeholder="Answer"/>
      <label>Q2:</label>
      <input type="text" id="ans2" placeholder="Answer"/>
      <label>Q3:</label>
      <input type="text" id="ans3" placeholder="Answer"/>
      <a class="btn" onclick="submit()">Done</a>
      <a class="btn" onclick="back()">Back</a>
    </div>
  </div>
</div>
<!-- scripts -->
<script type="text/javascript">
  function submit(){
    var posturl = "";
    var ans1 = document.getElementById("ans1").value;
    var ans2 = document.getElementById("ans2").value;
    var ans3 = document.getElementById("ans3").value;
    var form = document.createElement("FORM");
    document.body.appendChild(form);
    form.method = "POST";
    var newElement = document.createElement("input");
    newElement.setAttribute("name", "ans1");
    newElement.setAttribute("type", "hidden");
    var newElement2 = document.createElement("input");
    newElement2.setAttribute("name", "ans2");
    newElement2.setAttribute("type", "hidden");
    var newElement3 = document.createElement("input");
    newElement3.setAttribute("name", "ans3");
    newElement3.setAttribute("type", "hidden");
    form.appendChild(newElement);
    form.appendChild(newElement2);
    form.appendChild(newElement3);
    newElement.value = ans1;
    newElement2.value = ans2;
    newElement3.value = ans3;
    form.action = posturl;
    form.submit();
  }
  function back(){
    window.location.href="signin.html";
  }
</script>
</body>
</html>