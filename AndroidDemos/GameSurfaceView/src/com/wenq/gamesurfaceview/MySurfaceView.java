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

	// ˢ���߳�(��ʹUI��userû�н�����Ҳ����ˢ��)
	private Thread th;
	// ����
	private Canvas canvas;
	// ��ʶλ
	private boolean flag;
	// View�Ŀ��
	private int screenW, screenH;

	public MySurfaceView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub

		// setFocusable(true); //����Ҫ����

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
		screenH = this.getHeight(); // create֮����ܻ�ȡ��������ֵ=0

		flag = true;
		// ʵ���߳�
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
	 * ����ͼ��
	 */
	private void MyDraw() {

		try {
			canvas = sfh.lockCanvas();
			if (canvas != null) {
				canvas.drawColor(Color.BLACK); // refresh����
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
					Thread.sleep(50 - end - start); // ��֤ÿ��UIˢ��ʱ������50ms������
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
