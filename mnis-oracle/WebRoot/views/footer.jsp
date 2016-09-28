<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<div id="footer">
		<div style="height:30px"></div>
		<!-- 模态框（Modal）start -->
		<input type="text" id="smName" placeholder="扫腕带测试" onfocus="javascript:this.value='';"
						oninput="allsaowandai_Function()" style="width: 1px;height: 1px;border: none;"/>
		<div class="modal fade" id="moduleallswd" tabindex="-1" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" id="modalWrap"  style="width: 94%;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">病人信息</h4>
					</div>
					<div class="modal-body" id="modal_prxx">
						<p>
							姓名：<strong style="font-size: 20px;"></strong>
						</p>
						<p>
							床位号：<strong style="font-size: 20px;"></strong>
						</p>
						<p>
							性别：<strong style="font-size: 20px;"></strong>
						</p>
						<p>
							年龄：<strong style="font-size: 20px;"></strong>
						</p>
					</div>
					<div class="modal-footer" id="motal_f">
						<button type="button" class="btn pull-left btn-primary">
							确定</button>
						<button type="button" id="quxiao" class="btn btn-default"
							data-dismiss="modal">取消</button>
					</div>
				</div>
			</div>
		</div>
	<!-- 模态框（Modal）end -->
	</div>
	<script type="text/javascript">
	function allsaowandai_Function() {
		var val = $("#smName").val();/* var val_text = $(this).text(); */
		var url = "chabingren_byWanDai";
		var args = {
			"wandaixx" : val/* ,"time" : new Date() */};
			$.post(url,args,function(data) {
				if (data != "") {
					d = eval("(" + data + ")");
					var a = "<p>姓名：<strong style='font-size: 20px;'>" + d.br_name
					+ "</strong></p>"
					+ "<p>床位号：<strong style='font-size: 20px;'>"
					+ d.br_chw + "</strong></p>"
					+ "<p>性别：<strong style='font-size: 20px;'>" + d.br_xb + "</strong></p>"
					+ "<p>年龄：<strong style='font-size: 20px;'>" + d.br_age + "</strong></p>"
					$("#modal_prxx")[0].innerHTML = a;
					$("#motal_f")[0].innerHTML = "<a href='bingreng_yewumokuai?v_key1=" + d.br_key1 + "&v_key2="
					+ d.br_key2 + "' class='btn pull-left btn-primary'>确定</a>"
					+ "<button type='button' id='quxiao' class='btn btn-default' data-dismiss='modal'>取消</button>"
					$('#moduleallswd').modal('show');
				} else {
					$("#modal_prxx")[0].innerHTML = "<p>没有相关病人信息</p>";
					$("#motal_f")[0].innerHTML = "<button type='button' id='quxiao' class='btn btn-default' data-dismiss='modal'>确定</button>";
					$('#moduleallswd').modal('show');
				}
			});
	}
	</script>