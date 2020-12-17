package com.item.utiles;


import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {
	public static String getFormatDate(Date date,String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d=new Date();
		System.out.println(sdf.format(d));
	}
}
