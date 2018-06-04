package com.cn.singleton;

import com.cn.fileReader.remindTest;

public class Singleton_model {

	public static void main(String[] args) {
		
		Singleton s1 = Singleton.s;
		
	}
}



class Singleton{
	
	private Singleton(){} 
	public static final Singleton s = new Singleton();
	
	
	/*
	//饿汉式 
	//私有构造方法 其它类不能访问
	private Singleton(){	}	
	//成员变量被私不能通过类名.调用
	private static Singleton singleton = new Singleton();	
	//对外提供公共的统一方法,获取返回类的对象
	public static Singleton  getSingleton(){
		
		return singleton;
	}
	
	//懒汉式 单例的延迟加载模式
	//私有构造方法 其它类不能访问
	private Singleton(){	}	
	//成员变量被私不能通过类名.调用
	private static Singleton singleton;
	public static Singleton getSingleton() {
		
		if (singleton == null) {
			//如果在多线程中 线程1等待，线程2等待，可能会多次创建，演变成非单例模式
			singleton = new Singleton();
		}
		return singleton;
	}*/
	
	/*
	 * 饿汉式：空间换时间 多线程访问时，不会创建多个对象
	 * 懒汉式：时间换空间（不推荐使用） 多线程访问时有可能会创建多个对象
	 * */
	
}