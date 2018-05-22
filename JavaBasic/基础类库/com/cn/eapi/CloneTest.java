package com.cn.eapi;

import java.net.URI;

import javax.jws.soap.SOAPBinding.Use;

class Address{
	String detail;
	public Address(String detail) {
		// TODO Auto-generated constructor stub
		this.detail = detail;
	}
}

class User implements Cloneable{
	
	int age;
	Address address;
	
	public User(int age) {
		// TODO Auto-generated constructor stub
		this.age = age;
		address = new Address("广州");
		
	}
	
	//通过super.clone()来实现clone()方法
	public User clone() throws CloneNotSupportedException{
		
		return (User)super.clone();
	}
}


public class CloneTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		User u1 = new User(29);
		User u2 = u1.clone();

		//判断u1 u2 是否相同
		System.out.println( u1 == u2 );  //fale

		System.out.println(u1.address == u2.address); //true
	}
}
