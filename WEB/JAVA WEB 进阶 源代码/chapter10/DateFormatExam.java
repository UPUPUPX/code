package cn.itcast.chapter10;
import java.text.*;
import java.util.*;
public class DateFormatExam {
	public static void main(String[] args) throws ParseException {
		// ��ȡ����Ĭ�ϵ�DateFormat����
		DateFormat df=DateFormat.getDateTimeInstance();	
		// ��ȡ����Ĭ�ϵ�DateFormat����
		DateFormat df1=DateFormat.getDateInstance();    		
		Date date=new Date();
		System.out.println("ʹ��Ĭ�ϵı�����Ϣ������/ʱ����и�ʽ����");
		System.out.println(df.format(date));
		System.out.println("ʹ��Ĭ�ϵı�����Ϣ��������/ʱ���ַ�����");
		System.out.println(df1.parse("2013-12-11"));
	}
}
