package com.message.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.message.service.MsgModelService;

/**
 * @Title: MsgModelController.java
 * @Description: 
 * @author zxl
 * @date 2016年12月12日 下午2:05:28
 * @version 1.0
 */
@Controller
@RequestMapping("/")
public class IndexController extends BaseController {
	@Resource
	private MsgModelService msgModelService;
	
	@RequestMapping("/index.html")
	public String index() {
		return "index";
	}
}
