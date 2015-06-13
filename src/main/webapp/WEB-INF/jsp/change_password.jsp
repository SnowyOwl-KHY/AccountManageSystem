<!DOCTYPE html>
<html>
<head>
  <title>Online Payment - Change Password</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <!-- bootstrap -->
  <link href="/static/css/bootstrap/bootstrap.css" rel="stylesheet" />
  <link href="/static/css/bootstrap/bootstrap-responsive.css" rel="stylesheet" />
  <link href="/static/css/bootstrap/bootstrap-overrides.css" type="text/css" rel="stylesheet" />
  <!-- libraries -->
  <link href="/static/css/lib/bootstrap-wysihtml5.css" type="text/css" rel="stylesheet" />
  <link href="/static/css/lib/uniform.default.css" type="text/css" rel="stylesheet" />
  <link href="/static/css/lib/select2.css" type="text/css" rel="stylesheet" />
  <link href="/static/css/lib/bootstrap.datepicker.css" type="text/css" rel="stylesheet" />
  <link href="/static/css/lib/font-awesome.css" type="text/css" rel="stylesheet" />
  <!-- global styles -->
  <link rel="stylesheet" type="text/css" href="/static/css/layout.css" />
  <link rel="stylesheet" type="text/css" href="/static/css/elements.css" />
  <link rel="stylesheet" type="text/css" href="/static/css/icons.css" />
  <!-- this page specific styles -->
  <link rel="stylesheet" href="/static/css/compiled/change.css" type="text/css" media="screen" />
</head>

<body>
<!-- navbar -->
<div class="navbar navbar-inverse">
  <div class="navbar-inner">
    <a class="brand" h
       ref="main.html"><img src="/static/img/logo.png" /></a>
  </div>
</div>
<!-- end navbar -->
<!-- sidebar -->
<div id="sidebar-nav">
  <ul id="dashboard-menu">
    <li>
      <a href="#" onclick="InterSUB('main')">
        <i class="icon-home"></i>
        <span>Home</span>
      </a>
    </li>
    <li>
      <a href="#" onclick="InterSUB('info')">
        <i class="icon-edit"></i>
        <span>Information</span>
      </a>
    </li>
    <li>
      <a href="#" onclick="InterSUB('recharge')">
        <i class="icon-signal"></i>
        <span>Recharge</span>
      </a>
    </li>
    <li>
      <a href="#" onclick="InterSUB('purchase')">
        <i class="icon-calendar-empty"></i>
        <span>Purchase History</span>
      </a>
    </li>
    <li class="active">
      <div class="pointer">
        <div class="arrow"></div>
        <div class="arrow_border"></div>
      </div>
      <a href="#" onclick="InterSUB('pay_password_change')">
        <i class="icon-cog"></i>
        <span>Change Password</span>
      </a>
    </li>
  </ul>
</div>
<!-- end sidebar -->
<!-- main container -->
<div style="position:relative;margin-left:177px;">
  <div style="margin-left:100px;margin-top:100px;">
    <label>Old Passworld:</label>
    <input id="pw0" type="password" />
    <label>New Password:</label>
    <input id="pw1" type="password" />
    <label>Confirm New Password:</label>
    <input id="pw2" type="password" />
  </div>
  <a class="btn" onclick="change()" style="margin-left:100px;margin-top:50px;">
    Change
  </a>
</div>
<!-- scripts -->
<script type="text/javascript">
  var __ACCOUNT = ${account_name};
  function change(){
    var pw0 = document.getElementById("pw0").value;
    var pw1 = document.getElementById("pw1").value;
    var pw2 = document.getElementById("pw2").value;
    if(pw0==""){
      alert("Please enter old password!");
      return false;
    }
    if(pw1==""){
      alert("Please enter new password!");
      return false;
    }
    if(pw2==""){
      alert("Please confirm new password!");
      return false;
    }
    if(pw1!=pw2){
      alert("Password confirm false!");
      return false;
    }
    alert("Password change success!");
    submit(pw0, pw1);
  }
  function submit(pw0, pw1){
    var posturl = "pay_password_chage_";
    var pw0 = pw0;
    var pw1 = pw1;
    var form = document.createElement("FORM");
    document.body.appendChild(form);
    form.method = "POST";
    var newElement = document.createElement("input");
    newElement.setAttribute("name", "old_password");
    newElement.setAttribute("type", "hidden");
    var newElement2 = document.createElement("input");
    newElement2.setAttribute("name", "new_password");
    newElement2.setAttribute("type", "hidden");
    var newElement3 = document.createElement("input");
    newElement3.setAttribute("name", "account_name");
    newElement3.setAttribute("type", "hidden");
    form.appendChild(newElement);
    form.appendChild(newElement2);
    form.appendChild(newElement3);
    newElement.value = pw0;
    newElement2.value = pw1;
    newElement3.value = __ACCOUNT;
    form.action = posturl;
    form.submit();
  }


  function InterSUB(str){
    var form = document.createElement("FORM");
    document.body.appendChild(form);
    form.method = "POST";
    var newElement = document.createElement("input");
    newElement.setAttribute("name", "account_name");
    newElement.setAttribute("type", "hidden");
    form.appendChild(newElement);
    newElement.value = __ACCOUNT;
    form.action = str;
    form.submit();
  }

</script>
</body>
</html>