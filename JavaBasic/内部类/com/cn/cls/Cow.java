package com.cn.cls;

public class Cow {

	private  double weight;
	
	public Cow(){};
	public Cow(double weight){
		this.weight = weight;
	}
	
	
	private class CowLeg{
	
		private double length;
		private String color;
		
		public CowLeg(){};
		
		public CowLeg(double length, String color){
			this.length = length;
			this.color = color;
		}
		
		public double getLength() {
			return length;
		}

		public void setLength(double length) {
			this.length = length;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}
		
		
		public void info(){
			
			System.out.println("当前牛颜色："+color +",高"+length);
			System.out.println("牛牛weight"+weight);
			
		}
	}
	
	public void test(){
		
		CowLeg cl = new CowLeg(123,"亚瑟");
		cl.info();
		
	}
	
	public static void main(String[] args){
		
		Cow c = new Cow();
		c.test();
	}
}
