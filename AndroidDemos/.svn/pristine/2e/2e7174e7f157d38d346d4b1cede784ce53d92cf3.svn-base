package com.wenq.softreferencedemo;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;

//softreference：图像异步加载封装 
/***
 * 异步加载图片 缓存的实现
 * 
 * @author jia
 * 
 */
public class AsyncImageLoader {
	// 软引用
	private HashMap<String, SoftReference<Drawable>> imageCache;

	public AsyncImageLoader() {
		imageCache = new HashMap<String, SoftReference<Drawable>>();
	}

	/***
	 * 下载图片
	 * 
	 * @param imageUrl
	 *            图片地址
	 * @param imageCallback
	 *            回调接口
	 * @return
	 */
	public Drawable loadDrawable(final String imageUrl,
			final ImageCallback imageCallback) {

		// 软引用中查找图像
		if (imageCache.containsKey(imageUrl)) {
			SoftReference<Drawable> softReference = imageCache.get(imageUrl);
			Drawable drawable = softReference.get();
			if (drawable != null) {
				return drawable;
			}
		}

		// 软引用中没找到图像
		final Handler handler = new Handler() {
			public void handleMessage(Message message) {
				imageCallback.imageLoaded((Drawable) message.obj, imageUrl); // 调用回调接口
			}
		};

		// 开启线程下载图片
		new Thread() {
			@Override
			public void run() {
				Drawable drawable = loadImageFromUrl(imageUrl);
				// 将下载的图片保存至缓存中（软引用列表中）
				imageCache.put(imageUrl, new SoftReference<Drawable>(drawable));
				Message message = handler.obtainMessage(0, drawable); // 设置message对象参数
				handler.sendMessage(message);
			}
		}.start();

		return null;
	}

	/***
	 * 根据URL下载图片（这里要进行判断，先去本地sd中查找，没有则根据URL下载，有则返回该drawable）
	 * 
	 * @param url
	 * @return
	 */
	public static Drawable loadImageFromUrl(String url) {

		// Bitmap bitmap = Utils.GetBitmap(imageURL, 100);
		// Drawable drawable = new BitmapDrawable(bitmap);
		// return drawable;

		URL m;
		InputStream i = null;
		try {
			m = new URL(url);
			i = (InputStream) m.getContent();
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Drawable d = Drawable.createFromStream(i, "src");
		return d;
	}

	// 回调接口
	public interface ImageCallback {
		public void imageLoaded(Drawable imageDrawable, String imageUrl);
	}
}
