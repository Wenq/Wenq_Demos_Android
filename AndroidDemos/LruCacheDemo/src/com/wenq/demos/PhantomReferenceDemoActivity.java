package com.wenq.demos;

import com.wenq.lrucachedemo.R;
import com.wenq.lrucachedemo.R.layout;
import com.wenq.lrucachedemo.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class PhantomReferenceDemoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_phantom_reference_demo);
	}

}
