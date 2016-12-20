package com.message.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.message.common.EasyPage;
import com.message.common.MsgTimerTask;
import com.message.common.ResultMap;
import com.message.common.SimpleStringReplaceUtil;
import com.message.model.MsgModel;
import com.message.service.MsgModelService;

/**
 * @Title: MsgModelController.java
 * @Description: 
 * @author zxl
 * @date 2016年12月12日 下午2:05:28
 * @version 1.0
 */
@Controller
@RequestMapping("/msgModel")
public class MsgModelController extends BaseController {
	@Resource
	private MsgModelService msgModelService;
	
	@RequestMapping("/")
	public String showMsgModelPage() {
		return "message/showMsgModelPage";
	}
	
	@RequestMapping("/queryMsgModelById")
	@ResponseBody
	public Map<String, Object> queryMsgModelById(Long id) {
		MsgModel msgModel = msgModelService.queryMsgModelById(id);
		Map<String, Object> resultMap = null;
		if(msgModel != null) {
			resultMap = ResultMap.setData(msgModel, "查询成功");
		} else {
			resultMap = ResultMap.setMsg(false, "查询失败");
		}
		return resultMap;
	}
	
	/**
	 * @Title queryMsgModelPage 
	 * @Description 消息模板分页查询
	 * @return Map<String,Object>
	 * @author zxl
	 * @time 2016年12月13日 上午11:02:53
	 */
	@RequestMapping("/queryMsgModelPage")
	@ResponseBody
	public Map<String, Object> queryMsgModelPage(String jparam,
			@RequestParam(required = false, defaultValue = "1") int nowPage,
            @RequestParam(required = false, defaultValue = "10") int pageSize) {
		Map<String, Object> param = JSON.parseObject(jparam);
		EasyPage<MsgModel> easyPage = msgModelService.queryMsgModelPage(param, nowPage, pageSize);
		Map<String, Object> resultMap = null;
		if(easyPage != null) {
			resultMap = ResultMap.setData(easyPage, "查询成功");
		} else {
			resultMap = ResultMap.setMsg(false, "查询失败");
		}
		return resultMap;
	}
	
	
	@RequestMapping("/addMsgModel")
	@ResponseBody
	public Map<String, Object> addMsgModel(MsgModel msgModel) {
		Map<String, Object> resultMap = msgModelService.addMsgModel(msgModel);
		return resultMap;
	}
	
	@RequestMapping("/editMsgModel")
	@ResponseBody
	public Map<String, Object> editMsgModel(MsgModel msgModel) {
		Map<String, Object> resultMap = null;
		if(msgModelService.editMsgModel(msgModel) > 0) {
			resultMap = ResultMap.setMsg(true, "修改成功!");
		} else {
			resultMap = ResultMap.setMsg(false, "修改失败");
		}
		return resultMap;
	}
	
	@RequestMapping("/removeMsgModel")
	@ResponseBody
	public Map<String, Object> removeMsgModel(Long id, String optUser) {
		Map<String, Object> resultMap = null;
		if(msgModelService.removeMsgModel(id, optUser) > 0) {
			resultMap = ResultMap.setMsg(true, "删除成功!");
		} else {
			resultMap = ResultMap.setMsg(false, "删除失败");
		}
		return resultMap;
	}

	
	@RequestMapping("/sendMsgModel")
	@ResponseBody
	public Map<String, Object> sendMsgModel(String msgCode, String jsonParam) {
		Map<String, Object> resultMap = null;
		Map<String, Object> replaceMap = null;
		if(jsonParam != null && !"".equals(jsonParam)) {
			try {
				replaceMap = JSON.parseObject(jsonParam);
			} catch (Exception e) {
				resultMap = ResultMap.setMsg(false, "模板变量错误!");
				return resultMap;
			}
		}
		
		MsgModel msgModel = msgModelService.queryMsgModelByMsgCode(msgCode);
		if(msgModel != null) {
			//消息内容替换
			msgModel.setMsgContent(SimpleStringReplaceUtil.replaceByMap(msgModel.getMsgContent(), replaceMap));
			//添加任务
			if(MsgTimerTask.addTask(msgModel)) {
				resultMap = ResultMap.setMsg(true, "消息任务添加成功!");
			} else {
				resultMap = ResultMap.setMsg(false, "消息任务添加失败!");
			}
		} else {
			resultMap = ResultMap.setMsg(false, "消息编码有误!");
		}
		return resultMap;
	}
}
