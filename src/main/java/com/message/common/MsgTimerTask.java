package com.message.common;

import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.message.model.MsgModel;

/**
 * @Title: MsgTimerTask.java
 * @Description: 
 * @author zxl
 * @date 2016年12月19日 上午9:47:01
 * @version 1.0
 */
public class MsgTimerTask extends TimerTask {
	private static Timer timer = new Timer();
	//消息队列
	private static Queue<MsgModel> queue = new ConcurrentLinkedQueue<>();
	//循环周期
	static long period = 500;

	@Override
	public void run() {
		MsgModel msgModel = queue.poll();
		if(msgModel != null) {
			System.out.println(msgModel.getMsgContent());
		} else {
			System.out.println("暂时没有消息");
		}
	}
	
	public static boolean addTask(MsgModel msgModel) {
		return queue.add(msgModel);
	}
	
	static {
		MsgTimerTask msgTimerTask = new MsgTimerTask();
		timer.schedule(msgTimerTask, 0, MsgTimerTask.period);
	}

}
