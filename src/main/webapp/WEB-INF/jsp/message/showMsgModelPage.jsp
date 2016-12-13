<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>消息模板展示页面</title>
<jsp:include page="/WEB-INF/jsp/common/common.jsp"></jsp:include>
<script type="text/javascript">
	function queryMsgModel() {
		$.ajax({
			type : "get",
			url : $("#path").val() + "/msgModel/queryMsgModelPage",
			data : {},
			dataType : "json",
			async : true,
			success : function(resultMap) {
				if (resultMap.success = true) {
					$("#tt").datagrid({
						title:'My DataGrid',
						iconCls:'icon-save',
						width:700,
						height:350,
						nowrap: true,
						autoRowHeight: false,
						striped: true,
						collapsible:true,
						loadData:resultMap.data.list,
						sortName: 'code',
						sortOrder: 'desc',
						remoteSort: false,
						idField:'code',
						frozenColumns:[[
			                {field:'ck',checkbox:true},
			                {title:'Code',field:'code',width:80,sortable:true}
						]],
						columns:[[
					        {title:'Base Information',colspan:3},
							{field:'opt',title:'Operation',width:100,align:'center', rowspan:2,
								formatter:function(value,rec){
									return '<span style="color:red">Edit Delete</span>';
								}
							}
						],[
							{field:'name',title:'Name',width:120},
							{field:'addr',title:'Address',width:220,rowspan:2,sortable:true,
								sorter:function(a,b){
									return (a>b?1:-1);
								}
							},
							{field:'col4',title:'Col41',width:150,rowspan:2}
						]],
						pagination:true,
						rownumbers:true,
						toolbar:[{
							id:'btnadd',
							text:'Add',
							iconCls:'icon-add',
							handler:function(){
								$('#btnsave').linkbutton('enable');
								alert('add')
							}
						},{
							id:'btncut',
							text:'Cut',
							iconCls:'icon-cut',
							handler:function(){
								$('#btnsave').linkbutton('enable');
								alert('cut')
							}
						},'-',{
							id:'btnsave',
							text:'Save',
							disabled:true,
							iconCls:'icon-save',
							handler:function(){
								$('#btnsave').linkbutton('disable');
								alert('save')
							}
						}]
					});
				}
			},
			error : function() {

			}
		});
	}
	
	$(function(){
		queryMsgModel();
	});
</script>
</head>
<body>
	<table id="tt"></table>
</body>
</html>