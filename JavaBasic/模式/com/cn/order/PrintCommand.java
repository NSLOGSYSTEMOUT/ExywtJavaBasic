package com.cn.order;

public class PrintCommand implements Command {

	@Override
	public void process(int[] target) {
		// TODO Auto-generated method stub
		
		for (int i : target) {
			System.out.println("输出数组为:"+ i);
		}

	}

}
