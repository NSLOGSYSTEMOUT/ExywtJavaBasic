package com.cn.thread.security;

import java.util.Collections;
import java.util.regex.Pattern;

public class Thread_DeadLock {

	//多线程使用同步锁的时候容易产生死锁, 为了避免出现同步代码块不要嵌套操作
	
	public static String s1 = "左";
	public static String s2 = "右";
	
	public static void main(String[] args) {
		
		
		new Thread(){
			
			public void run() {
		
				while (true) {
				
					synchronized (s1) {
					
						System.out.println(getName()+"获取"+s1+"等待"+s2);
						
						synchronized (s2) {
							
							System.out.println(getName()+"拿到"+s2+"开始");
						}
					}
				}
			}
		}.start();
	
		
		new Thread(){
			
			public void run() {
		
				while (true) {
				
					synchronized (s2) {
					
						System.out.println(getName()+"获取"+s2+"等待"+s1);
						
						synchronized (s1) {
							
							System.out.println(getName()+"拿到"+s1+"开始");
						}
					}
				}
			}
		}.start();
	}
}
