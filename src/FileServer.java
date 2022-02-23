/*
 * @Author: AChangAZha
 * @Date: 2021-12-09 08:20:48
 * @LastEditTime: 2021-12-29 11:09:12
 * @LastEditors: AChangAZha
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class FileServer {
    public static void main(String args[]) throws IOException {
        ServerSocket server = null;
        Socket socket = null;
        try {
            server = new ServerSocket(4331);
        } catch (IOException e) {
            System.out.println("创建服务器ServerSocket失败");
            System.exit(1);
        }
        while (true) {
            try {
                System.out.println("正在等待客户端连接");
                socket = server.accept();
                System.out.println("客户端地址:" + socket.getInetAddress());
                System.out.println("客户端端口:" + socket.getPort());
            } catch (IOException e) {
                System.out.println("" + e);
            }
            if (socket != null) {
                new FileServerThread(socket).start();
            }
        }
    }
}

class FileServerThread extends Thread {
    Socket socket;
    BufferedReader in = null;
    PrintWriter out = null;

    FileServerThread(Socket t) {
        socket = t;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        } catch (IOException e) {
        }
    }

    public void run() {
        try {
            System.out.println("正在等待客户端(" + socket.getInetAddress() + ":" + socket.getPort() + ")发送文件名");
            String fileName;
            fileName = in.readLine();
            System.out.println("收到来自客户端(" + socket.getInetAddress() + ":" + socket.getPort() + ")的文件名" + fileName);
            out.println("收到文件名" + fileName);
            System.out.println("正在等待客户端(" + socket.getInetAddress() + ":" + socket.getPort() + ")发送文件长度");
            String fileLength;
            fileLength = in.readLine();
            System.out.println("收到来自客户端(" + socket.getInetAddress() + ":" + socket.getPort() + ")的文件长度" + fileLength);
            out.println("收到文件长度" + fileLength);
            System.out.println("正在等待客户端(" + socket.getInetAddress() + ":" + socket.getPort() + ")发送文件内容");
            System.out.println("请输入来自客户端(" + socket.getInetAddress() + ":" + socket.getPort() + ")的文件名");
            String fileContent;
            Scanner scanner = new Scanner(System.in);
            fileName = scanner.nextLine();
            fileContent = in.readLine();
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(fileName + ".txt");
                fos.write(fileContent.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            out.println("文件接收成功");
            System.out.println("来自客户端(" + socket.getInetAddress() + ":" + socket.getPort() + ")的文件保存成功");
        } catch (Exception exp) {
        }
    }

}
