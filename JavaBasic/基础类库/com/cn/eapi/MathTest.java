package com.cn.eapi;

import java.util.concurrent.ThreadLocalRandom;

public class MathTest {

	public static void main(String[] args) {
		
		//弧度转换为角度
		System.out.println(Math.toDegrees(1.23));
		
		//角度转换为弧度
		System.out.println(Math.toRadians(90));
		
		//计算反余弦，返回角度在0.0到pi之间
		System.out.println(Math.acos(1.2));
		
		//将矩形坐标转换为极坐标
		System.out.println(Math.atan2(0.1,0.2));
		
		//取整 返回小于目标数的最大整数
		System.out.println(Math.floor(-1.2));
		
		//取整 返回大于目标数的最小整数
		System.out.println(Math.ceil(-1.2));
		
		//四舍五入取整数
		System.out.println(Math.round(2.3));
		
		//立方根平方跟 指数幂运算
		//返回sqrt(x2+y2)没有中间溢出或下溢出
		System.out.println(Math.hypot(4, 4));
		//余数运算‘
		System.out.println(Math.IEEEremainder(5, 2));
		System.out.println(Math.log(4));
		
		//计算绝对值
		System.out.println(Math.abs(-12));
		//计算最大值 最小值
		//返回第一个参数和第二个参数之间与第一个参数相邻的浮点数
		System.out.println(Math.nextAfter(1.2, 1.0));
		
	}
}
