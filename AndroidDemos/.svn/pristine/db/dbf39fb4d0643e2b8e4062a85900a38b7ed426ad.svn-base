package com.wenq.notificationdemo;

import java.io.File;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RemoteViews;
import android.widget.Toast;
import android.app.Activity;
import android.app.PendingIntent;
import android.app.NotificationManager;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

public class MainActivity extends Activity implements OnClickListener {

	NotificationManager nm01;
	NotificationManager nm02;

	public final static String NotificationButton01 = "com.wenq.notificationdemo.NotificationButton";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button btn01 = (Button) findViewById(R.id.btn01);
		Button btn02 = (Button) findViewById(R.id.btn02);
		Button btn03 = (Button) findViewById(R.id.btn03);
		Button btn04 = (Button) findViewById(R.id.btn04);
		Button btn05 = (Button) findViewById(R.id.btn05);
		Button btn06 = (Button) findViewById(R.id.btn06);
		Button btn07 = (Button) findViewById(R.id.btn07);
		Button btn08 = (Button) findViewById(R.id.btn08);
		Button btn09 = (Button) findViewById(R.id.btn09);
		Button btn10 = (Button) findViewById(R.id.btn10);

		btn01.setOnClickListener(this);
		btn02.setOnClickListener(this);
		btn03.setOnClickListener(this);
		btn04.setOnClickListener(this);
		btn05.setOnClickListener(this);
		btn06.setOnClickListener(this);
		btn07.setOnClickListener(this);
		btn08.setOnClickListener(this);
		btn09.setOnClickListener(this);
		btn10.setOnClickListener(this);

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

		switch (arg0.getId()) {

		case R.id.btn01:
			// 发送notification：可跳转的Notiicaion
			Context context = this.getApplicationContext();
			nm01 = (NotificationManager) getSystemService(context.NOTIFICATION_SERVICE);
			Notification notification01 = new Notification(R.drawable.chat,
					"Hello,there!", System.currentTimeMillis());
			notification01.flags = Notification.FLAG_AUTO_CANCEL;
			// Intent i = new Intent(arg0.getContext(), NotificationShow.class);
			Intent i = new Intent(this, MainActivity.class);
			i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
					| Intent.FLAG_ACTIVITY_NEW_TASK);
			// PendingIntent
			PendingIntent contentIntent = PendingIntent.getActivity(context,
					R.string.app_name, i, PendingIntent.FLAG_UPDATE_CURRENT);

			notification01.setLatestEventInfo(context, "Hello,there!",
					"Hello,there,I'm john.", contentIntent);
			nm01.notify(R.string.app_name, notification01);
			break;

		case R.id.btn02:
			// 不可跳转的Notification
			nm02 = (NotificationManager) getSystemService(this.NOTIFICATION_SERVICE);
			Notification notification02 = new Notification(R.drawable.chat,
					"这是预览信息", System.currentTimeMillis());
			// Notification notification03 = new Notification.Builder(this)
			// .setSubText("这是什么").setSmallIcon(R.drawable.chat).build();
			notification02.setLatestEventInfo(this, "正文标题", "这是正文", null);
			nm02.notify(2, notification02);
			break;

		case R.id.btn03:
			// 取消单个notification
			if (nm02 != null) {
				nm02.cancel(2);
			}
			break;

		case R.id.btn04:
			// 取消notification
			if (nm01 != null) {
				// nm01.cancel(id)
				nm01.cancelAll(); // 取消所有notification
			}

		case R.id.btn05:
			// 常驻通知栏的Notification，且不可直接清除。
			setNotification();
			break;

		case R.id.btn06:
			// 清楚通知栏常驻Notification
			cancelNotification();
			break;

		case R.id.btn07:
			// 常驻且自定义布局的Notification
			int icon = R.drawable.ic_launcher;
			CharSequence tickerText = "Notification01";
			long when = System.currentTimeMillis();

			Notification notification = new Notification(icon, tickerText, when);

