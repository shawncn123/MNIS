<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<head>
	<base href="<%=basePath%>">
	<meta charset="UTF-8">
		<title>检验报告</title>
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="author" content="融汇国康" />
		<meta name="keywords" content="移动护理信息系统" />
		<meta name="description" content="检验报告,移动护理系统。" />
		<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
		<link href="css/base.css" rel="stylesheet" type="text/css" />
		<link rel="SHORTCUT ICON" href="images/favicon.ico">
		<link rel="icon" href="images/favicon.ico" type="image/x-icon">
		<link rel="stylesheet" type="text/css" href="css/song.css" />
		<link href="css/custom1.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="css/mobiscroll.css" />
		<link rel="stylesheet" href="css/mobiscroll_002.css" />
		<link rel="stylesheet" href="css/mobiscroll_003.css" />
		<script type="text/javascript" src="scripts/jquery-1.12.1.min.js"></script>
		<script src="scripts/mobiscroll_002.js"></script>
		<script src="scripts/mobiscroll_003.js"></script>
		<script src="scripts/mobiscroll_004.js"></script>
		<script src="scripts/mobiscroll_005.js"></script>
		<script src="scripts/mobiscroll.js"></script>
		<script src="scripts/timerpicker.js" type="text/javascript" ></script>
		<script type="text/javascript" src="scripts/viewjs.js"></script>
		<script type="text/javascript" src="scripts/song.js"></script>

		<script type="text/javascript">
			$(function() {
				// 绑定
				$("#head_banner_1").smartFloat();
			});
			function wjzflselcet() {
				document.getElementById("wjzsz").submit();
			}
			
			function changeDate() {
				/* alert($("#appDate1").val());
				var vcxrq = "2016-03-11"; */
				var vcxrq = $("#appDate").val();
				var vwjbz = $("#wjbzselect").val();
				var url = "getHuaYanByRiQi";
				var args = {"vsqrq" : vcxrq,"vwjbz":vwjbz/* ,"time" : new Date() */};
				$.post(url,args,function(data) {
					a = '';
					d = eval("("+ data+ ")");
					if(d!=null && d!="" ){
						
					for (var i = 0; i < d.length; i++) {
						a = a + '<div class="panel panel-default"><div class="panel-heading" role="tab" id="headingOne">'
						      +'<h4 class="panel-title">';
						if(d[i].wjflag!="1"){
							a = a + '<a role="button" data-toggle="collapse" href="#collapse_' + i + '" aria-expanded="false" '
							      + 'aria-controls="collapse_' + i 
							      + '" style="width: 100%;display: inline-block;color: yellowgreen;text-decoration: none;">>&nbsp;'
							      + d[i].bbmc + '&nbsp;&nbsp;&nbsp;';
							      
							var obj =  d[i].sqsj;
							var teo = new Date(obj.time);
							var vmonth = teo.getMonth()+1;
							if(vmonth<10){
								vmonth = "0"+vmonth;
							}
							var vsqsj = teo.getFullYear() + "-" + vmonth + "-" + teo.getDate();
						
							a = a + vsqsj + ' </a>';
						}else{
							a = a + '<a role="button" data-toggle="collapse" href="#collapse_' + i 
							      + '"  aria-expanded="false" aria-controls="collapse_' + i 
							      + '" style="width: 100%;display: inline-block;color: red;text-decoration: none;">>&nbsp;'
							      + d[i].bbmc + '&nbsp;&nbsp;&nbsp;';
							var obj =  d[i].sqsj;
							var teo = new Date(obj.time);
							var vmonth = teo.getMonth()+1;
							if(vmonth<10){
								vmonth = "0"+vmonth;
							}
							var vsqsj = teo.getFullYear() + "-" + vmonth + "-" + teo.getDate();
						
							a = a + vsqsj + ' </a>';
						}
			            a = a + '</h4></div>';
			            
			            if(d[i].vwHy1011s!="" && d[i].vwHy1011s!=null){
			            	a = a + ' <div id="collapse_' + i 
			            	      + '" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="heading_'
			            	      + i + '"><div class="panel-body" style="padding: 5px;">';
			            	var zbhys = d[i].vwHy1011s; 
			            	for (var j = 0; j < zbhys.length; j++) {
			            		a = a + '<div class="row" style="padding-top: 2%;padding-bottom: 2%;"><div class="col-xs-12">'
			            		      + '<p class="p-bg"><a href="javascript:void(0);" style="text-decoration: none;color: #080808;">'
			            		      + zbhys[j].yzmc + '</a></p></div></div>';
			            		if(zbhys[j].yszt!="" && zbhys[j].yszt!=null){
			            			a = a + '<div class="row" style="padding-top: 2%;padding-bottom: 2%;"><div class="col-xs-12">'
			            			      + '<p class="p-bg"><a href="javascript:void(0);" style="text-decoration: none;color: #080808;">'
			            			      + zbhys[j].yszt + '</a></p></div></div>';
			            		}
			            	}
			            	a = a + "</div></div>";
			            }
			            a = a + "</div>"
					}
					
					}else{
						a = "无数据！"; 
					}
					$("#huayancontainer")[0].innerHTML = a;
				});
			};
		</script>
