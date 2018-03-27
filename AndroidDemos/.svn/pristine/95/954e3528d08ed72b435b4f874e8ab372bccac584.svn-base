package com.wenq.demos;

import com.wenq.lrucachedemo.R;
import com.wenq.softreferencedemo.ImageAndTextListAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;

//软引用缓存
//参考：
//http://www.2cto.com/kf/201207/139035.html
//http://www.iteye.com/topic/685986
//完整的：http://www.cnblogs.com/tc310/p/4083152.html
//http://blog.csdn.net/onerain88/article/details/7008409

public class SoftReferenceActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_soft_reference);

		ListView lsView = (ListView) findViewById(R.id.lsView);
		ImageAndTextListAdapter adapter = new ImageAndTextListAdapter(this,
				null, lsView);
		lsView.setAdapter(adapter);
	}
}
