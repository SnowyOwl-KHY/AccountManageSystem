<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Online Payment - Change Password</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <!-- bootstrap -->
  <link href="css/bootstrap/bootstrap.css" rel="stylesheet" />
  <link href="css/bootstrap/bootstrap-responsive.css" rel="stylesheet" />
  <link href="css/bootstrap/bootstrap-overrides.css" type="text/css" rel="stylesheet" />
  <!-- libraries -->
  <link href="css/lib/bootstrap-wysihtml5.css" type="text/css" rel="stylesheet" />
  <link href="css/lib/uniform.default.css" type="text/css" rel="stylesheet" />
  <link href="css/lib/select2.css" type="text/css" rel="stylesheet" />
  <link href="css/lib/bootstrap.datepicker.css" type="text/css" rel="stylesheet" />
  <link href="css/lib/font-awesome.css" type="text/css" rel="stylesheet" />
  <!-- global styles -->
  <link rel="stylesheet" type="text/css" href="css/layout.css" />
  <link rel="stylesheet" type="text/css" href="css/elements.css" />
  <link rel="stylesheet" type="text/css" href="css/icons.css" />
  <!-- this page specific styles -->
  <link rel="stylesheet" href="/static/css/change.css" type="text/css" media="screen" />
</head>

<body>
<!-- navbar -->
<div class="navbar navbar-inverse">
  <div class="navbar-inner">
    <a class="brand" href="main.html"><img src="img/logo.png" /></a>
  </div>
</div>
<!-- end navbar -->
<!-- sidebar -->
<div id="sidebar-nav">
  <ul id="dashboard-menu">
    <li>
      <a href="main.html">
        <i class="icon-home"></i>
        <span>Home</span>
      </a>
    </li>
    <li>
      <a href="information.html">
        <i class="icon-edit"></i>
        <span>Information</span>
      </a>
    </li>
    <li>
      <a href="recharge.html">
        <i class="icon-signal"></i>
        <span>Recharge</span>
      </a>
    </li>
    <li>
      <a href="purchase_history.html">
        <i class="icon-calendar-empty"></i>
        <span>Purchase History</span>
      </a>
    </li>
    <li class="active">
      <div class="pointer">
        <div class="arrow"></div>
        <div class="arrow_border"></div>
      </div>
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
    <div id="pad-wrapper">
      <div class="row-fluid">
        <div class="span12">
          <div class="step-content">
            <div class="step-pane active" id="step1">
              <div class="row-fluid form-wrapper">
                <div class="span8">
                  <form />
                  <div class="field-box">
                    <label>Old Passworld:</label>
                    <input class="span8" id="pw0" type="password" />
                  </div>
                  <div class="field-box">
                    <label>New Password:</label>
                    <input class="span8" id="pw1" type="password" />
                  </div>
                  <div class="field-box">
                    <label>Confirm New Password:</label>
                    <input class="span8" id="pw2" type="password" />
                  </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
          <div class="wizard-actions">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <button type="button" onclick="change()" class="btn-glow primary btn">
              Change
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- end main container -->
<!-- scripts -->
<script type="text/javascript">
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
    var posturl = "";
    var pw0 = pw0;
    var pw1 = pw1;
    var form = document.createElement("FORM");
    document.body.appendChild(form);
    form.method = "POST";
    var newElement = document.createElement("input");
    newElement.setAttribute("name", "pw0");
    newElement.setAttribute("type", "hidden");
    var newElement2 = document.createElement("input");
    newElement2.setAttribute("name", "pw1");
    newElement2.setAttribute("type", "hidden");
    form.appendChild(newElement);
    form.appendChild(newElement2);
    newElement.value = pw0;
    newElement2.value = pw1;
    form.action = posturl;
    form.submit();
  }
</script>
</body>
</html>