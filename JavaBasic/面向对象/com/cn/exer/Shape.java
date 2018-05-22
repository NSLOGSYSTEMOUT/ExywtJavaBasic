package com.cn.exer;

public abstract class Shape {
	
	{
		System.out.println("执行shape初始化模块...");
	}
	
	private String color;
	public abstract double calPerimeter();
	public abstract String getType();

	public Shape(){}
	public Shape(String color){
		System.out.println("执行shape构造器方法...");
		this.color = color;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	

}
