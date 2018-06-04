package com.cn.threadTest;

public class threadTest {

	public static void main(String[] args) {
		
//		1:
//		MyThread thread  = new MyThread();
//		thread.start(); //开启线程 回去调用run方法

//		2: 创建runnable的子类对象
		MyRunalbe runalbe = new MyRunalbe();
//		传递给构造函数
		Thread t = new Thread(runalbe);
		t.start();
		
		for (int i = 0; i < 1000; i++) {

			System.out.println("main main main");
		}
		
	}
}

class MyRunalbe implements Runnable{

	@Override
	public void run() {
		
		for (int i = 0; i < 1000; i++) {
			
			System.out.println("*******");
		}
	}
	
	
}


class MyThread extends Thread {
	
	public void run(){
		 
		for (int i = 0; i < 1000; i++) {
			
			System.out.println("*******");
		}
	}
}
