package com.cn.xulieAndProperties;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class printStreamTest {

	public static void main(String[] args) throws FileNotFoundException {
		
		PrintWriter pw = new PrintWriter("f.txt");
		pw.write(97);
		
		pw.close();
	
	}
	
	
	public static void Demo_01() {
		//和方便的将对象toString()结果输出，而且自动使用刷新模式输出
		PrintStream printStream = System.out;
		
		printStream.println("zs");
		printStream.write(97);
		
		printStream.close();
	}
}
