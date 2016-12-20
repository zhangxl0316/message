package com.message.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: SimpleStringReplaceUtil.java
 * @Description: 简单字符串模板替换
 * @author zxl
 * @date 2016年12月20日 上午11:56:49
 * @version 1.0
 */
public class SimpleStringReplaceUtil {

	public static String replaceByMap(String template, Map<String, Object> replaceMap) {
		for (String s : replaceMap.keySet()) {
			template = template.replaceAll("\\$\\{".concat(s).concat("\\}"),
					replaceMap.get(s).toString());
		}
		return template;
	}

	public static void main(String[] args){
		String template = "亲爱的用户${name},你好，上次登录时间为${time}";
		Map<String, Object> replaceMap = new HashMap<String, Object>();
		replaceMap.put("name", "张三");
		replaceMap.put("time", "2016年12月");
	    System.out.println(replaceByMap(template, replaceMap));
	}
}
