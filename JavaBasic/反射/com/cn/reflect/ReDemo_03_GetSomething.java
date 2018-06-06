package com.cn.reflect;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

import com.cn.bean.Person;

public class ReDemo_03_GetSomething {

	public static void main(String[] args) throws Exception {
		
		 Class class1 = Class.forName("com.cn.bean.Person");
		 
		 /* get 构造方法 */
		 //通过无参构造创建对象
//		 Person p = (Person)class1.newInstance();
//		 System.out.println(p);
		 
		 //获取有参构造
		 Constructor c = class1.getConstructor(String.class, int.class);
//		 通过有参构造创建对象
		 Person p = (Person)c.newInstance("张张",18);
		 System.out.println(p);
		 
		 /* get 属性 */
		 //获取name属性字段 私有属性不可以访问到
//		 Field field = class1.getField("name");
//		field.set(p, "哈哈"); 
		 
		 //通过 暴力反射获取私有的字段
		 Field field2 = class1.getDeclaredField("name");
		 field2.setAccessible(true);  //去除私有权限
		 field2.set(p, "哈哈"); 
		 System.out.println(p);
		 
		 
		 /* get method */
		 
		 //获取eat方法
		 Method method = class1.getMethod("eat");
		 method.invoke(p);
		 
		 Method method2 = class1.getMethod("eat", int.class);
		 method2.invoke(p, 1000);
		 
		 /*通过反射越过泛型检查  编译器才有泛型  运行期泛型无效会被擦除 */
		 ArrayList<Integer> list = new ArrayList<>();
		 list.add(111);
		 list.add(222);
		 
//		 list.add("abc");
		 Class  class2 = Class.forName("java.util.ArrayList");  //获取字节码对象
		 Method m = class2.getMethod("add", Object.class);      //获取add方法
		 m.invoke(list, "abc");
		 
		 System.out.println(list);
		 
		 
		 /*通过反射写一个通用的设置某个对象的某个属性值为指定的值*/
		 Student student = new Student("站长", 23);
		 System.out.println(student);
		 
		 Tool tool = new Tool();
		 tool.setProperty(student, "name", "长常常");
		 System.out.println(student);
	}
}


/*通过反射写一个通用的设置某个对象的某个属性值为指定的值 工具类*/
class Tool{
	
	public void setProperty(Object obj, String propertyName, Object value) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		
		//获取字节码
		Class cls = obj.getClass();
		//暴力获取 私有 属性变量
		Field field = cls.getDeclaredField(propertyName);
		field.setAccessible(true);   //去除权限
		field.set(obj, value);
	}
}

class Student{
	
	private String name;
	private int age;
	
	public Student() {
	
	}
	
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
}

