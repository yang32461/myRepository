package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocketDemo {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket=new Socket("127.0.0.1",28888);
		//OutputStream os=socket.getOutputStream();
		//os.write("你好我是张三！\n".getBytes());
		PrintStream ps=new PrintStream(socket.getOutputStream());
		ps.println(" 你好 我是李四");
		
		BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		System.out.println(br.readLine());
		
		br.close();
		ps.close();
		
		socket.close();
	}

}
