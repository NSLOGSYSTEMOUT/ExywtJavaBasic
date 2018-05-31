package com.cn.fileReader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Arrays;

public class ReaderTest {

	public static void main(String[] args) throws IOException {
	
//		Demo_03_copyWriter();
		
	}
	
	public static void Demo_06_linenumber() throws IOException{

		 LineNumberReader reader = new LineNumberReader(new FileReader("bbb.txt"));
		 
		 String line;
		 
		 while ((line = reader.readLine()) != null) {
			
			 System.out.println(line + reader.getLineNumber());
		}

		 reader.close();
	}
	
	public static void Demo_05_reverse() throws IOException{
		
		//输入输出流尽量早开早关
		BufferedReader reader = new BufferedReader(new FileReader("bbb.txt"));
		
		ArrayList<String> list = new ArrayList<>();
		String line;
		
		while ((line = reader.readLine()) != null) {
			
			list.add(line);
			
		}
		reader.close();
		
		BufferedWriter writer = new BufferedWriter(new FileWriter("copybbb.txt"));
		for(int i= list.size()-1 ; i>=0 ; i--){
			
			writer.write(list.get(i));
			writer.newLine();
		}
		
		
		writer.close();
	}
	
	public static void Demo_04_bufferReader() throws IOException{
		
		BufferedReader reader = new BufferedReader(new FileReader("bbb.txt"));
		BufferedWriter writer = new BufferedWriter(new FileWriter("bbbcopy.txt"));
		
		String len;
		
		while ((len = reader.readLine())!= null) {
			
//			System.out.println(len);
			writer.write(len);
			
			//写出回车换行符 
			writer.newLine();   //跨平台的方法
//			writer.write("\r\n");  //只支持windows系统
		}
		reader.close();
		writer.close();
//		BufferedWriter writer = new BufferedWriter(new FileWriter("yyy.txt"));
//		
//		int len;
//		
//		while ((len = reader.read()) != -1) {
//			
//			writer.write(len);
//		}
//		
//		reader.close();
//		writer.close();
	}
	
	public static void Demo_03_copyWriter() throws IOException{
		
		//只可以拷贝纯文本的文件
		//字符流可以拷贝文件但是不推荐使用读取时把字节转换为字符，写出是还要把字节转化为字符
		FileReader fileReader = new FileReader("bbb.txt");
		FileWriter fileWriter = new FileWriter("copybbbb.txt");
		//自定义的缓冲区
		char[] cs = new char[1024*4];
		int b ;
		
		while ((b = fileReader.read(cs))!= -1) {
			
//			System.out.println(b);
//			fileWriter.write(b);
			fileWriter.write(cs, 0, b);
		}
		
		fileReader.close();
		fileWriter.close();  //Writer中有一个2k的缓冲区，如果不关闭会将内容写入到缓存区中 
	}
	
	public static void Demo_02_writer() throws IOException{
		
		FileReader fileReader = new FileReader("bbb.txt");
		
		FileWriter fileWriter = new FileWriter("bbb.txt",true);
		fileWriter.write("新添加的字符"); //可以直接写字符串，底层转换为字节流写入到文件中
		
		int b;
		
		while ((b = fileReader.read())!= -1) {
			
			System.out.print((char)b);
		}
		
		fileReader.close();
		fileWriter.close();
	}
	
	public static void Demo_01() throws IOException{
		
	FileReader  fileReader = new FileReader("bbb.txt");
		
		int x = fileReader.read();
		System.out.println(x);
		char  c = (char)x;
		System.out.println(c);
		fileReader.close();
	}
}
