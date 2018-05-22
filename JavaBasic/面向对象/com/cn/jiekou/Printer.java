package com.cn.jiekou;

public class Printer implements Output, Product {

	private String[] printData = new String[Max_Cache_Line];
	private int dataNum = 0;
	
	@Override
	public void out() {
		// TODO Auto-generated method stub
		while(dataNum > 0){
			System.out.println("打印机打印..."+printData[0]);
			System.arraycopy(printData, 1, printData, 0, --dataNum);
		}
	}

	@Override
	public void getData(String msg) {
		// TODO Auto-generated method stub
		if (dataNum >= Max_Cache_Line) {
			System.out.println("输出队列已满，添加失败");
		} else {			
//			dataNum++;
			printData[dataNum++] = msg;
		}
	}

		
	@Override
	public int getProduceTiem() {
		// TODO Auto-generated method stub
		return 45;
	}

	public static void main(String args[]){
		
		Output o = new Printer();
		o.getData("java");
		o.getData("java second");
		o.out();
		
		o.getData("android");
		o.getData("ios");
		o.out();
		
		o.print("one","two","three");
		o.test();
		
		Product p = new Printer();
		System.out.println(p.getProduceTiem());
//		Object obj = p;
		
	}

}
