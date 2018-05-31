package com.cn.dec;

public class decorationTest {

	public static void main(String[] args) {
		
		//装饰设计模式的好处是耦合性不强，被装饰的变化与装饰类的变化无关
		decorationStudent dStudent = new decorationStudent(new Student());
		dStudent.code();
	}
}


interface Coder{
	
	public void code();
}

class Student implements Coder{

	@Override
	public void code() {
	
		System.out.println("one");
		System.out.println("two");
		System.out.println("three");
	}
	
}

class decorationStudent implements Coder{
	
	private Student stu;
	
	public decorationStudent( Student student) {
		// TODO Auto-generated constructor stub
		this.stu = student;
	}
	
	@Override
	public void code() {
		// TODO Auto-generated method stub
		stu.code();
		
		System.out.println("everyThing");
	}
	
	
}