package com.cn.lambda;

import java.util.Arrays;

public class lambdaArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] arr1 = new String[]{"oneeee","two","three","four"};
		Arrays.parallelSort(arr1, (o1,o2)->o1.length() - o2.length());
		System.out.println(Arrays.toString(arr1));
		
		
		//left代表数组中前一个索引处的元素，计算第一个元素是，left为1
		//right代表数字中当前索引出的元素
		int[] arr2 = new int[]{3,-4,25,19,30,18};
		Arrays.parallelPrefix(arr2, (left, right)->left*right);
		System.out.println(Arrays.toString(arr2));
		
		long[] arr3 = new long[5];
		//operand代表正在计算的元素索引
		Arrays.parallelSetAll(arr3, operand-> operand*5);
		System.out.println(Arrays.toString(arr3));

	}

}
