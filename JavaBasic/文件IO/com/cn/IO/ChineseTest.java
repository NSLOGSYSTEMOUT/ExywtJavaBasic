package com.cn.IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class ChineseTest {

	public static void main(String[] args) throws IOException {
		
		//1.7版本 流对象会自动关闭 实现了AutoCloseable接口中的close方法
		try(
				FileInputStream fileInputStream = new FileInputStream("bbb.txt");
				FileOutputStream fileOutputStream = new FileOutputStream("bbb.txt");		
		){
		
			int b;
			while ((b = fileInputStream.read()) != -1) {
				
				fileOutputStream.write(b);
			}
//			fileInputStream.close();
//			fileOutputStream.close();
		}
		
		
		
	}
	
	
	public  static void Demo_01() throws IOException{
		
		FileInputStream fileInputStream  = null;
		FileOutputStream outputStream = null;
		try {
			//一个中文两个字节 使用字节流读取会有问题 字符流
			fileInputStream = new FileInputStream("bbb.txt");
			outputStream = new FileOutputStream("bbb.txt",true);
			outputStream.write("扣扣".getBytes()); //getBytes变为字节数组写入
			
			byte[] arr1 = new byte[3];
			
			int b;
			while ((b = fileInputStream.read(arr1)) != -1) {
				
				System.out.print(new String(arr1, 0, b));
			}
			
		}  finally {
			
			//try catch 的嵌套 尽量关闭一个流
			try{
				if (fileInputStream != null) {
					fileInputStream.close();	
				}
				
			} finally {
				if (outputStream !=  null) {
					outputStream.close();	
				}
			}
		}
	}
}
