package cn.itcast.chapter10;
import java.util.*;
public class LocaleExam {
	public static void main(String[] args) {
		Locale locale = new Locale("en", "US");
		System.out.println("����������ISO���Դ��룺" +
         locale.getLanguage());
		System.out.println("����������ISO���Ҵ��룺" +
         locale.getCountry());
		System.out.println("��ʾ�������û����������ƣ�" +
         locale.getDisplayLanguage());
		System.out.println("��ʾ�������û����������ƣ�" +  
         locale.getDisplayLanguage(locale));
		System.out.println("��ʾ�������û�����Ϣ���ƣ�" +
         locale.getDisplayName());
		System.out.println("��ʾ�������û�����Ϣ���ƣ�" +
         locale.getDisplayName(locale));
	}
}
