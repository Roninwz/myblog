package com.zua.blog.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckFormat {
	/**
	 * ��֤����
	 *
	 * @param email
	 * @return
	 */

	public static boolean checkEmail(String email) {
	    boolean flag = false;
	    try {
	        String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
	        Pattern regex = Pattern.compile(check);
	        Matcher matcher = regex.matcher(email);
	        flag = matcher.matches();
	    } catch (Exception e) {
	        flag = false;
	    }
	    return flag;
	}
	
	/**
	 * ��֤�ֻ����룬11λ���֣�1��ͨ���ڶ�λ��������3456789��Щ����֮һ *
	 * @param mobileNumber
	 * @return
	 */
	public static boolean checkMobileNumber(String mobileNumber) {
	    boolean flag = false;
	    try {
	        // Pattern regex = Pattern.compile("^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$");
	        Pattern regex = Pattern.compile("^1[345789]\\d{9}$");
	        Matcher matcher = regex.matcher(mobileNumber);
	        flag = matcher.matches();
	    } catch (Exception e) {
	        e.printStackTrace();
	        flag = false;

	    }
	    return flag;
	}
}
