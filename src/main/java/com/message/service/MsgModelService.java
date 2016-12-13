package com.message.service;

import java.util.Map;

import com.message.common.EasyPage;
import com.message.model.MsgModel;

/**
 * @Title: MsgModelService.java
 * @Description: TODO
 * @author zxl
 * @date 2016年12月12日 下午1:57:22
 * @version 1.0
 */
public interface MsgModelService {
	public int addMsgModel(MsgModel msgModel);
	public MsgModel queryMsgModelById(long id);
	public EasyPage<MsgModel> queryMsgModelPage(Map<String, Object> param, int nowPage, int pageSize);
}
