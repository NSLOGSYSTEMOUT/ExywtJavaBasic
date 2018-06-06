package com.cn.threadgroup;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsDemo {

	public static void main(String[] args) {
		
		ExecutorService pool = Executors.newFixedThreadPool(2);
		
		pool.submit(new MyRunnalbe());
		pool.submit(new MyRunnalbe());
		
		//关闭线程池
		pool.shutdown();
		
	}
}
