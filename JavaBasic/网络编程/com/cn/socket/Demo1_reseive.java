package com.cn.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Demo1_reseive {

	public static void main(String[] args) throws Exception {
		
//		String str = "hello world";
		//端口号
		DatagramSocket socket = new DatagramSocket(6666);
	
		DatagramPacket packet = 
				new DatagramPacket(new byte[1024], 1024);
		
		while (true) {

			//接收数据
			socket.receive(packet);
			//获取数据
			byte[] arr = packet.getData();
			//获取有效的字节个数
			int length = packet.getLength();
			
			//获取IP地址
			String ip = packet.getAddress().getHostAddress();
			//获取端口号
			int port = packet.getPort();
			
			
			System.out.println(ip +":"+port+":"+ new String(arr, 0, length));
		}

		//关闭
//		socket.close();
	}
}
