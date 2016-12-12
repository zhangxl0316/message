package com.message.common;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Title: ResultMap.java
 * @Description: 
 * @author zxl
 * @date 2016年12月12日 下午5:46:38
 * @version 1.0
 */
public class ResultMap {
	/** total键 存放总记录数，必须的 ,EasyUI根据这个参数，可以计算page和number的值，这个值不是users的长度 */
	private static final String TOTAL = "total";
	/** 存放每页记录 list */
	private static final String DATA = "data";
	private static final String SUCCESS = "success";
	private static final String MESSAGE = "msg";
	
	/**
	 * @Title setPageData 
	 * @Description 
	 * @param list 结果集
	 * @param msg 返回信息
	 * @return String
	 * @author zxl
	 * @time 2016年12月12日 下午2:48:50
	 */
	public static Map<String, Object> setPageData(Collection<? extends Object> list, String msg){
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put(TOTAL, list.size());
		dataMap.put(DATA, list);
		dataMap.put(SUCCESS, true);
		dataMap.put(MESSAGE, msg);
		return dataMap;
	}
	
	/**
	 * @Title setData 
	 * @Description 
	 * @param data
	 * @param msg
	 * @param success
	 * @return String
	 * @author zxl
	 * @time 2016年12月12日 下午3:05:55
	 */
	public static Map<String, Object> setData(Object data, String msg, boolean success){
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put(DATA, data);
		dataMap.put(SUCCESS, success);
		dataMap.put(MESSAGE, msg);
		return dataMap;
	}
	
	/**
	 * @Title setData 
	 * @Description 
	 * @param data
	 * @param msg
	 * @return String
	 * @author zxl
	 * @time 2016年12月12日 下午2:55:10
	 */
	public static Map<String, Object> setData(Object data, String msg){
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put(SUCCESS, true);
		dataMap.put(MESSAGE, msg);
		dataMap.put(DATA, data);
		return dataMap;
	}
	
	/**
	 * @Title setData 
	 * @Description 
	 * @param data
	 * @return String
	 * @author zxl
	 * @time 2016年12月12日 下午2:52:54
	 */
	public static Map<String, Object> setData(Object data){
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.clear();
		dataMap.put(DATA, data);
		dataMap.put(SUCCESS, true);
		return dataMap;
	}
	
	/**
	 * @Title setSuccessMsg 
	 * @Description 
	 * @param success
	 * @param msg
	 * @return String
	 * @author zxl
	 * @time 2016年12月12日 下午3:08:03
	 */
	public static Map<String, Object> setMsg(boolean success, String msg){
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.clear();
		dataMap.put(SUCCESS, success);
		dataMap.put(MESSAGE, msg);
		return dataMap;
	}
}
