package com.cn.collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.function.Predicate;

public class PredicateTest {

	public static void main(String[] args) {
		
		Collection<String> bookss = new HashSet<String>();
		
		bookss.add(new String("one wojava"));
		bookss.add(new String("onew=twojava"));
		bookss.add(new String("onethreejava"));
		bookss.add(new String("onefor fived"));
		bookss.add(new String("oneforjava fiver"));
		bookss.add(new String("dsa javasd"));
		
		bookss.removeIf(ele->((String)ele).length() <10);
//		System.out.println(books);
		
		//使用Collection的stream()方法可返回该集合对应的Stream对象
		System.out.println("*"+bookss.stream().filter(ele->((String)ele).contains("java")).count());
		
		System.out.println("**"+callAll(bookss, ele->((String)ele).contains("one")));
		System.out.println("***"+callAll(bookss, ele->(ele).contains("java")));
		System.out.println("****"+callAll(bookss, ele->(ele).length()>10));
		
	}
	
	public static int callAll(Collection<String> books, Predicate<String> p){
		
		int total = 0;
		for (String obj : books) {
			//Predicate的test方法
			if (p.test(obj)) {
					
				total+= 1;
			}
		}
		
		return total;
	}
	
	
	
}
