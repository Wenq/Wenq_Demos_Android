package com.wenq.demos;

import com.wenq.lrucachedemo.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

//LruCache 缓存
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button btn01 = (Button) findViewById(R.id.btn01);
		Button btn02 = (Button) findViewById(R.id.btn02);
		Button btn03 = (Button) findViewById(R.id.btn03);
		Button btn04 = (Button) findViewById(R.id.btn04);

		btn01.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent softReferenceIntent = new Intent();
				softReferenceIntent.setClass(MainActivity.this,
						SoftReferenceActivity.class);
				startActivity(softReferenceIntent);
			}
		});

		btn02.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent lruCacheIntent = new Intent();
				lruCacheIntent.setClass(MainActivity.this,
						LruCacheActivity.class);
				startActivity(lruCacheIntent);
			}
		});

		btn03.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				// 弱引用
				Intent weakIntent = new Intent();
				weakIntent.setClass(MainActivity.this,
						WeakReferenceDemoActivity.class);
				startActivity(weakIntent);
			}
		});

		btn04.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				// 虚引用
				Intent phantomIntent = new Intent();
				phantomIntent.setClass(MainActivity.this,
						PhantomReferenceDemoActivity.class);
				startActivity(phantomIntent);
			}
		});

	}
}
