package com.cn.collection;

import java.util.stream.IntStream;

public class SteamTest {

	public static void main(String[] args) {
		
		IntStream intStream = IntStream.builder().add(20).add(13).add(-2).add(18).build();
		
		//下面调用聚集方法的代码每次只能执行一行
//		System.out.println("is 所有元素的最大值为："+ intStream.max().getAsInt());
//		System.out.println("元素最小值为"+intStream.min().getAsInt());
//		System.out.println("元素总和为"+intStream.sum());
//		System.out.println("元素个数为"+intStream.count());
//		System.out.println("元素平均值为"+intStream.average());
//		System.out.println("元素平方是否都大于20"+intStream.allMatch(ele->ele*ele >20));
		//将 映射一个新Stream 每个元素是Stream元素的2倍加1
		IntStream newIs = intStream.map(ele->ele*2+1);
		newIs.forEach(System.out::println);
	}
}
