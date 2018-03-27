package com.example.threadpoolutilsdemo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Runnable run01 = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				// TODO:这里编写多线程执行的逻辑
				Toast.makeText(MainActivity.this, "我是run01......", Toast.LENGTH_SHORT)
						.show();
			}
		};
		ThreadPoolUtils.execute(run01);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
