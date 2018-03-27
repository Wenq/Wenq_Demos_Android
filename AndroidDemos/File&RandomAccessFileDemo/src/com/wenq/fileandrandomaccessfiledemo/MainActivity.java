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

			// File: �ļ�
			File fl = new File(fileNameAbsolute);
			if (!fl.exists()) {
				fl.createNewFile(); // ���������ڵ��ļ�
			}
			Utils.ShowMsg(this, fl.getAbsolutePath());
			Utils.ShowMsg(this, "�Ƿ����ļ���" + fl.isFile());
			Utils.ShowMsg(this, "�ļ���С��" + fl.length());
			Utils.ShowMsg(this, "����޸�ʱ�䣺" + fl.lastModified());
			Utils.ShowMsg(this, "�Ƿ���Ŀ¼��" + fl.isDirectory());
			Utils.ShowMsg(this, "�Ƿ��д�룺" + fl.canWrite());

			// File��Ŀ¼
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

			ra.write(e1.name.getBytes()); // ��˳��д�룺��name����age��
			ra.writeInt(e1.age);
			ra.write(e2.name.getBytes());
			ra.writeInt(e2.age);
			ra.write(e3.name.getBytes());
			ra.writeInt(e3.age);

			int len = 8;
			ra.skipBytes(8 + 4); // 8�ֽ�Ϊname�������ƣ�4Ϊage�ĳ��ȡ�
			// ra.seek(0); //���ļ�ָ��move����ͷλ�á�
			// ra.readByte(); //��ȡ���� һ��byteһ��byte��ȡ

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
