package com.cn.notify;

public class NotifyAll {
	public static void main(String[] args) {

		final Printer_All p = new Printer_All();
		
		new Thread(){
			
			public void run() {
				while (true) {
					
					try {
						p.print1();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}.start();
		
		new Thread() {

			public void run() {
				while (true) {

					try {
						p.print2();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}.start();

		new Thread() {

			public void run() {
				while (true) {

					try {
						p.print3();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}.start();

	}
}


//等待唤醒机制
/*
 * 在同步代码块中，用哪个对象就用哪个对象调用wait方法
 * Object中定义了wait与notify方法：所有对都可是锁对象，需要定义在Object基类中
 * 
 * sleep：必须传入参数参数是时间时间到了自动醒来，在同步函数或同步代码块中不释放锁
 * 与wait：参数可选，传入在参数时间结束后等待，不传入直接等待。在同步函数或同步代码块中是释放锁
 * */
class Printer_All {
	
	private int flag = 1;
	public   void print1() throws InterruptedException {
		
		synchronized (this) {
			
			while (flag != 1) {
				this.wait();
			}	
			
			System.out.print("你");
			System.out.print("好");
			System.out.print("啊");
			System.out.print("\r\n");
			
			flag = 2;
			//随机唤醒单个等待线程
//			this.notify();
			this.notifyAll();
		}
	}
	
	public  void print2() throws InterruptedException {
		
		synchronized (this) {
		
			while (flag != 2) {
				this.wait();
			}
			
			System.out.print("a");
			System.out.print("b");
			System.out.print("c");
			System.out.print("d");
			System.out.print("\r\n");	
			
			flag = 3;
//			this.notify();
			this.notifyAll();
			
		}
		
	}
	
	
	public  void print3() throws InterruptedException {
		
		synchronized (this) {

			//if在哪里等待就在哪里唤起
//			while是循环判断每一次判断都会判断标记
			while (flag != 3) {
				this.wait();
			}
			
			System.out.print("1");
			System.out.print("2");
			System.out.print("3");
			System.out.print("4");
			System.out.print("\r\n");	
			
			flag = 1;
//			this.notify();
			this.notifyAll();
			
		}
		
	}
}