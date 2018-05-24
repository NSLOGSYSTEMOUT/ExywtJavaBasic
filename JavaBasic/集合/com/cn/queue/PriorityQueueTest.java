package com.cn.queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		
		//不允许插入为null的对象 可以自然排序或者定制排序同TreeSet
		//保存队列元素的顺序不是按加入队列的顺序，而是按照队列元素的大小进行重新排序。
		PriorityQueue pQueue = new PriorityQueue<>();
		pQueue.offer(6);
		pQueue.offer(-3);
		pQueue.offer(20);
		pQueue.offer(18);
		
		//可能并没有很好的按照大小排序因为toString方法的返回值影响
		System.out.println(pQueue);
		
		//调用多次移除方法从小到大一次移除队列 
		System.out.println(pQueue.poll());
	}
}
