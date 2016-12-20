<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>首页API</title>
</head>
<body>
	<div>
		<ul>
			<li>
				查询消息模板<br />
				method : get <br />
				url: <a href="/msgModel/queryMsgModelById?id=1">/msgModel/queryMsgModelById?id=1</a> <br />
				参数: id <br/>
			</li>
			<li>
				查询消息模板<br />
				method : post <br />
				url: /msgModel/sendMsgModel<br />
				<form action="/msgModel/sendMsgModel" target="_blank" >
					消息编码: <input type="text" name="msgCode" value="A001"/><br/>
					参数JSON:<input type="text" name="jsonParam" value='{"name":"张三","orderCode":"000001","lastDate":"2016-12-12 12:12:12"}'/><br/>
					<input type="submit" value="提交">
				</form>
			</li>
		</ul>
	</div>
</body>
</html>