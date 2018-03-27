package com.wenq.inputstreamandoutputstreamdemo;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.SequenceInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.wenq.Utils.Utils;
import com.wenq.fileinputstreamfileoutputstreamdemo.R;

import android.os.Bundle;
import android.app.Activity;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		String filepath = Utils.GetTestPath() + "demo.txt";

		try {

			// ----------------------------------字节流-------------------------------------//

			// FileOutputStream :写入信息
			FileOutputStream out = new FileOutputStream(filepath, false); // false:直接覆盖

			Date dateNow = new Date(); // 获取当前系统日期+时间
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			String str = format.format(dateNow);
			out.write(str.getBytes()); // 字符串转byte[]
			out.flush();
			out.close();

			// FileInputStream ：读出信息
			FileInputStream in = new FileInputStream(filepath);
			byte[] buffer = new byte[in.available()];
			int length;
			length = in.read(buffer); // 读取内容
			String result = new String(buffer, 0, buffer.length); // in.available()是以当前位置为准，剩余可读长度
			in.close();

			ShowMsg("FileInputStream 读取内容为： " + result);

			// ----------------------------------字符流-------------------------------------//
			// 大概针对Unicode编码的文件进行操作 //

			// FileWriter
			try {
				FileWriter writer = new FileWriter(filepath, true); // true：只追加，不覆盖。默认覆盖。
				writer.append('我');
				writer.write(",我是谁？我从哪里来？");
				writer.flush();
				writer.close(); // close之前，可以不调用flush()方法，close（）有相同作用。
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// FileReader
			FileReader reader = new FileReader(filepath);
			char[] buf = new char[1024];
			reader.read(buf);
			reader.close();

			ShowMsg("FileReader 读取内容为： " + String.valueOf(buf));

			// ----------------------------------管道流-------------------------------------//
			// PipedInputStream; PipedOutputStream
			// 暂不写Demo，认为应用不多。

			// ------------ByteArrayInputStream 与
			// ByteArrayOutputStream--------------------//
			// 不太明白其使用场景，暂不介绍。

			// ----------------------------------打印流-------------------------------------//

			// PrintStream

			// PrintWriter
			PrintWriter pw = new PrintWriter(filepath);
			pw.println("向文件中写入数据.");
			pw.flush();
			pw.close();

			// ---------------------DataInputStream和DataOutputStream------------------------//

			DataOutputStream dataOut = new DataOutputStream(
					new FileOutputStream(filepath, false));
			// 数据格式： "225tab12tab商品名称\n"，实际显示为：225 12 商品名称
			dataOut.writeDouble(225);
			dataOut.writeChar('\t'); // tab
			dataOut.writeInt(12);
			dataOut.writeChar('\t');
			dataOut.writeChars("商品名称");
			dataOut.writeChar('\n'); // 换行符
			dataOut.close();

			DataInputStream dataIn = new DataInputStream(new FileInputStream(
					filepath));
			double double1 = dataIn.readDouble();
			int int1 = dataIn.readInt();
			char tmp;
			StringBuffer sb = new StringBuffer();
			while ((tmp = dataIn.readChar()) != '\n') {
				sb.append(tmp);
			}

			dataIn.close();
			ShowMsg("DataInputStream读取数据为： " + double1 + " " + int1 + " "
					+ sb.toString());

			// -----------------------------------合并流-----------------------------------//

			// SequenceInputStream
			FileInputStream in1 = new FileInputStream("");
			FileInputStream in2 = new FileInputStream("");
			SequenceInputStream s = new SequenceInputStream(in1, in2);
			int leng = s.available();
			byte[] bufferBytes = new byte[leng];
			s.read(bufferBytes);
			s.close();

			// BufferedReader
			BufferedReader br = new BufferedReader(new FileReader("")); // 从文件读取
			br.readLine();
			// br.read(buffer)
			br.close();

			BufferedReader br1 = new BufferedReader(new InputStreamReader(
					System.in)); // 从键盘读取
			br1.readLine();
			br1.close();

			// BufferedWriter

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void ShowMsg(String msg) {
		Utils.ShowMsg(this, msg);
	}

}
