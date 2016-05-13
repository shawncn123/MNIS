<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">
    <title>病人体征录入</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="author" content="沈旭峰"/>
    <meta name="keywords" content="移动护理信息系统"/>
    <meta name="description" content="病人体征录入,高大上的移动护理系统。"/>
    <meta name="viewport"
          content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <link href="css/bootstrap-clockpicker.min.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="scripts/jquery-1.12.1.min.js"></script>
    <script type="text/javascript" src="scripts/bootstrap-clockpicker.min.js"></script>
    <script type="text/javascript" src="scripts/bootstrap.min.js"></script>
    <script type="text/javascript">
    $(function(){
    	  $('.clockpicker').clockpicker();
    }) 
    </script>
</head>
<body>
<div id="head_banner_1" style="z-index:1000;" class="bg-info">
    <div class="row" style="border-bottom: #666666 1px solid;">
        <div class="col-xs-3">
            <a class="btn btn-default" href="javascript:history.go(-1)" role="button">返回</a>
        </div>
        <div class="col-xs-6 text-center">
            <h1 style="margin-top: 6%;color: #867A7A">体征录入</h1>
        </div>
        <div class="col-xs-3">
            <a class="btn btn-default" href="#" role="button">保存</a>
        </div>
    </div>
    <div class="row">
        <div class="col-xs-6">
            <h2 style="color: #2260AD;margin: 5%">${bingrgetixingxi.xm }&nbsp;${bingrgetixingxi.chw}&nbsp;床</h2>
        </div>
        <div class="col-xs-6">
		<!--新加html start-->
		<div class="input-group clockpicker" data-placement="left" data-align="top" data-autoclose="true">
		    <input type="text" class="form-control" value="13:14">
		    <span class="input-group-addon">
		        <span class="glyphicon glyphicon-time"></span>
		    </span>
		</div>
        </div>
    </div>
    </div>
</div>
<div id="content" class="container">
    <form class="form-horizontal">
    	<s:iterator value="#request.bingr_tizheng_luruxiang">
        <div class="form-group">
            <label class="col-xs-3 control-label text-right" style="padding:2% 2% 0 2%;">${xmmc }</label>
            <div class="col-xs-9">
                <input type="text" class="form-control" placeholder="${xmmc }" id="${xmid }">
            </div>
        </div>
        </s:iterator>
    </form>

    <!--导航结束-->
    <div class="clear"></div>

</div>
<!--页脚开始-->
<div id="footer">
    <div class="plug-div">
        <div class="plug-phone">
            <div class="plug-menu themeStyle">
                <!--<a class="ui-btn-back" href="javascript:history.go(-1)"></a>-->
                <a style="top: 0px;left: 0px;background: url(ky_img/back.png) no-repeat center center;
                    background-size: 24px auto;display: block;position: absolute;width: 50px;
                    height: 44px;text-indent: -9999px;margin: -5px;padding: 0;"
                   href="javascript:history.go(-1)"></a>
                <!--<div class="themeStyle plug-btn plug-btn1 open">-->
                <!--<a href="/"><span style="background-image: url(ky_img/home.png);"></span></a>-->
                <!--</div>-->

            </div>
            <div style="bottom: 80px;left: 16px;width: 36px;height: 36px;border-radius: 36px;position: absolute;
            z-index: 999;background: #DE270B;">
                <a href="yewumokuai.html">
                    <span style="background-image: url(ky_img/home.png);
                display: block;width: 28px;height: 28px;background-size: 28px 28px;text-indent: -999px;
                position: absolute;top: 50%;left: 50%;margin-top: -14px;margin-left: -14px;overflow: hidden;"></span>
                </a>
            </div>
        </div>
    </div>
    <div class="copyright">
        这里是底部信息<br>声明：目前是测试版本,图标含义与业务功能模块可能不匹配。
    </div>
</div>
<!--页脚结束-->
</body>
</html>