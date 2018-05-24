package com.cn.hashSet;

import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;

enum Season{
	SPTING,SUMMER,FALL,WINTER
}

public class EnumSetTest {
	//这几种Set线程不安全的 Collections.synchronizedSortedSet() 包装最好在创建的时候进行
	public static void main(String[] args) {
		
		EnumSet s1 = EnumSet.allOf(Season.class);
		System.out.println(s1);
		
		//创建一个EnumSet空集合，指定其集合元素是Season类的枚举值
		EnumSet<Season> s2 = EnumSet.noneOf(Season.class);
		System.out.println(s2);
		s2.add(Season.WINTER);
		s2.add(Season.SPTING);
		System.out.println(s2);
		
		//以指定的枚举值创建EnumSet集合
		EnumSet<Season> s3 = EnumSet.of(Season.SUMMER, Season.WINTER);
		System.out.println(s3);
		
		EnumSet<Season> s4 = EnumSet.range(Season.SUMMER, Season.WINTER);
		System.out.println(s4);
		
		//新创建的EnumSet集合和s4集合元素有相同的类型
		//s5集合元素+s4集合元素= Season枚举类的全部枚举值
		EnumSet<Season> s5 = EnumSet.complementOf(s4);
		System.out.println(s5);
		
		
		//当赋值Collection集合中的所有元素来创建新的EnumSet集合时要求Collection集合中的所有元素必须是同一个枚举类的枚举值
		Collection c = new HashSet<>();
		c.clear();
		c.add(Season.FALL);
		c.add(Season.SPTING);
		
		//复制Collection集合中的所有元素来创建EnumSet集合
		EnumSet enumSet = EnumSet.copyOf(c);
		System.out.println(enumSet);
		
		c.add("java");
		c.add("java ee");
		enumSet = EnumSet.copyOf(c);
		System.out.println(enumSet); //抛出异常集合添加的元素枚举类型不同
		
	}
}
