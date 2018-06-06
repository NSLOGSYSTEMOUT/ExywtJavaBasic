package com.cn.notify;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReenTrantLock_demo {

	public static void main(String[] args) {
		
		PrinterMyReen printerMyReen = new PrinterMyReen();
		
		new Thread(){
			
			public void run() {
				while (true) {
					
					try {
						printerMyReen.print1();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		
		}.start();
		
		new Thread(){
			
			public void run() {
				while (true) {
					
					try {
						printerMyReen.print2();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		
		}.start();
		
		new Thread(){
			
			public void run() {
				while (true) {
					
					try {
						printerMyReen.print3();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		
		}.start();
		
	}
	
}

class PrinterMyReen {
	
	private ReentrantLock reentrantLock = new ReentrantLock();
	private Condition  c1= reentrantLock.newCondition();
	private Condition  c2= reentrantLock.newCondition();
	private Condition  c3= reentrantLock.newCondition();
	private int flag = 1;
	public   void print1() throws InterruptedException {
		
//		synchronized (this) {
		//获取锁
		reentrantLock.lock();
			
		if (flag != 1) {
//				this.wait();
				c1.await();
			}	
			
			System.out.print("你");
			System.out.print("好");
			System.out.print("啊");
			System.out.print("\r\n");
			
			flag = 2;
			//随机唤醒单个等待线程
//			this.notify();
//			this.notifyAll();
			c2.signal();
			//释放锁
		reentrantLock.unlock();
//		}
	}
	
	public  void print2() throws InterruptedException {
		
//		synchronized (this) {
		reentrantLock.lock();
		if (flag != 2) {
//				this.wait();
				c2.await();
			}
			
			System.out.print("a");
			System.out.print("b");
			System.out.print("c");
			System.out.print("d");
			System.out.print("\r\n");	
			
			flag = 3;
//			this.notify();
//			this.notifyAll();
			c3.signal();
		reentrantLock.unlock(); 	
//		}
		
	}
	
	
	public  void print3() throws InterruptedException {
		
//		synchronized (this) {
		reentrantLock.lock();
			//if在哪里等待就在哪里唤起
//			while是循环判断每一次判断都会判断标记
		if (flag != 3) {
//				this.wait();
				c3.await();
			}
			
			System.out.print("1");
			System.out.print("2");
			System.out.print("3");
			System.out.print("4");
			System.out.print("\r\n");	
			
			flag = 1;
//			this.notify();
//			this.notifyAll();
			//唤醒指定的线程 while --可 if
			c1.signal();
		reentrantLock.unlock();	
//		}
		
	}
	
}
