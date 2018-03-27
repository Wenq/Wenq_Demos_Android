package com.wenq.onsaveinstancestatedemo;

import java.io.File;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.MediaController;
import android.widget.VideoView;

public class VedioViewActivity extends Activity {

	private VideoView videoView;
	// 测试视频地址
	private static final String VIDEO_PATH = Environment
			.getExternalStorageDirectory()
			+ File.separator
			+ "wq"
			+ File.separator + "movie" + File.separator + "jwdwhj.mp4";  //android自带的VedioView控件，似乎不支持rmvb格式

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vedio_view);
		Log.v("tag", "onCreate");

		if (videoView == null) {
			videoView = (VideoView) this.findViewById(R.id.myvideo);
			MediaController controller = new MediaController(this);
			videoView.setMediaController(controller);
			videoView.setVideoPath(VIDEO_PATH);
			videoView.requestFocus();
		}

		if (savedInstanceState != null
				&& savedInstanceState.getInt("currentposition") != 0) {

			videoView.seekTo(savedInstanceState.getInt("currentposition")); //读取保存进度
		}
		videoView.start();
	}

	//保存环境信息
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub

		// TODO:保存当前视频播放器播放进度
		outState.putInt("currentposition", videoView.getCurrentPosition()); //保存当前进度
		Log.v("tag", "onSaveInstanceState");
		super.onSaveInstanceState(outState);
	}

	//使用环境信息，恢复环境。与在OnCreate（）中使用savedInstanceState一样
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onRestoreInstanceState(savedInstanceState);
	}
	
	
}
