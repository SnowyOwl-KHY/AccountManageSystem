<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html>
<head>
  <title>Online Payment - Recharge</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
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
  <link rel="stylesheet" href="/static/css/compiled/recharge.css" type="text/css" media="screen" />
  <!-- open sans font -->
</head>

<body>
  <!-- navbar -->
  <div class="navbar navbar-inverse">
    <div class="navbar-inner">
      <a class="brand" href="signin"><img src="/static/img/logo.png" /></a>
      <div class="navbar-text">Hello, ${account_name}!</div>
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
      <li >
        <a href="#" onclick="InterSUB('info')">
          <i class="icon-edit"></i>
          <span>Information</span>
        </a>
      </li>
      <li class="active">
        <div class="pointer">
          <div class="arrow"></div>
          <div class="arrow_border"></div>
        </div>
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
      <div id="pad-wrapper">
        <div class="row-fluid">
          <div class="span12">
            <div id="fuelux-wizard" class="wizard row-fluid">
              <ul class="wizard-steps" style="left:150px">
                <li data-target="#step1" class="active">
                  <span class="step">1</span>
                  <span class="title">Recharge<br />Amount</span>
                </li>
                <li data-target="#step2">
                  <span class="step">2</span>
                  <span class="title">Recharge<br />Password</span>
                </li>
              </ul>
            </div>
            <div class="step-content">
              <div class="step-pane active" id="step1" style = "min-height:100px">
                <div class="row-fluid form-wrapper">
                  <div class="span8" style="position: relative;left: 150px;">
                    <form />
                    <div class="field-box">
                      <label>Amount:</label>
                      <div class="input-append">
                        <input class="input-large" type="text" id="_money" name="money">
                        <span class="add-on">.00$</span>
                      </div>
                    </div>
                    <div class="span12 field-box">
                      <label>Approach:</label>
                      <div class="ui-select span5">
                        <select id="_way">
                          <option value="AK">建设银行
                          </option><option value="HI">农业银行
                        </option><option value="CA">支付宝
                        </option><option value="NV">微信
                        </option></select>
                      </div>
                    </div>
                    </form>
                  </div>
                </div>
              </div>
              <div class="step-pane" id="step2" style = "min-height:100px">
                <div class="row-fluid form-wrapper">
                  <div class="span8" style="position: relative;left: 150px;">
                    <form />
                    <div class="field-box">
                      <label>Password:</label>
                      <input class="span4" type="password" id="_password" name="password"/>
                    </div>
                    </form>
                  </div>
                </div>
              </div>
              <div class="step-pane" id="step3">
              </div>
              <div class="wizard-actions" style="margin-right:525px">
                <button type="button" disabled="" class="btn-glow primary btn-prev">
                  <i class="icon-chevron-left">back</i>
                </button>
                <button type="button" class="btn-glow primary btn-next" data-last="Finish">
                  <i class="icon-chevron-right">next</i>
                </button>
                <button type="button" class="btn-glow success btn-finish" onclick="SUBM('recharge_')">
                  done
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- end main container -->
    <!-- scripts for this page -->
    <script src="/static/js/jquery-latest.js"></script>
    <script src="/static/js/bootstrap.min.js"></script>
    <script src="/static/js/theme.js"></script>
    <script src="/static/js/fuelux.wizard.js"></script>
    <script type="text/javascript">

      var __ACCOUNT = "${account_name}";
      var __STATE = 1;

      $(function () {
        var $wizard = $('#fuelux-wizard'),
                $btnPrev = $('.wizard-actions .btn-prev'),
                $btnNext = $('.wizard-actions .btn-next'),
                $btnFinish = $(".wizard-actions .btn-finish");
        $wizard.wizard().on('finished', function(e) {
          // wizard complete code
        }).on("changed", function(e) {
          var step = $wizard.wizard("selectedItem");
          // reset states
          $btnNext.removeAttr("disabled");
          $btnPrev.removeAttr("disabled");
          $btnNext.show();
          $btnFinish.hide();
          if (step.step === 1) {
            $btnPrev.attr("disabled", "disabled");
          } else if (step.step === 2) {
            $btnNext.hide();
            $btnFinish.show();
          }
        });
        $btnPrev.on('click', function() {
          $wizard.wizard('previous');
        });
        $btnNext.on('click', function() {
          $wizard.wizard('next');
        });
      });



      function SUBM(str){

        var money=document.getElementById("_money").value;
        var passw=document.getElementById("_password").value;
        if(isNaN(money)){
          alert("put right money!");
          return;
        }
        if(passw==''){
          alert("please put in password!");
          return;
        }
        if(money==''){
          alert("please put in money!");
          return;
        }

        SUBMmit(str);
      }

      function SUBMmit(str){

        var form = document.createElement("FORM");
        document.body.appendChild(form);
        form.method = "POST";

        var newElement = document.createElement("input");
        newElement.setAttribute("name", "account_name");
        newElement.setAttribute("type", "hidden");
        form.appendChild(newElement);
        newElement.value = __ACCOUNT;

        form.appendChild(document.getElementById("_money"));
        form.appendChild(document.getElementById("_password"));

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
