package com.message.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.message.common.EasyPage;
import com.message.common.ResultMap;
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
	public Map<String, Object> queryMsgModelById(long id) {
		MsgModel msgModel = msgModelService.queryMsgModelById(id);
		Map<String, Object> resultMap = null;
		if(msgModel != null) {
			resultMap = ResultMap.setData(msgModel, "查询成功");
		} else {
			resultMap = ResultMap.setData(false, "查询失败");
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
	public Map<String, Object> queryMsgModelPage(Map<String, Object> param,
			@RequestParam(required = false, defaultValue = "1") int nowPage,
            @RequestParam(required = false, defaultValue = "10") int pageSize) {
		EasyPage<MsgModel> easyPage = msgModelService.queryMsgModelPage(param, nowPage, pageSize);
		Map<String, Object> resultMap = null;
		if(easyPage != null) {
			resultMap = ResultMap.setData(easyPage, "查询成功");
		} else {
			resultMap = ResultMap.setData(false, "查询失败");
		}
		return resultMap;
	}
	
	
	@RequestMapping("/addMsgModel")
	@ResponseBody
	public Map<String, Object> addMsgModel(MsgModel msgModel) {
		Map<String, Object> resultMap = null;
		if(msgModelService.addMsgModel(msgModel) > 0) {
			resultMap = ResultMap.setMsg(true, "保存成功!");
		} else {
			resultMap = ResultMap.setData(false, "保存失败");
		}
		return resultMap;
	}
}
