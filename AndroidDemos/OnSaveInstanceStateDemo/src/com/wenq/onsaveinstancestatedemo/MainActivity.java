package com.wenq.onsaveinstancestatedemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

//onSaveInstanceState()·½·¨
public class MainActivity extends Activity {

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button btn01 = (Button) findViewById(R.id.btn01);
		btn01.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent vedio = new Intent();
				vedio.setClass(MainActivity.this, VedioViewActivity.class);
				startActivity(vedio);
			}
		});
	}
}
