package com.chinal.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

	public static String replaceAllBlank(String string) {
		Pattern p = Pattern.compile("\\s*|\t|\r|\n");
		Matcher m = p.matcher(string);
		return m.replaceAll("");
	}

	public static boolean isEmptyString(String str) {
		if (str == null) {
			return true;
		}
		
		return replaceAllBlank(str).isEmpty();
	}
}
