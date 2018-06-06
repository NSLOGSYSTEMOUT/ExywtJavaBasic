package com.cn.thread.runtime;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTask_demo {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		
		Timer tm = new Timer();
		
		tm.schedule(new MyTimer(), new Date(118, 6, 5, 10, 23, 5));
		
		
		while (true) {
			
			Thread.sleep(1000);
			System.out.println(new Date());
		}
		
		
		
		
		
	}
}


class MyTimer extends TimerTask{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
	
		System.out.println("hello ...");
	}
	
}
