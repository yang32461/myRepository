package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketDemo {

	public static void main(String[] args) throws IOException {
		
		ServerSocket sc=new ServerSocket(28888);
		System.out.println("服务器已启动");
		int num=0;
		while(true){
		Socket socket=sc.accept();
		System.out.println("开始连接客户端");
		//OutputStream os=socket.getOutputStream();
		//os.write("你好我是服务器！\n".getBytes());
		PrintStream ps=new PrintStream(socket.getOutputStream());
		ps.println("你好，我是服务器");
		
		BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		System.out.println(br.readLine());
		br.close();
		ps.close();
		socket.close();
		
		sc.close();
		}

	}

}
