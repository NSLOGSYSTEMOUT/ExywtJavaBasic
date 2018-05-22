package com.cn.Strings;

public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String为不可变的
		String s1 =  new String("abcdefghijklmnop");
		String s2 =  new String("abcdefghi");
		String s3 =  new String("abcdefghijklmn");
		
		//比较大小如果长字符串前面恰巧是短字符串则返回长度差
		System.out.println(s1.compareTo(s2));
		System.out.println(s1.compareTo(s3));
		//abcdefghijklmnopabcdefghi 将两个字符串连接在一起
		System.out.println(s1.concat(s2));
		
		char[] da = {'1','2','3','c'};
		
		String string= String.copyValueOf(da);
		boolean isTure = string.endsWith("3");
		System.out.println(isTure);
		System.out.println(string);
		System.out.println(string.indexOf("2"));
		byte[] bytes = string.getBytes();
		for (byte b : bytes) {
			System.out.println(b);
		}
		
		char[] chr = string.toCharArray();
		for (char c : chr) {
			System.out.println(c);
		}
		System.out.println(String.valueOf(string));
	}

}
