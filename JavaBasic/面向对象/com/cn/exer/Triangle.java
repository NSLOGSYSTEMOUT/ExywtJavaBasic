package com.cn.exer;

public class Triangle extends Shape {

	private double a;
	private double b;
	private double c;
	
	public Triangle(String color, double a, double b, double c){
		super(color);
		this.setSides(a, b, c);
	}
	
	public void setSides(double a, double b, double c){
		if( a>= b+c || b >= a+c || c>= a+b){
			System.out.println("不合法");
			return;
		}
		this.a = a ;
		this.b = b ;
		this.c = c;
	}
	
	@Override
	public double calPerimeter() {
		// TODO Auto-generated method stub
		return a+b+c;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "三角形";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Triangle t = new Triangle("red",3,4,5);
		System.out.println(t.calPerimeter());
		System.out.println(t.getType());
		System.out.println(t.getColor());
	}

}
