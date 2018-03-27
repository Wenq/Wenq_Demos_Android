package com.wq.progressbardemo;

import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class ProgressBarDemoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// 设置标题进度条风格
		requestWindowFeature(Window.FEATURE_PROGRESS);

		setContentView(R.layout.activity_progress_bar_demo);

		// 显示标题进度
		setProgressBarVisibility(true);
		// 设置标题当前进度值为5000（标题进度最大值默认为10000）
		setProgress(5000);
		// 关闭标题进度
		// setProgressBarVisibility(false);

		Button btnProgress = (Button) findViewById(R.id.btnProgressPopUp);
		Button btnProgress2 = (Button) findViewById(R.id.btnProgressPopUp2);

		// 圆形弹出进度条
		btnProgress.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ProgressDialog dialog = new ProgressDialog(
						ProgressBarDemoActivity.this);
				// 设置进度条风格，风格为圆形，旋转的
				dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
				// 设置ProgressDialog 标题
				dialog.setTitle("1111111这是标题");
				// 设置ProgressDialog 提示信息
				dialog.setMessage("这是内容.......");
				// 设置ProgressDialog 标题图标
				dialog.setIcon(android.R.drawable.ic_dialog_map);
				// 设置ProgressDialog 的一个Button
				dialog.setButton("确定", new ProgressDialog.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {

					}
				});
				// 设置ProgressDialog 的进度条是否不明确
				dialog.setIndeterminate(false);
				// 设置ProgressDialog 是否可以按退回按键取消
				dialog.setCancelable(false);
				// 显示
				dialog.show();
			}
		});

		// 长方形弹出进度条
		btnProgress2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ProgressDialog dialog = new ProgressDialog(
						ProgressBarDemoActivity.this);
				// 设置进度条风格，风格为圆形，旋转的
				dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
				// 设置ProgressDialog 标题
				dialog.setTitle("这是标题。。。。。");
				// 设置ProgressDialog 提示信息
				dialog.setMessage("这是。。。。。你懂的");
				// 设置ProgressDialog 标题图标
				dialog.setIcon(android.R.drawable.ic_dialog_alert);
				// 设置ProgressDialog的最大进度
				dialog.setMax(100);
				// 设置ProgressDialog 的一个Button
				dialog.setButton("确定", new ProgressDialog.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {

					}
				});
				// 设置ProgressDialog 是否可以按退回按键取消
				dialog.setCancelable(true);
				// 显示
				dialog.show();

				// 设置ProgressDialog的当前进度
				dialog.setProgress(50);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.progress_bar_demo, menu);
		return true;
	}

}
