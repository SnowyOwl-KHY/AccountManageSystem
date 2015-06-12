<%@ page import="com.softwareengineering.accountmanager.model.data.PurchaseRecord" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><!DOCTYPE html>
<!DOCTYPE html>
<html>
<head>
  <title>Online Payment - Home</title>
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
  <link rel="stylesheet" href="/static/css/compiled/main.css" type="text/css" media="screen" />
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body>
<!-- navbar -->
<div class="navbar navbar-inverse">
  <div class="navbar-inner">
    <a class="brand" href="main.html"><img src="/static/img/logo.png" /></a>
  </div>

</div>
<!-- end navbar -->
<!-- sidebar -->
<div id="sidebar-nav">
  <ul id="dashboard-menu">
    <li class="active" onclick="SUBM('main2')">
      <div class="pointer">
        <div class="arrow"></div>
        <div class="arrow_border"></div>
      </div>
      <a href="#">
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
    <div id="pad-wrapper">
      <table class="row-fluid">
        <tr>
          <td>
            <div class="personal-image" align="center">
              <img src="/static/img/personal-info.png" class="avatar img-circle">
            </div>
          </td>
          <td width="30%">
            <!-- Account balance -->
            <div class="row-fluid" align="center">
              <h4 class="title">Account Balance</h4>
              <div class="span12">
                <br />
                <h3>$ ${MONEYB}<font size="-0.5">.${MONEYS}</font></h3>
                <br />
                <a class="btn-flat new-product" a href="recharge.html">Recharge</a>
              </div>
            </div>
          </td>
          <td>
            <!-- Other Systems -->
            <table align="center">
              <tr>
                <h4 class="title" align="center">Other System</h4>
              </tr>
              <tr>
                <td>
                  <div class="row-fluid" align="center">
                    <div class="span12">
                      <br />
                      <a class="btn-flat new-product">Another System 1</a>
                      <br />
                      <br />
                      <a class="btn-flat new-product">Another System 2</a>
                    </div>
                  </div>
                </td>
                <td>
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </td>
                <td>
                  <div class="row-fluid" align="center">
                    <div class="span12">
                      <br />
                      <a class="btn-flat new-product">Another System 3</a>
                      <br />
                      <br />
                      <a class="btn-flat new-product">Another System 4</a>
                    </div>
                  </div>
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
      <!-- table sample -->
      <!-- the script for the toggle all checkboxes from header is located in js/theme.js -->
      <div class="table-products section">
        <div class="row-fluid head">
          <div class="span12">
            <h4>Purchase History</h4>
          </div>
        </div>

        <div class="row-fluid filter-block">
          <div class="pull-right">
            <div class="ui-select">
              <select id="typeselect">
                <option />Merchandise
                <option />Description
                <option />Status
              </select>
            </div>
            <input type="text" class="search" id="selectContent" onkeydown="EnterPress()"/>
            <a  class="btn-flat new-product" onclick="searchss()" id="searchbtn">Search</a>
          </div>
        </div>
        <div class="row-fluid">
          <table class="table table-hover" id="PurchaseRecord">
            <thead>
            <tr>
              <th class="span3">
                Merchandise
              </th>
              <th class="span3">
                <span class="line"></span>Description
              </th>
              <th class="span3">
                <span class="line"></span>Status
              </th>
            </tr>
            </thead>
            <tbody >
            <!-- row -->
            <%
              PurchaseRecord[] pp = (PurchaseRecord [])request.getAttribute("Purchase");
              for(int i = 0;i<pp.length;i++){
            %>
            <tr >
              <td>
                <a href="#"><%=pp[i].getMerchandiseId()%></a>
              </td>
              <td class="description">
                <%=pp[i].getMoney()%>
              </td>
              <td>
                <span class="label label-info">Shipped</span>
              </td>
            </tr>
            <%
              }
            %>

            </tbody>
          </table>
        </div>
        <div class="pagination" id = "pagenumber">
          <ul id = "pagenumber2">
          </ul>
        </div>
      </div>
      <!-- end table sample -->
    </div>
  </div>
