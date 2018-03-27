package com.wenq.socketdemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class socketAndroidClient extends Activity {

	EditText txtServerIP;
	EditText txtPort;
	EditText txtContent;
	EditText txtContentReceived;

	Button btnConnect;
	Button btnSend;

	Socket clientSocket;
	String HOST;
	int PORT;
	// private Socket socket = null;
	BufferedReader in = null;
	PrintWriter out = null;

	String Content;

	Handler mHandler;
	final int ShowMsg = 0x001;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		// 该setting保证在android 4.0中可以执行network相关操作
		// StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
		// .detectDiskReads().detectDiskWrites().detectNetwork()
		// .penaltyLog().build());
		// StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
		// .detectLeakedSqlLiteObjects().detectLeakedClosableObjects()
		// .penaltyLog().penaltyDeath().build());

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		txtServerIP = (EditText) findViewById(R.id.txtServerIP);
		txtPort = (EditText) findViewById(R.id.txtPort);
		txtContentReceived = (EditText) findViewById(R.id.txtContentReceived);
		txtContent = (EditText) findViewById(R.id.txtContent);
		btnConnect = (Button) findViewById(R.id.btnConnect);
		btnSend = (Button) findViewById(R.id.btnSend);

		String serverIP = txtServerIP.getText().toString().trim();
		String port = txtPort.getText().toString().trim();
		String content = txtContent.getText().toString().trim();

		this.HOST = serverIP;
		this.PORT = Integer.parseInt(port);
		this.Content = content;

		mHandler = new Handler() {

			@Override
			public void handleMessage(Message msg) {
				// TODO Auto-generated method stub
				switch (msg.what) {
				case ShowMsg:
					Toast.makeText(socketAndroidClient.this,
							msg.obj.toString(), Toast.LENGTH_LONG).show();
					break;
				}
				super.handleMessage(msg);
			}
		};

		// 连接Socket服务端
		btnConnect.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				// 线程：创建socket连接
				Thread connectThread = new Thread(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						try {
							clientSocket = new Socket(HOST, PORT); // 连接socket服务端
							in = new BufferedReader(new InputStreamReader(
									clientSocket.getInputStream()));
							out = new PrintWriter(new BufferedWriter(
									new OutputStreamWriter(clientSocket
											.getOutputStream())), true);

							// Utils.ShowMsg(socketAndroidClient.this,
							// "sokcet服务端连接成功.");

							ShowMsg("sokcet服务端连接成功.");
						} catch (IOException ex) {
							ex.printStackTrace();
							// Utils.ShowMsg(socketAndroidClient.this,
							// "连接Server失败，原因: " + ex.getMessage());
							ShowMsg("连接Server失败，原因: " + ex.getMessage());
						}
					}
				});
				connectThread.start();

				// 线程：接收服务端信息
				Thread receivedThread = new Thread(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub

						String str = null;
						while (true) {
							if (clientSocket != null
									&& clientSocket.isConnected()
									&& !clientSocket.isInputShutdown()) {

								try {
									str = in.readLine();
									// txtContentReceived.setText(str);
									// Utils.ShowMsg(socketAndroidClient.this,
									// "服务端信息： " + str);
									ShowMsg("服务端信息： " + str);
								} catch (IOException e) {
									// TODO Auto-generated catch
									// block
									e.printStackTrace();
								}
							} else {
								break;
							}
						}
					}
				});
				receivedThread.start();
			}
		});

		// 发送信息
		btnSend.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (clientSocket != null && clientSocket.isConnected()) {
					if (!clientSocket.isOutputShutdown()) {
						out.println(Content);
						out.flush();
					}
				}
			}
		});
	}

	// 显示UI提示信息
	private void ShowMsg(String info) {
		Message msg = new Message();
		msg.what = ShowMsg;
		msg.obj = info;
		mHandler.sendMessage(msg);
	}
}
