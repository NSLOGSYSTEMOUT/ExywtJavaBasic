package com.cn.factory;

public class TestFactory_1 {

	public static void main(String[] args) {
		
//		Dog dog = AnimalFactory.getDog();
//		dog.eat();
//		Cat cat = AnimalFactory.getCat();
//		cat.eat();
		
		Dog_1 dog = (Dog_1)AnimalFactory_1.createAnimal("dog");
		dog.eat();
		Cat_1 cat = (Cat_1)AnimalFactory_1.createAnimal("cat");
		cat.eat();
	}
}
