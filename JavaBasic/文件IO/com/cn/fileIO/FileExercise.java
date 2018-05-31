package com.cn.fileIO;

import java.io.File;
import java.util.Scanner;

public class FileExercise {

	public static void main(String[] args) {
		
		File dir = getDir();
		printPathName(dir);
		
	}
	
	public static File getDir(){
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("input file path");
		
		while (true) {
			
			String path = scanner.nextLine();
			File file = new File(path);
			
			if (! file.exists()) {
				System.out.println("path error again");
			}else if (file.isFile()) {
				System.out.println("get is 文件夹路径");
			} else {
				return file;
			}
		}
	}
	///Users/sai/Desktop/ExywtJavaBasic/JavaBasic/文件IO/com
	public static void printPathName(File file) {
		
		File[] subFiles = file.listFiles();
		
		for (File subFile : subFiles) {
			
			if (subFile.isFile() && subFile.getName().endsWith(".java") ) {
				System.out.println(subFile);
			//如果是文件夹就递归调用
			} else if(subFile.isDirectory()) {
				
				printPathName(subFile);
			}
		}
	}
}
