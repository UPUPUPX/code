package cn.itcast.chapter10;
import java.util.*;
public class MyResourcesBundle {
	public static void main(String[] args) {
		Locale locale=Locale.US;
		ResourceBundle myResources=
         		ResourceBundle.getBundle("MyResources",locale);
		String Key=myResources.getString("key");
		String Value=myResources.getString("value");
		System.out.println("key:"+Key);	
		System.out.println("value:"+Value);	
	}
}
