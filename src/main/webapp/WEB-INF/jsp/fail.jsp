<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Online Payment - Purchase History</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <!-- bootstrap -->
  <link href="/static/css/bootstrap/bootstrap.css" rel="stylesheet" />
  <link href="/static/css/bootstrap/bootstrap-responsive.css" rel="stylesheet" />
  <link href="/static/css/bootstrap/bootstrap-overrides.css" type="text/css" rel="stylesheet" />
  <!-- libraries -->
  <link href="/static/css/lib/jquery-ui-1.10.2.custom.css" rel="stylesheet" type="text/css" />
  <link href="/static/css/lib/font-awesome.css" type="text/css" rel="stylesheet" />
  <!-- global styles -->
  <link rel="stylesheet" type="text/css" href="/static/css/layout.css" />
  <link rel="stylesheet" type="text/css" href="/static/css/elements.css" />
  <link rel="stylesheet" type="text/css" href="/static/css/icons.css" />
  <!-- this page specific styles -->
  <link rel="stylesheet" href="/static/css/compiled/purchase.css" type="text/css" media="screen" />
  <!-- open sans font -->
  <!-- lato font -->
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body>
<!-- navbar -->
<div class="navbar navbar-inverse">
  <div class="navbar-inner">
    <a class="brand" href="main.html"><img src="/static/img/logo.png" /></a>
    <div class="navbar-text">Good afternoon, Cherry!</div>
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
    <li class="active">
      <div class="pointer">
        <div class="arrow"></div>
        <div class="arrow_border"></div>
      </div>
      <a href="#" onclick="InterSUB('purchase')">
        <i class="icon-calendar-empty"></i>
        <span>Purchase History</span>
      </a>
    </li>
    <li>
      <a href="change_password.html">
        <i class="icon-cog"></i>
        <span>Change Password</span>
      </a>
    </li>
  </ul>
</div>
<!-- end sidebar -->
<!-- main container -->
<div class="content">
  <div class="container-fluid">
    <div id="pad-wrapper" style="text-align: center;">
      <h6>CHANGING FAILED!</h6>
      <p>Sorry, modifying failed. Please check your input and retry</p>
    </div>
  </div>
</div>

<script type="text/javascript">
  var __ACCOUNT = "${ACCOUNT}";
  var __STATE = 1;

  function InterSUB(str){
    var form = document.createElement("FORM");
    document.body.appendChild(form);
    form.method = "POST";
    var newElement = document.createElement("input");
    newElement.setAttribute("name", "ACCOUNT");
    newElement.setAttribute("type", "hidden");
    form.appendChild(newElement);
    newElement.value = __ACCOUNT;
    form.action = str;
    form.submit();
  }
</script>


</body>
</html>