package com.wenq.asynctaskdemo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		AsyncTaskSub01 sub1 = new AsyncTaskSub01();
		// sub1.execute("");
		/*
		 * ��1.6֮ǰ��AsyncTask�Ǵ���ִ������ģ�1.6��ʱ��AsyncTask��ʼ�����̳߳��ﴦ��������
		 * ���Ǵ�3.0��ʼ��Ϊ�˱���AsyncTask�������Ĳ�������AsyncTask�ֲ���һ���߳�������ִ������
		 */
		sub1.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, ""); // 4.0������ϵͳ�����øýӿڲŲ���
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
