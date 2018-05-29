package com.cn.IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferStreamTest {

	public static void main(String[] args) throws IOException {
		
	}
	
	public static  void Demo_02() throws IOException{
		
		BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("ccc.txt"));
		BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("copyCCC.txt"));
		
		int b;
		
		while ((b = inputStream.read()) != -1) {
			
			outputStream.write(b);
		}
		
		//close() 具备刷新的功能，在关闭之前将缓冲区的字节都刷新到文件中，再关闭
		//flush() 刷新缓存区，可以每次刷新清空缓存区 ，可以及时的更新
		inputStream.close();
		outputStream.flush();
	}
	
	public static void Demo_01()throws IOException {
		
		//缓冲区的拷贝 对InputStream 与。。 的包装 降低到硬盘的读写次数增加效率
//		定义的小数组的读写会略快
		
//		FileInputStream inputStream = new  FileInputStream("A/5.png");
		
		FileOutputStream outputStream = new FileOutputStream("copy.png");
		
		//创建缓冲区对象，对输入输出流包装 优化
		BufferedInputStream bufferInput1 = new BufferedInputStream(new  FileInputStream("A/5.png"));
		BufferedOutputStream bufferOut1 = new BufferedOutputStream(outputStream);
		
		int b;
		while ( (b = bufferInput1.read()) != -1) {
			
			bufferOut1.write(b);
		}
		
		
		bufferInput1.close();
		bufferOut1.close();
	}
}
