package cn.itcast.chapter10;
import java.text.*;
import java.util.*;
public class NumberFormatExam {
	public static void main(String[] args) throws ParseException {
		System.out.println("--------------格式化数值--------------");
		NumberFormat nf=NumberFormat.getNumberInstance();
		System.out.println("使用本地信息格式化数值："+nf.format(101.5));
		NumberFormat nf1=NumberFormat.getPercentInstance();
		System.out.println("使用百分比形式格式化数值："+nf1.format(0.45));
		NumberFormat nf2=NumberFormat.getCurrencyInstance(Locale.US);
		System.out.println("使用美国地区信息格式化货币:"+nf2.format(1200));
		System.out.println("--------------解析数值--------------");
		NumberFormat nf3=NumberFormat.getInstance();
		System.out.println("使用默认的本地信息解析数值字符串："+
                                                  nf3.parse("113.55"));
		NumberFormat nf4=NumberFormat.getPercentInstance(Locale.US);
		System.out.println("使用美国地区信息解析百分数字符串："+
                                                  nf4.parse("125.3%"));
	}
}
