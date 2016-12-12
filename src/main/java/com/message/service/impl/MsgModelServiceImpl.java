package com.message.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

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
}
