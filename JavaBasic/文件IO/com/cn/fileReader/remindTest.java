package com.cn.fileReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class remindTest {

	
	public static void main(String[] args) throws IOException{
		
		BufferedReader reader = new BufferedReader(new FileReader("text.txt"));
		String line;
		
		line = reader.readLine();
		
		int  times  = Integer.parseInt(line);
		
		if (times > 0) {
			System.out.println("have "+times+"times");
			times --;
			
			FileWriter writer = new FileWriter("text.txt");
			writer.write(times+"");
			writer.close();
		}  else {
			 System.out.println("have none times");
		}
		
		
		reader.close();
	
	}
}
