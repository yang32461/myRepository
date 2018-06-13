package com.qst.Util;

import java.text.DecimalFormat;

public class CountPercent {
	public static String myPercent(int y, int z) { 
	    String percent = "";// 接受百分比的值 
	    double baiy = y * 1.0; 
	    double baiz = z * 1.0; 
	    double fen = baiy / baiz; 
	    DecimalFormat df1 = new DecimalFormat("##0.0%");// ##.0% 
	    // 百分比格式，后面不足1位的用0补齐 
	    percent = df1.format(fen); 
//	    System.out.println(percent); 
	    return percent; 
	  } 
}
