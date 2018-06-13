package hytc;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo {

	public static void main(String[] args) {
		try {
			URL mybook=new URL("http://news.baidu.com/?tn=news");
			System.out.println("Э��protocol"+mybook.getProtocol());
			System.out.println("����host"+mybook.getHost());
			System.out.println("�˿�port"+mybook.getPort());
			System.out.println("�ļ�filename"+mybook.getFile());
			System.out.println("êref"+mybook.getRef());
			System.out.println("��ѯ��Ϣquery"+mybook.getQuery());
			System.out.println("·��path"+mybook.getPath());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
