<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>Check EI!</title>
		<meta http-equiv="keywords" content="EI检索,EI号查询,免费">
		<meta http-equiv="description" content="免费EI号检索">
		<link rel="stylesheet" type="text/css"
			href="bootstrap/css/bootstrap.css">
		<script type="text/javascript" src="js/postei.js"></script>
		<script type="text/javascript" src="js/jquery-2.1.0.min.js"></script>
	</head>

	<body>

		<div class="container">
			<div class="row">
				<div class="col-md-9">
					<label for="text">
						<h2>
							EI号检索
						</h2>
					</label>
				</div>
				<div class="col-md-1">
					<h5>
						问题反馈
					</h5>
				</div>
				<div class="col-md-1">
					<h5>
						捐赠作者
					</h5>
				</div>
				<div class="col-md-1">

				</div>
			</div>


			<div class="form-group">
				<input type="text" class="form-control" id="searchWord1"
					placeholder="Enter Title">
			</div>
			<button type="button" class="btn btn-primary" onclick="dwr_postei()">
				Serach
			</button>


		</div>
	</body>
</html>
