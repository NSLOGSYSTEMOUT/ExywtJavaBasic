package com.cn.exer;

public class cacheImmutale {
	
	private static int MAX_Size = 10;
	private static cacheImmutale[] cache = new cacheImmutale[MAX_Size];
	private static int pos = 0;
	private final String name;
	private cacheImmutale(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public static cacheImmutale valueOf(String name){
		
		for (int i = 0; i < MAX_Size; i++) {
			
			if(cache[i] != null && cache[i].getName().equals(name)){
				
				return cache[i];
			}
		}
		
		if (pos == MAX_Size){
			
			cache[0] = new cacheImmutale(name);
			pos = 1;
		} else {
			
			cache[pos++] = new cacheImmutale(name);
		}
		
		return cache[pos -1];
	}
	
	public boolean equals(Object obj){
		if(this == obj){
			
			return true;
		}
		if(obj != null && obj.getClass() == cacheImmutale.class){
			cacheImmutale ci = (cacheImmutale)obj;
			return name.equals(ci.getName());
		}
		
		return false;
	}
	
	public int hashCode(){
		
		return name.hashCode();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		cacheImmutale c1 = cacheImmutale.valueOf("hello");
		cacheImmutale c2 = cacheImmutale.valueOf("hello");
		
		System.out.println(c1 == c2);
	}

}
