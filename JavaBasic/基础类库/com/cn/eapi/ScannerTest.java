package com.cn.eapi;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.in 代表标准输入 键盘
		Scanner sc  = new Scanner(System.in);
		//将把回车作为分隔符
		sc.useDelimiter("\n");
//		sc.hasNextLine() 返回输入源是否还有下一行
//		sc.nextLine() 返回输入源中下一行的字符串
		while (sc.hasNext()) {
			
			//输出输入项
			System.out.println("键盘输入内容是："+sc.next());
//			String string = (String) sc.next();
//			System.out.println("***"+string);
			
		}

	}

}
