package com.wenq.runnalbedemo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//方式1
		RunnableSub01 sub1 = new RunnableSub01();
		Thread thread01 = new Thread(sub1);
		thread01.start();

		//方式2
		Thread thread02 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

			}
		});
		thread02.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
