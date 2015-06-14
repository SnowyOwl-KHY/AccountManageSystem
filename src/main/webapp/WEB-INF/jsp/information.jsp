<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Online Payment - Information</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <!-- bootstrap -->
  <link href="/static/css/bootstrap/bootstrap.css" rel="stylesheet" />
  <link href="/static/css/bootstrap/bootstrap-responsive.css" rel="stylesheet" />
  <link href="/static/css/bootstrap/bootstrap-overrides.css" type="text/css" rel="stylesheet" />
  <!-- global styles -->
  <link rel="stylesheet" type="text/css" href="/static/css/layout.css" />
  <link rel="stylesheet" type="text/css" href="/static/css/elements.css" />
  <link rel="stylesheet" type="text/css" href="/static/css/icons.css" />
  <!-- libraries -->
  <link rel="stylesheet" type="text/css" href="/static/css/lib/font-awesome.css" />
  <link href="/static/css/lib/bootstrap.datepicker.css" rel="stylesheet" />
  <!-- this page specific styles -->
  <link rel="stylesheet" href="/static/css/compiled/information.css" type="text/css" media="screen" />
  <!-- open sans font -->
  <link href='http://fonts.useso.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css' />
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body>
<!-- navbar -->
<div class="navbar navbar-inverse">
  <div class="navbar-inner">
    <a class="brand" href="main.html"><img src="/static/img/logo.png" /></a>
    <div class="navbar-text">Good afternoon, ${account_name}</div>
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
    <li class="active">
      <div class="pointer">
        <div class="arrow"></div>
        <div class="arrow_border"></div>
      </div>
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
    <li>
      <a href="#" onclick="InterSUB('pay_password_change')">
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
    <div id="pad-wrapper" class="new-user">
      <div class="row-fluid header">
        <h3>Personal Info</h3>
      </div>
      <div class="row-fluid form-wrapper">
        <div class="container">
          <form class="new_user_form inline-input" />
          <div class="span12 field-box" style="text-align:center;">
            <div class="personal-image">
              <img src="/static/img/personal-info.png" class="avatar img-circle">
              <p>upload image</p>
              <input type="file" style="position: relative;left: 55px;">
            </div>
          </div>
          <div class="span12 field-box">
            <label>Nickname:</label>
            <input class="span9" type="text" id="_nickname" placeholder="${info.getNickname()}" name="nickname"/>
          </div>
          <div class="span12 field-box">
            <label>Name:</label>
            <input class="span9" type="text" id="_name" name="realname" placeholder="${info.getRealName()}"/>
          </div>
          <div class="span12 field-box">
            <label>Gender:</label>
            <div class="span9">
              <label class="radio">
                <div class="radio" ><span class=""><input type="radio" name="optionsRadios" id="optionsRadios1" value="male" checked=""></span></div>male
              </label>
              <label class="radio">
                <div class="radio"><span class="checked"><input type="radio" name="optionsRadios" id="optionsRadios2" value="female"></span></div>female
              </label>
              <label class="radio">
                <div class="radio"><span class="checked"><input type="radio" name="optionsRadios" id="optionsRadios3" value="else"></span></div>else
              </label>
            </div>
          </div>
          <div class="span12 field-box">
            <label>Country:</label>
            <div class="ui-select span5">
              <select id="_country" name="country">
                <option value="China" />China
                <option value="United States" />United States
                <option value="Korean" />Korean
                <option value="Japan" />Japan
                <option value="England" />England
                <option value="German" />German
                <option value="Spain" />Spain
              </select>
            </div>
          </div>
          <div class="field-box">
            <label>Date of birth:</label>
            <input type="text" placeholder="${info.getBirthday()}" class="input-large datepicker" id="_birthday" name="birthday">
          </div>
          <div class="span12 field-box">
            <label>Phone:</label>
            <input class="span9" type="text" placeholder="${info.getPhone()}" id="_phone"name="phone"/>
          </div>
          <div class="span12 field-box">
            <label>Address:</label>
            <div class="address-fields">
              <input class="span12" type="text" placeholder="${info.getAddress()}" id="_addr1" name="address"/>
              <input class="span12 small" type="text" placeholder="Beijing" id="_addr2"/>
              <input class="span12 small" type="text" placeholder="China" id="_addr3"/>
              <input class="span12 small last" type="text" placeholder="${info.getPostcode()}" id="_postcode" name="postcode"/>
            </div>
          </div>
          <div class="span12 field-box textarea">
            <label>Personal profile:</label>
            <textarea class="span9" id="_text" name="text" onKeyDown="textdown()" placeholder="${info.getText()}"></textarea>
            <span class="charactersleft">no more than 200 words</span>
          </div>
          <div class="span11 field-box actions">
            <input type="button" class="btn-glow primary" value="Save" onclick="SUBM('info_change')"/>
          </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- end main container -->
