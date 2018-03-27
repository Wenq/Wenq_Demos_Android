package com.wenq.pulltorefreshdemo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

//下拉刷新效果2
public class PullToRefresh2Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pull_to_refresh2);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pull_to_refresh2, menu);
		return true;
	}

}
