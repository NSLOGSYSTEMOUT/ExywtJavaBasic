package com.cn.thread.syn;

public class Thread_synchronized2 {

	public static void main(String[] args) {
		
		Printer_my2 p = new Printer_my2();
		
		new Thread(){
		
			public void run(){
				
				while (true) {
					p.print1();
				}
			}
		}.start();

		new Thread(){
			
			public void run() {
				while (true) {
					
					p.print2();
				}
			}
		}.start();
	}
}


class Printer_my2 {
	
//	demo_my demo = new demo_my();
	//同步方法只需要在方法前加上synchronized即可
	//非静态方法的锁对象是：this
	//静态方法的锁对象是：该类的字节码对象
	public static synchronized void print1() {
		
		System.out.print("你");
		System.out.print("好");
		System.out.print("啊");
		System.out.print("\r\n");
		
	}
	
	public static void print2() {
		
		synchronized (Printer_my2.class) {
		
			System.out.print("a");
			System.out.print("b");
			System.out.print("c");
			System.out.print("d");
			System.out.print("\r\n");	
			
		}
		
	}
}

class demo_my {}
