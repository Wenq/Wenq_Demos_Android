package com.wenq.pulltorefreshdemo;

//����ˢ��Ч��1
import com.wenq.View.RefreshableView;
import com.wenq.View.RefreshableView.PullToRefreshListener;

import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.Activity;

public class MainActivity extends Activity {

	RefreshableView refreshableView;
	ListView listView;
	ArrayAdapter<String> adapter;
	String[] items = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
			"L" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		refreshableView = (RefreshableView) findViewById(R.id.refreshable_view);
		listView = (ListView) findViewById(R.id.list_view);
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, items);
		listView.setAdapter(adapter);
		refreshableView.setOnRefreshListener(new PullToRefreshListener() {
			@Override
			public void onRefresh() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				refreshableView.finishRefreshing();
			}
		}, 0);
	}
}