package com.cn.collection;

//使用泛型声明一个类
public class AppleE<A> {
	
	private A info;
	
	//定义的类型info确定
	public AppleE(A info){
		this.info = info;
	}

	public A getInfo() {
		return info;
	}

	public void setInfo(A info) {
		this.info = info;
	}
	
	

}
