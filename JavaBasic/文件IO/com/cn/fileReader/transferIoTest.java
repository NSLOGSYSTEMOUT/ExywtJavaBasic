package com.cn.fileReader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class transferIoTest {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bReader= new BufferedReader(new InputStreamReader(new FileInputStream("utf-8.txt"), "utf-8"));
		BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("gbk.txt"), "gbk"));
		
		int c;
		while ((c = bReader.read()) != -1) {
			
			bWriter.write(c);
		}
		
		bReader.close();
		bWriter.close();
	}
	
	public static void Demo_02_encoding() throws IOException {
		
		//指定的字符编码读取存储
		InputStreamReader streamReader = new InputStreamReader(new FileInputStream("utf-8.txt"), "utf-8");
		OutputStreamWriter streamWriter = new OutputStreamWriter(new FileOutputStream("gbk.txt"), "gbk");
		
		int c;
		
		while ((c = streamReader.read()) != -1) {
			
			streamWriter.write(c);
		}
		
		streamReader.close();
		streamWriter.close();
		
	}
	
	
	
	public static void Demo_01() throws IOException {
		
		//使用默认的编码表读写，乱码
				FileReader reader = new FileReader("utf-8.txt");
				FileWriter writer = new FileWriter("gbk.txt");
				
				int c;
				
				while ((c = reader.read()) != -1) {
					
					writer.write(c);
				}
				
				reader.close();
				writer.close();
	}
}
