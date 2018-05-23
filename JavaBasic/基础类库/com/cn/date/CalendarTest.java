package com.cn.date;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

public class CalendarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calendar calendar1 = Calendar.getInstance();
		
		Date date = calendar1.getTime();
		
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(date);
		//....add roll区别：超出允许范围是上级字段会不会增大 roll不会
		//关闭容错性
		calendar1.setLenient(false);
		
		System.out.println(LocalTime.now());
		
		//jdk8 import java.time包中包含时间类方法
		Clock clock = Clock.systemUTC();
		System.out.println("当前时刻为："+clock.instant());
		
		System.out.println(clock.millis());
		System.out.println(System.currentTimeMillis());
		
		Duration duration = Duration.ofSeconds(6000);
		//转换为时分秒
		System.out.println("相当于"+ duration.toMinutes()+"分");
		
		//clock基础上增加6000秒返回
		Clock clock2 = Clock.offset(clock, duration);
		System.out.println(clock2.instant());
		
		Instant instant = Instant.now();
		System.out.println(instant);
		
		Instant instant2 = Instant.parse("2018-05-23T04:27:54.226Z");
		System.out.println(instant2);
		
		
		

	}

}
