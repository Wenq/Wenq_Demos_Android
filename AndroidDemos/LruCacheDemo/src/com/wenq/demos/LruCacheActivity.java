package com.wenq.demos;

import com.wenq.lrucachedemo.R;
import com.wenq.strongreferencedemo.Images;
import com.wenq.strongreferencedemo.PhotoWallAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.GridView;

//图片缓存  参考blog：http://blog.csdn.net/guolin_blog/article/details/9526203
public class LruCacheActivity extends Activity {

	/**
	 * 用于展示照片墙的GridView
	 */
	private GridView mPhotoWall;

	/**
	 * GridView的适配器
	 */
	private PhotoWallAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lru_cache);

		mPhotoWall = (GridView) findViewById(R.id.photo_wall);
		adapter = new PhotoWallAdapter(this, 0, Images.imageThumbUrls,
				mPhotoWall);
		mPhotoWall.setAdapter(adapter);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();

		// 退出程序时结束所有的下载任务
		adapter.cancelAllTasks();
	}

}
