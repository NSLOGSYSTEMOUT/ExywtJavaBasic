package com.cn.test;

public enum gender  implements GenderDesc {
	
	MALE("男"){
		
		//此方法将覆盖实现接口中的方法
		public void info(){
			System.out.println("枚举值代表男");
		}
	},FEMALE("女"){
		
		public void info(){
			System.out.println("枚举值代表女");
		}
	};

	private final String name;
	private gender(String name){
		
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}

	@Override
	public void info() {
		// TODO Auto-generated method stub
		
		System.out.println("这是一个用于定义性别的枚举类");
		
	}
	
//	MALE("男") 等同于
//	public static final gender MALE = new gender("男");
	
	/*
	MALE,FEMALE;
	
	private String name;
	
	public void setName(String name){
		
		switch (this) {
		case MALE:
			
			if(name.equals("男")){
				this.name = name;
			}else{
				System.out.println("参数错误");
				return;
			}
			break;
		case FEMALE:
			if (name.equals("女")) {
				this.name = name;
			} else {
				System.out.println("参数错误");
				return;
			}
			
		default:
			break;
		}
	}
	
	public String getName(){
		return this.name;
	}
	*/
	
}
