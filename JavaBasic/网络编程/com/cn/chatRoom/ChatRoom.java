package com.cn.chatRoom;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

public class ChatRoom extends Frame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ChatRoom() {
	
		init();
		southPanel();
	}
	
	public void centerPanel(){
		
		Panel center =  new Panel();
		TextArea viewText = new TextArea();
		TextArea sendText = new TextArea();
		center.setLayout(new BorderLayout());
		
		center.add(viewText, BorderLayout.CENTER);
		center.add(sendText, BorderLayout.SOUTH);
		
		//设置
		viewText.setEditable(false);
		this.add(center,BorderLayout.CENTER);
	}
	
	public void southPanel(){
		//创建左边的panel
		Panel panel = new Panel();
		panel.setBounds(0,450,600,50);
		panel.setBackground(Color.red);
		
		TextField field = new TextField(20);
		field.setBounds(10,5,200,40);
		Button send = new Button("发送");
		send.setBounds(242,10,70,40);
		Button log = new Button("记录");
		log.setBounds(314,10,70,40);
		Button clear  = new Button("清屏");
		clear.setBounds(386,10,70,40);
		Button shake = new Button("震动");
		shake.setBounds(460,10,70,40);
		
		panel.add(field);
		panel.add(send);
		panel.add(log);
		panel.add(clear);
		panel.add(shake);
		panel.setLayout(new FlowLayout());
		//将Panel放在Frame的
		this.add(panel);
		
		
	}

	public void init() {
		this.setLocation(500, 200);
		this.setSize(600, 500);
	
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new ChatRoom();
	}
}
