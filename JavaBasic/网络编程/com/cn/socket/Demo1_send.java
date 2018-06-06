package com.cn.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Demo1_send {

	public static void main(String[] args) throws Exception {
		
		//创建键盘输入对象
		Scanner scanner = new Scanner(System.in);
		//端口号
		//随机端口号（可以指定）
		//创建socket相当于码头
		DatagramSocket socket = new DatagramSocket();
		
		while (true) {
		
			String str = scanner.nextLine();
			
			if ("exit".equals(str)) {
				
				break;
			}
			
			//指定数据、长度、地址、端口
			//创建Packet相当于集装箱
			DatagramPacket packet = 
					new DatagramPacket(str.getBytes(), str.getBytes().length, InetAddress.getByName("127.0.0.1"), 6666);
			
			//将数据发出去
			socket.send(packet);
		}
		
		socket.close();
		
	}
}
