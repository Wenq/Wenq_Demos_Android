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
			// ����notification������ת��Notiicaion
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
			// ������ת��Notification
			nm02 = (NotificationManager) getSystemService(this.NOTIFICATION_SERVICE);
			Notification notification02 = new Notification(R.drawable.chat,
					"����Ԥ����Ϣ", System.currentTimeMillis());
			// Notification notification03 = new Notification.Builder(this)
			// .setSubText("����ʲô").setSmallIcon(R.drawable.chat).build();
			notification02.setLatestEventInfo(this, "���ı���", "��������", null);
			nm02.notify(2, notification02);
			break;

		case R.id.btn03:
			// ȡ������notification
			if (nm02 != null) {
				nm02.cancel(2);
			}
			break;

		case R.id.btn04:
			// ȡ��notification
			if (nm01 != null) {
				// nm01.cancel(id)
				nm01.cancelAll(); // ȡ������notification
			}

		case R.id.btn05:
			// ��פ֪ͨ����Notification���Ҳ���ֱ�������
			setNotification();
			break;

		case R.id.btn06:
			// ���֪ͨ����פNotification
			cancelNotification();
			break;

		case R.id.btn07:
			// ��פ���Զ��岼�ֵ�Notification
			int icon = R.drawable.ic_launcher;
			CharSequence tickerText = "Notification01";
			long when = System.currentTimeMillis();

			Notification notification = new Notification(icon, tickerText, when);

			// �Զ���Notification����
			RemoteViews contentView = new RemoteViews(getPackageName(),
					R.layout.custom_notification); // �����Զ��岼��

			// contentView.setImageViewResource(R.id.image, R.drawable.chat);
			// contentView.setTextViewText(R.id.title, "Custom notification");
			// contentView.setTextViewText(R.id.text,
			// "This is a custom layout");

			Intent itent = new Intent().setAction(NotificationButton01); // ͨ���㲥:����֪ͨ���Զ��尴ť�����Ϣ������
			// PendingIntent pItent =
			// PendingIntent.getActivity(MainActivity.this,
			// 100, itent, PendingIntent.FLAG_UPDATE_CURRENT);
			PendingIntent pItent = PendingIntent.getBroadcast(
					MainActivity.this, 100, itent,
					PendingIntent.FLAG_UPDATE_CURRENT); // ���͹㲥
			contentView.setOnClickPendingIntent(R.id.image, pItent); // �����Զ��岼���еİ�ť������Ϊ���޷�ֱ��ͨ����Ϣ�󶨰�ť��click�߼���
			contentView.setOnClickPendingIntent(R.id.title, pItent);
			contentView.setOnClickPendingIntent(R.id.text, pItent);

			notification.contentView = contentView;

			Intent notificationIntent = new Intent(this, MainActivity.class);
			PendingIntent content = PendingIntent.getActivity(
					MainActivity.this, 0, notificationIntent, 0);
			notification.contentIntent = content;

			notification.flags = Notification.FLAG_ONGOING_EVENT; // ���ó�פ Flag

			String ns = Context.NOTIFICATION_SERVICE;
			NotificationManager mNotificationManager = (NotificationManager) getSystemService(ns);
			mNotificationManager.notify(11, notification);
			break;

		case R.id.btn08:
			// ȡ����פ���Զ��岼�ֵ�Notification

			break;

		case R.id.btn09:
			// Notification�ĸ߼�����
			// ����ʾ��+��+��˸�Ƶ�Notification

			nm02 = (NotificationManager) getSystemService(this.NOTIFICATION_SERVICE);
			Notification notifi = new Notification(R.drawable.chat, "~~~",
					System.currentTimeMillis());
			notifi.setLatestEventInfo(this, "���ı���", "��������", null);
			// ������ʾ��
			// notifi.sound = Uri.fromFile(new File(""));

			// ������: ��Ҫ����Ȩ��
			long[] vibrates = { 0, 1000, 1000, 1000 }; // �𶯹��ɣ���ֹһ�룬��һ��
			notifi.vibrate = vibrates;

			// ������˸��
			notifi.ledARGB = Color.RED; // ��˸����ɫ��һ���������ɫ��ѡ
			notifi.ledOnMS = 1000; // ����ʱ��
			notifi.ledOffMS = 1000; // ��Ϩ��ʱ��
			notifi.flags = Notification.FLAG_SHOW_LIGHTS;

			// notifi.defaults = Notification.DEFAULT_ALL; //
			// ������Ϣ���ò���ϵͳĬ��Ч�������ݵ�ǰ�ֻ���������

			nm02.notify(2, notifi);

			break;

		case R.id.btn10:
			// ȡ������ʾ��+��+��˸�Ƶ�Notification

			break;

		default:
			break;

		}
	}

	// ���ӳ�פ֪ͨ
	private void setNotification() {
		NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		Notification notification = new Notification(R.drawable.chat,
				getString(R.string.app_name), System.currentTimeMillis());
		Intent intent = new Intent(this, MainActivity.class);
		notification.flags = Notification.FLAG_ONGOING_EVENT; // ���ó�פ Flag
		PendingIntent contextIntent = PendingIntent.getActivity(this, 0,
				intent, 0);
		notification.setLatestEventInfo(getApplicationContext(),
				getString(R.string.app_name), getString(R.string.hello_world),
				contextIntent);
		notificationManager.notify(R.string.app_name, notification);
	}

	// ȡ��֪ͨ
	private void cancelNotification() {
		NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		notificationManager.cancel(R.string.app_name);
	}
}