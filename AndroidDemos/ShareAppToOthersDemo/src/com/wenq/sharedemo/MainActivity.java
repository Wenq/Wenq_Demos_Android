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

				// TODO:��������app
				Intent intent = new Intent(Intent.ACTION_SEND);
				intent.setType("image/*");
				// ������ʾ������
				intent.putExtra(Intent.EXTRA_SUBJECT, "Share");
				// ������ı�����(��������������������������app���������ӵ�)
				intent.putExtra(Intent.EXTRA_TEXT,
						"I have successfully share my message through my app (������wenq)");

				// intent.setType("text/plain"); //���ı�
				// //ͼƬ����
				// ��������it.setType("image/png");
				// ����������//���ͼƬ
				// �������� File f = new
				// File(Environment.getExternalStorageDirectory()+"/name.png");
				// �������� Uri uri = Uri.fromFile(f);
				// �������� intent.putExtra(Intent.EXTRA_STREAM, uri); 
				
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(Intent.createChooser(intent, getTitle()));
			}
		});
	}
}
