<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Check EI</title>
<meta http-equiv="keywords" content="EI检索,EI号查询,免费">
<meta http-equiv="description" content="免费EI号检索">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- Loading Bootstrap -->
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">

<!-- Loading Flat UI -->
<link href="css/flat-ui.css" rel="stylesheet">
<link href="css/writeform.css" rel="stylesheet">

<link rel="shortcut icon" href="images/EVlogo.png">

<script src="js/jquery-1.8.3.min.js"></script>


<!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
<!--[if lt IE 9]>
  <script src="js/html5shiv.js"></script>
  <script src="js/respond.min.js"></script>
  <![endif]-->
</head>
<body onload="loadPage()">
	<div class="navbar navbar-inverse">
		<div class="container ">

			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#navbar-collapse-01">
					<span class="sr-only">Toggle navigation</span>
				</button>
				<a class="navbar-brand" href="#">EI Search</a>
			</div>
			<div class="collapse navbar-collapse" id="navbar-collapse-01">
				<ul class="nav navbar-nav">
					<li><a href="#" data-toggle="modal" data-target="#statement">免责声明</a>
					</li>
					<li><a href="mailto:congyuandong@gmail.com">问题反馈</a></li>
					<li><a href="http://me.alipay.com/congyuandong"
						target="_blank">捐赠作者</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="container">
		<h5>Quick Search</h5>
	</div>
	<div class="container tilesigle">
		<div class="row">
			<div class="col-md-2 ha">SEARCH FOR</div>
			<div class="col-md-6">
				<div class="form-group">
					<input type="text" value="" placeholder="Enter Title"
						class="form-control" id="searchWord1" data-container="body"
						data-toggle="popover" data-placement=bottom
						data-content="不要调戏我了,这里什么都没有" />
				</div>
			</div>
			<!-- div class="col-md-1 ha">
					in
				</div-->
			<div class="col-md-2">
				<select name="SRange1" value="All fields" class="select-block">
					<option value="TI" selected="selected">Title</option>
					<option value="ECC">暂不支持</option>
				</select>
			</div>
			<div class="col-md-2">
				<button class="btn btn-inverse btn-block" onclick="dwr_postei()"
					id="btn_search">Search</button>
				<!-- span onclick="dwr_postei()">
					<a href="#" class="btn btn-block btn-sm btn-inverse" role="button">Search</a>
					</span -->

			</div>

		</div>

	</div>

	<div class="container" id="no_progressbar">&nbsp;</div>

	<div class="container tiledetail" style="display: none;"
		id="detail_panel">

		<div class="container" id="progressbar" style="width: 98%">
			<div class="progress progress-striped active">
				<div class="progress-bar" role="progressbar" aria-valuenow="0"
					aria-valuemin="0" aria-valuemax="100" style="width: 0%">
					&nbsp;</div>
			</div>
		</div>

		<div id="detail_load"></div>

	</div>

	<!-- Modal 模态框 免责申明-->
	<div class="modal fade" id="statement" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">免责声明</h4>
				</div>
				<div class="modal-body">
					<p>
						EISearch提醒您：在使用EISearch(以下简称EIS)搜索前，请您务必仔细阅读并透彻理解本声明。您可以选择不使用EIS，但如果您使用EIS，您的使用行为将被视为对本声明全部内容的认可。
					</p>
					<ul>
						<li>
							您应该对使用搜索引擎的结果自行承担风险。EIS不做任何形式的保证：不保证搜索结果满足您的要求，不保证搜索服务不中断，不保证搜索结果的安全性、正确性、及时性、合法性。因网络状况、通讯线路、第三方网站等任何原因而导致您不能正常使用EIS，EIS不承担任何法律责任。
						</li>
						<li>
							鉴于EIS以非人工检索方式，除EIS注明之服务条款外，其他一切因使用EIS而可能遭致的意外、疏忽、侵权及其造成的损失（包括因下载被搜索链接到的第三方网站内容而感染电脑病毒），EIS对其概不负责，亦不承担任何法律责任。
						</li>
						<li>
							任何通过使用EIS而搜索链接到的第三方网页均系他人制作或提供，您可能从该第三方网页上获得资讯及享用服务，EIS对其合法性概不负责，亦不承担任何法律责任。
						</li>
						<li>EIS搜索结果根据您键入的关键字自动搜索获得并生成，不代表EIS赞成被搜索链接到的第三方网页上的内容或立场。</li>
						<li>
							任何单位或个人认为通过EIS搜索链接到的第三方网页内容可能涉嫌侵犯其信息网络传播权，应该及时向EIS提出书面权利通知，将会依法尽快断开相关链接内容。
						</li>
					</ul>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal">
						确定</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->

	<!-- Modal -->
	<div class="modal fade" id="modal_donate" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">感谢您的支持</h4>
				</div>
				<div class="modal-body">
					<p class="text-left">&nbsp;&nbsp;如果觉得我们的工具对你有帮助，请慷慨的送我们一杯咖啡吧~</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal">
						残忍拒绝</button>
					<button type="button" class="btn btn-primary"
						onclick="window.open('http://me.alipay.com/congyuandong')";
>
						立刻支持</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->

	<!-- /.container -->
	<!-- cnzz统计代码，上线时候解注 -->
	<!--div id="cnzz" style="display:none">
			<script type="text/javascript">var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");document.write(unescape("%3Cspan id='cnzz_stat_icon_5821035'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s23.cnzz.com/stat.php%3Fid%3D5821035%26show%3Dpic' type='text/javascript'%3E%3C/script%3E"));</script>
		</div-->

	<!-- Load JS here for greater good =============================-->
	<script src="js/jquery.cookie.js"></script>
	<script type="text/javascript" src="dwr/engine.js"></script>
	<script type="text/javascript" src="dwr/util.js"></script>
	<script type="text/javascript" src="dwr/interface/SearchEI.js"></script>
	<script src="js/jquery-ui-1.10.3.custom.min.js"></script>
	<script src="js/jquery.ui.touch-punch.min.js"></script>
	<script src="js/bootstrap.js"></script>
	<script src="js/bootstrap-select.js"></script>
	<script src="js/flatui-checkbox.js"></script>
	<script src="js/jquery.tagsinput.js"></script>
	<script src="js/jquery.placeholder.js"></script>
	<script src="js/application.js"></script>
	<script src="js/postei.js"></script>

</body>
</html>