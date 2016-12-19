<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>消息模板展示页面</title>
<jsp:include page="/WEB-INF/jsp/common/common.jsp"></jsp:include>
<script type="text/javascript">
	function queryMsgModel(nowPage, pageSize) {
		$.ajax({
			type : "get",
			url : $("#path").val() + "/msgModel/queryMsgModelPage",
			data : {'nowPage' : nowPage, 'pageSize' : pageSize},
			dataType : "json",
			async : true,
			success : function(resultMap) {
				if (resultMap.success = true) {
					$("#tt").datagrid("loadData", resultMap.data);
				}
			}
		});
	}

	
	$(function() {
		queryMsgModel(1, 10);
		
		$("#tt").datagrid({
			toolbar : [{
				id : 'btnadd',
				text : '添加',
				iconCls : 'icon-add',
				handler : function() {
					$('#addMsgModelWin').panel('open');
				}
			}]
		});
		
		var pager = $('#tt').datagrid('getPager');    // get the pager of datagrid
		pager.pagination({
			showPageList :false,
			pageSize : 10,
			beforePageText : "当前页 ",
			afterPageText : " 总页数 {pages}",
			displayMsg : "总记录:{total}",
			onSelectPage : function(nowPage, pageSize) {
				queryMsgModel(nowPage, pageSize);
			},
			onRefresh(nowPage, pageSize){
				queryMsgModel(nowPage, pageSize);
			}
		});
		
		//模板添加
		$('#addMsgModelForm').form({
			url : $("#path").val() + "/msgModel/addMsgModel",
			success : function(resultMapString) {
				var resultMap = jQuery.parseJSON(resultMapString);
				if(resultMap.success) {
					$('#addMsgModelWin').panel('close');
					var pager = $('#tt').datagrid('getPager');
					var options = pager.pagination("options");
					queryMsgModel(options.pageNumber, options.pageSize);
				}
			}
		});
		
		//模板修改
		$('#editMsgModelForm').form({
			url : $("#path").val() + "/msgModel/editMsgModel",
			success : function(resultMapString) {
				var resultMap = jQuery.parseJSON(resultMapString);
				if(resultMap.success) {
					$('#editMsgModelWin').panel('close');
					var pager = $('#tt').datagrid('getPager');
					var options = pager.pagination("options");
					queryMsgModel(options.pageNumber, options.pageSize);
				}
			}
		})
		
	});
	
	function msgTypeFormat(value) {
		switch(value){
			case 1:
				return "业务变更";
		  		break;
			case 2:
				return "节日祝福";
		  		break;
			default:
				return value;
		}
	}
	function editFormat(value, rowData, rowIndex) {
		var e = '<a  href="#" onclick="showEditWin(' + rowData.id + ')">修改</a> ';
		var d = '<a  href="#" onclick="removeMsgModel(' + rowData.id + ')">删除</a>';
		return e + d;
	}
	
	//展示模板编辑窗,并查询
	function showEditWin(id) {
		$.ajax({
			type : "post",
			url : $("#path").val() + "/msgModel/queryMsgModelById",
			data : {"id" : id},
			dataType : "json",
			async : true,
			success : function(resultMap) {
				if (resultMap.success = true) {
					$('#msgId').val(resultMap.data.id);
					$('#msgType').combobox("setValue", resultMap.data.msgType);
					$('#msgCode').textbox("setValue", resultMap.data.msgCode);
					$('#msgName').textbox("setValue", resultMap.data.msgName);
					$('#msgContent').textbox("setValue", resultMap.data.msgContent);
					$('#sendMode').combobox("setValue", resultMap.data.sendMode);
					$('#recipientType').combobox("setValue", resultMap.data.recipientType);
					$('#optUser').textbox("setValue", resultMap.data.optUser);
					$('#msgId').val(resultMap.data.id);
					$('#editMsgModelWin').panel('open');
				}
			}
		});
	}
	
	//删除模板,并查询
	function removeMsgModel(id, optUser) {
		$.ajax({
			type : "post",
			url : $("#path").val() + "/msgModel/removeMsgModel",
			data : {"id" : id, "optUser" : "李四"},
			dataType : "json",
			async : true,
			success : function(resultMap) {
				if (resultMap.success = true) {
					var pager = $('#tt').datagrid('getPager');
					var options = pager.pagination("options");
					queryMsgModel(options.pageNumber, options.pageSize);
				}
			}
		});
	}
