package com.cn.template;

public class Template {

	public static void main(String[] args) {
		/*
		Long start = System.currentTimeMillis();
		
		for (int i = 0; i < 100000; i++) {
			System.out.println("xx");
		}
		Long end  = System.currentTimeMillis();
		System.out.println(end - start);
		*/
		
		Demo demo = new Demo();
		System.out.println(demo.getGap());
	}
}


abstract class getTime{
	
	public final Long getGap() {
		
		Long start = System.currentTimeMillis();
		code();
		Long end  = System.currentTimeMillis();
		return end - start;
	}

	public abstract void code() ;
}

class Demo extends getTime{
	
	@Override
	public void code() {
	
		int i = 0;
		while (i < 10000) {
			System.out.println("..");
			i++;
		}
		
	}
}
