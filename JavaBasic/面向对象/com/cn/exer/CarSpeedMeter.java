package com.cn.exer;

import com.cn.jiekou.Output;

public class CarSpeedMeter extends SpeedMeter {

	@Override
	public double getRadius() {
		// TODO Auto-generated method stub
		return 0.28;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CarSpeedMeter speed = new CarSpeedMeter();
		speed.setTurnRate(15);
		System.out.println(speed.getSpeed());
		
		int i = Output.Max_Cache_Line;
		System.out.println(i);
		System.out.println(Output.staticTest());
	}

}
