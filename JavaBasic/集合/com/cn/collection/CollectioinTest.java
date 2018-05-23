package com.cn.collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import javax.lang.model.type.NullType;

public class CollectioinTest {

	public static void main(String[] args) {
		
		Collection books = new HashSet<>();
		
		books.add("one");
		books.add("two");
		books.add("three");
		
		books.forEach(obj->System.out.println("迭代元素为"+obj));
		
		
		Iterator<String> it = books.iterator();
		while (it.hasNext()) {
			
			String string = (String) it.next();
			System.out.println(string);
			
			if (string.equals("one")) {
			
//				不可以修改
//				books.remove(string);
				it.remove();
			
			}
			//对集合赋值不会高改变集合元素本身
			string = "测试字符串";
			
		}
		
		System.out.println(books);
		
		Iterator<String> iterator = books.iterator();
		iterator.forEachRemaining(obj -> System.out.print("biedaiyuansu "+obj));
		
		
		
	}
}
