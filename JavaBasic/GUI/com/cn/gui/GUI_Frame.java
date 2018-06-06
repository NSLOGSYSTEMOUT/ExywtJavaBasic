package com.cn.gui;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GUI_Frame {

	public static void main(String[] args) {
		
		Frame frame = new Frame("first window");
		frame.setSize(600,600);
		frame.setLocation(600, 600);
		frame.setIconImage(Toolkit.getDefaultToolkit().createImage("logo.png"));

		
		//添加窗口的监听
		frame.addWindowListener(new WindowAdapter() {
		});
		
		//鼠标监听
		Button b1 = new Button("按钮");
		b1.setSize(100, 100);
		
		Button b2 = new Button("按钮2");
		frame.setLayout(new FlowLayout());
		frame.add(b1);
		frame.add(b2);
		
		
		//使用匿名内部咧
		b1.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		//键盘监听
		b1.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
//				System.exit(0);
				//获取点击的键
				//键的静态常量KeyEvent.KEY_FIRST
				System.out.println(e.getKeyCode());
			}
		});
		
		//动作监听
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
		});
		
		//设置窗口可见
		frame.setVisible(true);		
		
	}
}

//通过继承
class windowListene extends WindowAdapter{
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}
}

//通过接口
class MyWindowListener implements WindowListener{

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
