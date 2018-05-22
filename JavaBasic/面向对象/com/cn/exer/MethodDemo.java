package com.cn.exer;
import java.util.ArrayList;
import java.util.Arrays;

public class MethodDemo {

	
	public void test(){
		
		System.out.println("this调用类中的非static方法");
	}
	
	public void test2(){
		this.test();
		
		Integer b1 = 13;
		Integer b2 = 12;
		System.out.println(Integer.toUnsignedString(-12,16));
		System.out.println("this 2");
		System.out.println('A'==65);
		System.out.println("b1=b2是否成立 = " + (b1==b2));
		
		String s1 = "java";
		String s2 = "ja";
		String s3 = "va";
		String s4 = "ja"+"va";
		String s5 =  s2 + s3;
		System.out.println(s1.equals(s5));
		
				
	
	}
	
	public static void main(String[] args) {
		
		
		
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("hello");
		Class c1 = list1.getClass();
		Class c2 = list1.getClass();
		System.out.println(c1 == c2);
		

		int a []  = new int[]{1,2,2,2,3};
		int b [] = new int[]{4,5,6};
		
		boolean isTrue = Arrays.equals(a, b);
		System.out.println(isTrue);
		
		
		String arraytoString = Arrays.toString(a);
		System.out.println(arraytoString);
		
		int keyInt = Arrays.binarySearch(a, 3);
		int count = 0;
		for(int j = 0;j < a.length;j++){
			
			if(a[j] == 2){
				++count;
				System.out.println(a[j]);
				System.out.println(a[j] +"出现次数"+count+"索引值为："+j);
			}
		}
		
		System.out.println(keyInt);
		
		int c [] = Arrays.copyOfRange(a, 0, 2);
		Arrays.fill(c, Integer.parseInt("123"));
		
		for (int i = 0; i < c.length; i++) {
			System.out.println(c[i]);
		}
		
		
		MethodDemo method = new MethodDemo();
		
		method.test2();
	}
}
