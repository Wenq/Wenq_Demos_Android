package com.wenq.fileandrandomaccessfiledemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import com.wenq.Utils.Utils;
import com.wenq.model.EmployeeModel;
import com.wenq.randomaccessfiledemo.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	private final String fileName = "demo.txt";
	private static String fileNameAbsolute;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		try {
			fileNameAbsolute = Utils.GetTestPath() + fileName;

			// File: 文件
			File fl = new File(fileNameAbsolute);
			if (!fl.exists()) {
				fl.createNewFile(); // 创建不存在的文件
			}
			Utils.ShowMsg(this, fl.getAbsolutePath());
			Utils.ShowMsg(this, "是否是文件：" + fl.isFile());
			Utils.ShowMsg(this, "文件大小：" + fl.length());
			Utils.ShowMsg(this, "最后修改时间：" + fl.lastModified());
			Utils.ShowMsg(this, "是否是目录：" + fl.isDirectory());
			Utils.ShowMsg(this, "是否可写入：" + fl.canWrite());

			// File：目录
			File fDir = new File(Utils.GetTestPath());
			if (fDir.exists()) {
				String[] files = fDir.list();
				for (String t : files) {
					Utils.ShowMsg(this, t);
				}
			}

			// RandomAccessFile
			RandomAccessFile ra = new RandomAccessFile(fileNameAbsolute, "rw");
			Utils.ShowMsg(this, fileNameAbsolute);

			EmployeeModel e1 = new EmployeeModel("test1", 11);
			EmployeeModel e2 = new EmployeeModel("test2", 11);
			EmployeeModel e3 = new EmployeeModel("test3", 11);

			ra.write(e1.name.getBytes()); // 按顺序写入：先name，后age。
			ra.writeInt(e1.age);
			ra.write(e2.name.getBytes());
			ra.writeInt(e2.age);
			ra.write(e3.name.getBytes());
			ra.writeInt(e3.age);

			int len = 8;
			ra.skipBytes(8 + 4); // 8字节为name长度限制，4为age的长度。
			// ra.seek(0); //将文件指针move到开头位置。
			// ra.readByte(); //读取内容 一个byte一个byte读取

			ra.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
