package com.message.common;

import com.message.model.MsgModel;

/**
 * @Title: TimerTaskUtil.java
 * @Description: 循环任务工具类
 * @author zxl
 * @date 2016年12月18日 下午10:08:35
 * @version 1.0
 */
public class TimerTaskUtil {
	public static void main(String[] args) {
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				MsgModel msgModel = new MsgModel();
				msgModel.setId(1l);
				MsgTimerTask.addTask(msgModel);
				msgModel = new MsgModel();
				msgModel.setId(2l);
				MsgTimerTask.addTask(msgModel);
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				MsgModel msgModel = new MsgModel();
				msgModel.setId(3l);
				MsgTimerTask.addTask(msgModel);
				msgModel = new MsgModel();
				msgModel.setId(4l);
				MsgTimerTask.addTask(msgModel);
			}
		});
		
		Thread thread3 = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				MsgModel msgModel = new MsgModel();
				msgModel.setId(5l);
				MsgTimerTask.addTask(msgModel);
				msgModel = new MsgModel();
				msgModel.setId(6l);
				MsgTimerTask.addTask(msgModel);
			}
		});
		thread1.start();
		thread2.start();
		thread3.start();
	}

}
