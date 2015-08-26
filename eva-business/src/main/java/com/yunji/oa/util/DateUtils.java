package com.yunji.oa.util;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	
	
	public static String HOUR_FORMAT = "yyyy-MM-dd HH:00:00";

	public static Integer getYear()
	{
	    Calendar cc = Calendar.getInstance();
	    return cc.get(Calendar.YEAR);
	}
	
	public static Integer getMonth()
	{
	    Calendar cc = Calendar.getInstance();
	    return cc.get(Calendar.MONTH)+1;
	}
	
	public static Integer getQuarter()
	{
	    Calendar cc = Calendar.getInstance();
	    Integer month =  cc.get(Calendar.MONTH)+1;
	    if(month<4)
	    {
	    	return 1;
	    }
	    else if(month<7)
	    {
	    	return 2;
	    }
	    else if(month<10)
	    {
	    	return 3;
	    }
	    else
	    {
	    	return 4;
	    }
	    
	    
	}
	
	public static Date getCurHourTime() throws ParseException
	{
		Date dt=new Date();//如果不需要格式,可直接用dt,dt就是当前系统时间
		DateFormat df = new SimpleDateFormat(HOUR_FORMAT);//设置显示格式
		String nowTime="";
		nowTime= df.format(dt);//用DateFormat的format()方法在dt中获取并以yyyy/MM/dd HH:mm:ss格式显示
		
		return df.parse(nowTime);
	}
	
	public static Date incHour(Date date,Integer hour)
	{
		Calendar ca=Calendar.getInstance();
		ca.setTime(date);
		ca.add(Calendar.HOUR_OF_DAY, hour);
		return ca.getTime();
	}
	
	public static Date incCurDateForHour(Integer hour) throws ParseException
	{
		Date curHourTime = getCurHourTime();
	
		return incHour(curHourTime, hour);
	}
	public static String getTimestamp()
	{
//		long cc = new Date().getTime(); 
		String  cc = MessageFormat.format("{0,date,yyyyMMddHHmmss}" ,new Object[]  {new java.sql.Date(System.currentTimeMillis()) });
	    return cc;
	}
	public static void main(String[] args) throws ParseException {
		System.out.println(getTimestamp());
//		System.out.println(incCurDateForHour(2));
/*		System.out.println(getYear());
		System.out.println(getMonth());
		System.out.println(getQuarter());*/
	}
}
