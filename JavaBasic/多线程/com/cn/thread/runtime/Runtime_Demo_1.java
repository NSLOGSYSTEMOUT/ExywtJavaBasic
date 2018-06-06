package com.cn.thread.runtime;

import java.io.IOException;

public class Runtime_Demo_1 {

	public static void main(String[] args) throws IOException {
		
		
		//获取运行时对象 是单例的模式
		Runtime t = Runtime.getRuntime();
//		t.exec("shutdown -s -t 3000");
		t.exec("shutdown -a");
		System.out.println("1111");
		
	}
}
