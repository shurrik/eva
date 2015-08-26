package com.eden.eva.util;

public class Constants {
	
	public static Integer REMIND_HOURS = 2;//提前2个小时提醒收文限时到期
	
	public static String RESOURCE_ROOT= "root";	
	
	public static String MAIN_TAB= "main";
	
	public static String SYS_ADMIN_ID= "0";
	public static String SYS_ADMIN= "SYS";
	
	public static Integer PAGE_SIZE = 20;
	public static Integer MAX_PAGE_SIZE = 1000;
	public static String FLOW_NAME_REC = "收文流程";
	public static String FLOW_NAME_SEND = "发文流程";
	
	public static String TYPE_RECFORM_HANDLE = "办文";
	public static String TYPE_RECFORM_READ = "阅文";
	public static String STATUS_UN_HANDLE = "待办文";
	public static String STATUS_HANDLED = "已办文";
	public static String STATUS_RECORD = "已归档";
	public static String STATUS_UN_SUBMIT = "未提办";
	public static String STATUS_REC_DRAFT = "草稿";
	public static String STATUS_REC_REGISTER = "登记";
	public static String STATUS_REC_HANDLE = "办文";
	public static String STATUS_REC_VERIFY = "审核";
	public static String STATUS_PRESS_HANDLE="已督办";
	
    public static String STATUS_SEND_COLLECT = "签发";
	public static String STATUS_SEND_DRAFT = "草稿";
	
	
	public static String TYPE_SENDFORM_SINGLE = "单独发文";
	public static String TYPE_SENDFORM_COLLECT = "会签发文";
	
	public static String REMIND_REC_UNFINISHED_URL = "admin/recform/listunfinished";
	
	public static String ATTACH_TYPE_REC = "rec";
}
