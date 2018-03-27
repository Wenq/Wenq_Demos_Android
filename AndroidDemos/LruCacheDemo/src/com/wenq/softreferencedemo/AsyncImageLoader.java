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

//softreference��ͼ���첽���ط�װ 
/***
 * �첽����ͼƬ �����ʵ��
 * 
 * @author jia
 * 
 */
public class AsyncImageLoader {
	// ������
	private HashMap<String, SoftReference<Drawable>> imageCache;

	public AsyncImageLoader() {
		imageCache = new HashMap<String, SoftReference<Drawable>>();
	}

	/***
	 * ����ͼƬ
	 * 
	 * @param imageUrl
	 *            ͼƬ��ַ
	 * @param imageCallback
	 *            �ص��ӿ�
	 * @return
	 */
	public Drawable loadDrawable(final String imageUrl,
			final ImageCallback imageCallback) {

		// �������в���ͼ��
		if (imageCache.containsKey(imageUrl)) {
			SoftReference<Drawable> softReference = imageCache.get(imageUrl);
			Drawable drawable = softReference.get();
			if (drawable != null) {
				return drawable;
			}
		}

		// ��������û�ҵ�ͼ��
		final Handler handler = new Handler() {
			public void handleMessage(Message message) {
				imageCallback.imageLoaded((Drawable) message.obj, imageUrl); // ���ûص��ӿ�
			}
		};

		// �����߳�����ͼƬ
		new Thread() {
			@Override
			public void run() {
				Drawable drawable = loadImageFromUrl(imageUrl);
				// �����ص�ͼƬ�����������У��������б��У�
				imageCache.put(imageUrl, new SoftReference<Drawable>(drawable));
				Message message = handler.obtainMessage(0, drawable); // ����message�������
				handler.sendMessage(message);
			}
		}.start();

		return null;
	}

	/***
	 * ����URL����ͼƬ������Ҫ�����жϣ���ȥ����sd�в��ң�û�������URL���أ����򷵻ظ�drawable��
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

	// �ص��ӿ�
	public interface ImageCallback {
		public void imageLoaded(Drawable imageDrawable, String imageUrl);
	}
}
