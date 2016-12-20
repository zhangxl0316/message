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
		接口总叙 : 省略
	</div>
	<div>
		<ul>
			<li>
				1.查询消息模板,根据id<br />
				method : get <br />
				url: /msgModel/queryMsgModelById <br />
				<form action="/msgModel/queryMsgModelById" target="_blank" >
					消息id(id): <input type="text" name="id" value="63"/><br/>
					<input type="submit" value="提交">
				</form>
			</li>
			<li>
				2.查询消息模板,分页<br />
				method : get <br />
				url: /msgModel/queryMsgModelPage <br />
				<form action="/msgModel/queryMsgModelPage" target="_blank" >
					json参数(jparam): <input type="text" name="jparam" value=""/><br/>
					当前页(nowPage): <input type="text" name="nowPage" value="1"/><br/>
					每页记录(pageSize): <input type="text" name="pageSize" value="5"/><br/>
					<input type="submit" value="提交">
				</form>
			</li>
			<li>
				3.添加消息模板<br />
				method : post <br />
				url: /msgModel/addMsgModel<br />
				<form action="/msgModel/addMsgModel" target="_blank">
					消息类型(msgType): <input type="text" name="msgType" value="1"/><br/>
					消息编码(msgCode): <input type="text" name="msgCode" value="A009"/><br/>
					消息名称(msgName): <input type="text" name="msgName" value="合同取消"/><br/>
					消息内容(msgContent): <input type="text" name="msgContent" value="\${name},你好"/><br/>
					发送发式(sendMode): <input type="text" name="sendMode" value="2"/><br/>
					接收人类型: <input type="text" name="recipientType" value="1"/><br/>
					消操作人: <input type="text" name="optUser" value="李四"/><br/>
					<input type="submit" value="提交">
				</form>
			</li>
			<li>
				3.查询消息模板<br />
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