
/*
 * @Author: AChangAZha
 * @Date: 2021-12-04 16:53:30
 * @LastEditTime: 2021-12-29 11:11:22
 * @LastEditors: AChangAZha
 */
import java.io.*;
import java.net.*;
import java.util.*;

public class FileClient {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		Socket clientSocket = null;
		BufferedReader inData = null;
		PrintWriter outData = null;
		Thread thread;
		FileRead read = null;
		try {
			read = new FileRead();
			thread = new Thread(read);
			System.out.print("�����������IP:");
			String IP = scanner.nextLine();
			System.out.print("����˿ں�:");
			int port = scanner.nextInt();
			scanner.nextLine();
			clientSocket = new Socket(IP, port);
			InputStream in = clientSocket.getInputStream();
			OutputStream out = clientSocket.getOutputStream();
			inData = new BufferedReader(new InputStreamReader(in));
			outData = new PrintWriter(new BufferedWriter(new OutputStreamWriter(out)), true);
			read.setBufferedReader(inData);
			read.setPrintWriter(outData);
			thread.start();
		} catch (Exception e) {
			System.out.println("�������ѶϿ�" + e);
		}
	}
}

class FileRead implements Runnable {
	Scanner scanner = new Scanner(System.in);
	BufferedReader in;
	PrintWriter out;

	public void setBufferedReader(BufferedReader in) {
		this.in = in;
	}

	public void setPrintWriter(PrintWriter out) {
		this.out = out;
	}

	public void run() {
		try {
			System.out.println("�����ļ���:");
			String fileInfo = scanner.nextLine();
			out.println(fileInfo);
			String str = in.readLine();
			System.out.println(str);
			System.out.println("�����ļ�����:");
			fileInfo = scanner.nextLine();
			out.println(fileInfo);
			str = in.readLine();
			System.out.println(str);
			System.out.println("�����ļ�����:");
			fileInfo = scanner.nextLine();
			out.println(fileInfo);
			str = in.readLine();
			System.out.println(str);
		} catch (Exception e) {
		}
	}
}
