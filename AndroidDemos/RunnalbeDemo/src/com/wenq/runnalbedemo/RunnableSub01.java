package com.wenq.runnalbedemo;

//Runnable�ӿ�ʵ��
public class RunnableSub01 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub

		// TODO:�����д���̵߳��߼�
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
