package com.wenq.androiddefaultprogramusedemo;

import java.io.File;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private static final int REQUEST_CODE = 10; // ͼ��ѡ�����������ʶ��
	private static String imgPath = ""; // ѡ���ͼƬ·��

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button btn01 = (Button) findViewById(R.id.btn01);
		Button btn02 = (Button) findViewById(R.id.btn02);
		Button btn03 = (Button) findViewById(R.id.btn03);
		Button btn04 = (Button) findViewById(R.id.btn04);
		Button btn05 = (Button) findViewById(R.id.btn05);

		btn01.setOnClickListener(this);
		btn02.setOnClickListener(this);
		btn03.setOnClickListener(this);
		btn04.setOnClickListener(this);
		btn05.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn01: // ����ͼ�������ѡ��
			OpenImageDialog();
			break;
		case R.id.btn02: // �����ļ�ѡ����
			SelectFile();
			break;
		case R.id.btn03: // ����ͼ��鿴���ɷŴ���С��
			BrowserImage(imgPath);
			break;
		case R.id.btn04: // ����Ƶ�ļ�
			OpenVideo("");
			break;
		case R.id.btn05: // ����Ƶ�ļ�
			OpenAudio("");
			break;
		}
	}

	// ��ͼ��ѡ���� �����Դ򿪵�ϵͳ��ᣩ
	private void OpenImageDialog() {
		try {
			Intent intent = new Intent(
					Intent.ACTION_PICK,
					android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
			startActivityForResult(intent, REQUEST_CODE);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);

		// �ص�����ѡ���ͼ��
		if (requestCode == REQUEST_CODE) {
			if (resultCode == Activity.RESULT_OK && data != null) {
				try {
					Uri selectedImageUri = data.getData();
					Cursor cursor = getContentResolver().query(
							selectedImageUri, null, null, null, null);
					if (cursor == null) {
						ShowMsg("δ�ҵ�ͼ��.");
					} else {
						cursor.moveToFirst(); // ��ȡ��һ�м�¼
						String imagePath = cursor.getString(1);
						cursor.close();
						imgPath = imagePath;

						ShowMsg("ѡ���ͼ��·��Ϊ�� " + imagePath);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	// ���ļ�ѡ����
	private String[] SelectFile() {
		String[] lst = null;

		ShowMsg("���Զ�������ص�������ϵͳ���Դ������ͳ���");

		return lst;
	}

	// ͼ����� (���Դ򿪵�ϵͳͼƬ�鿴���鿴������������Ĵ˳���)
	private void BrowserImage(String filePath) {
		try {
			// �·�����ͨ��Intent����ϵͳ��ͼƬ�鿴���Ĺؼ�����
			Intent intent = new Intent();
			intent.setAction(android.content.Intent.ACTION_VIEW);
			intent.setDataAndType(Uri.fromFile(new File(filePath)), "image/*"); // file��һ��File����ʵ��
			startActivity(intent);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ShowMsg(e.getMessage());
		}

	}

	// ����Ƶ
	private void OpenVideo(String videoPath) {
		try {
			Intent intent = new Intent();
			intent.setAction(android.content.Intent.ACTION_VIEW);
			File file = new File(videoPath);
			intent.setDataAndType(Uri.fromFile(file), "video/*"); // ���ļ�Ϊ����Ƶ���͡�
			startActivity(intent);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ShowMsg(e.getMessage());
		}

	}

	// ����Ƶ
	private void OpenAudio(String audioPath) {
		try {
			Intent intent = new Intent();
			intent.setAction(android.content.Intent.ACTION_VIEW);
			File file = new File(audioPath);
			intent.setDataAndType(Uri.fromFile(file), "audio/*"); // ���ļ�Ϊ����Ƶ���͡�
			startActivity(intent);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ShowMsg(e.getMessage());
		}

	}

	// ��ʾ��ʾ��Ϣ
	private void ShowMsg(String msg) {
		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
	}
}
