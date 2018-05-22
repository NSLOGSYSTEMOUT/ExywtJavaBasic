package com.cn.lambda;

@FunctionalInterface
interface Displayable{
	
	void display();
	
	default int add(int a, int b){
		return a+b;
	}
}

public class LambdaAndInner {

	private int age  = 12;
	private static String name = "java center";
	public void test(){
		
		String book = "jacdoc";
		Displayable dis = ()->{
		
			System.out.println("book局部变量"+book);
			System.out.println("外部类的age实例为"+age);
			System.out.println("外部类的name类变量为"+name);
			
		};
		
		dis.display();
		System.out.println(dis.add(3, 5));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LambdaAndInner lambda = new LambdaAndInner();
		lambda.test();
	}

}
