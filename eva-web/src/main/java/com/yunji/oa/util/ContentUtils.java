package com.yunji.oa.util;

public class ContentUtils {

	public static String replaceBrackets(String content)
	{
		content = content.replaceAll("<","щ").replaceAll(">", "Ψ");
		return content;
	}
}
