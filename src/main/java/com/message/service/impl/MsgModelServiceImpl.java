package com.message.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.message.common.EasyPage;
import com.message.dao.MsgModelMapper;
import com.message.model.MsgModel;
import com.message.service.MsgModelService;

/**
 * @Title: MsgModelServiceImpl.java
 * @Description: TODO
 * @author zxl
 * @date 2016年12月12日 下午1:57:46
 * @version 1.0
 */
@Service
public class MsgModelServiceImpl implements MsgModelService {
	@Resource
	private MsgModelMapper msgModelMapper;

	@Override
	public MsgModel queryMsgModelById(long id) {
		return msgModelMapper.selectByPrimaryKey(id);
	}

	@Override
	public EasyPage<MsgModel> queryMsgModelPage(Map<String, Object> param, int nowPage, int pageSize) {
		if(param != null) {
			if(param.get("msgName") != null) param.put("msgName", "%" + param.get("msgName") + "%");
			if(param.get("msgContent") != null) param.put("msgContent", "%" + param.get("msgContent") + "%");
			if(param.get("optUser") != null) param.put("optUser", "%" + param.get("optUser") + "%");
		}
		PageHelper.startPage(nowPage, pageSize);
		return  new EasyPage<MsgModel>(msgModelMapper.selectValidMsgModel());
	}

	@Override
	public int addMsgModel(MsgModel msgModel) {
		// TODO Auto-generated method stub
		return msgModelMapper.insertSelective(msgModel);
	}
}
