package com.wenq.runnalbedemo;

//Runnable接口实现
public class RunnableSub01 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub

		// TODO:这里编写多线程的逻辑
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
