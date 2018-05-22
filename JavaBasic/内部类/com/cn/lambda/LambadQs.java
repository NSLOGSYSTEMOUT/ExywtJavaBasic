package com.cn.lambda;

import javax.swing.JFrame;

@FunctionalInterface
interface yourTest{
	
	JFrame win(String title);
}

@FunctionalInterface
interface myTest{
	String test(String a, int b, int c);
}

@FunctionalInterface
interface Converter{
	
	Integer convert(String from);
}

interface Eatable{
	void taste();
}

interface Flyable{
	void fly(String weather);
}

interface Addable{
	int add(int a, int b);
}

public class LambadQs {

	public void eat(Eatable e){
		System.out.println(e);
		e.taste();
	}
	
	public void driver(Flyable f){
		System.out.println("正在驾驶 ——"+f);
		f.fly("OK");
	}
	
	public void test(Addable a){
		System.out.println("5+3 = "+ a.add(5, 3));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Converter con = from->Integer.valueOf(from);
		//引用类方法
		Converter con = Integer::valueOf;
		Integer val = con.convert("99");
		System.out.println(val);
		
		//应用特定对象的实例方法
//		Converter con2 = from->"fkit.org".indexOf(from);
		Converter con2 = "fkit.org"::indexOf;
		Integer value2 = con2.convert("it");
		System.out.println(value2);//2
	
		//引用某类对象的实例方法
//		myTest my = (a,b,c) -> a.substring(b, c);
		myTest my = String ::substring;
		String strs = my.test(" I love java", 2, 9);
		System.out.println(strs);
			
		//引用构造器
//		yourTest your = (String a )-> new JFrame(a);
		yourTest your = JFrame::new;
		JFrame jf = your.win("我的窗口");
		System.out.println(jf);
		
		LambadQs la = new LambadQs();
	
		
		la.eat(()->System.out.println("nice")
		);
		
		la.driver((String str)->{

			System.out.println("天气"+str);
		});
		
//		la.test((int a, int b)->{
//			
//			int sum = a +b;
//			return sum;
//		});
		
		la.test((a, b)->a+b);
		
		Runnable r = ()->{
			
			System.out.println();
		};
		
	}

}
