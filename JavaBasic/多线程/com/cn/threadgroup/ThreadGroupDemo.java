package com.cn.threadgroup;

public class ThreadGroupDemo {
/*
 * 
 * */
	//默认所有的线程都输入主线程组中
	public static void main(String[] args) {
			
		ThreadGroup threadGroup = new  ThreadGroup("新的线程组");
		
		MyRunnalbe runnalbe = new MyRunnalbe();//新的线程组
		Thread t1 = new Thread(threadGroup, runnalbe, "threadOne");
		Thread t2 = new Thread(threadGroup, runnalbe, "threadTwo");
		
		System.out.println(t1.getThreadGroup().getName());
		System.out.println(t2.getThreadGroup().getName());
		
		//守护线程
//		threadGroup.setDaemon(true);
	}
	
	public static void Demo_01() {
		
		MyRunnalbe my1 = new MyRunnalbe();
		
		Thread t1 = new Thread(my1, "threadOne");
		Thread t2 = new Thread(my1, "threadTwo");
		
		ThreadGroup group1 = t1.getThreadGroup();
		ThreadGroup group2 = t2.getThreadGroup();
		
		//默认主线程
		System.out.println(group1.getName());
		System.out.println(group2.getName());
	}
}

class MyRunnalbe implements Runnable{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
	
		for (int i = 0; i < 1000; i++) {
			
			System.out.println(Thread.currentThread().getName() + "...."+i);
		}
	}
	
}
