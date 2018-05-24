package com.cn.queue;

import java.util.ArrayDeque;

public class ArrayDequeStackTest {

	
	public static void main(String[] args) {
		
		ArrayDeque<String> stack = new ArrayDeque<>();
		
		//当做栈使用
		stack.push("jvav one");
		stack.push("java two");
		stack.push("java three");
		
		//以栈的方式输出 先进后出
		System.out.println(stack);
		//输出栈顶第一个元素
		System.out.println(stack.peek());
		
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack);
		
		//当做队列使用 先进先出
		ArrayDeque queue = new ArrayDeque<>();
		queue.offer("queue one");
		queue.offer("queue two");
		queue.offer("queue three");
		
		System.out.println(queue);
		System.out.println(queue.peek());
		
		System.out.println(queue.poll());
	}
}
