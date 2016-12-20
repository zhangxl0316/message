package com.message.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.message.common.EasyPage;
import com.message.common.ResultMap;
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
		return  new EasyPage<MsgModel>(msgModelMapper.selectValidMsgModel(param));
	}

	@Override
	public Map<String, Object> addMsgModel(MsgModel msgModel) {
		Map<String, Object> resultMap = null;
		if(msgModel != null) {
			MsgModel msgModelOld = queryMsgModelByMsgCode(msgModel.getMsgCode());
			if(msgModelOld == null) {
				msgModel.setOptTime(new Date());
				msgModel.setState((short) 1);
				if(msgModelMapper.insertSelective(msgModel) > 0) {
					resultMap = ResultMap.setMsg(true, "保存成功!");
				} else {
					resultMap = ResultMap.setMsg(false, "系统出错,保存失败!");
				}
			} else {
				resultMap = ResultMap.setMsg(false, "消息编号已存在,保存失败!");
			}
		} else {
			resultMap = ResultMap.setMsg(false, "数据为空,保存失败!");
		}
		
		return resultMap;
	}

	@Override
	public int editMsgModel(MsgModel msgModel) {
		msgModel.setOptTime(new Date());
		msgModel.setState((short) 1);
		return msgModelMapper.updateByPrimaryKeySelective(msgModel);
	}

	@Override
	public int removeMsgModel(long id, String optUser) {
		MsgModel msgModel = msgModelMapper.selectByPrimaryKey(id);
		if (msgModel != null && msgModel.getState() != 0) {
			msgModel.setOptTime(new Date());
			msgModel.setOptUser(optUser);
			msgModel.setState((short) 0);
			return msgModelMapper.updateByPrimaryKeySelective(msgModel);
		}
		
		return 0;
	}

	@Override
	public MsgModel queryMsgModelByMsgCode(String msgCode) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("msgCode", msgCode);
		List<MsgModel> list = msgModelMapper.selectValidMsgModel(param);
		if(list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
}
