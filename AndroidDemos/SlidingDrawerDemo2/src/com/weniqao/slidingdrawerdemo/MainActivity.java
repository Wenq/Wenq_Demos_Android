package com.weniqao.slidingdrawerdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SlidingDrawer;
import android.widget.TextView;

@SuppressWarnings("deprecation")
public class MainActivity extends Activity {

	@SuppressWarnings("deprecation")
	private SlidingDrawer mDrawer;
	//private ImageButton imbg;
	private Boolean flag = false;
	private TextView tv;

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//imbg = (ImageButton) findViewById(R.id.handle);
		mDrawer = (SlidingDrawer) findViewById(R.id.slidingdrawer);
		//tv = (TextView) findViewById(R.id.tv);

		mDrawer.setOnDrawerOpenListener(new SlidingDrawer.OnDrawerOpenListener() {
			@Override
			public void onDrawerOpened() {
				flag = true;
				//imbg.setImageResource(R.drawable.btn_focused); // down
			}

		});

		mDrawer.setOnDrawerCloseListener(new SlidingDrawer.OnDrawerCloseListener() {

			@Override
			public void onDrawerClosed() {
				flag = false;
				//imbg.setImageResource(R.drawable.btn_focused); // up
			}

		});

		mDrawer.setOnDrawerScrollListener(new SlidingDrawer.OnDrawerScrollListener() {

			@Override
			public void onScrollEnded() {
				//tv.setText("结束拖动");
			}

			@Override
			public void onScrollStarted() {
				//tv.setText("开始拖动");
			}

		});

	}

}
