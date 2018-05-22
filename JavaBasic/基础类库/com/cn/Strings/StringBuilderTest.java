package com.cn.Strings;

public class StringBuilderTest {

	public static void main(String[] args) {

//		StringBuffer线程安全开销大 StringBuilder线程不安全
		StringBuilder builder = new StringBuilder();
		builder.append("java");
		builder.insert(0, "hello ");
		builder.replace(5, 6, ",");
		builder.delete(5, 6);
		
		System.out.println(builder);
		
		builder.reverse();
		System.out.println(builder);
		
		System.out.println(builder.length());
		System.out.println(builder.capacity());
		
		builder.setLength(5);
		System.out.println(builder);
		
		//可变字符串转换为不可变字符串
		String str = builder.toString();
		
	}
}
