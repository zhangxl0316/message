<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<script type="text/javascript" src="<%=path%>/resources/js/common/jquery.min.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/common/jquery.easyui.min.js"></script>
<link href="<%=path%>/resources/css/common/themes/default/easyui.css" rel="stylesheet" type="text/css" media="screen" /> 
<link href="<%=path%>/resources/css/common/themes/icon.css" rel="stylesheet" type="text/css" media="screen" /> 
<input id="path" type="hidden" value="<%=path%>">