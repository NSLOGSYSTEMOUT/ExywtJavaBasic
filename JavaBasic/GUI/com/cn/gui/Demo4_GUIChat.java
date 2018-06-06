package com.cn.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo4_GUIChat extends Frame {

	private TextField tf;
	private Button send;
	private Button log;
	private Button clear;
	private Button shake;
	private TextArea viewText;
	private TextArea sendText;
	private DatagramSocket socket;
	private BufferedWriter bw;
	/**
	 * @param args
	 * GUIÁÄÌì
	 */
	public Demo4_GUIChat() {
		init();
		southPanel();
		centerPanel();
		event();
	}

	public void event() {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					socket.close();
					bw.close();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				System.exit(0);
			}
		});
		
		send.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					send();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			}

		});
		
		log.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					logFile();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			}

		});
		
		clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				viewText.setText("");
			}
		});
		
		shake.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					send(new byte[]{-1},tf.getText());
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			}

		});
		
		sendText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				//if(e.getKeyCode() == KeyEvent.VK_ENTER && e.isControlDown()) {	//isControlDown ctrlÊÇ·ñ±»°´ÏÂ
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						send();
					} catch (IOException e1) {
						
						e1.printStackTrace();
					}
				}
			}
		});
	}
	

	private void shake() {
		int x = this.getLocation().x;							//»ñÈ¡ºá×ø±êÎ»ÖÃ
		int y = this.getLocation().y;							//»ñÈ¡×Ý×ø±êÎ»ÖÃ
		
		for(int i = 0; i < 20; i++) {
			try {
				this.setLocation(x + 20, y + 20);
				Thread.sleep(20);
				this.setLocation(x + 20, y - 20);
				Thread.sleep(20);
				this.setLocation(x - 20, y + 20);
				Thread.sleep(20);
				this.setLocation(x - 20, y - 20);
				Thread.sleep(20);
				this.setLocation(x, y);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	private void logFile() throws IOException {
		bw.flush();									//Ë¢ÐÂ»º³åÇø
		FileInputStream fis = new FileInputStream("config.txt");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();	//ÔÚÄÚ´æÖÐ´´½¨»º³åÇø
		
		int len;
		byte[] arr = new byte[8192];
		while((len = fis.read(arr)) != -1) {
			baos.write(arr, 0, len);
		}
		
		String str = baos.toString();				//½«ÄÚ´æÖÐµÄÄÚÈÝ×ª»»³ÉÁË×Ö·û´®
		viewText.setText(str);
		
		fis.close();
	}
	
	private void send(byte[] arr, String ip) throws IOException {
		DatagramPacket packet = 
				new DatagramPacket(arr, arr.length, InetAddress.getByName(ip), 9999);
		socket.send(packet);						//·¢ËÍÊý¾Ý
	}
	
	private void send() throws IOException {
		String message = sendText.getText();		//»ñÈ¡·¢ËÍÇøÓòµÄÄÚÈÝ
		String ip = tf.getText();					//»ñÈ¡ipµØÖ·;
		ip = ip.trim().length() == 0 ? "255.255.255.255" : ip;
		
		send(message.getBytes(),ip);
		
		String time = getCurrentTime();				//»ñÈ¡µ±Ç°Ê±¼ä
		String str = time + " ÎÒ¶Ô:" + (ip.equals("255.255.255.255") ? "ËùÓÐÈË" : ip) + "Ëµ\r\n" + message + "\r\n\r\n";	//alt + shift + l ³éÈ¡¾Ö²¿±äÁ¿
		viewText.append(str);						//½«ÐÅÏ¢Ìí¼Óµ½ÏÔÊ¾ÇøÓòÖÐ
		bw.write(str);								//½«ÐÅÏ¢Ð´µ½Êý¾Ý¿âÖÐ
		sendText.setText("");
		
		
	}
	
	private String getCurrentTime() {
		Date d = new Date();						//´´½¨µ±Ç°ÈÕÆÚ¶ÔÏó
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyÄêMMÔÂddÈÕ HH:mm:ss");
		return sdf.format(d);						//½«Ê±¼ä¸ñÊ½»¯
	}

	public void centerPanel() {
		Panel center = new Panel();					//´´½¨ÖÐ¼äµÄPanel
		viewText = new TextArea();
		sendText = new TextArea(5,1);
		center.setLayout(new BorderLayout());		//ÉèÖÃÎª±ß½ç²¼¾Ö¹ÜÀíÆ÷
		center.add(sendText,BorderLayout.SOUTH);	//·¢ËÍµÄÎÄ±¾ÇøÓò·ÅÔÚÄÏ±ß
		center.add(viewText,BorderLayout.CENTER);	//ÏÔÊ¾ÇøÓò·ÅÔÚÖÐ¼ä
		viewText.setEditable(false);				//ÉèÖÃ²»¿ÉÒÔ±à¼­
		viewText.setBackground(Color.WHITE);		//ÉèÖÃ±³¾°ÑÕÉ«
		sendText.setFont(new Font("xxx", Font.PLAIN, 15));
		viewText.setFont(new Font("xxx", Font.PLAIN, 15));
		this.add(center,BorderLayout.CENTER);
	}

	public void southPanel() {
		Panel south = new Panel();					//´´½¨ÄÏ±ßµÄPanel
		tf = new TextField(15);
		tf.setText("127.0.0.1");
		send = new Button("·¢ ËÍ");
		log = new Button("¼Ç Â¼");
		clear = new Button("Çå ÆÁ");
		shake = new Button("Õð ¶¯");
		south.add(tf);
		south.add(send);
		south.add(log);
		south.add(clear);
		south.add(shake);
		this.add(south,BorderLayout.SOUTH);			//½«Panel·ÅÔÚFrameµÄÄÏ±ß
	}

	public void init() {
		this.setLocation(500, 50);
		this.setSize(400, 600);
		new Receive().start();
		try {
			socket = new DatagramSocket();
			bw = new BufferedWriter(new FileWriter("config.txt",true));	//ÐèÒªÔÚÎ²²¿×·¼Ó
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		this.setVisible(true);
	}
	private class Receive extends Thread {			//½ÓÊÕºÍ·¢ËÍÐèÒªÍ¬Ê±Ö´ÐÐ,ËùÒÔ¶¨Òå³É¶àÏß³ÌµÄ
		public void run() {
			try {
				DatagramSocket socket = new DatagramSocket(9999);
				DatagramPacket packet = new DatagramPacket(new byte[8192], 8192);
				
				while(true) {
					socket.receive(packet);				//½ÓÊÕÐÅÏ¢
					byte[] arr = packet.getData();		//»ñÈ¡×Ö½ÚÊý¾Ý
					int len = packet.getLength();		//»ñÈ¡ÓÐÐ§µÄ×Ö½ÚÊý¾Ý
					if(arr[0] == -1 && len == 1) {		//Èç¹û·¢¹ýÀ´µÄÊý×éµÚÒ»¸ö´æ´¢µÄÖµÊÇ-1,²¢ÇÒÊý×é³¤¶ÈÊÇ1
						shake();						//µ÷ÓÃÕð¶¯·½·¨
						continue;						//ÖÕÖ¹±¾´ÎÑ­»·,¼ÌÐøÏÂ´ÎÑ­»·,ÒòÎªÕð¶¯ºó²»ÐèÒªÖ´ÐÐÏÂÃæµÄ´úÂë
					}
					String message = new String(arr,0,len);	//×ª»»³É×Ö·û´®
					
					String time = getCurrentTime();		//»ñÈ¡µ±Ç°Ê±¼ä
					String ip = packet.getAddress().getHostAddress();	//»ñÈ¡ipµØÖ·
					String str = time + " " + ip + " ¶ÔÎÒËµ:\r\n" + message + "\r\n\r\n";
					viewText.append(str);
					bw.write(str);
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new Demo4_GUIChat();
	}

}
