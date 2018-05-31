package com.cn;

import java.io.File;
import java.util.Scanner;

public class CountFileSize {

	public static void main(String[] args) {
		
		File dir = getDir();
		
		long len = getFileLength(dir);
		System.out.println(len/1024);
		
	}
	
	public static File getDir(){
		
		Scanner  sc = new Scanner(System.in);
		System.out.println("请输入一个文件夹的路径");
		
		while (true) {
			String line = sc.nextLine();
			
			File file = new File(line);
			
			if ( !file.exists()) {
				System.out.println("文件夹路径不存在");
			}else if (file.isFile()) {
				
				System.out.println("is 文件路径，请输入一个文件夹路径");
			}  else{
				
				return file;
			}
		}
		
	}
	
	public static long getFileLength(File dir) {
		long len = 0;
		
		File[] files = dir.listFiles();
		for (File file : files) {
			
			if (file.exists()) {
				
				len = len + file.length();
			} else {
				len = len +getFileLength(file);
			}
		}
		return len;
	}
}
