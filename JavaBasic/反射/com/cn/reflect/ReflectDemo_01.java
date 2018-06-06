package com.cn.reflect;

import com.cn.bean.Person;

public class ReflectDemo_01 {

	public static void main(String[] args) throws ClassNotFoundException {
		
		//通过三种方式获得字节码对象
		Class cls = Class.forName("com.cn.bean.Person");
		
		Class cls2 = Person.class;
		
//		Person person = new Person();
		
//		Class cls3= person.getClass();
		
		
		//true
		System.out.println(cls == cls2);
//		System.out.println(cls2 == cls3);
	}
}
