package com.cn.notify;


public class Notifiy_demo {

	//等待唤醒
	public static void main(String[] args) {
		
		Printer_m printer =  new Printer_m();
		
		new Thread(){
			
			public void run() {
				
				while (true) {
					
					try {
						printer.print1();
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
						printer.print2();
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
class Printer_m {

	
	private int flag = 1;
	public   void print1() throws InterruptedException {
		
		synchronized (this) {
			
			if (flag != 1) {
				this.wait();
			}
			
			System.out.print("你");
			System.out.print("好");
			System.out.print("啊");
			System.out.print("\r\n");
			
			flag = 2;
			//随机唤醒单个等待线程
			this.notify();
		}
	}
	
	public  void print2() throws InterruptedException {
		
		synchronized (this) {
		
			if (flag != 2) {
				this.wait();
			}
			
			System.out.print("a");
			System.out.print("b");
			System.out.print("c");
			System.out.print("d");
			System.out.print("\r\n");	
			
			flag = 1;
			this.notify();
			
		}
		
	}
}
