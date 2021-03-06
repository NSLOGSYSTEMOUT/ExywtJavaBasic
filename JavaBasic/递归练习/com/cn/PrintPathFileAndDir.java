package com.cn;

import java.io.File;
import java.math.BigInteger;

public class PrintPathFileAndDir {

	public static void main(String[] args) {
		
		BigInteger big1 = new BigInteger("1");
		for (int i = 1; i <= 1000; i++) {
			
			BigInteger big2 = new BigInteger(i+"");
			big1 = big1.multiply(big2);  //相乘
		}
		
		String str = big1.toString();  //获取字符串的表现形式
		
		int count = 0;
		
		for (int i = 0; i < str.length(); i++) {
			
			if ('0' == str.charAt(i)) {
				count++;
			}
		}
		System.out.println(count);
		
		//获取文件夹调用
		File dir = CountFileSize.getDir();
		printLev(dir,0);
	}
	
	public static void printLev(File dir, int lev) {
		
		//把文件夹中的文件与文件在按层级打印
		File[] subFils = dir.listFiles();
		
		for (File file : subFils) {
			
			for(int i =0; i < lev; i++){
				System.out.print("\t");
			}
			
			System.out.println(file);
			if (file.isDirectory()) {
				
				printLev(file, lev+1);
			}
			
		}
	}
}
