package com.wq.dialogdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class PriorityDlg extends Dialog {

	private Context context;
	private ListView dlg_priority_lvw = null;

	public PriorityDlg(Context context) {
		super(context);
		this.context = context;
		// TODO Auto-generated constructor stub
	}

	public PriorityDlg(Context context, int theme) {
		super(context, theme);
		this.context = context;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		// 设置对话框使用的布局文件
		this.setContentView(R.layout.lvw_priority);

		dlg_priority_lvw = (ListView) findViewById(R.id.dlg_priority_lvw);

		// 设置ListView的数据源
		SimpleAdapter adapter = new SimpleAdapter(context, getPriorityList(),
				R.layout.dlg_priority, new String[] { "list_priority_img",
						"list_priority_value" }, new int[] {
						R.id.list_priority_img, R.id.list_priority_value });
		dlg_priority_lvw.setAdapter(adapter);

		// 为ListView设置监听器
		dlg_priority_lvw
				.setOnItemClickListener(new AdapterView.OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						// TODO Auto-generated method stub

					}
				});
	}

	/**
	 * 得到ListView数据源
	 * 
	 * @return
	 */
	private List<HashMap<String, Object>> getPriorityList() {
		List<HashMap<String, Object>> priorityList = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map1 = new HashMap<String, Object>();
		map1.put("list_priority_img", R.drawable.priority_not_important);
		map1.put(
				"list_priority_value",
				context.getResources().getString(
						R.string.dlg_priority_not_important));
		priorityList.add(map1);
		HashMap<String, Object> map2 = new HashMap<String, Object>();
		map2.put("list_priority_img", R.drawable.priority_general);
		map2.put("list_priority_value",
				context.getResources().getString(R.string.dlg_priority_general));
		priorityList.add(map2);
		HashMap<String, Object> map3 = new HashMap<String, Object>();
		map3.put("list_priority_img", R.drawable.priority_important);
		map3.put(
				"list_priority_value",
				context.getResources().getString(
						R.string.dlg_priority_important));
		priorityList.add(map3);
		HashMap<String, Object> map4 = new HashMap<String, Object>();
		map4.put("list_priority_img", R.drawable.priority_very_important);
		map4.put(
				"list_priority_value",
				context.getResources().getString(
						R.string.dlg_priority_very_important));
		priorityList.add(map4);

		return priorityList;
	}

}
