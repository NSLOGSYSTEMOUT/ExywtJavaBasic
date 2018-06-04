package com.cn;

import java.util.ArrayList;

public class CircleYueTest {

	public static void main(String[] args) {
		
		System.out.println(getLuckyNumber(9));
	}
	
	public static int getLuckyNumber(int num) {
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int i = 1; i <= num; i++) {
			list.add(i);
		}
		
		int cout = 1;
		for (int i = 0; list.size() != 1; i++) {
			
			if (i == list.size()) {
				i = 0;
			}
			

			if (cout % 3 == 0) {
				
				list.remove(i--);
			}
			cout ++;
		}
		
		return list.get(0);
	}
}
