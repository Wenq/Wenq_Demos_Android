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

	private static final int REQUEST_CODE = 10; // 图像选择器，请求标识。
	private static String imgPath = ""; // 选择的图片路径

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
		case R.id.btn01: // 本地图像浏览与选择
			OpenImageDialog();
			break;
		case R.id.btn02: // 本地文件选择器
			SelectFile();
			break;
		case R.id.btn03: // 本地图像查看：可放大缩小等
			BrowserImage(imgPath);
			break;
		case R.id.btn04: // 打开视频文件
			OpenVideo("");
			break;
		case R.id.btn05: // 打开视频文件
			OpenAudio("");
			break;
		}
	}

	// 打开图像选择器 （测试打开的系统相册）
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

		// 回调处理选择的图像
		if (requestCode == REQUEST_CODE) {
			if (resultCode == Activity.RESULT_OK && data != null) {
				try {
					Uri selectedImageUri = data.getData();
					Cursor cursor = getContentResolver().query(
							selectedImageUri, null, null, null, null);
					if (cursor == null) {
						ShowMsg("未找到图像.");
					} else {
						cursor.moveToFirst(); // 读取第一行记录
						String imagePath = cursor.getString(1);
						cursor.close();
						imgPath = imagePath;

						ShowMsg("选择的图像路径为： " + imagePath);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	// 打开文件选择器
	private String[] SelectFile() {
		String[] lst = null;

		ShowMsg("需自定义或下载第三方，系统不自带该类型程序。");

		return lst;
	}

	// 图像浏览 (测试打开的系统图片查看器查看，或许因关联的此程序)
	private void BrowserImage(String filePath) {
		try {
			// 下方是是通过Intent调用系统的图片查看器的关键代码
			Intent intent = new Intent();
			intent.setAction(android.content.Intent.ACTION_VIEW);
			intent.setDataAndType(Uri.fromFile(new File(filePath)), "image/*"); // file是一个File对象实例
			startActivity(intent);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ShowMsg(e.getMessage());
		}

	}

	// 打开视频
	private void OpenVideo(String videoPath) {
		try {
			Intent intent = new Intent();
			intent.setAction(android.content.Intent.ACTION_VIEW);
			File file = new File(videoPath);
			intent.setDataAndType(Uri.fromFile(file), "video/*"); // 打开文件为“视频类型”
			startActivity(intent);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ShowMsg(e.getMessage());
		}

	}

	// 打开音频
	private void OpenAudio(String audioPath) {
		try {
			Intent intent = new Intent();
			intent.setAction(android.content.Intent.ACTION_VIEW);
			File file = new File(audioPath);
			intent.setDataAndType(Uri.fromFile(file), "audio/*"); // 打开文件为“音频类型”
			startActivity(intent);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ShowMsg(e.getMessage());
		}

	}

	// 显示提示信息
	private void ShowMsg(String msg) {
		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
	}
}
