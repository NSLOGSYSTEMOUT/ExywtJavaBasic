package com.cn.dynamic;

import java.lang.reflect.Proxy;

public class TestDynamic {

//	动态代理 通过反射实现代理，只能针对接口做代理java.land.reflect Proxy类中的方法创建动态代理对象 
//	更强大的代理cglib ,
	public static void main(String[] args) {
		
		UserImpl user = new UserImpl();
		user.add();
		user.delete();
		
		System.out.println("________");
		
		MyInvocationHandler my = new MyInvocationHandler(user);
		User u = (User)Proxy.newProxyInstance(user.getClass().getClassLoader(), user.getClass().getInterfaces(), my);
		u.add();
		u.delete();
		
	}
}
