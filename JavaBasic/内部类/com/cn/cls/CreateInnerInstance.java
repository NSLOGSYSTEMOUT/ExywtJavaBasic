package com.cn.cls;

interface A{
	void test();
}

public class CreateInnerInstance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Out.In in = new Out().new In("string");
		
		Out out = new Out();
		in = out.new In("string");
		
		//age被匿名内部类使用的相当于被final修饰了不可以改变
		int age = 8;
		
		A a = new A(){

			@Override
			public void test() {
				// TODO Auto-generated method stub
				System.out.println(age);
			}
			
		};
		
		a.test();

	}

}