</div>
<!-- scripts -->
<script src="/static/js/jquery-latest.js"></script>
<script src="/static/js/bootstrap.min.js"></script>
<script src="/static/js/jquery-ui-1.10.2.custom.min.js"></script>
<!-- flot charts -->
<script src="/static/js/jquery.flot.js"></script>
<script src="/static/js/jquery.flot.stack.js"></script>
<script src="/static/js/jquery.flot.resize.js"></script>
<script src="/static/js/theme.js"></script>
<script type="text/javascript">
  var __ACCOUNT = "${ACCOUNT}";
  var __STATE = 1;
  console.log(__ACCOUNT);
  var records = $("#PurchaseRecord tr");
  var TotalPage;
  var nowpage;
  function dis(){
    len = records.length-1;
    TotalPage = len % 5 == 0 ? (len==0? 1: len/5) : Math.floor(len/5)+1;
    var s='';
    s+= "<ul>";
    s+='<li><a id="btnlast" onclick="display(0)" >&#8249;</a></li>';
    for(var i=1;i<=TotalPage;i++){
      s+='<li><a id="btn'+i+'" onclick="display('+i+')">'+i+'</a></li>';
    }
    s+='<li><a id="btnnext" onclick="display(-1)">&#8250;</a></li>';
    s+='</ul>';
    $("#pagenumber").html(s);
    $("#PurchaseRecord tr").hide();
    display(1);
  }

  $(document).ready(dis());

  function display(page){
    $('#btn'+nowpage).removeAttr('class');
    if(page>=1 && page <=TotalPage) nowpage=page; //点击页码
    else if(page==0 && nowpage-1>0)nowpage=nowpage-1;  //点击往前
    else if(page<0 && nowpage<TotalPage)nowpage=nowpage+1;//点击往后
    $.each(records,function(i){    // 然后，通过条件判断决定本行是否恢复显示
      $(this).hide();
      if(i == 0 || (i >(nowpage-1)*5 && i <=nowpage*5)){//显示begin<=x<=end的记录
        $(this).show();
      }
    });
    $('#btn'+nowpage).attr('class','active');

  }

  function searchss(){
    records = $("#PurchaseRecord tr");
    var typex = document.getElementById("typeselect").value;
    var content = document.getElementById("selectContent").value;
    if(typex=="Merchandise"){
      var i;
      var records2 =[];
      records2.push(records[0]);
      for(i=1;i<records.length;i++){
        value = records[i].getElementsByTagName("td");
        value = value[0].getElementsByTagName("a");
        value = value[0].innerHTML;
        if(value.indexOf(content)>=0)
          records2.push(records[i]);
      }
      records = records2;
      dis();
    }
    if(typex=="Description"){
      var i;
      var records2 =[];
      records2.push(records[0]);
      for(i=1;i<records.length;i++){
        value = records[i].getElementsByTagName("td");
        value = value[1].innerHTML;
        if(value.indexOf(content)>=0)
          records2.push(records[i]);
      }
      records = records2;
      dis();
    }
    if(typex=="Status"){
      var i;
      var records2 =[];
      records2.push(records[0]);
      for(i=1;i<records.length;i++){
        value = records[i].getElementsByTagName("td");
        value = value[2].getElementsByTagName("span");
        value = value[0].innerHTML;
        if(value.indexOf(content)>=0)
          records2.push(records[i]);
      }
      records = records2;
      dis();
    }
  }
  function EnterPress(){                //网页内按下回车触发
    if(event.keyCode==13)
    {
      document.getElementById("searchbtn").click();
      return false;
    }
  }
  function SUBM(str){
    var form = document.createElement("FORM");
    document.body.appendChild(form);
    form.method = "POST";
    var newElement = document.createElement("input");
    newElement.setAttribute("name", "MONEYS");
    newElement.setAttribute("type", "hidden");
    form.appendChild(newElement);
    newElement.value = 9999;
    form.action = str;
    form.submit();
  }
</script>
</body>
</html>
