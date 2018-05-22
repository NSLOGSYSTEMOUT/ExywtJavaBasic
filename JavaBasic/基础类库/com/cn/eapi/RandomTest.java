package com.cn.eapi;

import java.sql.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomTest {

	public static void main(String[] args) {
		
		//伪随机的 推荐 System.currentTimeMillis()
		Random rand = new Random(System.currentTimeMillis());
		System.out.println(rand.nextBoolean());
		
		byte[] buffer = new byte[16];
		rand.nextBytes(buffer);
		System.out.println(Arrays.toString(buffer));

		//0-1.0之间
		System.out.println(rand.nextDouble());
		System.out.println(rand.nextFloat());
		
		//生成平均值是0.0标准差是1.0的伪高斯数
		System.out.println(rand.nextGaussian());
		System.out.println(rand.nextInt(28));
		
		ThreadLocalRandom random = ThreadLocalRandom.current();
		//生成一个4-20之间的为随机整数
		int val = random.nextInt(4,20);
		//生成一个2.0-20.0之间的伪随机数
		double val2 =random.nextDouble(2.0, 10.0);
	}
}
