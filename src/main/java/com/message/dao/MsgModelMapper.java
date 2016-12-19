package com.message.dao;

import java.util.List;
import java.util.Map;

import com.message.model.MsgModel;

public interface MsgModelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MsgModel record);

    int insertSelective(MsgModel record);

    MsgModel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MsgModel record);

    int updateByPrimaryKey(MsgModel record);
    
    List<MsgModel> selectValidMsgModel(Map<String, Object> param);
}