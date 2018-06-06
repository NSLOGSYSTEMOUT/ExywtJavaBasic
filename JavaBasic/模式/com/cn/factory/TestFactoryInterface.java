package com.cn.factory;

public class TestFactoryInterface {

	public static void main(String[] args) {
		
		DogFactory dogFactory = new DogFactory();
		Dog_1 dog = (Dog_1)dogFactory.createAnimal();
		dog.eat();
		
		
		CatFactory catFactory = new CatFactory();
		Cat_1 cat = (Cat_1)catFactory.createAnimal();
		cat.eat();
		
	}
}
