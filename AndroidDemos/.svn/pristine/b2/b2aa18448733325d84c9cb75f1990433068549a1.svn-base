package com.wenq.asynctaskdemo;

import android.os.AsyncTask;
import android.os.SystemClock;

//android异步对象AsyncTask
public class AsyncTaskSub01 extends AsyncTask<String, Integer, Long> {

	@Override
	protected void onProgressUpdate(Integer... progress) {
		
		//this.publishProgress(values); //调用该接口，触发onProgressUpdate
	}

	@Override
	protected void onPostExecute(Long result) {
	}

	@Override
	protected Long doInBackground(String... params) {
		// TODO Auto-generated method stub

		SystemClock.sleep(2000);
		return null;
	}

}