<!-- scripts -->
<script src="/static/js/jquery-latest.js"></script>
<script src="/static/js/bootstrap.min.js"></script>
<script src="/static/js/theme.js"></script>
<script src="/static/js/bootstrap.datepicker.js"></script>
<script type="text/javascript">
  $(function () {
    // toggle form between inline and normal inputs
    var $buttons = $(".toggle-inputs button");
    var $form = $("form.new_user_form");
    $buttons.click(function () {
      var mode = $(this).data("input");
      $buttons.removeClass("active");
      $(this).addClass("active");
      if (mode === "inline") {
        $form.addClass("inline-input");
      } else {
        $form.removeClass("inline-input");
      }
    });
  });

</script>
<!-- call this page plugins -->
<script type="text/javascript">
  $(function () {
    // datepicker plugin
    $('.datepicker').datepicker().on('changeDate', function (ev) {
      $(this).datepicker('hide');
    });
  });
</script>

<script type="text/javascript">

  var __ACCOUNT = "${account_name}";
  var __STATE = 1;
  var __flag = "${flag}";
  console.log(__flag);

  var __country="${info.getCountry()}";
  var __nickname="${info.getNickname()}";
  var __gender="${info.getGender()}";
  var __realname="${info.getRealName()}";
  var __birthday="${info.getBirthday()}";
  var __phone="${info.getPhone()}";
  var __address="${info.getAddress()}";
  var __text="${info.getText()}";
  var __postcode="${info.getPostcode()}";

  var radios=document.getElementsByName("optionsRadios");
  for (var i=0;i<radios.length;i++){ //遍历Radio
    if(radios[i].value=="${info.getGender()}")
      radios[i].checked=true;
  }

  document.getElementById("_country").value="${info.getCountry()}";



  function textdown()
  {
    console.log("进入了keyup");
    var s = document.getElementById('_text').value;
    console.log("字符串长度",s.length);
    if(s.length > 180)
    {
      document.getElementById('_text').value=s.substring(0,180);
    }
  }
  function SUBM(str){

    var phonenumber=document.getElementById("_phone").value;
    if(isNaN(phonenumber)){
      alert("Phone number is not right!");
      return;
    }

    SUBMmit(str);
  }

  function SUBMmit(str){

    var j_gender;
    var j_radios=document.getElementsByName("optionsRadios")
    for (var i=0;i<j_radios.length;i++){ //遍历Radio
      if(j_radios[i].checked){
        j_gender=j_radios[i].value;
      }
    }

    var form = document.createElement("FORM");
    document.body.appendChild(form);
    form.method = "POST";

    var newElement = document.createElement("input");
    newElement.setAttribute("name", "account_name");
    newElement.setAttribute("type", "hidden");
    newElement.value = __ACCOUNT;
    form.appendChild(newElement);

    var newElement2 = document.createElement("input");
    newElement2.setAttribute("name", "gender");
    newElement2.setAttribute("type", "hidden");
    form.appendChild(newElement2);
    newElement2.value = j_gender;

    if(document.getElementById("_nickname").value=="")document.getElementById("_nickname").value==__nickname;
    if(document.getElementById("_name").value=="")document.getElementById("_name").value==__realname;
    if(document.getElementById("_birthday").value=="")document.getElementById("_birthday").value==__birthday;
    if(document.getElementById("_phone").value=="")document.getElementById("_phone").value==__phone;
    if(document.getElementById("_addr1").value=="")document.getElementById("_addr1").value==__address;
    if(document.getElementById("_text").value=="")document.getElementById("_text").value==__text;
    if(document.getElementById("_postcode").value=="")document.getElementById("_postcode").value==__postcode;
    form.appendChild(document.getElementById("_nickname"));
    form.appendChild(document.getElementById("_name"));
    form.appendChild(document.getElementById("_country"));
    form.appendChild(document.getElementById("_birthday"));
    form.appendChild(document.getElementById("_phone"));
    form.appendChild(document.getElementById("_addr1"));
    form.appendChild(document.getElementById("_text"));
    form.appendChild(document.getElementById("_postcode"));

    form.action = str;
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
