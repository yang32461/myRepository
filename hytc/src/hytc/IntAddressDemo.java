package hytc;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;


public class IntAddressDemo {

	public static void main(String[] args) throws IOException {
		try {
			//获取本机地址
			InetAddress localip=InetAddress.getLocalHost();
			System.out.println("localip.getCanonicalHostName()"+":"+localip.getCanonicalHostName());
			System.out.println("localip.getHostAddress()"+":"+localip.getHostAddress());
			System.out.println("localip.getHostName()"+":"+localip.getHostName());
			System.out.println("localip.toString()"+":"+localip.toString());
			System.out.println("localip.isReachable(5000)"+":"+localip.isReachable(5000));
			System.out.println("******************************");
			
			//获取指定域名地址信息
			InetAddress baiduIp=InetAddress.getByName("www.baidu.com");
			System.out.println("baiduIp.getCanonicalHostName()"+":"+baiduIp.getCanonicalHostName());
			System.out.println("baiduIp.getHostAddress()"+":"+baiduIp.getHostAddress());
			System.out.println("baiduIp.getHostName()"+":"+baiduIp.getHostName());
			System.out.println("baiduIp.toString()"+":"+baiduIp.toString());
			System.out.println("baiduIp.isReachable(5000)"+":"+baiduIp.isReachable(5000));
			
			System.out.println("******************************");
			//获取指定原始IP地址信息
			//InetAddress ip=InetAddress.getByAddress(new byte[]{192.168.14.44});
			InetAddress ip=InetAddress.getByName("192.168.14.44");
			System.out.println("ip.getCanonicalHostName()"+":"+ip.getCanonicalHostName());
			System.out.println("ip.getHostAddress()"+":"+ip.getHostAddress());
			System.out.println("ip.getHostName()"+":"+ip.getHostName());
			System.out.println("ip.toString()"+":"+ip.toString());
			System.out.println("ip.isReachable(5000)"+":"+ip.isReachable(5000));
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
