package com.cn.adapter;

public class AdapterModel {
/*
 * 适配器模式：通常接口中有多个方法，而程序中不一定所有的都用到 但又必须重写
 * 适配器简化了这一操作，只要继承适配器然后重写需要的方法即可
 * */
	
	public static void main(String[] args) {
		
		small person = new small();
		person.run();
		person.sleep();
	}
}


interface Person{
	
	public void eat();
	public void play();
	public void run();
	public void sleep();
}

//声明为抽象的原因是：不想让其它类创建本类，创建无意义方法都是空的
//这是个适配器类
abstract class centerClass implements Person{

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		
	}
	
}

class small extends centerClass{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("run ...");
	}
	
	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("sleep ...");
	}
}
