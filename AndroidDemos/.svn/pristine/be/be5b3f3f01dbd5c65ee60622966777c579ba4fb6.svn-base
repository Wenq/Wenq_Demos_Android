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
		 * 在1.6之前，AsyncTask是串行执行任务的，1.6的时候AsyncTask开始采用线程池里处理并行任务，
		 * 但是从3.0开始，为了避免AsyncTask所带来的并发错误，AsyncTask又采用一个线程来串行执行任务
		 */
		sub1.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, ""); // 4.0及以上系统，调用该接口才并行
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
