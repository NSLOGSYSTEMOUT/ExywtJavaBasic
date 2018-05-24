package com.cn.hashSet;

import java.util.LinkedHashSet;

public class LinkHashSetTest {

	public static void main(String[] args) {
		LinkedHashSet<String> books = new LinkedHashSet<String>();
		books.add("java");
		books.add("java ee");
		
		System.out.println(books);
		
		books.remove("java");
		books.add("java");
		
		//元素为位置与添加的顺序一致
		System.out.println(books);
	}
	
	
}
