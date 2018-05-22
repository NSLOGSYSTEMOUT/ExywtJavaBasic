package com.cn.lambda;

import com.cn.order.Command;
import com.cn.order.ProcessArray;

public class CommandTest {

	public static void main(String[] args) {
		
		ProcessArray pa = new ProcessArray();
		int [] target = {3,-4,6,5};
		
		pa.process(target, new Command() {
			
			@Override
			public void process(int[] target) {
				// TODO Auto-generated method stub
				
				int sum = 0;
				for (int tmp : target) {
					sum += tmp;
				}
				
				System.out.println(sum);
			}
		});
	}
}
