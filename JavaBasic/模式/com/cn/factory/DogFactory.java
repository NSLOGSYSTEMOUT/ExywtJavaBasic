package com.cn.factory;

public class DogFactory implements FactoryInterface {

	@Override
	public Animal createAnimal() {
		// TODO Auto-generated method stub
		return new Dog_1();
	}

}
