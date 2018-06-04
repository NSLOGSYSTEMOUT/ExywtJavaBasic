package com.cn.xulieAndProperties;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.DeflaterOutputStream;

public class DataSreamTest {

	public static void main(String[] args) throws IOException{
		
		
		DataInputStream inputStream = new DataInputStream(new FileInputStream("a.txt"));
		int x  = inputStream.readInt();
		int y  = inputStream.readInt();
		int z  = inputStream.readInt();
		
		System.out.println("x="+x+"y="+y+"z="+z);
		
		inputStream.close();
	}
	
	public static void Demo_01() throws IOException{
		DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("a.txt"));
		
		outputStream.writeInt(997);
		outputStream.writeInt(998);
		outputStream.writeInt(999);
		
		outputStream.close();
	}
}
