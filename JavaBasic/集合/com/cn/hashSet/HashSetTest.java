package com.cn.hashSet;

import java.util.HashSet;
import java.util.Iterator;

class A{
	
	public boolean equals(Object obj){
		
		return true;
	}
}

class B{
	
	public int hashCode(){
		
		return 1;
	}
}

class C{
	
	public int hashCode(){
		return 2;
	}
	
	public boolean equals(Object obj){
		return true;
	}
}


class R{
	
	int count;
	public R(int count){
		
		this.count = count;
	}
	
	public String toString(){
		return "R[count:"+count+"]";
	}
	
	public boolean equals(Object obj){
		
		if (this == obj) {
			return true;
		}
		
		if (obj!=null && obj.getClass()== R.class) {
			R r = (R)obj;
			return this.count == r.count;
		}
		return false;
	}
	
	public int hashCode(){
		return this.count;
	}
}
public class HashSetTest {

	public static void main(String[] args) {
		
		HashSet books = new HashSet<>();
		books.add(new A());
		books.add(new A());
		books.add(new B());
		books.add(new B());
		books.add(new C());
		books.add(new C());
		
		//当equals 与 hashCode返回值相同时 同一个对象？？？
		System.out.println(books);
		
		HashSet<R> hs = new HashSet<R>();
		hs.add(new R(5));
		hs.add(new R(-3));
		hs.add(new R(9));
		hs.add(new R(-2));
		
		System.out.println(hs);
		
		Iterator<R> iterator=hs.iterator();
		R first = iterator.next();
		first.count = -3;
		System.out.println(hs);
		
		hs.remove(new R(-3));
		
		System.out.println(hs);
		
		//false false 修改后的-3站位了-2的位置
		System.out.println("hs是否包含count为-3的R对象"+hs.contains(new R(-3)));
		System.out.println("hs是否包含count为-2的R对象"+hs.contains(new R(-2)));
		
	}
}
