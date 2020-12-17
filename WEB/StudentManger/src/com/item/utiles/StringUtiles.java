package com.item.utiles;

public class StringUtiles {
	public static boolean isEmpty(String str) {
		if(str == null || "".equals(str))return true;
		return false;
	}
}
