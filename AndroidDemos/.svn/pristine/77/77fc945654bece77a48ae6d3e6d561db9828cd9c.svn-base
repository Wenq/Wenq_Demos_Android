package com.wq.dialogdemo;

import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button btn1 = (Button) findViewById(R.id.btnShowDialog1);
		Button btn2 = (Button) findViewById(R.id.btnShowDialog2);
		Button btn3 = (Button) findViewById(R.id.btnShowDialog3);
		Button btn4 = (Button) findViewById(R.id.btnShowDialog4);
		Button btn5 = (Button) findViewById(R.id.btnShowDialog5);
		Button btn6 = (Button) findViewById(R.id.btnShowDialog6);

		// android使用Dialog第一种方法：直接创建Dialog对象，然后调用Dialog对象的show和dismiss方法来控制对话框的显示和隐藏。
		View.OnClickListener btnClickListener = new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				switch (v.getId()) {
				case R.id.btnShowDialog1:
					ShowDialog1();
					break;
				case R.id.btnShowDialog2:
					ShowDialog2();
					break;
				case R.id.btnShowDialog3:
					ShowDialog3();
					break;
				case R.id.btnShowDialog4:
					ShowDialog4();
					break;
				case R.id.btnShowDialog5:
					ShowDialog5();
				case R.id.btnShowDialog6:
					ShowDialog6();
					break;
				}
			}
		};

		btn1.setOnClickListener(btnClickListener);
		btn2.setOnClickListener(btnClickListener);
		btn3.setOnClickListener(btnClickListener);
		btn4.setOnClickListener(btnClickListener);
		btn5.setOnClickListener(btnClickListener);
		btn6.setOnClickListener(btnClickListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	// 常用对话框
	private void ShowDialog1() {
		// 创建对话框
		AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
		builder.setTitle("普通对话框")
				// 标题
				.setIcon(R.drawable.ic_launcher)
				// icon
				.setCancelable(false)
				// 不响应back按钮
				.setMessage("这是一个普通对话框")
				// 对话框显示内容
				// 设置按钮
				.setPositiveButton("确定", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(MainActivity.this, "点击了确定按钮",
								Toast.LENGTH_SHORT).show();
					}
				})
				.setNeutralButton("中立", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(MainActivity.this, "点击了中立按钮",
								Toast.LENGTH_SHORT).show();
					}
				})
				.setNegativeButton("取消", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(MainActivity.this, "点击了取消按钮",
								Toast.LENGTH_SHORT).show();
					}
				});
		// 创建Dialog对象
		AlertDialog dlg = builder.create();
		dlg.show();
	}

	// 列表对话框
	private void ShowDialog2() {

		final CharSequence[] items = { "Item1", "Item2", "Item3" };
		// 创建builder
		AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
		builder.setTitle("列表对话框") // 标题
				.setIcon(R.drawable.ic_launcher) // icon
				.setCancelable(false) // 不响应back按钮
				.setItems(items, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(MainActivity.this, "选择了" + items[which],
								Toast.LENGTH_SHORT).show();
					}
				});
		// 创建Dialog对象
		AlertDialog dlg = builder.create();
		dlg.show();
	}

	// 列表可选中对话框
	private void ShowDialog3() {

		final CharSequence[] items = { "Item1", "Item2", "Item3" };
		// 创建builder
		AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
		builder.setTitle("列表对话框")
				// 标题
				.setIcon(R.drawable.ic_launcher)
				// icon
				.setCancelable(true)
				// 不响应back按钮
				.setSingleChoiceItems(items, -1,
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								Toast.makeText(MainActivity.this,
										"选择了" + items[which],
										Toast.LENGTH_SHORT).show();
							}
						});
		// 创建Dialog对象
		AlertDialog dlg = builder.create();
		dlg.show();
	}

	// 日期设置对话框
	private void ShowDialog4() {

		Calendar calendar = Calendar.getInstance();
		DatePickerDialog.OnDateSetListener dateListener = new DatePickerDialog.OnDateSetListener() {
			@Override
			public void onDateSet(DatePicker datePicker, int year, int month,
					int dayOfMonth) {
				Toast.makeText(MainActivity.this,
						year + "年" + (month + 1) + "月" + dayOfMonth + "日",
						Toast.LENGTH_SHORT).show();
			}
		};
		DatePickerDialog dlg = new DatePickerDialog(MainActivity.this,
				dateListener, calendar.get(Calendar.YEAR),
				calendar.get(Calendar.MONTH),
				calendar.get(Calendar.DAY_OF_MONTH));
		dlg.show();
	}

	// 时间设置对话框
	private void ShowDialog5() {

		Calendar calendar = Calendar.getInstance();
		TimePickerDialog.OnTimeSetListener timeListener = new TimePickerDialog.OnTimeSetListener() {

			@Override
			public void onTimeSet(TimePicker timePicker, int hourOfDay,
					int minute) {
				Toast.makeText(MainActivity.this, hourOfDay + ":" + minute,
						Toast.LENGTH_SHORT).show();
			}

		};
		TimePickerDialog dlg = new TimePickerDialog(MainActivity.this,
				timeListener, calendar.get(Calendar.HOUR_OF_DAY),
				calendar.get(Calendar.MINUTE), true);
		dlg.show();
	}

	// 自定义对话框
	private void ShowDialog6() {
		PriorityDlg dlg = new PriorityDlg(MainActivity.this,
				R.style.dlg_priority);
		dlg.show();
	}

	// android使用Dialog第二种方法：在Activity的onCreateDialog(int
	// id)方法中创建Dialog对象并返回，然后调用Activty的showDialog(int id)和dismissDialog(int
	// id)来显示和隐藏对话框。
	@Override
	public Dialog onCreateDialog(int id) {
		Dialog dialog = null;
		// switch (id) {
		// case DIALOG_SET_SEARCH_RANGE:
		// AlertDialog.Builder b = new AlertDialog.Builder(this);
		// b.setItems(null, null);
		// dialogSetRange = b.create();
		// dialog = dialogSetRange;
		// break;
		//
		// case DIALOG_SET_DATETIME:
		// AlertDialog.Builder abSetDatetime = new AlertDialog.Builder(this);
		// abSetDatetime.setItems(null, null);
		// dialogSetDatetime = abSetDatetime.create();
		// dialog = dialogSetDatetime;
		// break;
		//
		// case DIALOG_SCH_DEL_CONFIRM:
		// AlertDialog.Builder abSchDelConfirm = new AlertDialog.Builder(this);
		// abSchDelConfirm.setItems(null, null);
		// dialogSchDelConfirm = abSchDelConfirm.create();
		// dialog = dialogSchDelConfirm;
		// break;
		//
		// case DIALOG_CHECK:
		// AlertDialog.Builder abCheck = new AlertDialog.Builder(this);
		// abCheck.setItems(null, null);
		// dialogCheck = abCheck.create();
		// dialog = dialogCheck;
		// break;
		//
		// case DIALOG_ALL_DEL_CONFIRM:
		// AlertDialog.Builder abAllDelConfirm = new AlertDialog.Builder(this);
		// abAllDelConfirm.setItems(null, null);
		// dialogAllDelConfirm = abAllDelConfirm.create();
		// dialog = dialogAllDelConfirm;
		// break;
		//
		// case DIALOG_ABOUT:
		// AlertDialog.Builder abAbout = new AlertDialog.Builder(this);
		// abAbout.setItems(null, null);
		// dialogAbout = abAbout.create();
		// dialog = dialogAbout;
		// break;
		// }
		return dialog;
	}
}
