package com.cn.fileReader;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;

public class AppearNumbers {

	public static void main(String[] args) throws IOException {
		
		
		//创建带缓冲区的流
		BufferedReader reader = new BufferedReader(new FileReader("bbb.txt"));
		
		TreeMap<Character, Integer> tMap = new TreeMap<>();
		
		int ch;	
		
		while ((ch = reader.read()) != -1) {
			
			char c = (char)ch;
			
//			if (! tMap.containsKey(c)) {
//				tMap.put(c, 1);
//			} else {
//				 tMap.put(c, tMap.get(c)+1);
//			}
			
			tMap.put(c, !tMap.containsKey(c)?1:tMap.get(c)+1);
		}

		reader.close();
		
		BufferedWriter writer = new BufferedWriter(new FileWriter("counts.txt"));
		
		for (char key : tMap.keySet()) {
			
			switch (key) {
			case '\t':	
				writer.write("\\t" + "=" + tMap.get(key));
				break;
			case '\r':	
				writer.write("\\r" + "=" + tMap.get(key));
				break;
				
			case '\n':	
				writer.write("\\n " + "=" + tMap.get(key));
				break;

			default:
				writer.write(key +"="+tMap.get(key));
				break;
			}
			
			
			writer.newLine();
		}
		
		writer.close();
		
	}
	
	
}
