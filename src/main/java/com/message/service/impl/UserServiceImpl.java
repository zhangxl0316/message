package com.message.service.impl;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.message.common.CommonUtil;
import com.message.dao.LoginMapper;
import com.message.dao.UserMapper;
import com.message.model.Login;
import com.message.model.User;
import com.message.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	private LoginMapper loginMapper;
	@Resource
	private UserMapper userMapper;

	@Override
	public int addUser(Login login) {
		String userId  = CommonUtil.getUUID();
		String loginId  = CommonUtil.getUUID();
		
		User user = new User();
		user.setName(login.getUsername());
		user.setId(userId);
		
		login.setUserId(userId);
		login.setId(loginId);
		
		userMapper.insertSelective(user);
		loginMapper.insertSelective(login);
		return 0;
	}

	@Override
	public Login getLoginByUsername(String username) {
		return loginMapper.selectByUsername(username);
	}

	@Override
	public List<Map<String, Object>> selectUserAndLogin(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return loginMapper.selectUserAndLogin(map);
	}

}
