package com.capitolone.cua.util;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class CardUsageUtil {

	public String getDateKey(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		String dateKey = cal.get(Calendar.YEAR)+"-"+cal.get(Calendar.MONTH)+"";
		System.out.println("DateKey > "+dateKey);
		return dateKey;
	}
	
	public String getDateKey(String dateStr){
		String dateKey = dateStr.substring(0, 7);
		return dateKey;
	}
	
}
