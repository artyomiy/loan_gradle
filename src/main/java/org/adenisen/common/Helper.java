package org.adenisen.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Helper {
	public static Date addTimeToCurrentDate(String time){
		Date result = null;
		try {
			SimpleDateFormat dt = new SimpleDateFormat("hh:mm"); 
			Date timeDate;
			timeDate = dt.parse(time);
			Calendar now = Calendar.getInstance();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(timeDate);
			calendar.set(now.get(Calendar.YEAR), now.get(Calendar.MONTH), Calendar.DATE);
			result = calendar.getTime();
		} catch (ParseException e) {
		}
		return result; 
	}
}