			// 自定义Notification布局
			RemoteViews contentView = new RemoteViews(getPackageName(),
					R.layout.custom_notification); // 加载自定义布局

			// contentView.setImageViewResource(R.id.image, R.drawable.chat);
			// contentView.setTextViewText(R.id.title, "Custom notification");
			// contentView.setTextViewText(R.id.text,
			// "This is a custom layout");

			Intent itent = new Intent().setAction(NotificationButton01); // 通过广播:处理通知栏自定义按钮点击消息？？？
			// PendingIntent pItent =
			// PendingIntent.getActivity(MainActivity.this,
			// 100, itent, PendingIntent.FLAG_UPDATE_CURRENT);
			PendingIntent pItent = PendingIntent.getBroadcast(
					MainActivity.this, 100, itent,
					PendingIntent.FLAG_UPDATE_CURRENT); // 发送广播
			contentView.setOnClickPendingIntent(R.id.image, pItent); // 设置自定义布局中的按钮，其行为。无法直接通过消息绑定按钮的click逻辑。
			contentView.setOnClickPendingIntent(R.id.title, pItent);
			contentView.setOnClickPendingIntent(R.id.text, pItent);

			notification.contentView = contentView;

			Intent notificationIntent = new Intent(this, MainActivity.class);
			PendingIntent content = PendingIntent.getActivity(
					MainActivity.this, 0, notificationIntent, 0);
			notification.contentIntent = content;

			notification.flags = Notification.FLAG_ONGOING_EVENT; // 设置常驻 Flag

			String ns = Context.NOTIFICATION_SERVICE;
			NotificationManager mNotificationManager = (NotificationManager) getSystemService(ns);
			mNotificationManager.notify(11, notification);
			break;

		case R.id.btn08:
			// 取消常驻且自定义布局的Notification

			break;

		case R.id.btn09:
			// Notification的高级技巧
			// 带提示音+震动+闪烁灯的Notification

			nm02 = (NotificationManager) getSystemService(this.NOTIFICATION_SERVICE);
			Notification notifi = new Notification(R.drawable.chat, "~~~",
					System.currentTimeMillis());
			notifi.setLatestEventInfo(this, "正文标题", "这是正文", null);
			// 设置提示音
			// notifi.sound = Uri.fromFile(new File(""));

			// 设置震动: 需要配置权限
			long[] vibrates = { 0, 1000, 1000, 1000 }; // 震动规律：静止一秒，震动一秒
			notifi.vibrate = vibrates;

			// 设置闪烁灯
			notifi.ledARGB = Color.RED; // 闪烁灯颜色：一般红绿蓝三色可选
			notifi.ledOnMS = 1000; // 灯亮时长
			notifi.ledOffMS = 1000; // 等熄灭时长
			notifi.flags = Notification.FLAG_SHOW_LIGHTS;

			// notifi.defaults = Notification.DEFAULT_ALL; //
			// 所有消息设置采用系统默认效果：根据当前手机环境进行

			nm02.notify(2, notifi);

			break;

		case R.id.btn10:
			// 取消带提示音+震动+闪烁灯的Notification

			break;

		default:
			break;

		}
	}

	// 添加常驻通知
	private void setNotification() {
		NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		Notification notification = new Notification(R.drawable.chat,
				getString(R.string.app_name), System.currentTimeMillis());
		Intent intent = new Intent(this, MainActivity.class);
		notification.flags = Notification.FLAG_ONGOING_EVENT; // 设置常驻 Flag
		PendingIntent contextIntent = PendingIntent.getActivity(this, 0,
				intent, 0);
		notification.setLatestEventInfo(getApplicationContext(),
				getString(R.string.app_name), getString(R.string.hello_world),
				contextIntent);
		notificationManager.notify(R.string.app_name, notification);
	}

	// 取消通知
	private void cancelNotification() {
		NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		notificationManager.cancel(R.string.app_name);
	}
}
