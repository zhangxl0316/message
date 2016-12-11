package com.message.dao;

import java.util.List;
import java.util.Map;

import com.message.model.Login;


public interface LoginMapper {
    int deleteByPrimaryKey(String id);

    int insert(Login record);

    int insertSelective(Login record);

    Login selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Login record);

    int updateByPrimaryKey(Login record);
    
    Login selectByUsername(String username);
    
    /**
     * @Title: selectUserAndLogin
     * @Description: ��ѯ�û��˺�����
     * @param:
     * @return:
     * @author ������
     * @date 2016��2��18�� ����3:19:39
     */
    List<Map<String, Object>> selectUserAndLogin(Map<String, Object> map);
}