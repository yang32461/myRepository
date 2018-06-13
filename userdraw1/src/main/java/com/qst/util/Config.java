package com.qst.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/***
 * 获取配置信息，通过指定文件
 * 并将配置文件内容作为常量
 *
 */
public class Config {
	static Properties properties;
	static{
		properties = new Properties();
		//可以获取资源文件
		InputStream inStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("UserDraw.properties");
		try {
			properties.load(inStream);//通过输入流读取配置文件信息
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//UserDraw 将配置文件中的内容定义为常量
	public String Separator = properties.getProperty("Separator");
	public String Date = properties.getProperty("Date");
	public String MDN = properties.getProperty("MDN");
	public String appID = properties.getProperty("appID");
	public String count = properties.getProperty("count");
	public String ProcedureTime = properties.getProperty("ProcedureTime");
	}
