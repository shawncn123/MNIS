<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<div id="footer">
		<!-- <div class="plug-div">
			<div class="plug-phone">
				<div class="plug-menu themeStyle">
					<a style="top: 0px;left: 0px;background: url(images/back.png) no-repeat center center;
                    background-size: 24px auto;display: block;position: absolute;width: 50px;
                    height: 44px;text-indent: -9999px;margin: -5px;padding: 0;" href="javascript:history.go(-1)"></a>
				</div>
			</div>
		</div> -->
		<div class="copyright">
			这里是底部信息<br>声明：目前是测试版本,图标含义与业务功能模块可能不匹配。
		</div>
	 <!--扫腕带弹出框   start-->
		<input type="hidden"  value="" id="smName" data-toggle="modal" data-target="#module"> 	
		<div class="modal fade" id="module" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" id="modalWrap" style="width: 94%;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">病人信息</h4>
					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-xs-6">
								<span>2046床</span>
							</div>
							<div class="col-xs-6">
								<span>李家禄</span>
							</div>
							<!-- <div class="col-xs-3">
								<span>chuangwei</span>
							</div>
							<div class="col-xs-3">
								<span>男</span>
							</div> -->
						</div>
					<!-- <div class="row">
						<div class="col-xs-3">
							<span>年龄:</span>
						</div>
						<div class="col-xs-9">
							<span>84岁</span>
						</div>
					</div> -->
						<div class="row">
							<div class="col-xs-4">
								<span>病案号:</span>
							</div>
							<div class="col-xs-8">
								<span>1535400</span>
							</div>
							<!-- <div class="col-xs-4">
								<span>第一次住院</span>
							</div> -->
						</div>
						<!-- <div class="row">
							<div class="col-xs-3">
								<span>婚姻:</span>
							</div>
							<div class="col-xs-3">
								<span>已婚</span>
							</div>
							<div class="col-xs-3">
								<span>国籍</span>
							</div>
							<div class="col-xs-3">
								<span>中国</span>
							</div>
						</div> -->
						<!-- <div class="row">
							<div class="col-xs-3">
								<span>民族:</span>
							</div>
							<div class="col-xs-9">
								<span>汉族</span>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-3">
								<span>身份证号:</span>
							</div>
							<div class="col-xs-9">
								<span>110101192501244510</span>
							</div>
						</div> -->
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default pull-left" data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary">确定</button>
					</div>
				</div>
			</div>
			<!--扫腕带弹出框  end-->
		</div>
	</div>