package com.wenq.utils;

import android.content.Context;
import android.widget.Toast;

public class Utils {

	// 文件目录
	public static String testPath = "/Nikoyo/Test/";

	/**
	 * 获取SD卡路径
	 */
	public static String GetSDCardPath() {
		return android.os.Environment.getExternalStorageDirectory().getAbsolutePath();
	}

	/**
	 * 测试用文件路径
	 */
	public static String GetTestPath() {
		return GetSDCardPath() + testPath;
	}

	/**
	 * 显示提示信息 
	 */
	public static void ShowMsg(Context context, String msg) {
		if (context != null) {
			Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
		}
	}
}
