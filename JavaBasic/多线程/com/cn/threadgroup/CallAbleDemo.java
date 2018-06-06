package com.cn.threadgroup;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallAbleDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		Future<Integer> f1 = executor.submit(new MyCallAble(100));
		Future<Integer> f2 =executor.submit(new MyCallAble(50));
		
		System.out.println(f1.get());
		System.out.println(f2.get());
		executor.shutdown();
		
	}
	
}

class MyCallAble implements Callable<Integer>{

	
	private int num;
	
	public MyCallAble(int num) {
	
		this.num = num; 
	}
	public Integer call() throws Exception {
		
		int sum = 0;
		for (int i = 1 ; i <= num; i++) {
			sum += i;
		}
		
		return sum;
	}
	
	
}
