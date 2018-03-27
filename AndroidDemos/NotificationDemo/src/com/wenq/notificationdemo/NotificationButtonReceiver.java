package com.wenq.notificationdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class NotificationButtonReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		// TODO Auto-generated method stub

		Toast.makeText(arg0, "通知栏自定义按钮单击逻辑", Toast.LENGTH_LONG).show();
	}

}
