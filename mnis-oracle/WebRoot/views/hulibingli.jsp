<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

  <!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>护理录入</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="SHORTCUT ICON" href="images/favicon.ico">
	<link rel="icon" href="images/favicon.ico" type="image/x-icon">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="author" content="沈旭峰"/>
    <meta name="keywords" content="移动护理信息系统"/>
    <meta name="description" content="护理病历,高大上的移动护理系统。"/>
   	<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <!-- <link href="css/style.css" rel="stylesheet" type="text/css"/> -->
    <link href="css/base.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="css/song.css" />
    <script type="text/javascript" src="scripts/jquery-1.12.1.min.js"></script>
    <script type="text/javascript" src="scripts/viewjs.js"></script>
	<script src="scripts/song.js" type="text/javascript"></script>
   <!--  <script src="scripts/common.js" type="text/javascript"></script> -->
</head>
<body>
<%@ include file="header-bingren.jsp"%>
</div>
<div class="container" style="margin-top: 1%;">
    <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
        <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="headingOne">
                <h4 class="panel-title">
                    <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion"
                       href="#collapseOne" aria-expanded="false"
                       aria-controls="collapseOne"
                       style="width: 100%;display: inline-block;">
                        护理评估
                    </a>
                </h4>
            </div>
            <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel"
                 aria-labelledby="headingOne">
                <div class="panel-body" style="padding: 5px;">
                    <div class="row">
                        <div class="col-xs-2">
                            <img src="images/friend.png" style="width: 100%;">
                        </div>
                        <div class="col-xs-10" style="margin: 1% 0;">
                            <a href="views/ruyuanhuli_pinggu_yibanziliao.jsp">
                                入院护理一般资料
                            </a>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-2">
                            <img src="images/friend.png" style="width: 100%;">
                        </div>
                        <div class="col-xs-10" style="margin: 1% 0;">
                            <a href="hulipinggupinggu?bbfl=1">
                                入院护理评估
                            </a>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-2">
                            <img src="images/friend.png" style="width: 100%;">
                        </div>
                        <div class="col-xs-10" style="margin: 1% 0;">
                            <a role="button" href="hzwxpg">
                                患者危险因素评估
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="headingTwo">
                <h4 class="panel-title">
                    <a class="collapsed" role="button" data-toggle="collapse"
                       data-parent="#accordion" href="#collapseTwo" aria-expanded="false"
                       aria-controls="collapseTwo"
                       style="width: 100%;display: inline-block;">
                        护理预防
                    </a>
                </h4>
            </div>
            
            <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel"
                 aria-labelledby="headingTwo">
                <div class="panel-body" style="padding: 5px;">
                    <div class="row">
                        <div class="col-xs-2">
                            <img src="images/friend.png" style="width: 100%;">
                        </div>
                        <div class="col-xs-10" style="margin: 1% 0;">
                            <a href="yachuangpinggu?bbfl=2">
                                压疮评估及预防
                            </a>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-2">
                            <img src="images/friend.png" style="width: 100%;">
                        </div>
                        <div class="col-xs-10" style="margin: 1% 0;">
                            <a role="button" data-toggle="modal"
                               data-target="#testmodal">
                                管路滑脱防范
                            </a>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-2">
                            <img src="images/friend.png" style="width: 100%;">
                        </div>
                        <div class="col-xs-10" style="margin: 1% 0;">
                            <a role="button" data-toggle="modal"
                               data-target="#testmodal">
                                管路置管／拔管
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
       <!--  <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="headingThree">
                <h4 class="panel-title">
                    <a class="collapsed" role="button" data-toggle="collapse"
                       data-parent="#accordion" href="#collapseThree" aria-expanded="false"
                       aria-controls="collapseThree"
                       style="width: 100%;display: inline-block;">
                        护理病历内容分类三
                    </a>
                </h4>
            </div>
            <div id="collapseThree" class="panel-collapse collapse" role="tabpanel"
                 aria-labelledby="headingThree">
                <div class="panel-body" style="padding: 5px;">
                    <div class="row">
                        <div class="col-xs-2">
                            <img src="images/friend.png" style="width: 100%;">
                        </div>
                        <div class="col-xs-10" style="margin: 1% 0;">
                            <a role="button" data-toggle="modal"
                               data-target="#testmodal">
                                询问病史及体格检查
                            </a>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-2">
                            <img src="images/friend.png" style="width: 100%;">
                        </div>
                        <div class="col-xs-10" style="margin: 1% 0;">
                            <a role="button" data-toggle="modal"
                               data-target="#testmodal">
                                完成病历书写
                            </a>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-2">
                            <img src="images/friend.png" style="width: 100%;">
                        </div>
                        <div class="col-xs-10" style="margin: 1% 0;">
                            <a role="button" data-toggle="modal"
                               data-target="#testmodal">
                                开检查单
                            </a>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-2">
                            <img src="images/friend.png" style="width: 100%;">
                        </div>
                        <div class="col-xs-10" style="margin: 1% 0;">
                            <a role="button" data-toggle="modal"
                               data-target="#testmodal">
                                上级医师查房
                            </a>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-2">
                            <img src="images/friend.png" style="width: 100%;">
                        </div>
                        <div class="col-xs-10" style="margin: 1% 0;">
                            <a role="button" data-toggle="modal"
                               data-target="#testmodal">
                                完成术前准备与术前评估
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>-->
    </div>
</div>

<!--导航结束-->
   <div class="clear"></div>
		<%@ include file="menu-hushi.jsp" %>
	</div>
	<%@ include file="footer.jsp"%>
<script type="text/javascript" src="scripts/bootstrap.min.js"></script>
</body>
</html>
