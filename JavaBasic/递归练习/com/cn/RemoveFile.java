package com.cn;

import java.io.File;

public class RemoveFile {

	public static void main(String[] args) {
		
		///Users/sai/Desktop/APP适配20170915
		File dir =  CountFileSize.getDir();
		deleteFile(dir);
	}
	
	//删除该文件夹
	public static void deleteFile(File dir) {
		
		File[] subFiles = dir.listFiles();
		
		for (File file : subFiles) {
			 
			if (file.isFile()) {
				file.delete();
			} else {
				deleteFile(file);
			}
		}
		
		//循环结束后删除空的文件夹  否则文件夹不会删除
		dir.delete();
	} 
}
