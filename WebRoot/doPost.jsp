<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="GetEINum.ResponseMobile" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%	
	ResponseMobile rm = new ResponseMobile();
	String res = rm.ResByWord1(request.getParameter("SearchWord1"));
	//out.println(request.getParameter("SearchWord1"));
	out.println(res);
	//out.println("{\"message\":\"Brett\"}");
%>

