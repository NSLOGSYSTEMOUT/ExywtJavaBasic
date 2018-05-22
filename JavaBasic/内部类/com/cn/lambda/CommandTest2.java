package com.cn.lambda;
import com.cn.order.ProcessArray;

public class CommandTest2 {

	public static void main(String[] args) {
		
		ProcessArray pa = new ProcessArray();
		
		int array[] = {3,-4,15,6};
		
		pa.process(array, (int[] target)->{
			
			int sum = 0;
			for (int i : array) {
				sum += i;
			}
			System.out.println(sum);
		});
	}
}
