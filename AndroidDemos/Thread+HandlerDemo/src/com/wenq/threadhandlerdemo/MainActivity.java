package com.wenq.threadhandlerdemo;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

//Android异步处理一：使用Thread+Handler实现非UI线程更新UI界面
public class MainActivity extends Activity {

	private static final int MSG_SUCCESS = 0;// 获取图片成功的标识
	private static final int MSG_FAILURE = 1;// 获取图片失败的标识

	private ImageView mImageView;
	private Button mButton;

	private Thread mThread;

	private Handler mHandler = new Handler() {
		public void handleMessage(Message msg) {// 此方法在ui线程运行
			switch (msg.what) {
			case MSG_SUCCESS:
				mImageView.setImageBitmap((Bitmap) msg.obj);// imageview显示从网络获取到的logo
				Toast.makeText(getApplication(),
						getApplication().getString(R.string.get_pic_success),
						Toast.LENGTH_LONG).show();
				break;

			case MSG_FAILURE:
				Toast.makeText(getApplication(),
						getApplication().getString(R.string.get_pic_failure),
						Toast.LENGTH_LONG).show();
				break;
			}
		}
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mImageView = (ImageView) findViewById(R.id.imageView);// 显示图片的ImageView
		mButton = (Button) findViewById(R.id.button);
		mButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (mThread == null) {
					mThread = new Thread(runnable);
					mThread.start();// 线程启动
				} else {
					Toast.makeText(
							getApplication(),
							getApplication().getString(R.string.thread_started),
							Toast.LENGTH_LONG).show();
				}
			}
		});
	}

	//获取网络图像
	Runnable runnable = new Runnable() {

		@Override
		public void run() {// run()在新的线程中运行
			HttpClient hc = new DefaultHttpClient();
			HttpGet hg = new HttpGet(
					"http://csdnimg.cn/www/images/csdnindex_logo.gif");// 获取csdn的logo
			final Bitmap bm;
			try {
				HttpResponse hr = hc.execute(hg);
				bm = BitmapFactory.decodeStream(hr.getEntity().getContent());
			} catch (Exception e) {
				mHandler.obtainMessage(MSG_FAILURE).sendToTarget();// 获取图片失败
				return;
			}
			mHandler.obtainMessage(MSG_SUCCESS, bm).sendToTarget();// 获取图片成功，向ui线程发送MSG_SUCCESS标识和bitmap对象

			// mImageView.setImageBitmap(bm); //出错！不能在非ui线程操作ui元素

			// 多线程更新UI元素方法2
			// mImageView.post(new Runnable() {//另外一种更简洁的发送消息给ui线程的方法。
			//
			// @Override
			// public void run() {//run()方法会在ui线程执行
			// mImageView.setImageBitmap(bm);
			// }
			// });
		}
	};
}
