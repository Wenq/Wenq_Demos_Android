package com.wenq.sharedemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button btnShare = (Button) findViewById(R.id.share);
		btnShare.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				// TODO:分享到其他app
				Intent intent = new Intent(Intent.ACTION_SEND);
				intent.setType("image/*");
				// 分享显示的主题
				intent.putExtra(Intent.EXTRA_SUBJECT, "Share");
				// 分享的文本内容(具体分享内容由需求决定，比如app的下载链接等)
				intent.putExtra(Intent.EXTRA_TEXT,
						"I have successfully share my message through my app (分享自wenq)");

				// intent.setType("text/plain"); //纯文本
				// //图片分享
				// 　　　　it.setType("image/png");
				// 　　　　　//添加图片
				// 　　　　 File f = new
				// File(Environment.getExternalStorageDirectory()+"/name.png");
				// 　　　　 Uri uri = Uri.fromFile(f);
				// 　　　　 intent.putExtra(Intent.EXTRA_STREAM, uri); 
				
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(Intent.createChooser(intent, getTitle()));
			}
		});
	}
}
