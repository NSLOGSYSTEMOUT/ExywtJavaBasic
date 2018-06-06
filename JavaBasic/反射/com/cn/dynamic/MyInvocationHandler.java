package com.cn.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

	private Object target;
	
	//接收被代理对象
	public MyInvocationHandler(Object target) {
	
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		//method通过反射获得
//		执行被代理target对象的方法
		System.out.println("权限校验");
		method.invoke(target, args);
		System.out.println("日志记录");
		return null;
	}

}