</script>
</head>
<body>
	<table id="tt" class="easyui-datagrid" data-options="title : '消息模板', height : 600, pagination : true, rownumbers : true," >
		<thead>
			<tr>
				<th data-options="field : 'id', hidden : true"></th>
				<th data-options="field : 'msgCode', title : '编码', width : '10%'"></th>
				<th data-options="field : 'msgType', title : '消息类型', width : '12%', formatter : msgTypeFormat"></th>
				<th data-options="field : 'msgName', title : '消息名称', width : '12%'"></th>
				<th data-options="field : 'msgContent', title : '发送内容', width : '20%'"></th>
				<th data-options="field : 'sendMode', title : '发送方式', width : '8%'"></th>
				<th data-options="field : 'recipientType', title : '接收对象', width : '8%'"></th>
				<th data-options="field : 'optUser', title : '操作人', width : '10%'"></th>
				<th data-options="field : 'optTime', title : '操作时间', width : '10%', formatter : formatDatebox1"></th>
				<th data-options="field : 'edit', title : '编辑', width : '9%', formatter : editFormat"></th>
			</tr>
		</thead>
	</table>
	
	<div id="addMsgModelWin" class="easyui-dialog" title="消息模板添加"
		data-options="closed:true,modal:true, draggable : false"
		style="width: 100%; max-width: 400px; padding: 30px 60px;">
		<form id="addMsgModelForm" method="post" >
			<div style="margin-bottom: 20px">
				<select class="easyui-combobox" name="msgType" label="消息类型:"
					style="width: 100%">
					<option value="1" selected="selected">业务变更</option>
					<option value="2">节日祝福</option>
				</select>
			</div>
			<div style="margin-bottom: 20px">
				<input class="easyui-textbox" name="msgCode" style="width: 100%"
					data-options="label:'消息编码:',required:true,missingMessage:'不能为空'" value="A001">
			</div>
			<div style="margin-bottom: 20px">
				<input class="easyui-textbox" name="msgName" style="width: 100%"
					data-options="label:'消息名称:',required:true,missingMessage:'不能为空'" value="合同签署">
			</div>
			<div style="margin-bottom: 20px">
				<input class="easyui-textbox" name="msgContent" style="width: 100%"
					data-options="label:'消息内容:',multiline:true,required:true,missingMessage:'不能为空'" value="您好,您的订单已经签署完毕,请及时查看.">
			</div>
			<div style="margin-bottom: 20px">
				<select class="easyui-combobox" name="sendMode" label="发送发式:"
					style="width: 100%">
					<option value="1" selected="selected">系统通知</option>
					<option value="2">邮件</option>
					<option value="3">短信</option>
				</select>
			</div>
			<div style="margin-bottom: 20px">
				<select class="easyui-combobox" name="recipientType" label="接收人类型:"
					style="width: 100%">
					<option value="1" selected="selected">客户</option>
					<option value="2">销售</option>
					<option value="3">坐席</option>
				</select>
			</div>
			<div style="margin-bottom: 20px">
				<input class="easyui-textbox" name="optUser" style="width: 100%"
					data-options="label:'操作人:',required:true,missingMessage:'不能为空'" value="张三">
			</div>
		</form>
		<div style="text-align: center; padding: 5px 0">
			<a href="javascript:$('#addMsgModelForm').submit();" class="easyui-linkbutton"
				style="width: 80px">保存</a> <a
				href="javascript:$('#addMsgModelWin').panel('close');" class="easyui-linkbutton"
				style="width: 80px">取消</a>
		</div>
	</div>
	
	<div id="editMsgModelWin" class="easyui-dialog" title="消息模板修改"
		data-options="closed:true,modal:true, draggable : false"
		style="width: 100%; max-width: 400px; padding: 30px 60px;">
		<form id="editMsgModelForm" method="post" >
			<input type="hidden" id="msgId" name="id"/>
			<div style="margin-bottom: 20px">
				<select class="easyui-combobox" id="msgType" name="msgType" label="消息类型:"
					style="width: 100%">
					<option value="1">业务变更</option>
					<option value="2">节日祝福</option>
				</select>
			</div>
			<div style="margin-bottom: 20px">
				<input class="easyui-textbox" id="msgCode" name="msgCode" style="width: 100%"
					data-options="label:'消息编码:',required:true,missingMessage:'不能为空',disabled : true" >
			</div>
			<div style="margin-bottom: 20px">
				<input class="easyui-textbox" id="msgName" name="msgName" style="width: 100%"
					data-options="label:'消息名称:',required:true,missingMessage:'不能为空'">
			</div>
			<div style="margin-bottom: 20px">
				<input class="easyui-textbox" id="msgContent" name="msgContent" style="width: 100%"
					data-options="label:'消息内容:',multiline:true,required:true,missingMessage:'不能为空'" >
			</div>
			<div style="margin-bottom: 20px">
				<select class="easyui-combobox" id="sendMode" name="sendMode" label="发送发式:"
					style="width: 100%">
					<option value="1">系统通知</option>
					<option value="2">邮件</option>
					<option value="3">短信</option>
				</select>
			</div>
			<div style="margin-bottom: 20px">
				<select class="easyui-combobox" id="recipientType" name="recipientType" label="接收人类型:"
					style="width: 100%">
					<option value="1">客户</option>
					<option value="2">销售</option>
					<option value="3">坐席</option>
				</select>
			</div>
			<div style="margin-bottom: 20px">
				<input class="easyui-textbox" id="optUser" name="optUser" style="width: 100%"
					data-options="label:'操作人:',required:true,missingMessage:'不能为空'">
			</div>
		</form>
		<div style="text-align: center; padding: 5px 0">
			<a href="javascript:$('#editMsgModelForm').submit();" class="easyui-linkbutton"
				style="width: 80px">保存</a> <a
				href="javascript:$('#editMsgModelWin').panel('close');" class="easyui-linkbutton"
				style="width: 80px">取消</a>
		</div>
	</div>
</body>
</html>