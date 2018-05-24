package com.cn.hashSet;

import java.util.TreeSet;

//定制排序
class M {
	
	int age;
	
	public M (int age){
		this.age = age;
	}
	
	public String toString(){
		
		return "M[age:"+age+"]";
	}
	
	
}

class Z implements Comparable{
	
	int age;
	
	public Z(int age){
		this.age = age;
	}
	
	public boolean equals(Object obj){
		return true;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		
		
		return 1;
	}
	
	
}

public class TreeSetTest  {

	
	public static void main(String[] args) {
		
		TreeSet<Integer> nums = new TreeSet<>();
		nums.add(5);
		nums.add(2);
		nums.add(10);
		nums.add(-9);
		
		//有序输出
		System.out.println(nums);
		
		System.out.println(nums.first());
		System.out.println(nums.last());
		
		//返回小于4的子集 不包含4
		System.out.println(nums.headSet(4));
		//返回大于5的子集 如果Set中包含5 子集中还包含5
		System.out.println(nums.tailSet(5));
		//返回大于等于-3 小于4的子集
		System.out.println(nums.subSet(-3, 4));
		
		System.out.println("********");
		
		TreeSet<Z> set =  new TreeSet<Z>();
		Z z = new Z(6);
		set.add(z);
		
		System.out.println(set.add(z));
		System.out.println(set);
		
		set.first().age = 9;
		System.out.println(set.last().age);
		
		//修改处理set中的可变类复杂容易出错
		//Lambda表达式
		TreeSet<M> tSet = new TreeSet<M>((o1,o2)->{
			M m1 = (M)o1;
			M m2 = (M)o2;
			//自定义按降序排列
			return m1.age > m2.age ? -1:m1.age<m2.age ?1:0;
		});
		
		tSet.add(new M(5));
		tSet.add(new M(-3));
		tSet.add(new M(9));
		
		System.out.println(tSet);
		
	}
}
