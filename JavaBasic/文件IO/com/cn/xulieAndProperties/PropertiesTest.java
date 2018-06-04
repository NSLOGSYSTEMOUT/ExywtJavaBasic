package com.cn.xulieAndProperties;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) throws IOException{
		
		Properties prop = new Properties();
		
		prop.load(new FileInputStream("conf.properties"));
		System.out.println(prop);
		prop.setProperty("tel",	"18911111111");
		//写入的   属性列表的描述
		prop.store(new FileOutputStream("conf.properties"), "属性列表的描述");
		System.out.println(prop);
	}
	
	public static void Demo_01ProEnumr() {
		//Properties HashTable的子类 
		Properties properties = new Properties();
//		properties.put("abc", 123);
		
		properties.setProperty("a", "123");
		properties.setProperty("name", "123dfds");
		properties.setProperty("age", "16");
//		System.out.println(properties);
		
		Enumeration<String> em =  (Enumeration<String>)properties.propertyNames();
		while (em.hasMoreElements()) {
			//获取properties中的每一个键
			String key = (String) em.nextElement();
			String value = properties.getProperty(key);
			System.out.println(key + "= " +value);
		}
	}
}
