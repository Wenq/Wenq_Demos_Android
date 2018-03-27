package SocketDemo_PCServer.wenq.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class socketPCServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// try {
		// System.out.println("这是第一个java console program！");
		// System.in.read();
		// System.out.println("console is over!");
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		ServerSocket serverSocket = null; // Socket服务端
		Socket clientSocket = null;

		PrintWriter out = null; // 输出到socket客户端
		BufferedReader in = null; // 接收socket客户端的输入

		int Port = 9001; // server监听端口

		try {
			serverSocket = new ServerSocket(Port); // 服务端Socket对象
			System.out.println("Socket服务端开始监听，地址："
					+ serverSocket.getLocalSocketAddress().toString());
			clientSocket = serverSocket.accept(); // 阻塞式，等待客户端连接

			out = new PrintWriter(clientSocket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(
					clientSocket.getInputStream()));

			String str = null;
			while (true) { // 不断接收socket客户端输入，直到客户端输入"bye"
				str = in.readLine();
				if (str != null && !str.isEmpty()) {

					out.write("who are you? fine, think you!"); // 输出信息到socket客户端
					out.flush();

					System.out.println("socket客户端输入内容:" + str);

					if (str.equalsIgnoreCase("bye")) // socket客户端传入“bye”，则结束通信.
					{
						System.out.println("socket客户端结束通信.");
						break;
					}
				}
			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (serverSocket != null)
					serverSocket.close();
				if (clientSocket != null)
					clientSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