</head>
	<body>
		<%@ include file="header-bingren.jsp"%>
			<div class="row marg-l" style="margin:0 -4px;">
				<div class="col-xs-5" style="margin-bottom: -10px; margin-top: 2px;">
					<div class="row">
						<div class="col-xs-10" style="padding-left: 5px;">
						<form action="chahuayandata" method="post" id="wjzsz">
							<div class="form-group">
								<select name="vwjbz" id="wjbzselect" class="form-control" onchange="wjzflselcet()">
									<s:if test='vwjbz=="2"||vwjbz==null'>
									<option value="2" selected>全部检验</option>
									<option value="1">危急值</option>
									</s:if><s:else>
									<option value="2" >全部检验</option>
									<option value="1" selected>危急值</option>
									</s:else>
								</select>
							</div>
						</form>
						</div>
					</div>
				</div>
				<div class="col-xs-2">
				</div>
				<div class="col-xs-5" style="padding: 0; margin: 0;">
					<div class="demos">
						<input value="" placeholder="" class="form-control" readonly="readonly" name="appDateTime" id="appDate" type="text"  onchange="changeDate()">
					</div>
				</div>
			</div>
		</div>

		<div class="container" id="content" style="position: relative;">
			<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true" style="margin-top: 2%;">
				<div id="huayancontainer">
				<s:iterator value="#request.bingrgeti_huayan" status="status">
       			 <div class="panel panel-default">
		            <div class="panel-heading" role="tab" id="headingOne">
		                <h4 class="panel-title">
		                	<s:if test='wjflag!="1"'>
		                    <a role="button" data-toggle="collapse" href='#collapse_<s:property value="#status.index"/>' 
		                        aria-expanded="false" aria-controls='collapse_<s:property value="#status.index"/>'
		                        style="width: 100%;display: inline-block;color: yellowgreen;text-decoration: none;">
		                        >&nbsp;${bbmc }&nbsp;&nbsp;&nbsp;<s:date name="sqsj" format="yyyy-MM-dd"/>
		                    </a>
		                    </s:if>
		                    <s:else>
		                    	<a role="button" data-toggle="collapse" href='#collapse_<s:property value="#status.index"/>' 
		                        aria-expanded="false" aria-controls='collapse_<s:property value="#status.index"/>'
		                        style="width: 100%;display: inline-block;color: red;text-decoration: none;">
		                        >&nbsp;${bbmc }&nbsp;&nbsp;&nbsp;<s:date name="sqsj" format="yyyy-MM-dd"/>
		                    </a>
		                    </s:else>
		                </h4>
		            </div>
		            <s:if test="vwHy1011s!=null">
		            <div id="collapse_<s:property value="#status.index"/>" class="panel-collapse collapse in" role="tabpanel"
		                 aria-labelledby="heading_<s:property value="#status.index"/>">
		                <div class="panel-body" style="padding: 5px;">
		                	<s:iterator value="vwHy1011s">
		                    <div class="row" style="padding-top: 2%;padding-bottom: 2%;">
		                        <div class="col-xs-12">
		                            <p class="p-bg"><a href="javascript:void(0);" style="text-decoration: none;color: #080808;">${yzmc }</a></p>
		                        </div>
		                    </div>
		                    <s:if test="yszt!=null">
		                    <div class="row" style="padding-top: 2%;padding-bottom: 2%;">
		                        <div class="col-xs-12">
		                            <p class="p-bg"><a href="javascript:void(0);" style="text-decoration: none;color: #080808;">${yszt}</a></p>
		                        </div>
		                    </div>
		                    </s:if>
		                    </s:iterator>
		                </div>
		            </div>
		            </s:if>
		        </div>
		        </s:iterator>
		        </div>
				<%@ include file="menu-hushi.jsp" %>
			</div>
		</div>
		<!--导航结束-->
		<div class="clear"></div>
		<!--页脚开始-->
		<%@ include file="footer.jsp" %>
		<!--页脚结束-->
		<script type="text/javascript" src="scripts/bootstrap.min.js"></script>
	</body>
</html>