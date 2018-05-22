package com.cn.eapi;

import java.io.FileOutputStream;
import java.util.Map;
import java.util.Properties;

public class SystemTest  {

	public static void main(String[] args) throws Exception{
		
		//获取系统的所有环境变量
		Map<String, String> env = System.getenv();
		
		for (String name : env.keySet()) {
			System.out.println(name + "----->"+env.get(name));
		}
		
		//获取指定环境变量的值
		System.out.println(System.getenv("JAVA_HOME"));
		//获取所有的系统属性
		Properties  props = System.getProperties();
		//将所有的系统属性保存到props.txt文件中
		props.store(new FileOutputStream("props.txt"),"System Properties");
		System.out.println(System.currentTimeMillis());
		System.out.println("************");
		System.out.println(System.nanoTime());
		
		//identityHashCode当一个类的hashCode方法被重写就不能唯一的标识该对象，但通过identityHashCode
//		方法返回的hashCode值相同（依然是根据该对象的地址计算得到）为同一对象
		System.out.println(System.identityHashCode(new SystemTest()));
		//输出特定的系统属性
		System.out.println(System.getProperty("os.name"));
	}
}
