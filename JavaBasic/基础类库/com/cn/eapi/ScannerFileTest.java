package com.cn.eapi;

import java.io.File;
import java.util.Scanner;

public class ScannerFileTest {

	public static void main(String[] args) throws Exception{
		
		Scanner sc = new Scanner(new File("/Users/sai/Desktop/ExywtJavaBasic/JavaBasic/基础类库/com/cn/eapi/ScannerFileTest.java"));
		System.out.println("scannerFileTest文件内容：");
		while (sc.hasNextLine()) {
			
			System.out.println(sc.nextLine());
		}
	}
}
