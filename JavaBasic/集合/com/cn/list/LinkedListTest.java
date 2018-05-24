package com.cn.list;

import java.util.LinkedList;

public class LinkedListTest {

	public static void main(String[] args) {
		
//		LinkedList实现了List接口可以根据索引来随机访问集合中的元素
//		同时还实现了Deque接口，可以被当成双端队列来使用，因此可以被当做栈来使用
		LinkedList<String> books = new LinkedList<>();
		
		//字符创加入队列的尾部
		books.offer("java one 加入到队列尾部信息");
		//将字符创加入栈的顶部
		books.push("加入到栈顶部的信息");
		//将字符串添加到队列的头部
		books.offerFirst("添加到队列头部的信息");
		
		//以List的方式按索引遍历访问
		
		for (int i = 0; i < books.size(); i++) {
			System.out.println("遍历中："+books.get(i));
		}
		
		//访问不删除栈顶元素
		System.out.println(books.peekFirst());
//		访问不删除队列的最后一个元素
		System.out.println(books.peekLast());
		//栈顶元素 弹出
		System.out.println(books.pop());

		System.out.println(books);
	}
}
