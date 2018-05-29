package com.cn.IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class CopyFileTest {

	
	public static void main(String[] args) throws IOException{
		
//		File file = getFile();
//		
//		BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));
//		
//		BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file.getName()));
//		
//		int b;
//		
//		while ( (b = inputStream.read()) != -1) {
//			
//			outputStream.write(b);
//		}
//		
//		inputStream.close();
//		outputStream.close();
		
		//将键盘录入的数据拷贝到当前项目下的text.txt文件中 键盘录入遇到quit时就退出
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入数据");
		BufferedOutputStream writeTo = new BufferedOutputStream(new FileOutputStream("text.txt"));
		
		while (true) {
		
			String string = scanner.nextLine();
			
			if ("quite".equals(string)) {
				
				System.out.println("输入结束");
				break;
			}
			
			writeTo.write(string.getBytes());
			writeTo.write("\r\n".getBytes());
		}
		
		writeTo.close();
	}
	
	
	
	public static File getFile() {
		
		Scanner scanner = new Scanner(System.in); // 创建键盘录入对象
		System.out.println("Path:");
		while (true) {
			
			String path = scanner.nextLine();  //接受键盘输入的路径
			File isFile = new File(path);      //封装成File对象并对其进行判断
			
			if (!isFile.exists()) {
				
				System.out.println("路径不存在");
			} else if(isFile.isDirectory()) {
				System.out.println("输入的为文件夹路径重新录入");
			} else {
				
				return isFile;
			}
		}
		
	}
}
