package hytc;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo {

	public static void main(String[] args) {
		try {
			URL mybook=new URL("http://news.baidu.com/?tn=news");
			System.out.println("协议protocol"+mybook.getProtocol());
			System.out.println("主机host"+mybook.getHost());
			System.out.println("端口port"+mybook.getPort());
			System.out.println("文件filename"+mybook.getFile());
			System.out.println("锚ref"+mybook.getRef());
			System.out.println("查询信息query"+mybook.getQuery());
			System.out.println("路径path"+mybook.getPath());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
