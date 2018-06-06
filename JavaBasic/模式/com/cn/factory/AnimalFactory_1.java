package com.cn.factory;

public class AnimalFactory_1 {
	/*
	public static Dog getDog() {
		
		return new Dog();
	}
	
	public static Cat getCat() {
		
		
		return new Cat();
	}*/
	
	
	//当方法很多时候
	public static Animal createAnimal(String name){
		
		if ("dog".equals(name)) {
			return new Dog_1();
		} else  if ("cat".equals(name)) {
			return new Cat_1();
		}else{
			return null;
		}
	} 
}
