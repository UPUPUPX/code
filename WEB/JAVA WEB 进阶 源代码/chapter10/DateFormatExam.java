package cn.itcast.chapter10;
import java.text.*;
import java.util.*;
public class DateFormatExam {
	public static void main(String[] args) throws ParseException {
		// 获取本地默认的DateFormat对象
		DateFormat df=DateFormat.getDateTimeInstance();	
		// 获取本地默认的DateFormat对象
		DateFormat df1=DateFormat.getDateInstance();    		
		Date date=new Date();
		System.out.println("使用默认的本地信息对日期/时间进行格式化：");
		System.out.println(df.format(date));
		System.out.println("使用默认的本地信息解析日期/时间字符串：");
		System.out.println(df1.parse("2013-12-11"));
	}
}
