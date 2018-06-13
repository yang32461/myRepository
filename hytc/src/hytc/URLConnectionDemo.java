package hytc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionDemo {

	public static void main(String[] args) throws IOException {

		try {
			URL mybook=new URL("http://news.baidu.com/?tn=news");
			URLConnection urlCon=mybook.openConnection();
			urlCon.setRequestProperty("Charset","UTF-8");
			BufferedReader buffer=new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
			String inputline;
			// 循环读取并打印数据
			while((inputline=buffer.readLine())!=null){
				System.out.println(inputline);
			}
			//关闭输入流
			buffer.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
