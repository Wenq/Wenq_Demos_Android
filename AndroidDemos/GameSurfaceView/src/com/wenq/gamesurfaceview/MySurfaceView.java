package com.wenq.gamesurfaceview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class MySurfaceView extends SurfaceView implements Callback, Runnable {

	private SurfaceHolder sfh;
	private Paint paint;

	private float startX, startY;

	// 刷新线程(即使UI与user没有交互，也不断刷新)
	private Thread th;
	// 画布
	private Canvas canvas;
	// 标识位
	private boolean flag;
	// View的宽高
	private int screenW, screenH;

	public MySurfaceView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub

		// setFocusable(true); //不需要调用

		startX = 10;
		startY = 10;

		sfh = this.getHolder();
		paint = new Paint();
		paint.setColor(Color.WHITE);
		paint.setTextSize(50);

		sfh.addCallback(this);
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub

		screenW = this.getWidth();
		screenH = this.getHeight(); // create之后才能获取到，否则值=0

		flag = true;
		// 实例线程
		th = new Thread(this);
		th.start();
		// MyDraw();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		flag = false;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub

		startX = event.getX();
		startY = event.getY();
		// invalidate();
		// MyDraw();
		// return super.onTouchEvent(event);
		return true;
	}

	/*
	 * 绘制图像
	 */
	private void MyDraw() {

		try {
			canvas = sfh.lockCanvas();
			if (canvas != null) {
				canvas.drawColor(Color.BLACK); // refresh画布
				// canvas.drawRGB(0, 0, 0);
				// canvas.drawRect(r, paint);
				canvas.drawText("dddddddddd", startX, startY, paint);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (canvas != null) {
				sfh.unlockCanvasAndPost(canvas);
			}
		}
	}

	private void logic() {

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (flag) {
			long start = System.currentTimeMillis();
			MyDraw();
			logic();
			long end = System.currentTimeMillis();
			try {
				if ((end - start) < 50) {
					Thread.sleep(50 - end - start); // 保证每次UI刷新时间间隔在50ms或以上
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
