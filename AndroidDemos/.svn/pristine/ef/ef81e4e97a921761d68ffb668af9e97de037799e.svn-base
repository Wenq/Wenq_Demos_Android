package com.wenq.gameview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

public class MyView extends View {

	private float startX, startY;

	public MyView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub

		startX = 10;
		startY = 10;

		setFocusable(true);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub

		Paint paint = new Paint();
		paint.setColor(Color.RED);
		paint.setTextSize(50);
		canvas.drawText("测试文本.", startX, startY, paint);

		super.onDraw(canvas);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		return super.onKeyUp(keyCode, event);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub

		startX = event.getX();
		startY = event.getY();
		invalidate(); // 主动refresh UI
		// postInvalidate();

		// return super.onTouchEvent(event);
		return true; // 必须返回true，否则this View无法处理Touch Move消息
	}

}
