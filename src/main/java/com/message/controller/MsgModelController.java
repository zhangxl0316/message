package com.message.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
