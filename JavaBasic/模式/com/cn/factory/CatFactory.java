package com.cn.factory;

public class CatFactory implements FactoryInterface {

	@Override
	public Animal createAnimal() {
	
		return new Cat_1();
	}

}
