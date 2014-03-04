<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>Engineering Village - Quick Search Detailed Format</title>
		<link type="image/x-icon"
			href="http://www.engineeringvillage.com/static/images/engineering_village_favicon.gif"
			rel="SHORTCUT ICON" />
		<link rel="stylesheet" type="text/css" media="screen"
			href="css/standard.css" />
		<link href="css/ev_abstract.css" media="all" type="text/css"
			rel="stylesheet" />

		<script type="text/javascript" src="js/postei.js"></script>
		<script type="text/javascript" src="js/jquery-2.1.0.min.js"></script>
		<script type="text/javascript" src="dwr/engine.js"></script>
		<script type="text/javascript" src="dwr/util.js"></script>
		<script type="text/javascript" src="dwr/interface/SearchEI.js"></script>
	</head>
	<body onload="loadtable();">
		<div id="container">

			<div id="abstractbox">
				<div class="hr" style="height: 5px; margin: 0 10px">
					<hr />
				</div>
				
				<table id="abstractwrapper" border="0" cellpadding="0"
					cellspacing="0">
					<tbody>

						<tr>
							<td id="lhcolumn">
								<div class="hr"
									style="color: #9b9b9b; background-color: #9b9b9b; height: 1px; margin: 0 0 7px 0;">
									<hr />
								</div>
								
								<div id="abstractarea" class="shadowbox" aria-label="Article"
									role="main">

									<p style="margin: 0 0 5px 0">
										Check record to add to Selected Records
									</p>

									<div id="detail_load">
									</div>

									<div class="clear"></div>

								</div>
								
								<div class="clear"></div>
								
							</td>
						</tr>
					</tbody>
				</table>
				<div class="clear"></div>
			</div>
		</div>
	</body>
</html>