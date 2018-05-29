package com.cn.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;

import javax.swing.InputMap;

public class IOtest {

	/**
	 * 字节流可以处理任何数据（都是以字节流的形式存储的）
	 * 字符流只能操作纯字符数据
	 * @throws IOException 
	 * */
	
	public static void main(String[] args) throws IOException {
		
		//
		FileInputStream inputStream  = new FileInputStream("bbb.txt");
		FileOutputStream outputStream = new FileOutputStream("copyb.txt");
		
		byte[] arr=new byte[1024 * 8];
		int len;
		
		//arr忘记传入参数，返回的就不是读取的字节数而是字节的码表值
		while ((len = inputStream.read(arr)) != -1) {
			
			outputStream.write(arr,0,len);
		}
		
		inputStream.close();
		outputStream.close();
	}
	
	public static void Demo_05_defineArr() throws IOException{
		
		//自定义字节数组
				FileInputStream  fileInputStream = new FileInputStream("bbb.txt");
				FileOutputStream outputStream  = new FileOutputStream("yyy.txt");
				byte[] arry = new byte[2];
				
				int len;
				
				while ((len = fileInputStream.read(arry)) != -1) {
					
					outputStream.write(arry,0,len);
				}
				
				fileInputStream.close();
				outputStream.close();
				
				//将文件上的字节读取到字节数组中
				/*int a = fileInputStream.read(arry);
//				System.out.println(a); 读取到的有效字节个数
				System.out.println(a);
				for (byte b : arry) {
					
					System.out.println(b);
				}
				
				System.out.println("_______");
				int c= fileInputStream.read(arry);
				System.out.println(c);
				for (byte b : arry) {
					
					System.out.println(b);
				}
				
				fileInputStream.close();*/
	}
	
	public static void Demo_04() throws IOException{
		
//		效率高些
		//输入流对象
		FileInputStream inputStream = new FileInputStream("A/5.png");
//		输出流对象
		FileOutputStream outputStream = new FileOutputStream("copy5Arr.png");
		//返回目标文件的大小
//		int len = inputStream.available();
		byte[] arr= new byte[inputStream.available()];
		
//		目标文件过大会造成内存溢出 不推荐使用
		//读取到字节数组
		inputStream.read(arr);
		//将字节数组写到文件中
		outputStream.write(arr);

		inputStream.close();
		outputStream.close();
	}
	
	public static void Demo_03() throws IOException {
		
//		拷贝一张图片 逐个字节拷贝 效率低 小文件的
		//输入流对象
		FileInputStream inputStream = new FileInputStream("A/5.png");
//		输出流对象
		FileOutputStream outputStream = new FileOutputStream("copy5.png");
		
		int b;
		
		while ((b = inputStream.read()) != -1) {
			
			outputStream.write(b);
		}

		inputStream.close();
		outputStream.close();
	}
	
	public static void Demo_02() throws IOException{
		
		//创建字节输出流对象如果没有文件自动创建一个
//		FileOutputStream outputStream = new FileOutputStream("bbb.txt");
		FileOutputStream outputStream = new FileOutputStream("bbb.txt", true); //文件是否续写
		
		//写入的为int类型 文件上的是一个字节会自动去除前三个八位
		outputStream.write(97);
		outputStream.write(98);
		outputStream.write(99);
//		outputStream.write(100);
		outputStream.write(97);
		outputStream.write(98);
//		

//		outputStream.write(12);
		
		outputStream.close();
	}
	
	public static void Demo_01() throws IOException{
		
		//字节流 抽象类不能直接生成对象的InputStream OutputStream
		//字符流：Writer Reader
//		FileInputStream
//	创建流对象
		FileInputStream fileInputStream = new FileInputStream("ccc.txt");
		//硬盘上读取一个字节
		
//		int x = fileInputStream.read();
//		System.out.println(x);
//		
//		int y = fileInputStream.read();
//		System.out.println(y);
		//一次读取一个字节，文件结束标志位-1不是有效的字节
		
		int r; //read()读取的为Byte却使用int返回接收 -1会停止遍历损失精度反码补码的形式
		
		while ((r=fileInputStream.read() )!=-1) {
			
			System.out.println(r);
		}
		
//		关闭释放资源
		fileInputStream.close();
	}
}

