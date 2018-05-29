package com.cn.fileIO;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class FileTest {

	
	public static void main(String[] args) throws IOException  {
		
	
		File dirImag = new File("/Users/sai/Desktop/picture/");
		
		//文件名称过滤器
		String[] arr=  dirImag.list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				File fileName = new File(dir, name);
				
				return fileName.isFile() && fileName.getName().endsWith(".png");
			}
		});
		
		for (String string : arr) {
		
			System.out.println(string);
		}
		
		
	}
	
	public static void Demo_05() {
		
		File dir = new File("/Users/sai/Desktop/桌面文件/Base64G");
		String[] strArray  = dir.list();
		for (String string : strArray) {
			
			System.out.println(string);
		}
		
		File[] subFile = dir.listFiles();
		
		for (File file : subFile) {
			
			System.out.println(file);
		}
		
		System.out.println("***********");
		
		File dirImag = new File("/Users/sai/Desktop/picture/640x1136");
		String[] string= dirImag.list();
		
		for (String string2 : string) {
			
			if (string2.endsWith(".png")) {
				System.out.println(string2);
			}
		}
		
		System.out.println("*****");
		File files = new File("/Users/sai/Desktop/picture");
		
		File[] subFiles = files.listFiles();
		for (File file : subFiles) {
			//获取当前路径下的文件夹的所有文件
			System.out.println(file);
			if (file.isFile() && file.getName().endsWith(".png")) {
				System.out.println(file);
			}
		}
	}
	
	public static void Demo_04() throws IOException {
		 File createFile =  new File("ccc.txt");
		 createFile.createNewFile();
		 //获取绝对路径
		 System.out.println(createFile.getAbsolutePath());
		 //获取构造方法中传入的路径
		 System.out.println(createFile.getPath());

		 //获取文件或者文件夹的名字
		 System.out.println(createFile.getName());
		 System.out.println(createFile.length());
		 //最后一次的修改时间
		 System.out.println(createFile.lastModified());
		 Date date = new Date(createFile.lastModified());
		 SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:MM:SS");
		 
		 System.out.println(format.format(date));
	}
	
	public static void Demo_03() {
//		File file1 = new File("readme.txt");
//		File file2 = new File("changeR");
//		System.out.println(file1.renameTo(file2));

		File dir = new File("C");
		System.out.println(dir.isDirectory());
		
		File dir2 = new File("changeR");
		dir2.setReadable(false);
		System.out.println(dir2.isFile());
		
		//windows true 认为所有的文件都是可读的 ，false
		System.out.println(dir2.canRead());
		
		dir2.setWritable(false);
		//false 可以设置为不可写
		System.out.println(dir2.canWrite());
		
//		dir2.isHidden(); 判断是否是隐藏
	}
	
	public static void Demo_02() {

		//文件夹与多层文件夹的创建
		File dir = new File("A");
		System.out.println(dir.mkdir());
		//window \\
		File dir2 = new File("C/D");
		System.out.println(dir2.mkdirs());
		//只可以删除为空的文件夹
//		dir2.delete();
	}
	
	public static void Demo_01()  throws IOException{
		
		//文件的创建
//		File file = new File("/Users/sai/Desktop/数据结构.rtf ");
		File file = new File("/Users/sai/Desktop");
		String child = "数据结构.rtf";
		File path = new File(file, child);
		System.out.println(path.exists());
		
		File createF = new File("readme.txt"); 
		System.out.println(createF.createNewFile());		
	}
}
