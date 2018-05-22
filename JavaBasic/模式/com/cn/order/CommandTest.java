package com.cn.order;

public class CommandTest {

	public static void main(String[] args){
		
		ProcessArray pa = new ProcessArray();
		int[] target = {2,-4,5,4};
		
		pa.process(target, new PrintCommand());
		pa.process(target, new AddCommand());
	}
}
