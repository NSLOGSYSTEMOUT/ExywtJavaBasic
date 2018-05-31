package com.cn;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyDirToAnother {

	public static void main(String[] args) throws IOException {
		
		File dir1 = CountFileSize.getDir();
		File toDir = CountFileSize.getDir();
		if (dir1.equals(toDir)) {
			System.out.println("目标文件夹是源文件夹的子文件夹");
		}else {
			copy(dir1, toDir);
		}
		
	}
	
	public static void copy(File file, File toFile) throws IOException{
		
		//在目标文件夹中创建文件夹
		File newDir2 = new File(toFile, file.getName());
		newDir2.mkdir();
		
		//获取原文件夹的所有的文件和文件夹 存储在File数组中
		File[] subFiles = file.listFiles();
		
		for (File subFile : subFiles) {
			
			if (subFile.isFile()) {
				BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(subFile));
				BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(new File(newDir2, subFile.getName())));
				
				int b;
				while ((b = inputStream.read())!= -1) {
					outputStream.write(b);
				}
				
				inputStream.close();
				outputStream.close();
			} else {
				//如果是文件夹就递归调用
				copy(subFile,newDir2);
			}
		}
	}
}
