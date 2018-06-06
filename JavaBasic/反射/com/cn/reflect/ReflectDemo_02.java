package com.cn.reflect;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReflectDemo_02 {

	public static void main(String[] args) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException {
		
		//通过多态
		/*
		Juicer jce = new Juicer();
//		1.改进后的代码抽象一个Fruit的接口，让水果类implements （多态）
		jce.run(new Apple());
		jce.run(new Orange());
		*/
		
		//通过反射与配置文件
		
		BufferedReader reader = new BufferedReader(new FileReader("config.properties"));
		Class cls = Class.forName(reader.readLine());
		//相当于父类应用指向子类对象 水果的引用指向了Apple对象
		Fruit fruit = (Fruit)cls.newInstance();
		
		Juicer juicer = new Juicer();
		juicer.run(fruit);
		
	}
}

interface Fruit{
	
	public void juice();
}

class Apple implements Fruit{
	
	public void juice() {
		
		System.out.println("juice apple");
	}
}

class Orange implements Fruit{
	
	public void juice() {
		
		System.out.println("juice orange");
	}
}

class  Juicer{
	
	public void run(Fruit fruit){
		
		fruit.juice();
	}
}
