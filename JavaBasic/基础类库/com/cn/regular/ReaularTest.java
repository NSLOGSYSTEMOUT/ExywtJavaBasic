package com.cn.regular;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReaularTest {

	public static void main(String[] args) {
		String str = "hello world";
		System.out.println(str.replaceFirst("\\w*", "✨"));
		System.out.println(str.replaceFirst("\\w*?", "✨"));
		
		//将一个字符串编译成一个pattern对象
		Pattern pattern = Pattern.compile("a*b");
		Matcher matcher = pattern.matcher("aaabbb");
		boolean b = matcher.matches(); //返回ture
		
//		System.out.println(matcher.lookingAt());
		
//		正则表达式只执行一次可用静态方法，相当于上面，但每次都需要重新编译Pattren对象
		boolean b2 = Pattern.matches("a*b", "aabbb"); //返回ture
		
		
		String string = "晚上的收代理费132938473839"+"阿萨德付款，13393747198"+"为空连接方式13384781818";
		
		Matcher m = Pattern.compile("((13\\d{9})|(15\\d{9}))").matcher(string);
		while(m.find()){
			System.out.println(m.group());
		}
		
		
		String regStr = "java is tebie easy";
		System.out.println("字符串："+regStr);
		Matcher matcher2 = Pattern.compile("\\w+").matcher(regStr);
		while(matcher2.find()){
			
			System.out.println(matcher2.group()+"子串的起始位置："+matcher2.start() +",结束位置："+matcher2.end());
		}
		
		
		String[] mails = {"konge@163.com","konge@gmail.com","konge@crazii.org","kdonge@abc.xxx"};
		
		String mailRegex = "\\w{3,20}@\\w+\\.(com|org|cn|net|gov)";
		Pattern mailPattern = Pattern.compile(mailRegex);
		Matcher matcher3 = null;
		for (String mail : mails) {
			if (matcher3 == null) {
				matcher3 = mailPattern.matcher(mail);
			}else {
				matcher3.reset(mail);
			}
			String result = mail +(matcher3.matches()?"shi":"bushi"+"一个有效的邮箱地址");
			System.out.println(result);
		}
		

	}

}
