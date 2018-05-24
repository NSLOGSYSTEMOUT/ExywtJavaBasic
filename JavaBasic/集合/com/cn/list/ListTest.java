package com.cn.list;


import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

class A{

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return true;
	}
	
	
}

public class ListTest {

	public static void main(String[] args) {
		
		List<String> books =  new ArrayList();
		books.add(new String("java ee excerse"));
		books.add(new String("java jiang yi"));
		books.add(new String("andriond ..."));
		
		System.out.println(books);
		
		for (int i = 0; i < books.size(); i++) {
			
			System.out.println(books.get(i));
		}
		
		books.set(1, new String("one"));
		//不包括3
//		System.out.println(books.subList(0, 3));
		
		//List两个对象相等只要通过equals方法比较返回true即可
		//导致第一个元素被删除 A实现的equal方法返回true认为对象相同
//		books.remove(new A());
//		System.out.println(books);
		
		//java8中新增的方法
		books.sort((o1,o2)->(((String)o1).length() -((String)o2).length())
		);
		
		System.out.println(books);
		
//		books.replaceAll(ele->((String)ele).length());
		System.out.println(books);
		
//		ListIterator 增加了向前迭代的功能
		ListIterator lis1 = books.listIterator();
		
		while (lis1.hasNext()) {
			Object object = (Object) lis1.next();
			
		}
		
		while (lis1.hasPrevious()) {
			
		}
		
	}
}
