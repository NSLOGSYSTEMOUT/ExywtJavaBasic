package com.cn.xulieAndProperties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class sequenceInputStreamTest {

	public static void main(String[] args)  throws IOException{
		
		FileInputStream firs1 = new FileInputStream(new File("a.txt"));
		FileInputStream firs2 = new FileInputStream("b.txt");
		
		//将两个流整合为一个流
//		SequenceInputStream inputStream = new SequenceInputStream(firs1, firs2);
		
		//整合多个
		Vector< FileInputStream>  vector = new Vector<>(); //创建集合对象
		vector.add(firs1);
		vector.add(firs2);
		Enumeration<FileInputStream> enumeration = vector.elements();
		//将枚举中的输入流整合为一个
		SequenceInputStream inputStream = new SequenceInputStream(enumeration); 
		FileOutputStream outputStream = new FileOutputStream("c.txt");
		
		int b;
		
		while ((b = inputStream.read()) != -1) {
			
			outputStream.write(b);
		}
		
		inputStream.close();
		outputStream.close();
	}
}
