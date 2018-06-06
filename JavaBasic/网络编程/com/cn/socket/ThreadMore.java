package com.cn.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ThreadMore {

	public static void main(String[] args) {
		
		new receive().start();
		
		new send().start();
	}
}

class receive extends Thread{
	
	@Override
	public void run() {
	
		//端口号
				try {
					DatagramSocket socket = new DatagramSocket(6666);
					DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
					while (true) {

						//接收数据
						socket.receive(packet);
						//获取数据
						byte[] arr = packet.getData();
						//获取有效的字节个数
						int len = packet.getLength();

						//获取IP地址
						String ip = packet.getAddress().getHostAddress();
						//获取端口号
						int port = packet.getPort();

						System.out.println(ip + ":" + port + ":" + new String(arr, 0, len));
					} 
				} catch (Exception e) {
					// TODO: handle exception
				}
	}
	
}


class send extends Thread{
	
	@Override
	public void run() {

		try {
			//创建键盘输入对象
			Scanner sc = new Scanner(System.in);
			//端口号
			//随机端口号（可以指定）
			//创建socket相当于码头
			DatagramSocket socket = new DatagramSocket();
			while (true) {

				String str = sc.nextLine();

				if ("quite".equals(str)) {

					break;
				}

				//指定数据、长度、地址、端口
				//创建Packet相当于集装箱
				DatagramPacket packet = new DatagramPacket(str.getBytes(), str.getBytes().length,
						InetAddress.getByName("127.0.0.1"), 6666);

				//将数据发出去
				socket.send(packet);
			}
			socket.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
