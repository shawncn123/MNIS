<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
		<meta charset="utf-8">
		<title></title>
		<script src="scripts/jquery-1.12.1.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">	
			$(function(){
				$('body').css('background','#DDD');
				var url = "pcbaibanmoban";
				$.post(url,function(data) {
					var a = '';
					var d = eval("("+ data+ ")");
					$('body').css('background','#DDD');	
					for (var i = 0; i < d.length; i++) {
/* 					    $('<label id="title' + i + '">' + d[i].xmmc + '</label><input id="cont' + i + '" type="text">').appendTo($("#box"+i+"")); */
 						
 						var vtitle =  "title" + i;
 						
 						var dsTitle = 'inline-block';
 						if(d[i].titleVisible=="0"){
 							dsTitle = 'none';
 						}
 						
 						var titletext = d[i].xmmc;
 						if(d[i].titleText!=""){
 							titletext = d[i].titleText;
 						}
 						
 						var title_alignment = 'left';
 						if(d[i].titleAlignment=="1"){
 							title_alignment = 'right';
 						}
 						if(d[i].titleAlignment=="2"){
 							title_alignment = 'center';
 						}
 						
 						var title_border = 'none';
 						if(d[i].titleBorder=="1"){      //1, 定义的是shadow   转换显示为groove 定义 3D 凹槽边框
 							title_border = 'groove  1px';
 						}
 						if(d[i].titleBorder=="2"){		//2, 定义的是box   转换显示为solid   定义实线
 							title_border = 'solid 1px';
 						}
 						if(d[i].titleBorder=="3"){     //3 ,定义的Resize  暂无对应
 							title_border = 'none';
 						}
 						if(d[i].titleBorder=="4"){     //4 ,定义的Underline  转换显示为下边框solid
 							title_border = 'solid 1px';
 						}
 						if(d[i].titleBorder=="5"){     //5 ,定义的3D Lowered  转换显示为inset
 							title_border = 'inset  1px';
 						}
 						if(d[i].titleBorder=="6"){     //6 ,定义的, 6 - 3D Raised  转换显示为outset
 							title_border = 'outset 1px';
 						}
 						
 						var title_color = '#000';
 						if(d[i].titleColor != 0){
 							title_color = d[i].titleColor;
 						}
 						
 						var title_font_face = d[i].titleFontFace;      //项目
 						var title_font_height = d[i].titleFontHeight + "px";
 						var title_font_bold = 'normal';
 						if(d[i].titleFontBold == "1"){
 							title_font_bold = 'bold';
 						}
 						var title_font_italic = 'normal';
 						if(d[i].titleFontItalic == "1"){
 							title_font_italic = 'italic';
 						}
 						
 						var title_font_underline = "none";
 						if(d[i].titleFontUnderline == "1" && d[i].titleFontStrikethrough == "1"){
 							title_font_underline='underline line-through'; /*是否下划线 中划线*/
 						}
 						if(d[i].titleFontUnderline == "1" && d[i].titleFontStrikethrough == "0"){
 							title_font_underline='underline'; /*是否下划线 中划线*/
 						}
 						if(d[i].titleFontUnderline == "0" && d[i].titleFontStrikethrough == "1"){
 							title_font_underline='line-through'; /*是否下划线 中划线*/
 						}
 						
 						var title_width = d[i].titleWidth + "px";
 						var title_height = d[i].titleHeight + "px";
 						
 						var title_position = 'absolute';     //7.6添加
 						var title_x = d[i].titleX + "px";
 						var title_y = d[i].titleY + "px";
 						
 						if(d[i].titleBorder!="4"){
 							vtitle = {
 								display:dsTitle,
 								"text-align":title_alignment,
 								border:title_border,
 								color:title_color,
 								"font-family":title_font_face,
 								"font-size":title_font_height ,
 								"font-weight":title_font_bold,
 								"font-style":title_font_italic,
 								"text-decoration":title_font_underline,
 								width:title_width,
 								height:title_height,
 								position:title_position,
 								top:title_y, 
 								left:title_x
 								};
 						};
 						if(d[i].titleBorder=="4"){
 							vtitle = {
 								display:dsTitle,
 								"text-align":title_alignment,
 								"border-bottom":title_border,
 								color:title_color,
 								"font-family":title_font_face,
 								"font-size":title_font_height ,
 								"font-weight":title_font_bold,
 								"font-style":title_font_italic,
 								"text-decoration":title_font_underline,
 								width:title_width,
 								height:title_height,
 								position:title_position,
 								top:title_y, 
 								left:title_x
 								};
 						};
 						
 						var nr_alignment = "left";
 						if(d[i].nrAlignment=="1"){
 							nr_alignment="right";
 						}
 						if(d[i].nrAlignment=="2"){
 							nr_alignment="center";
 						}
 						
 						var nr_border = "none";
 					
 						if(d[i].nrBorder=="1"){      //1, 定义的是shadow   转换显示为groove 定义 3D 凹槽边框
 							nr_border = 'groove 1px';
 						}
 						if(d[i].nrBorder=="2"){		//2, 定义的是box   转换显示为solid   定义实线
 							nr_border = 'solid 1px';
 						}
 						if(d[i].nrBorder=="3"){     //3 ,定义的Resize  暂无对应
 							nr_border = 'none';
 						}
 						if(d[i].nrBorder=="4"){     //4 ,定义的Underline  转换显示为下边框solid
 							nr_border = 'solid 1px';
 						}
 						if(d[i].nrBorder=="5"){     //5 ,定义的3D Lowered  转换显示为inset
 							nr_border = 'inset 1px';
 						}
 						if(d[i].nrBorder=="6"){     //6 ,定义的, 6 - 3D Raised  转换显示为outset
 							nr_border = 'outset 1px';
 						}
 						
 						var nr_color = '#000';
 						if(d[i].nrColor != 0){
 							nr_color = d[i].nrColor;
 						}
 						
 						var nr_font_face = d[i].nrFontFace; 
 						var nr_font_height = d[i].nrFontHeight;
 						var nr_font_bold = "normal";
 						if(d[i].nrFontBold == "1"){
 							nr_font_bold = 'bold';
 						}
 						
 						var nr_font_italic = 'normal';
 						if(d[i].nrFontItalic == "1"){
 							nr_font_italic = 'italic';
 						}
 						
 						var nr_font_underline = "none";
 						if(d[i].nrFontUnderline == "1" && d[i].nrFontStrikethrough == "1"){
 							nr_font_underline='underline line-through'; /*是否下划线*/
 						}
 						if(d[i].nrFontStrikethrough == "1" && d[i].nrFontStrikethrough == "0"){
 							nr_font_underline='underline'; /*是否中划线*/
 						}
 						if(d[i].nrFontStrikethrough == "0" && d[i].nrFontStrikethrough == "1"){
 							nr_font_underline='line-through'; /*是否中划线*/
 						}
 						
 						var nr_width = d[i].nrWidth + "px";
 						var nr_height = d[i].nrHeight + "px";
 						
 						var nr_position = 'absolute';     //7.6添加
 						var nr_x = d[i].nrX + "px";
 						var nr_y = d[i].nrY + "px";
 						
 						var nr_resize = 'none';   
 						
 						if(d[i].nrBorder!="4"){
 							vcontentcss = {
 								"font-family":nr_font_face,
 								"font-size":nr_font_height,
 								"font-weight":nr_font_bold,					
 								"text-align":nr_alignment,
 								color:nr_color,
 								border:nr_border,
 								width:nr_width,
 								height:nr_height,
 								position:nr_position,    //7.6添加
 								top:nr_y,
 								left:nr_x,
 								resize:nr_resize
 							};
 						};
 						if(d[i].nrBorder=="4"){
 							vcontentcss = {
 								"font-family":nr_font_face,
 								"font-size":nr_font_height,
 								"font-weight":nr_font_bold,					
 								"text-align":nr_alignment,
 								color:nr_color,
 								"border-bottom":nr_border,
 								width:nr_width,
 								height:nr_height,
 								position:nr_position,    //7.6添加
 								top:nr_y,
 								left:nr_x,
 								resize:nr_resize
 							};
 						};
 						
 						
 						$('<label id="title' + i + '">' + titletext + '</label><textarea id="cont' + i + '"></textarea>').appendTo($("body"));
 						$('#title' + i).css(vtitle);
 						$('#cont' + i).css(vcontentcss);
					}
				})
			});
					
			function date_2() { 
				var url = "pcbaibanneirong";
				$.post(url,function(data) {
					var ct = eval("("+ data+ ")");
					console.trace(ct);
					for (var j = 0; j < ct.length; j++) {
						
					    $('#cont' + j).val(ct[j]);
					}
				}) }
			
			$(function(){
				setInterval('date_2();', 10000);
				/* date_2(); */
			});	 
			
			/* $(function(){			
				var title_font_face = '宋体';      //项目
				var title_font_height = '14px';
				var title_font_bold = 'bold';
				var title_alignment = 'center';
				var title_color = '#000';
				var title_border = 'none';
				var title_width = '100px';
				var title_height = '30px';
				var dsTitle = 'inline-block';
				
				var nr_font_face = '宋体';      //内容
				var nr_font_height = '14px';
				var nr_font_bold = 'normal';
				var nr_alignment = 'left';
				var nr_color = '#000';
				var nr_border = '1px solid #000';
				var nr_width = '200px';
				var nr_height = '30px';
				
				var title0 = {       //项目样式
					display:dsTitle,
					"font-family":title_font_face,
					"font-size":title_font_height,
					"font-weight":title_font_bold,					
					"text-align":title_alignment,					
					color:title_color,
					border:title_border,
					width:title_width,
					height:title_height
				};	
				var title1 = {       
					display:dsTitle,
					"font-family":title_font_face,
					"font-size":title_font_height,
					"font-weight":title_font_bold,					
					"text-align":title_alignment,					
					color:title_color,
					border:title_border,
					width:title_width,
					height:title_height
				};
				
				var cont0 = {			//内容样式	 	
					"font-family":nr_font_face,
					"font-size":nr_font_height,
					"font-weight":nr_font_bold,					
					"text-align":nr_alignment,
					color:nr_color,
					border:nr_border,
					width:nr_width,
					height:nr_height
				};	
				var cont1 = {			
					"font-family":nr_font_face,
					"font-size":nr_font_height,
					"font-weight":nr_font_bold,					
					"text-align":nr_alignment,
					color:nr_color,
					border:nr_border,
					width:nr_width,
					height:nr_height
				};
				
				var titleArry = [title0, title1];   
				var contArry = [cont0, cont1];
				
				$('body').css('background','#DDD');				
				for (var i=0; i<10; i++) {	
					$('<div id="box'+i+'"></div>').appendTo($("body"));	
				    $('<label id="title' + i + '">输液</label><input id="cont' + i + '" type="text">').appendTo($("#box"+i+""));
				    if (i<=(titleArry.length-1)) {
				        $('#title' + i + '').css(titleArry[i]);
				    }
					if (i<=(contArry.length-1)) {
				        $('#cont' + i + '').css(contArry[i]);
				    }
				}				
			}); */
		</script>
	</head>
	<body>
	  <%--  <a href="pcbaibanmoban">test</a>
		<s:iterator value="#request.baibaimoban">
			${xmmc }&nbsp;${nrColor }<br/>
		</s:iterator> --%>
	</body>
</html>
