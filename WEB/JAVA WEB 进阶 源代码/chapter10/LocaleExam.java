package cn.itcast.chapter10;
import java.util.*;
public class LocaleExam {
	public static void main(String[] args) {
		Locale locale = new Locale("en", "US");
		System.out.println("美国地区的ISO语言代码：" +
         locale.getLanguage());
		System.out.println("美国地区的ISO国家代码：" +
         locale.getCountry());
		System.out.println("显示给本地用户的语言名称：" +
         locale.getDisplayLanguage());
		System.out.println("显示给美国用户的语言名称：" +  
         locale.getDisplayLanguage(locale));
		System.out.println("显示给本地用户的信息名称：" +
         locale.getDisplayName());
		System.out.println("显示给美国用户的信息名称：" +
         locale.getDisplayName(locale));
	}
}
