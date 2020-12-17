package cn.itcast.chapter10;
import java.text.*;
import java.util.*;
public class NumberFormatExam {
	public static void main(String[] args) throws ParseException {
		System.out.println("--------------��ʽ����ֵ--------------");
		NumberFormat nf=NumberFormat.getNumberInstance();
		System.out.println("ʹ�ñ�����Ϣ��ʽ����ֵ��"+nf.format(101.5));
		NumberFormat nf1=NumberFormat.getPercentInstance();
		System.out.println("ʹ�ðٷֱ���ʽ��ʽ����ֵ��"+nf1.format(0.45));
		NumberFormat nf2=NumberFormat.getCurrencyInstance(Locale.US);
		System.out.println("ʹ������������Ϣ��ʽ������:"+nf2.format(1200));
		System.out.println("--------------������ֵ--------------");
		NumberFormat nf3=NumberFormat.getInstance();
		System.out.println("ʹ��Ĭ�ϵı�����Ϣ������ֵ�ַ�����"+
                                                  nf3.parse("113.55"));
		NumberFormat nf4=NumberFormat.getPercentInstance(Locale.US);
		System.out.println("ʹ������������Ϣ�����ٷ����ַ�����"+
                                                  nf4.parse("125.3%"));
	}
}
