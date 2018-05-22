package com.cn.eapi;

public class RuntimeTest {
	
	public static void main(String[] args) {
	
//		runtime java程序运行时环境，应用程序不能自己创建runtime实例可以通过getRuntime方法获取关联的Runtime对象
//		同System类也提供了gc（）方法和runFinalization()方法通知系统进行垃圾回收
//		提供了load(String filename) loadLibraty(String libname)方法来加载文件和动态链接库
		//获取java关联的运行时对象 访问jvm相关信息
		Runtime rt = Runtime.getRuntime();
		System.out.println("处理器数量 "+rt.availableProcessors() );
		System.out.println("空闲内存数："+rt.freeMemory());
		System.out.println("总内存数："+rt.totalMemory());
		System.out.println("可用最大内存数："+rt.maxMemory());
		
		
	}

}

class ExecTest{
	
	public static void printOrdinal() throws Exception{
		
		Runtime rt = Runtime.getRuntime();
		//运行某一程序
		rt.exec("notepad.");
	}
}
