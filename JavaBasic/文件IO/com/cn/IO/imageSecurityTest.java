package com.cn.IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class imageSecurityTest {

	public static void main(String[] args) throws IOException{
		
		
//		BufferedInputStream inputStream = new BufferedInputStream( new FileInputStream("A/5.png"));
//		BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("copy.png"));
		
		//通过相同的字节流被异或两次就是其本身解密
		BufferedInputStream inputStream = new BufferedInputStream( new FileInputStream("copy.png"));
		BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("copyre.png"));
		
		int b;
		
		while ((b = inputStream.read()) != -1) {
			
			outputStream.write(b^1234);
		}
		
		
		
		
		inputStream.close();
		outputStream.close();
	}
	
}
